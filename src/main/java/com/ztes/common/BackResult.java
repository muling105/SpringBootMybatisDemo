package com.ztes.common;

/**
 * 最外层返回结果的封装
 */
public class BackResult<T> {

    //返回的正确码或错误码 1-正确
    private Integer code;
    //正确或错误信息
    private String msg;
    //返回结果，使用泛型
    private T result;

    public BackResult() {
    }

    public BackResult(Integer code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BackResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}

