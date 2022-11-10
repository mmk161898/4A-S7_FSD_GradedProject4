package com.greatLearning.employeeManagement.service;

import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.User;

@Service
public interface UserService {

	public User saveUser(User user);

}
