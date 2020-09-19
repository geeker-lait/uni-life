package com.uni.service.user.entity;

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
@Table(name = "user_role")
@EqualsAndHashCode(callSuper = false)
public class UserRole extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 用户_i_d
     */
    //@Column(name = "uid")
    private String uid;

    /**
     * TODO 角色_i_d
     */
    //@Column(name = "role_id")
    private String roleId;

    /**
     * TODO 角色名
     */
    //@Column(name = "role_name")
    private String roleName;

}
