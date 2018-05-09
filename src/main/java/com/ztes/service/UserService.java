package com.ztes.service;

import com.ztes.pojo.User;

import java.util.List;

public interface UserService {

    int insert(User bean);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    List<User> selectAll(int pageNum, int pageSize);

    String testRran(User user);

}
