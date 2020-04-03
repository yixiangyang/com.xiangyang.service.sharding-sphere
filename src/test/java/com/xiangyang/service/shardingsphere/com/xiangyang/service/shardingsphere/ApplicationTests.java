package com.xiangyang.service.shardingsphere.com.xiangyang.service.shardingsphere;

import com.xiangyang.service.application.Application;
import com.yixiangyang.model.Employee;
import com.yixiangyang.model.User;
import com.yixiangyang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTests {
	@Resource
	private UserService userService;
	@Test
	public void mm() {
		for(int i=50003;i<50020;i++){
			System.out.println(i);
			Date createTime = new Date(System.currentTimeMillis());
			userService.addUser(new User(i,"test"+i,createTime));
		}
	}

	@Test
	public void addEmployee (){
		for(int i=5000;i<5100;i++){
			Date createTime = new Date(System.currentTimeMillis());
			userService.addEmployee(new Employee(i,"test"+i,createTime));
		}
	}
	@Test
	public void addEmployee1 (){
		for(int i=50003;i<50020;i++){
			System.out.println(i);
			Date createTime = new Date(System.currentTimeMillis());
			userService.addUser(new User(i,"test"+i,createTime));
		}
	}

}
