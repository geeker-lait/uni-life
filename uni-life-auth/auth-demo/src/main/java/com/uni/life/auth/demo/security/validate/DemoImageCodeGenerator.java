package com.uni.life.auth.demo.security.validate;

import com.uni.life.auth.core.validate.code.ValidateCodeGenerator;
import com.uni.life.auth.core.validate.code.image.ImageCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created By: Sun Chuan
 * Created Date: 2019/7/6 19:03
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
