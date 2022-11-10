package com.greatLearning.employeeManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.repository.RoleRepository;
import com.greatLearning.employeeManagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role saveRole(Role role) {
		return this.roleRepository.save(role);
	}

}
