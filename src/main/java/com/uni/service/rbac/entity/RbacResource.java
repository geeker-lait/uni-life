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
@Table(name = "rbac_resource")
@EqualsAndHashCode(callSuper = false)
public class RbacResource extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 类目id
     */
    //@Column(name = "category_id")
    private String categoryId;

    /**
     * TODO 资源名
     */
    //@Column(name = "resource_name")
    private String resourceName;

    /**
     * TODO 资源码
     */
    //@Column(name = "resource_code")
    private String resourceCode;

    /**
     * TODO 类型:1目录、2菜单、3按钮、4链接
     */
    //@Column(name = "resource_typ")
    private String resourceTyp;

    /**
     * TODO 资源值
     */
    //@Column(name = "resource_val")
    private String resourceVal;

    /**
     * TODO 资源路径
     */
    //@Column(name = "resource_path")
    private String resourcePath;

    /**
     * TODO 资源图标
     */
    //@Column(name = "resource_icon")
    private String resourceIcon;

    /**
     * TODO 资源描述
     */
    //@Column(name = "resource_descr")
    private String resourceDescr;

    /**
     * TODO 是否隐藏
     */
    //@Column(name = "visible")
    private Integer visible;

    /**
     * TODO 层级
     */
    //@Column(name = "level")
    private Integer level;

}
