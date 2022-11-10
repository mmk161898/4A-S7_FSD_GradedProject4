package com.greatLearning.employeeManagement.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.repository.EmployeeRepository;
import com.greatLearning.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> employee = this.employeeRepository.findById(id);

		Employee theEmployee = null;

		if (employee != null) {
			theEmployee = employee.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + id);
		}

		return theEmployee;
	}

	@Override
	public Employee saveOrUpdate(Employee employee) {
		this.employeeRepository.save(employee);
		return employee;
	}

	@Override
	public String deleteById(int id) {
		Employee theEmployee = this.findById(id);
		if (theEmployee != null) {
			this.employeeRepository.deleteById(id);
			return "Deleted employee id - " + id;
		} else {
			return "Employee details are not available for given id";
		}
	}

	@Override
	public List<Employee> searchEmployeeWithFirstName(String firstName) {
		Employee theEmployee = new Employee(firstName, "", "");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "lastName", "email");
		Example<Employee> example = Example.of(theEmployee, exampleMatcher);
		List<Employee> employeesWithFirstName = this.employeeRepository.findAll(example);
		return employeesWithFirstName;
	}

	@Override
	public List<Employee> getAllEmployeesSortedByFirstName(Direction direction) {
		List<Employee> employeesSortedByFirstName = this.employeeRepository.findAll(Sort.by(direction, "firstName"));
		return employeesSortedByFirstName;
	}

}
