package com.uni.life.auth.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @date : 2019/7/6 17:24
 * Description : 以后还会有别的验证码生成逻辑，故将其统一定义出来
 */
public interface ValidateCodeGenerator {
    /**
     * 生成验证码
     *
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
