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
@Table(name = "rbac_post")
@EqualsAndHashCode(callSuper = false)
public class RbacPost extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 父id
     */
    //@Column(name = "post_pid")
    private String postPid;

    /**
     * TODO 岗位名
     */
    //@Column(name = "post_name")
    private String postName;

    /**
     * TODO 岗位code
     */
    //@Column(name = "post_code")
    private String postCode;

    /**
     * TODO icon
     */
    //@Column(name = "post_icon")
    private String postIcon;

    /**
     * TODO 薪资
     */
    //@Column(name = "salary")
    private String salary;

}
