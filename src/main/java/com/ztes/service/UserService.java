package com.ztes.service;

import com.ztes.common.BackResult;
import com.ztes.pojo.User;

import java.util.List;

public interface UserService {

    int insert(User bean);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    List<User> selectAll(int pageNum, int pageSize);

    void exceptionName(int userId) throws Exception;

    BackResult selectTwo(Integer userId) throws Exception;

    String testRran(User user);

}
