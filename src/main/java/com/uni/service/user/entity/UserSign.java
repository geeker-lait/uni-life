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
@Table(name = "user_sign")
@EqualsAndHashCode(callSuper = false)
public class UserSign extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 账号_i_d/用户_i_d/会员_i_d/商户_i_d
     */
    //@Column(name = "uid")
    private String uid;

    /**
     * TODO 用户昵称可随机生成
     */
    //@Column(name = "nick")
    private String nick;

    /**
     * TODO 头像
     */
    //@Column(name = "icon")
    private String icon;

    /**
     * TODO 来源，推广统计用
     */
    //@Column(name = "source")
    private String source;

}
