package com.uni.life.auth.core.enums;

/**
 * @date: 2019/7/19 23:57
 * @Description： 利用interface封装常量的好处是不用写public static final三个关键字
 * 因为interface中常量会默认加上这三个关键字
 */
public interface SecurityConstants {

    /**
     * 默认处理验证码的url前缀   public static final可以不写
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 当请求需要身份认证时，默认跳转的url
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
    /**
     * 默认的OPENID登录请求处理url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_OPENID = "/authentication/openid";
    /**
     * 默认登录页面
     */
    String DEFAULT_LOGIN_PAGE_URL = "/login.html";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imgCode";
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    /**
     * session失效默认的跳转地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/session-invalid.html";
    /**
     * 默认的注册url
     */
    String DEFAULT_SIGNUP_URL = "/signup.html";
    /**
     * 获取第三方账号的用户信息对应的url
     */
    String DEFAULT_GET_SOCIAL_USERINFO_URL = "/social/user";
    /**
     * openid参数名
     */
    String DEFAULT_PARAMETER_NAME_OPENID = "openId";
    /**
     * providerId参数名
     */
    String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";
}
