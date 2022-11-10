package com.greatLearning.employeeManagement.service;

import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Role;

@Service
public interface RoleService {

	public Role saveRole(Role role);

}
