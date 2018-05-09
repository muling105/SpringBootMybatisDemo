package com.ztes.controller;

import com.ztes.pojo.LearnCourse;
import com.ztes.service.LearnCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/learnCourse")
public class LearnCourseController {

    @Autowired
    private LearnCourseService learnCourseService;

    @RequestMapping("/saveBean")
    public int saveBean(LearnCourse bean){
        return learnCourseService.saveBean(bean).getId();
    }

    @RequestMapping("/update")
    public int update(LearnCourse bean){
        return learnCourseService.update(bean).getId();
    }

    @RequestMapping("/delete")
    public int delete(int id){
        return learnCourseService.delete(id);
    }

    @RequestMapping("/selectOne")
    public String selectOne(int id){
        LearnCourse bean = learnCourseService.selectOne(id);
        return bean.toString();
    }

}
