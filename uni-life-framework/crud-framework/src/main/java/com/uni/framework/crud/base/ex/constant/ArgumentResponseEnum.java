package com.uni.framework.crud.base.ex.constant;

import com.uni.framework.crud.base.ex.assertion.CommonExceptionAssert;

/**
 * <p>
 * 参数校验异常返回结果
 * </p>
 *

 */
public enum ArgumentResponseEnum implements CommonExceptionAssert {
    /**
     * 绑定参数校验异常
     */
    VALID_ERROR(6000, "参数校验异常"),

    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private ArgumentResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
