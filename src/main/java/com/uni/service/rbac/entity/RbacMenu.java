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
@Table(name = "rbac_menu")
@EqualsAndHashCode(callSuper = false)
public class RbacMenu extends BaseEntity {

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
     * TODO 英文码
     */
    //@Column(name = "menu_code")
    private String menuCode;

    /**
     * TODO 名称
     */
    //@Column(name = "menu_name")
    private String menuName;

    /**
     * TODO 值
     */
    //@Column(name = "menu_val")
    private String menuVal;

    /**
     * TODO 层级
     */
    //@Column(name = "level")
    private Integer level;

    /**
     * TODO 排序
     */
    //@Column(name = "sorted")
    private Integer sorted;

    /**
     * TODO 是否iframe
     */
    //@Column(name = "is_frame")
    private Integer isFrame;

    /**
     * TODO 图标
     */
    //@Column(name = "icon")
    private String icon;

}
