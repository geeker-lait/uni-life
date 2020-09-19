package com.uni.service.rbac.entity;

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
 * Created On 2020-09-17.
 */
@Data
@Entity
@Table(name = "rbac_category")
@EqualsAndHashCode(callSuper = false)
public class RbacCategory extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 父节点_i_d
     */
    //@Column(name = "pid")
    private String pid;

    /**
     * TODO 资源类目名
     */
    //@Column(name = "category_name")
    private String categoryName;

    /**
     * TODO 排序
     */
    //@Column(name = "sorted")
    private Integer sorted;

}
