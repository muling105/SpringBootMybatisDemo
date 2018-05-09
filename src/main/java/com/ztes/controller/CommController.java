package com.ztes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/comm")
public class CommController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/common/test");
        logger.info("这是在Controller中打印的日志格式！！！");
        return mav;
    }

}
