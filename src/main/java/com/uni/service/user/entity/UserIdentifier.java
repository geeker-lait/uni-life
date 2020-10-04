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
@Table(name = "user_identifier")
@EqualsAndHashCode(callSuper = false)
public class UserIdentifier extends BaseEntity {

    private static final long serialVersionUID = -1L;

    /**
     * TODO 用户_i_d
     */
    //@Column(name = "uid")
    private String uid;

    /**
     * TODO 识别标识:身份唯一标识，如：登录账号、邮箱地址、手机号码、_q_q号码、微信号、微博号；
     */
    //@Column(name = "identifier")
    private String identifier;

    /**
     * TODO 授权凭证【_c_r_e_d_e_n_t_i_a_l】：站内账号是密码、第三方登录是_token；
     */
    //@Column(name = "credential")
    private String credential;

    /**
     * TODO 登录类型【_i_d_e_n_t_i_t_y_t_y_p_e】：登录类别，如：系统用户、邮箱、手机，或者第三方的_q_q、微信、微博；
     */
    //@Column(name = "chanel_type")
    private String chanelType;

}
