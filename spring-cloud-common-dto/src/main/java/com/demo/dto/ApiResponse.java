package com.demo.dto;


import java.io.Serializable;


public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 77027745177829703L;

    public interface Codes {

        int SUCCESS = 200;

        String SUCCESS_MSG = "OK";

        int REQ_INVALID_PARAM = 400;

        int INTERNAL_ERROR = 500;
    }


    private T data;

    private Integer code;

    private String msg;


    public T getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ApiResponse<T> setOkayData(T data) {
        return setData(data, Codes.SUCCESS, "");
    }

    private ApiResponse<T> setData(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        return this;
    }

    private ApiResponse<T> setErrorData(Integer code, String errorMsg) {
        return setData(null, code, errorMsg);
    }

    private ApiResponse<T> setErrorData(Integer code, String errorMsg, T data) {
        return setData(data, code, errorMsg);
    }

    public static <T> ApiResponse<T> okay(T data) {
        return new ApiResponse<T>()
                .setOkayData(data);
    }

    public static <T> ApiResponse<T> error(Integer code, String errorMsg) {
        return new ApiResponse<T>()
                .setErrorData(code, errorMsg);
    }

    public static <T> ApiResponse<T> error(Integer code, String errorMsg, T data) {
        return new ApiResponse<T>()
                .setErrorData(code, errorMsg, data);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"data\":")
                .append(data);
        sb.append(",\"code\":")
                .append(code);
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
