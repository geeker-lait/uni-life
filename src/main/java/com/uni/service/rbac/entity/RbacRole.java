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
@Table(name = "rbac_role")
@EqualsAndHashCode(callSuper = false)
public class RbacRole extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 角色名
     */
    //@Column(name = "role_name")
    private String roleName;

    /**
     * TODO 角色码
     */
    //@Column(name = "role_code")
    private String roleCode;

    /**
     * TODO 角色图标
     */
    //@Column(name = "icon")
    private String icon;

    /**
     * TODO 角色描述
     */
    //@Column(name = "descr")
    private String descr;

}
