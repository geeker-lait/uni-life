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
 * Created On 2020-10-04.
 */
@Data
@Entity
@Table(name = "rbac_role_permission")
@EqualsAndHashCode(callSuper = false)
public class RbacRolePermission extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 角色_i_d
     */
    //@Column(name = "role_id")
    private String roleId;

    /**
     * TODO 权限_i_d
     */
    //@Column(name = "permission_id")
    private String permissionId;

}
