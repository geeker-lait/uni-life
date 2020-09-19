package com.uni.service.use.entity;

import com.uni.framework.crud.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

/**
 *
 * 这是类的注释
 *
 * @author lait
 * Created On 2020-08-26.
 */
@Data
@Entity
@Table(name = "use_rorg")
@EqualsAndHashCode(callSuper = false)
public class UseRorg extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     * TODO 用户ID
     */
    //@Column(name = "uid")
    private String uid;

    /**
     * TODO 组ID
     */
    //@Column(name = "groupId")
    private String groupid;

    /**
     * TODO 职位ID
     */
    //@Column(name = "postId")
    private String postid;

    /**
     * TODO 组名
     */
    //@Column(name = "groupName")
    private String groupname;

    /**
     * TODO 职位名
     */
    //@Column(name = "postName")
    private String postname;

    /**
     * TODO 应用ID
     */
    //@Column(name = "appId")
    private String appid;

    /**
     * TODO 租户ID
     */
    //@Column(name = "tenantId")
    private String tenantid;

    /**
     * TODO 
     */
    //@Column(name = "isActive")
    private Integer isactive;

    /**
     * TODO 
     */
    //@Column(name = "createdBy")
    private String createdby;

    /**
     * TODO 
     */
    //@Column(name = "createdDate")
    private LocalDateTime createddate;

}
