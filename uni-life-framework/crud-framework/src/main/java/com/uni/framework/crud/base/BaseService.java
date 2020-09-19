package com.uni.framework.crud.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uni.framework.crud.base.conver.EnumConverter;
import com.uni.framework.crud.base.utils.RequestSearchUtils;
import com.uni.framework.crud.base.utils.SearchFilter;
import com.uni.framework.crud.base.utils.SearchFilter.Operator;
import io.beanmapper.BeanMapper;
import io.beanmapper.config.BeanMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 基础业务模型，用于实现基础的业务功能<br>
 * 本身自带强大的查询参数构造
 *
 * @param <T>  数据库实体
 * @param <ID> 数据库实体的主键实体
 */
public abstract class BaseService<T, ID extends Serializable> {

    @Autowired
    protected BaseRepository<T, ID> baseRepository;

    /**
     * 如果是采用spring boot的话，会自动注入，其他情况需要手动创建
     */
    @Autowired
    protected ObjectMapper objectMapper;

    /**
     * 属性复制工具
     */
    protected BeanMapper beanMapper = new BeanMapperBuilder().addConverter(new EnumConverter()).build();

    /**
     * 默认删除标志的字段
     */
    protected String isActive = "isActive";

    /**
     * 保存单个实体
     *
     * @param t 实体
     * @return 返回保存的实体
     */
    @Transactional(readOnly = false)
    public T save(T t) {
        return baseRepository.save(t);
    }

    /**
     * 保存多个实体
     *
     * @param List<t> 实体
     * @return 返回保存的实体
     */
    @Transactional(readOnly = false)
    public List<T> saveList(List<T> tlist) {
        return baseRepository.saveAll(tlist);
    }

    /***
     * 删除实体
     *
     * @param id 主键id
     */
    @Transactional(readOnly = false)
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    /***
     * 删除实体
     *
     * @param t 需要删除的实体
     */
    @Transactional(readOnly = false)
    public void deleteById(T t) {
        baseRepository.delete(t);
    }

    /***
     * 根据主键集合删除实体
     *
     * @param ids 主键集合
     */
    @Transactional(readOnly = false)
    public void deleteAllById(List<ID> ids) {
        List<T> delList = baseRepository.findAllById(ids);
        this.deleteList(delList);
    }

    /**
     * 删除实体集合
     *
     * @param delList
     */
    @Transactional(readOnly = false)
    public void deleteList(List<T> delList) {
        baseRepository.deleteInBatch(delList);
    }

    /**
     * 删除所有实体
     */
    @Transactional(readOnly = false)
    public void deleteAll() {
        baseRepository.deleteAll();
    }

    /**
     * 统计实体总数
     *
     * @return 实体总数
     */
    @Transactional(readOnly = true)
    public long count() {
        List<SearchFilter> sfList = Arrays.asList(new SearchFilter(isActive, Operator.EQ, Boolean.TRUE));
        return this.countBySpec(RequestSearchUtils.bySearchFilter(sfList));
    }

    /**
     * 根据某个字段查询数量<br>
     * 该查询会过滤掉实体字段isActive=false的数据
     *
     * @param param    实体的搜索字段，字段必须在实体中存在
     * @param operator 搜索查询的方式
     * @param object   搜索查询的值
     * @return 根据条件查询到数量
     */
    @Transactional(readOnly = true)
    public long countByParam(String param, Operator operator, Object object) {
        List<SearchFilter> sfList = this.doDefaultSearchFilter(param, operator, object);
        return this.countBySpec(RequestSearchUtils.bySearchFilter(sfList));
    }

    /**
     * 根据map条件获取查询符合条件的数量
     *
     * @param searchParams
     * @return
     */
    @Transactional(readOnly = true)
    public long countByMapParams(Map<String, Object> searchParams) {
        return this.countBySpec(RequestSearchUtils.buildSpec(searchParams));
    }

    /**
     * 根据查询条件获取数量
     *
     * @param spec 构造的JPA搜索条件
     * @return 查询的数量
     */
    @Transactional(readOnly = true)
    public long countBySpec(Specification<T> spec) {
        return baseRepository.count(spec);
    }

