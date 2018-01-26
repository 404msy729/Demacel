package com.husky.service;

import com.husky.bean.PageBean;
import com.husky.dao.StuDao;
import com.husky.domain.Student;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by songshiwen on 18/1/25.
 */
@Service("stuService")
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;


    @Override
    public PageBean<Student> queryStu(Student student, int pageNum, int pageSize) {
        String sql = "from Student where 1=1 ";
        Object[] args;
        List<Object> params = new ArrayList<>();
        if (!StringUtils.isBlank(student.getSname())){
            sql+=" and sname like ? ";
            params.add("%"+student.getSname()+"%");
        }
        args=params.toArray();
        int totalRecord = stuDao.getTotalRecord("select count(sid) "+sql,args);
        PageBean<Student> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Student> studentList = stuDao.queryStu(sql,args,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setBeanList(studentList);
        return pageBean;
    }
}
