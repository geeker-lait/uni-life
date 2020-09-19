package com.uni.service.product.entity;

import com.uni.framework.crud.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-08-26.
 */
@Data
@Entity
@Table(name = "product_category")
@EqualsAndHashCode(callSuper = false)
public class ProductCategory extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 
     */
    //@Column(name = "category_id")
    private String categoryId;

    /**
     * TODO 
     */
    //@Column(name = "category_pid")
    private Integer categoryPid;

    /**
     * TODO 
     */
    //@Column(name = "sort")
    private Integer sort;

    /**
     * TODO 
     */
    //@Column(name = "url")
    private String url;

    /**
     * TODO 
     */
    //@Column(name = "icon")
    private String icon;

    /**
     * TODO 
     */
    //@Column(name = "name")
    private String name;

    /**
     * TODO 
     */
    //@Column(name = "state")
    private Integer state;

    /**
     * TODO 
     */
    //@Column(name = "create_time")
    private String createTime;

}
