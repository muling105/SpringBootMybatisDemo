package com.ztes.service;

import com.ztes.pojo.LearnCourse;

public interface LearnCourseService {

    LearnCourse update(LearnCourse bean);

    int delete(int id);

    LearnCourse selectOne(int id);

    LearnCourse saveBean(LearnCourse bean);

}
