package com.ztes.common.exception;

import com.ztes.common.enums.ResultEnum;

public class UserException extends RuntimeException{

    private int code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
