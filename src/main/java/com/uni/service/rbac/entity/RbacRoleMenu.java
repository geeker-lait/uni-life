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
@Table(name = "rbac_role_menu")
@EqualsAndHashCode(callSuper = false)
public class RbacRoleMenu extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 角色_i_d
     */
    //@Column(name = "role_id")
    private String roleId;

    /**
     * TODO 菜单_i_d
     */
    //@Column(name = "menu_id")
    private String menuId;

}
