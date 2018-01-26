package com.husky.dao;

import com.husky.domain.Student;

import java.util.List;

/**
 * Created by songshiwen on 18/1/25.
 */
public interface StuDao {
    int getTotalRecord(String sql,Object[] args);
    List<Student> queryStu(String sql,Object[] args,int startIndex,int pageSize);
}
