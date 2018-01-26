package com.husky.service;

import com.husky.bean.PageBean;
import com.husky.domain.Student;

/**
 * Created by songshiwen on 18/1/25.
 */
public interface StuService {
    PageBean<Student> queryStu(Student student,int pageNum,int pageSize);
}
