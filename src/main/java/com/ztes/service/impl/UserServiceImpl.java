package com.ztes.service.impl;

import com.github.pagehelper.PageHelper;
import com.ztes.mapper.UserMapper;
import com.ztes.pojo.User;
import com.ztes.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    public int insert(User bean){
        return userMapper.insert(bean);
    }

    public User selectByPrimaryKey(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    public List<User> selectAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAll();
        return list;
    }

    @Transactional
    public String testRran(User user){
        userMapper.insert(user);
        String a = null;
        a.indexOf('c');
        return "succ";
    }

}
