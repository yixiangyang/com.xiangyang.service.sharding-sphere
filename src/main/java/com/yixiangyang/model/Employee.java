package com.yixiangyang.model;

import lombok.Data;

import java.util.Date;
@Data
public class Employee {
    private Integer id;

    private String name;

    private Date createTime;

    public Employee() {
    }

    public Employee(Integer id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }
}
