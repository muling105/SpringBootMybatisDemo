package com.ztes.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义静态资源映射目录
 */
@Configuration
public class MyConfigureAdapter extends WebMvcConfigurerAdapter{

    /**
     * 配置静态访问资源
     * 比如访问 http://localhost:8080/upload/test.jpg，就可以访问upload文件夹下的文件
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")//在访问url中有/upload/ 的地址即访问此目录下的文件
                .addResourceLocations("classpath:/upload/");
        super.addResourceHandlers(registry);
    }

    /**
     * 视图控制器配置
     * 配置文件映射指定请求路径到指定View页面，当然也是在请求目标页面时不需要做什么数据处理才可以这样使用
     * 相当于访问：http://localhost:8080/toLogin
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("toLogin").setViewName("login");
        super.addViewControllers(registry);
    }

    /**
     * 添加拦截器
     * addPathPatterns("/**")对所有请求都拦截，但是排除了/toLogin和/login请求的拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/toLogin", "/login");
        super.addInterceptors(registry);
    }
}
