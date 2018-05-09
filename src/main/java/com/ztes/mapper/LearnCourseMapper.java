package com.ztes.mapper;

import com.ztes.pojo.LearnCourse;
import tk.mybatis.mapper.common.Mapper;

public interface LearnCourseMapper extends Mapper<LearnCourse> {

    void saveBean(LearnCourse bean);


}