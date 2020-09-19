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
@Table(name = "rbac_permission")
@EqualsAndHashCode(callSuper = false)
public class RbacPermission extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 权限码query/creat/update/delete
     */
    //@Column(name = "permission_code")
    private String permissionCode;

    /**
     * TODO 权限名称
     */
    //@Column(name = "permission_name")
    private String permissionName;

    /**
     * TODO 权限值
     */
    //@Column(name = "permission_val")
    private String permissionVal;

    /**
     * TODO url
     */
    //@Column(name = "permission_uri")
    private String permissionUri;

    /**
     * TODO 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    //@Column(name = "permission_typ")
    private String permissionTyp;

    /**
     * TODO 排序
     */
    //@Column(name = "sorted")
    private Integer sorted;

}
