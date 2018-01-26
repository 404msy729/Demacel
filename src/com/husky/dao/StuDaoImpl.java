package com.husky.dao;

import com.husky.bean.PagerHibernateCallback;
import com.husky.domain.Student;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by songshiwen on 18/1/25.
 */
@Repository("stuDao")
public class StuDaoImpl implements StuDao {
    @Resource
    private HibernateTemplate hibernateTemplate;
    @Override
    public int getTotalRecord(String sql, Object[] args) {
        List<Long> list = (List<Long>) hibernateTemplate.find(sql,args);
        if (list!=null&&list.size()>0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Student> queryStu(String sql, Object[] args, int startIndex, int pageSize) {
        return hibernateTemplate.execute(
                new PagerHibernateCallback<Student>(sql,args,startIndex,pageSize)
        );
    }
}
