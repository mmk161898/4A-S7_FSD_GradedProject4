package com.greatLearning.employeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public Employee saveOrUpdate(Employee employee);

	public String deleteById(int id);

	public List<Employee> searchEmployeeWithFirstName(String firstName);

	public List<Employee> getAllEmployeesSortedByFirstName(Direction direction);
}
