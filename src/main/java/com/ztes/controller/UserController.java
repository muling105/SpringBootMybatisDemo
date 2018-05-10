package com.ztes.controller;

import com.ztes.common.BackResult;
import com.ztes.common.ResultUtil;
import com.ztes.pojo.ConfigTestBean;
import com.ztes.pojo.User;
import com.ztes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //读取application.yml或application.properties文件
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ConfigTestBean configBean;

    @RequestMapping("/testConfig")
    public String testConfig(){
        return serverPort + ", " + configBean.getCompany() + ",  "
                + configBean.getUuid() + "," + configBean.getAddress();
    }

    @RequestMapping("/add")
    public int add(User user){
        return userService.insert(user);
    }

    @RequestMapping("/select")
    public User select(int userId){
        return userService.selectByPrimaryKey(userId);
    }

    @RequestMapping("/selectOne")
    public BackResult<User> selectOne(int userId){
        User user = userService.selectByPrimaryKey(userId);
        return user != null ? ResultUtil.success(user)
                        : ResultUtil.error(0, "用户不存在！");
    }

    @RequestMapping("/exceptionName")
    public void exceptionName(int userId) throws Exception{
        userService.exceptionName(userId);
    }

    @RequestMapping("/selectAll")
    public List<User> selectAll(int pageNum, int pageSize){
        //将参数传给这个方法就可以实现物理分页了
        //PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAll(pageNum, pageSize);
        return list;
    }

    //测试事务
    @RequestMapping("/testTran")
    public String testTran(){
        User user = new User();
        user.setUserName("鸾小平");
        user.setPassword("123456");
        user.setPhone("15612998910");
        userService.testRran(user);
        return "succ";
    }

}
