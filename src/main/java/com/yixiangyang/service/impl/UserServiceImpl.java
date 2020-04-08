package com.yixiangyang.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import javax.annotation.Resource;

import com.yixiangyang.mapper.EmployeeMapper;
import com.yixiangyang.model.Employee;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.yixiangyang.mapper.UserMapper;
import com.yixiangyang.model.EmpLogin;
import com.yixiangyang.model.User;
import com.yixiangyang.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Resource
	private EmployeeMapper employeeMapper;
	@Override
	public void addUser(User user) {
//		HintManager.getInstance().setMasterRouteOnly();
		Date createTime = new Date(System.currentTimeMillis());
//		Integer ad = userMapper.getMaxUserId();
//		Integer id = ad+1;
//		User user = new User(id,"向阳test1", createTime);
		userMapper.inserUser(user);
//		userMapper.getUsers();
//		userMapper.inserUser(user);
//		HintManager.clear();
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		CompletableFuture<List<String>> future1 = CompletableFuture.supplyAsync(new Supplier<List<String>>() {
//
//			@Override
//			public List<String> get() {
//				Date createTime = new Date(System.currentTimeMillis());
//				for (int i = 0; i < 10000; i++) {
//					User user = new User("测试名字"+i, createTime);
//					userMapper.inserUser(user);
//				}
//				return null;
//			}
//			
//		},executor);
//		if(future1.isDone()) {
//			executor.shutdown();
//		}
	}


	@Override
	public List<User> getUsers() {
		List<User> users = userMapper.getUsers();
		return users;
	}

	@Override
	public List<User> getSlave() {
		List<User> users = userMapper.getUsers2();
		return users;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeMapper.inserEmployee(employee);
	}

	@Override
	@Transactional
	public void addUser() {
		Date createTime = new Date(System.currentTimeMillis());
		User user1 = new User(101,"这个是测试回滚",createTime);
		userMapper.inserUser(user1);
		User user2 = new User(50026,"这个是测试回滚",createTime);
		userMapper.inserUser(user2);

	}

}
