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
@Table(name = "user_relationship")
@EqualsAndHashCode(callSuper = false)
public class UserRelationship extends BaseEntity {

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
     * TODO 组
     */
    //@Column(name = "org")
    private Integer org;

    /**
     * TODO 深度
     */
    //@Column(name = "deep")
    private Integer deep;

    /**
     * TODO 顺序
     */
    //@Column(name = "seq")
    private Integer seq;

    /**
     * TODO 推荐人_i_d
     */
    //@Column(name = "from_uid")
    private String fromUid;

    /**
     * TODO 推荐人姓名
     */
    //@Column(name = "from_user_name")
    private String fromUserName;

    /**
     * TODO 推荐人手机
     */
    //@Column(name = "from_user_phone")
    private String fromUserPhone;

    /**
     * TODO 账号_i_d
     */
    //@Column(name = "to_uid")
    private String toUid;

    /**
     * TODO 用户手机
     */
    //@Column(name = "to_user_phone")
    private String toUserPhone;

    /**
     * TODO 用户名
     */
    //@Column(name = "to_user_name")
    private String toUserName;

}
