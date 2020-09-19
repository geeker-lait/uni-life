package com.uni.framework.crud.base.ex;

/**
 * 枚举异常接口
 *

 */
public interface IResponseEnum {

    /**
     * 返回的异常错误码
     *
     * @return
     */
    int getCode();

    /**
     * 异常错误信息
     * @return
     */
    String getMessage();
}