    /**
     * 按照主键查询
     *
     * @param id 主键
     * @return 返回id对应的实体
     */
    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }

    /**
     * 根据某个字段查询单个实体<br>
     * 该查询不会过滤实体字段isActive=false的数据<br>
     *
     * @param param    实体的搜索字段，字段必须在实体中存在
     * @param operator 搜索查询的方式
     * @param object   搜索查询的值
     * @return 查询不到返回null
     */
    @Transactional(readOnly = true)
    public Optional<T> findOneByParam(String param, Operator operator, Object object) {
        List<SearchFilter> sfList = this.doDefaultSearchFilter(param, operator, object);
        return this.findOneBySpec(RequestSearchUtils.bySearchFilter(sfList));
    }

    /**
     * 查询所有实体，根据排序方式和字段排序<br>
     * searchParams的参数key必须包含如：EQ_name=xxx<br>
     * 否则无法正确解析构造动态的jpa搜索条件
     *
     * @param searchParams 搜索参数
     * @param direction    排序方式
     * @param sortType     排序字段
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<T> findOneByMapParams(Map<String, Object> searchParams) {
        return this.findOneBySpec(RequestSearchUtils.buildSpec(searchParams));
    }

    /**
     * 根据查询条件获取，返回Optional
     *
     * @param spec 构造的JPA搜索条件
     * @return 返回实体的Optional信息
     */
    @Transactional(readOnly = true)
    public Optional<T> findOneBySpec(Specification<T> spec) {
        return baseRepository.findOne(spec);
    }

    /**
     * 查询所有实体
     *
     * @return 实体集合
     */
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    /**
     * 根据某个字段查询实体集合<br>
     * 该查询会过滤掉实体字段isActive=false的数据
     *
     * @param param    实体的搜索字段，字段必须在实体中存在
     * @param operator 搜索的方式
     * @param object   搜索的值
     * @return 实体集合
     */
    @Transactional(readOnly = true)
    public List<T> findAllByParam(String param, Operator operator, Object object) {
        List<SearchFilter> sfList = this.doDefaultSearchFilter(param, operator, object);
        return this.findAllBySpec(RequestSearchUtils.bySearchFilter(sfList));
    }

    /**
     * 查询所有实体，根据排序方式和字段排序<br>
     * searchParams的参数key必须包含如：EQ_name=xxx<br>
     * 否则无法正确解析构造动态的jpa搜索条件
     *
     * @param searchParams 搜索参数
     * @return 实体集合
     */
    @Transactional(readOnly = true)
    public List<T> findAllByMapParams(Map<String, Object> searchParams) {
        return this.findAllBySpec(RequestSearchUtils.buildSpec(searchParams));
    }

    /**
     * 查询所有实体，根据排序方式和字段排序<br>
     * searchParams的参数key必须包含如：EQ_name=xxx<br>
     * 否则无法正确解析构造动态的jpa搜索条件
     *
     * @param searchParams 搜索参数
     * @param direction    排序方式
     * @param sortType     排序字段
     * @return 实体集合
     */
    @Transactional(readOnly = true)
    public List<T> findAllBySort(Map<String, Object> searchParams, Direction direction, String... sortType) {
        return baseRepository.findAll(RequestSearchUtils.buildSpec(searchParams), Sort.by(direction, sortType));
    }

    /**
     * 根据查询条件获取所有
     *
     * @param spec 构造的JPA搜索条件
     * @return 实体集合
     */
    @Transactional(readOnly = true)
    public List<T> findAllBySpec(Specification<T> spec) {
        return baseRepository.findAll(spec);
    }

    /**
     * 获取分页，不排序
     *
     * @param searchParams 搜索参数
     * @param pageNumber   页码
     * @param pageSize     分页大小
     * @return 分页实体信息
     */
    @Transactional(readOnly = true)
    public Page<T> findPage(Map<String, Object> searchParams, int pageNumber, int pageSize) {
        return baseRepository.findAll(RequestSearchUtils.buildSpec(searchParams),
                PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, pageSize));
    }

    /**
     * 获取分页
     *
     * @param searchParams 搜索参数
     * @param pageNumber   页码
     * @param pageSize     分页大小
     * @param direction    排序方式
     * @param sortType     排序字段
     * @return 分页实体信息
     */
    @Transactional(readOnly = true)
    public Page<T> findPageBySort(Map<String, Object> searchParams, int pageNumber, int pageSize, Direction direction,
                                  String... sortType) {
        return baseRepository.findAll(RequestSearchUtils.buildSpec(searchParams),
                PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, pageSize, Sort.by(direction, sortType)));
    }

    /**
     * 获取集合的子列表，第二个参数是获取的大小，从0开始
     *
     * @param list  数据集合
     * @param limit 子列表大小
     * @return 实体集合
     */
    @Transactional(readOnly = true)
    public List<T> getLimit(List<T> list, int limit) {
        return list.size() > limit ? list.subList(0, limit) : list;
    }

    /**
     * 统一构造默认查询条件的<code>SearchFilter</code>集合
     *
     * @param param    实体的搜索字段，字段必须在实体中存在
     * @param operator 搜索查询的方式
     * @param object   搜索查询的值
     * @return 搜索参数集合
     */
    protected List<SearchFilter> doDefaultSearchFilter(String param, Operator operator, Object object) {
        return Arrays.asList(new SearchFilter(param, operator, object),
                new SearchFilter(isActive, Operator.EQ, Boolean.TRUE));
    }

    /**
     * 克隆对象属性值<br>
     * 来源和接收实体都不能为空
     *
     * @param source      属性来源实体
     * @param destination 属性接收实体
     */
    @Transactional(readOnly = true)
    public void mapper(Object source, Object destination) {
        beanMapper.map(destination,source);
    }

    /**
     * 克隆对象属性值<br>
     *
     *
     * @param <E>
     *
     * @param source 属性来源实体，不能为null
     * @param clz    属性实体的class类型
     */
    @Transactional(readOnly = true)
    public <E> E mapperByClass(Object source, Class<E> clz) {
        return beanMapper.map(source, clz);
    }

    /**
     * 克隆集合对象属性
     *
     * @param <D>
     * @param <E>
     *
     * @param sourceList 属性来源实体集合
     * @param clz        属性接收实体的class
     */
    @Transactional(readOnly = true)
    public <D, E> List<E> mapperList(List<D> sourceList, Class<E> clz) {
        return beanMapper.map(sourceList, clz);
    }

    /**
     * 将一个实体转换成另一个实体<br>
     * 通常情况下是将map转成Java Bean
     *
     * @param <S>
     * @param source 来源实体
     * @param cls    目标转换的class
     * @return
     */
    public <S> S conver(Object source, Class<S> cls) {
        return objectMapper.convertValue(source, cls);
    }

}
