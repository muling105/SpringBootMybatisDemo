package com.ztes.common;

import com.ztes.common.enums.ResultEnum;
import com.ztes.common.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义捕获异常
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    //private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BackResult handle(Exception e){
        if(e instanceof UserException){
            UserException userException = (UserException)e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        }else {
            log.error("系统错误：{}", e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());
        }

    }

}
