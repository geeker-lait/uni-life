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
 * Created On 2020-10-04.
 */
@Data
@Entity
@Table(name = "user_idcard")
@EqualsAndHashCode(callSuper = false)
public class UserIdcard extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 用户_i_d
     */
    //@Column(name = "uid")
    private String uid;

    /**
     * TODO 身份证号
     */
    //@Column(name = "idcard")
    private String idcard;

    /**
     * TODO 名字
     */
    //@Column(name = "name")
    private String name;

    /**
     * TODO 年龄
     */
    //@Column(name = "age")
    private Integer age;

    /**
     * TODO 性别
     */
    //@Column(name = "sex")
    private Integer sex;

    /**
     * TODO 生日
     */
    //@Column(name = "birthday")
    private String birthday;

    /**
     * TODO 名族
     */
    //@Column(name = "nation")
    private String nation;

    /**
     * TODO 居住地
     */
    //@Column(name = "domicile")
    private String domicile;

    /**
     * TODO 颁发机构
     */
    //@Column(name = "sign_org")
    private String signOrg;

}
