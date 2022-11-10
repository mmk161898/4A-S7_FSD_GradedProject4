package com.greatLearning.employeeManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.repository.UserRepository;
import com.greatLearning.employeeManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
		return this.userRepository.save(user);
	}

}
