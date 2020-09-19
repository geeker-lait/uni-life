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
@Table(name = "user_org")
@EqualsAndHashCode(callSuper = false)
public class UserOrg extends BaseEntity {

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
     * TODO 组_i_d
     */
    //@Column(name = "group_id")
    private String groupId;

    /**
     * TODO 职位_i_d
     */
    //@Column(name = "post_id")
    private String postId;

    /**
     * TODO 组名
     */
    //@Column(name = "group_name")
    private String groupName;

    /**
     * TODO 职位名
     */
    //@Column(name = "post_name")
    private String postName;

}
