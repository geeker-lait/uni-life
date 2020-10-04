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
@Table(name = "rbac_group")
@EqualsAndHashCode(callSuper = false)
public class RbacGroup extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 父id
     */
    //@Column(name = "group_pid")
    private String groupPid;

    /**
     * TODO 组code
     */
    //@Column(name = "group_code")
    private String groupCode;

    /**
     * TODO 组织架构名
     */
    //@Column(name = "group_name")
    private String groupName;

    /**
     * TODO 组织架构_i_c_o_n
     */
    //@Column(name = "group_icon")
    private String groupIcon;

    /**
     * TODO 排序
     */
    //@Column(name = "sorted")
    private Integer sorted;

}
