package com.ztes.common.enums;

/**
 * 自定义错误代码和信息的枚举
 * 方便统一维护
 */
public enum ResultEnum {
    SUCCESS(1, "成功"),
    UNKONW_ERROR(-1, "未知错误"),
    OTHER_ERROR(100, "其他错误"),
    ONE_ERROR(101, "139号段"),
    TWO_ERROR(102, "156号段")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
