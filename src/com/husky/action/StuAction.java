package com.husky.action;

import com.husky.bean.PageBean;
import com.husky.domain.Student;
import com.husky.service.StuService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by songshiwen on 18/1/25.
 */
@Controller("stuAction")
@Scope("prototype")
public class StuAction extends ActionSupport implements ModelDriven<Student> {
    @Resource
    private StuService stuService;

    private Student student;
    private BeanResult beanResult;
    private int PageIndex;
    private int pageSize;

    public String queryStu(){
        PageBean<Student> pageBean = stuService.queryStu(student,getPageIndex()+1,getPageSize());
        beanResult=new BeanResult();
        beanResult.setTotal(pageBean.getTotalPage());
        beanResult.setData(pageBean.getBeanList());
        return SUCCESS;
    }

    public BeanResult getBeanResult() {
        return beanResult;
    }

    public void setBeanResult(BeanResult beanResult) {
        this.beanResult = beanResult;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    @Override
    public Student getModel() {
        student=new Student();
        return student;
    }
}
