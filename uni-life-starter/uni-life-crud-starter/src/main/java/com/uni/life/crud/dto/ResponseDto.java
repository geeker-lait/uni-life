package com.uni.life.crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.uni.life.crud.utils.IConstants;

/***
 * 封装统一返回的Json数据结构
 *
 * @param <T>
 */
public class ResponseDto<T> {

    /**
     * 操作码，成功默认为200，其他为失败
     */
    private int code = IConstants.SUCCESS;

    /**
     * 操作信息
     */
    private String msg = IConstants.MSG_SUCCESS;

    /**
     * 响应数据，为空时json序列化时会忽略
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private ResponseDto(T data) {
        this.data = data;
    }

    private ResponseDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 请求成功的返回方法
     *
     * @param data 返回数据
     * @return
     */
    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(data);
    }

    /**
     * 请求失败的返回方法
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    public static <T> ResponseDto<T> error(int code, String msg) {
        return new ResponseDto<>(code, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
