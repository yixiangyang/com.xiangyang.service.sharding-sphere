package com.yixiangyang.mapper;

import com.yixiangyang.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    @Insert("insert into employee(id,name,create_time) values(#{e.id},#{e.name},#{e.createTime})")
    public void inserEmployee(@Param("e") Employee employee);
}
