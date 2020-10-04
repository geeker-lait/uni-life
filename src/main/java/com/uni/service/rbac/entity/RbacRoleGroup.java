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
@Table(name = "rbac_role_group")
@EqualsAndHashCode(callSuper = false)
public class RbacRoleGroup extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 角色_i_d
     */
    //@Column(name = "role_id")
    private String roleId;

    /**
     * TODO 组织_i_d
     */
    //@Column(name = "group_id")
    private String groupId;

}
