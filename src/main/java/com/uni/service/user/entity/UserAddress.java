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
@Table(name = "user_address")
@EqualsAndHashCode(callSuper = false)
public class UserAddress extends BaseEntity {

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
     * TODO 省
     */
    //@Column(name = "province")
    private String province;

    /**
     * TODO 市
     */
    //@Column(name = "city")
    private String city;

    /**
     * TODO 区
     */
    //@Column(name = "district")
    private String district;

    /**
     * TODO 街道
     */
    //@Column(name = "street")
    private String street;

    /**
     * TODO 地址类型：工作地址/家庭地址/收货地址...
     */
    //@Column(name = "typ")
    private Integer typ;

    /**
     * TODO 顺序
     */
    //@Column(name = "indx")
    private Integer indx;

    /**
     * TODO 联系人
     */
    //@Column(name = "contacts")
    private String contacts;

    /**
     * TODO 手机号
     */
    //@Column(name = "phone_num")
    private String phoneNum;

}
