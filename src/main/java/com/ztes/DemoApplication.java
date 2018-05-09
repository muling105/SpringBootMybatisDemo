package com.ztes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
//@MapperScan("com.ztes.mapper")//将在项目中的mapper类
@MapperScan(basePackages = "com.ztes.mapper")
@EnableTransactionManagement//开启事务
@EnableScheduling //使用定时任务
@EnableCaching //开启缓存
public class DemoApplication{
//public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }*/

}
