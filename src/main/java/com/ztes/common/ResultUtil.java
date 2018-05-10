package com.ztes.common;


/**
 * 外层返回结构封装的工具类
 */
public class ResultUtil {

    //成功，有返回值
    public static BackResult success(Object object){
        BackResult backResult = new BackResult(1, "成功", object);
        return backResult;
    }

    //成功，无返回值
    public static BackResult success(){
        return success(null);
    }

    //失败
    public static BackResult error(Integer code, String msg){
        BackResult backResult = new BackResult(code, msg, null);
        return backResult;
    }

}
