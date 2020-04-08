package com.yixiangyang.service;

import java.util.List;

import com.yixiangyang.model.Employee;
import com.yixiangyang.model.User;

public interface UserService {
	public void addUser(User user);
	
	public List<User> getUsers();
	
	public List<User> getSlave();

	public void addEmployee(Employee employee);

	public void addUser();
}
