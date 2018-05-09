package com.ztes.service.impl;

import com.ztes.mapper.LearnCourseMapper;
import com.ztes.pojo.LearnCourse;
import com.ztes.service.LearnCourseService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "learnCourse")
public class LearnCourseServiceImpl implements LearnCourseService {

    @Resource
    private LearnCourseMapper learnCourseMapper;

    /*往缓存里添加值，key为参数post的id属性， #p参数index”
    这样当我们save一个Post对象时，redis就会新增一个以id为key的Post对象*/
    @CachePut(key = "'learnCourseId-' + #p0.id")
    public LearnCourse saveBean(LearnCourse bean){
        learnCourseMapper.saveBean(bean);
        return bean;
    }

    @CachePut(key = "'learnCourseId-' + #p0.id")
    public LearnCourse update(LearnCourse bean){
        learnCourseMapper.updateByPrimaryKey(bean);
        return bean;
    }

    @Transactional
    //删除redis的相关记录
    @CacheEvict(key = "'learnCourseId-' + #p0")
    public int delete(int id){
        return learnCourseMapper.deleteByPrimaryKey(id);
    }

    //#p0代表第一个参数，也就是id， #p参数index”
    @Cacheable(key = "'learnCourseId-' + #p0", unless = "#result == null")
    public LearnCourse selectOne(int id){
        return learnCourseMapper.selectByPrimaryKey(id);
    }



}
