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
@Table(name = "rbac_role_resource")
@EqualsAndHashCode(callSuper = false)
public class RbacRoleResource extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 角色_i_d
     */
    //@Column(name = "role_id")
    private String roleId;

    /**
     * TODO 资源_i_d
     */
    //@Column(name = "resource_id")
    private String resourceId;

}
