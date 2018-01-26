package com.husky.action;

import com.husky.domain.Student;

import java.util.List;

/**
 * Created by songshiwen on 18/1/25.
 */
public class BeanResult {
    private int total;
    private List<Student> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
}
