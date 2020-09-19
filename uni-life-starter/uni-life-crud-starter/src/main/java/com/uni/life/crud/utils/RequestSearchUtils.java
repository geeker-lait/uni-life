package com.uni.life.crud.utils;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Map.Entry;

/**
 * 页面搜索及JPA的搜索参数构造工具类
 *
 */
public class RequestSearchUtils {

    /**
     * 空字符串
     */
    private static final String NULL_STRING = "";

    /**
     * 百分号的字符串
     */
    private static final String PERCENT_STRING = "%";

    /**
     * 英文下的"."字符串，需要转义
     */
    private static final String POINT_STRING = "\\.";

    /**
     * 组合Parameters生成Query String的Parameter部分, 并在paramter name上加上prefix.
     *
     * @see #getParametersStartingWith
     */
    public static String enParamStrWithPrefix(Map<String, Object> params, String prefix) {
        if (params == null || params.isEmpty()) {
            return NULL_STRING;
        }
        prefix = Optional.ofNullable(prefix).orElseGet(() -> NULL_STRING);
        StringBuilder queryStringBuilder = new StringBuilder();
        Iterator<Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            queryStringBuilder.append(prefix).append(entry.getKey()).append('=').append(entry.getValue());
            if (it.hasNext()) {
                queryStringBuilder.append('&');
            }
        }
        return queryStringBuilder.toString();
    }

    /**
     * 构造一般搜索标准查询
     *
     * @param searchParams
     * @return
     */
    public static <T> Specification<T> buildSpec(Map<String, Object> searchParams) {
        return RequestSearchUtils.bySearchFilter(SearchFilter.parse(searchParams));
    }

    /**
     * 实现复杂对象查询，实现toPredicate方法，用JPA去构造Specification对象查询；
     *
     * @author qsr
     *
     */
    public static <T> Specification<T> bySearchFilter(final Collection<SearchFilter> filters) {
        return new Specification<T>() {
            /**
             *
             */
            private static final long serialVersionUID = 7054380594285260439L;

            // Root 查询中的条件表达式
            // CriteriaQuery 条件查询设计器
            // CriteriaBuilder 条件查询构造器
            @SuppressWarnings({ "unchecked", "rawtypes" })
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();
                if (!CollectionUtils.isEmpty(filters)) {
                    // 保存查询条件集
                    filters.forEach(f -> {
                        // 使用原生的java API进行分割，防止过度依赖第三方包
                        String[] names = f.fieldName.split(POINT_STRING);
                        Path expression = root.get(names[0]);
                        if (names.length > 1) {
                            expression = getSubExpression(names, expression, root);
                        }
                        switch (f.operator) {
                        case EQ:
                            // 等于查询构造
                            predicates.add(builder.equal(expression, f.value));
                            break;
                        case NE:
                            // 不等于查询构造
                            predicates.add(builder.notEqual(expression, f.value));
                            break;
                        case LIKE:
                            // 模糊查询构造
                            String likeValue = f.value.toString();
                            if (!likeValue.startsWith(PERCENT_STRING)) {
                                likeValue = likeValue.concat(PERCENT_STRING);
                            }
                            if (!likeValue.endsWith(PERCENT_STRING)) {
                                likeValue = likeValue.concat(PERCENT_STRING);
                            }
                            predicates.add(builder.like(expression, likeValue));
                            break;
                        case GT:
                            // 大于查询构造
                            predicates.add(builder.greaterThan(expression, (Comparable) f.value));
                            break;
                        case LT:
                            // 小于查询构造
                            predicates.add(builder.lessThan(expression, (Comparable) f.value));
                            break;
                        case GTE:
                            // 大于等于查询
                            predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) f.value));
                            break;
                        case LTE:
                            // 小于等于查询构造
                            predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) f.value));
                            break;
                        case IN:
                            // 使用IN的查询构造，需要以数组为Value;
                            Object[] queryObj = null;
                            if (f.value instanceof Collection) {
                                queryObj = (Object[]) ((Collection) f.value).toArray();
                            } else {
                                queryObj = (Object[]) f.value;
                            }
                            predicates.add(builder.isTrue(expression.in(queryObj)));
                            break;
                        case BETWEEN:
                            if (f.value instanceof List) {
                                List c = (List) f.value;
                                Object param1 = c.get(0);
                                Object param2 = c.get(1);
                                if (param1 instanceof Number) {
                                    predicates.add(builder.between(expression, ((Number) param1).longValue(),
                                            ((Number) param2).longValue()));
                                } else if (param1 instanceof Date) {
                                    predicates.add(builder.between(expression, (Date) param1, (Date) param2));
                                } else if (param1 instanceof LocalDateTime) {
                                    predicates.add(builder.between(expression, (LocalDateTime) param1,
                                            (LocalDateTime) param2));
                                } else {
                                    predicates.add(builder.between(expression, param1.toString(), param2.toString()));
                                }
                            }
                            break;
                        case ISNULL:
                            predicates.add(builder.isNull(expression));
                            break;
                        case ISNOTNULL:
                            predicates.add(builder.isNotNull(expression));
                            break;
                        default:
                            break;
                        }
                    });
                }
                // 如果predicates集合大于0，将所有条件用 and 联合起来
                return predicates.isEmpty() ? builder.conjunction()
                        : builder.and(predicates.toArray(new Predicate[predicates.size()]));
            }

            /**
             * 无限连接查询构造<br>
             * 支持属性为List、Set、Map的集合数据
             *
             * @param names      对应实体里面的字段
             * @param expression
             * @param root
             * @return
             */
            @SuppressWarnings("rawtypes")
            private Path getSubExpression(String[] names, Path expression, Root<T> root) {
                Join join = null;
                for (int i = 1; i < names.length; i++) {
                    // 属性为List集合
                    if (Objects.equals(List.class, expression.getJavaType())) {
                        if (join == null) {
                            join = root.joinList(names[i - 1]);
                        } else {
                            join = join.joinList(names[i - 1]);
                        }
                        expression = join.get(names[i]);
                    } else if (Objects.equals(Set.class, expression.getJavaType())) {
                        // 属性为Set集合
                        if (join == null) {
                            join = root.joinSet(names[i - 1]);
                        } else {
                            join = join.joinSet(names[i - 1]);
                        }
                        expression = join.get(names[i]);
                    } else if (Objects.equals(Map.class, expression.getJavaType())) {
                        // 属性为Map集合
                        if (join == null) {
                            join = root.joinMap(names[i - 1]);
                        } else {
                            join = join.joinMap(names[i - 1]);
                        }
                        expression = join.get(names[i]);
                    } else {
                        // 非集合属性
                        expression = expression.get(names[i]);
                    }
                }
                return expression;
            }
        };
    }

}
