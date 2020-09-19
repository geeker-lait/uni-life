package com.uni.life.crud;

import com.uni.life.crud.dto.BaseResponseDto;
import com.uni.life.crud.utils.IConstants;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.*;
import org.springframework.hateoas.PagedModel.PageMetadata;
import org.springframework.hateoas.server.core.EmbeddedWrapper;
import org.springframework.hateoas.server.core.EmbeddedWrappers;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.*;
import java.util.Map.Entry;

/**
 * 基础控制器 其他控制器继承此控制器获得日期字段类型转换和防止XSS攻击的功能
 * @date 2019年02月01日
 */
public abstract class BaseEndpoint implements WebBindingInitializer {

    private static final Logger log = LoggerFactory.getLogger(BaseEndpoint.class);

    /**
     * 返回的集合或分页为空时的包装，将数据包装成空集合的形式，json格式<br>
     * {"_embedded":{"resources":[]}}
     */
    private final EmbeddedWrappers wrappers = new EmbeddedWrappers(false);

    /**
     * web数据绑定，主要是过滤XSS攻击<br>
     * 该方法只对控制器方法参数为String生效<br>
     * 其他诸如POST、PUT方法的请求体参数无效<br>
     */
    @InitBinder
    @Override
    public void initBinder(WebDataBinder binder) {
        log.debug("进入BaseEndpoint的initBinder方法");
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                log.debug("传进来的String类型的字符串为={}", text);
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });

    }

    /**
     * 统一构造spring data rest 的分页数据信息
     *
     * @param pageNumber      当前请求搜索的页吗
     * @param pageSize        当前请求搜索的分页大小
     * @param sortTypes       当前请求搜索的分页排序
     * @param request         当前请求搜索的参数
     * @param controllerClass 当前请求搜索的控制器类
     * @param page            当前需要构造分页信息的分页数据
     * @return spring data rest 的分页数据信息
     */
    public HttpEntity<PagedModel<?>> doPage(int pageNumber, int pageSize, String sortTypes, ServletRequest request,
                                            Class<?> controllerClass, Page<? extends BaseResponseDto> page) {

        List<EntityModel<?>> resList = new ArrayList<>(page.getContent().size());
        page.getContent().forEach(item -> {
            resList.add(new EntityModel<>(item, this.getSelfLink(controllerClass, item.getId())));
        });
        int totalPages = page.getTotalPages();
        // 组装分页信息
        PageMetadata pageMetadata = new PageMetadata(pageSize, pageNumber, page.getTotalElements(), totalPages);
        // 第一页链接
        Link firstLink = WebMvcLinkBuilder.linkTo(((BaseEndpoint) WebMvcLinkBuilder.methodOn(controllerClass))
                .getPageData(1, pageSize, sortTypes, request)).withRel(IanaLinkRelations.FIRST);
        Link prevLink = null;
        // 大于1时添加上一页链接
        if (pageNumber > 1 && totalPages > pageNumber) {
            prevLink = WebMvcLinkBuilder.linkTo(((BaseEndpoint) WebMvcLinkBuilder.methodOn(controllerClass))
                    .getPageData(pageNumber - 1, pageSize, sortTypes, request)).withRel(IanaLinkRelations.PREV);
        }
        // 本页链接
        Link selfLink = WebMvcLinkBuilder.linkTo(((BaseEndpoint) WebMvcLinkBuilder.methodOn(controllerClass))
                .getPageData(pageNumber, pageSize, sortTypes, request)).withSelfRel();

        // 当总页数大于当前页数时，才有下一页
        Link nextLink = null;
        if (totalPages > pageNumber) {
            // 下一页链接
            nextLink = WebMvcLinkBuilder.linkTo(((BaseEndpoint) WebMvcLinkBuilder.methodOn(controllerClass))
                    .getPageData(pageNumber + 1, pageSize, sortTypes, request)).withRel(IanaLinkRelations.NEXT);
        }

        // 最后一页链接
        Link lastLink = null;
        if (totalPages > 1) {
            lastLink = WebMvcLinkBuilder.linkTo(((BaseEndpoint) WebMvcLinkBuilder.methodOn(controllerClass))
                    .getPageData(totalPages, pageSize, sortTypes, request)).withRel(IanaLinkRelations.LAST);
        }

        PagedModel<?> pagedResources;

        if (CollectionUtils.isEmpty(resList)) {
            pagedResources = doEmptyPageModel(BaseResponseDto.class, pageMetadata);
        } else {
            pagedResources = new PagedModel<>(resList, pageMetadata);
        }
        pagedResources.add(firstLink); // 第一页
        if (Objects.nonNull(prevLink)) {
            pagedResources.add(prevLink); // 上一页
        }
        pagedResources.add(selfLink);// 当前页
        if (Objects.nonNull(nextLink)) {
            pagedResources.add(nextLink); // 下一页
        }
        if (Objects.nonNull(lastLink)) {
            pagedResources.add(lastLink); // 最后一页
        }
        return new HttpEntity<PagedModel<?>>(pagedResources);
    }

    /**
     * 数据为空时构造空的pageModel
     *
     * @param <S>
     * @param <S>
     * @param clz          类型
     * @param pageMetadata 分页信息
     * @return
     */
    protected PagedModel<?> doEmptyPageModel(Class<?> clz, PageMetadata pageMetadata) {

        List<EmbeddedWrapper> embedded = createdEmptyEmbedded(clz);
        PagedModel<?> pageModel = new PagedModel<>(embedded, pageMetadata);
        return pageModel;
    }

    /**
     * 创建空的实体集合模型
     *
     * @param clz 类型
     * @return
     */
    protected List<EmbeddedWrapper> createdEmptyEmbedded(Class<?> clz) {
        EmbeddedWrapper wrapper = wrappers.emptyCollectionOf(clz);
        List<EmbeddedWrapper> embedded = Collections.singletonList(wrapper);
        return embedded;
    }

    /**
     * 抽象方法，由子类实现分页的数据的获取
     *
     * @param pageNumber 查询的页码
     * @param pageSize   分页大小
     * @param sortType   排序字段
     * @param request    请求参数
     * @return spring data rest 的分页数据信息
     */
    protected abstract HttpEntity<PagedModel<?>> getPageData(int pageNumber, int pageSize, String sortType,
                                                             ServletRequest request);

    /**
     * 实体详情接口，交给子类实现
     *
     * @param id 数据库主键id
     * @return spring data rest 的单个实体信息
     */
    protected abstract ResponseEntity<?> details(Long id);

    /**
     * 构造单个实体的spring data rest形式
     *
     * @param data            单个实体的数据
     * @param controllerClass 控制器的类
     * @return
     */
    protected ResponseEntity<?> doResource(BaseResponseDto data, Class<?> controllerClass) {
        return ResponseEntity.ok(EntityModel.of(data, this.getSelfLink(controllerClass, data.getId())));

    }

    /**
     * 构造List列表的spring data rest形式
     *
     * @param sourcesList     列表数据
     * @param controllerClass 端点控制器
     * @return spring data rest 的集合实体信息
     */
    protected ResponseEntity<?> doListResources(List<? extends BaseResponseDto> sourcesList, Class<?> controllerClass) {
        CollectionModel<?> cm;
        if (CollectionUtils.isEmpty(sourcesList)) {
            cm = CollectionModel.of(createdEmptyEmbedded(BaseResponseDto.class), getDefaultSelfLink());
        } else {
            List<EntityModel<?>> resList = new ArrayList<>(sourcesList.size());
            sourcesList.forEach(item -> {
                resList.add(EntityModel.of(item, this.getSelfLink(controllerClass, item.getId())));
            });
            cm = CollectionModel.of(resList);
        }

        return ResponseEntity.ok(cm);
    }

    /**
     * 取得带相同前缀的Request Parameters,
     *
     * 返回的结果的Parameter名已去除前缀.
     */
    protected Map<String, Object> getSearchParamStartWith(ServletRequest request, String prefix) {
        prefix = Optional.ofNullable(prefix).orElseGet(() -> IConstants.EMPTY_SEARCH_PREFIX);
        Map<String, String[]> paramMap = request.getParameterMap();
        Map<String, Object> params = new TreeMap<>();
        for (Entry<String, String[]> e : paramMap.entrySet()) {
            String paramName = e.getKey();
            if (prefix.length() > 0 && paramName.startsWith(prefix)) {
                paramName = paramName.substring(prefix.length());
            }
            String[] values = e.getValue();
            if (values == null || values.length == 0) {
                // Do nothing, no values found at all.
            } else if (values.length > 1) {
                params.put(paramName, values);
            } else {
                params.put(paramName, StringEscapeUtils.escapeHtml4(values[0]));
            }
        }
        log.debug("请求参数解析后为=[{}],原始参数为=[{}]", params, paramMap);
        return params;
    }

    /**
     * 统一构造spring data rest的链接
     *
     * @param controllerClass 控制器class，带有@Controller或@RestController的控制器
     * @param id              主键字段
     * @return 构造的链接实体
     */
    protected Link getSelfLink(Class<?> controllerClass, Long id) {
        return WebMvcLinkBuilder.linkTo(((BaseEndpoint) WebMvcLinkBuilder.methodOn(controllerClass)).details(id))
                .withSelfRel();
    }

    /**
     * 获取默认的指向详情的链接
     *
     * @return
     */
    protected Link getDefaultSelfLink() {
        return Link.of(ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString());
    }

}
