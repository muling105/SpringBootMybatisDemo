package com.ztes.service.impl;

import com.github.pagehelper.PageHelper;
import com.ztes.common.enums.ResultEnum;
import com.ztes.common.exception.UserException;
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

    public void exceptionName(int userId) throws Exception{
        User user = userMapper.selectByPrimaryKey(userId);
        String prePhone = user.getPhone().substring(0, 3);
        if(prePhone.contains("139")){
            throw new UserException(ResultEnum.ONE_ERROR);
        }else if(prePhone.contains("156")){
            throw new UserException(ResultEnum.TWO_ERROR);
        }else {
            throw new UserException(ResultEnum.OTHER_ERROR);
        }
    }

    @Transactional
    public String testRran(User user){
        userMapper.insert(user);
        String a = null;
        a.indexOf('c');
        return "succ";
    }

}
