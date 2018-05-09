package com.ztes.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class MyTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0/30 * * * * ?")
    public void one(){
        logger.info("---------------------- 每隔30秒打印一次 -------------------------");
    }

}
