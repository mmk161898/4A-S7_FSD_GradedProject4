package com.greatLearning.employeeManagement.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	public static final String ASC = "asc";
	public static final String DESC = "desc";

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable int id) {
		return this.employeeService.findById(id);
	}

	@PutMapping("/update")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveOrUpdate(employee);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return this.employeeService.deleteById(id);
	}

	@GetMapping("/search/{firstName}")
	public List<Employee> findEmployeeByFirstName(@PathVariable String firstName) {
		return this.employeeService.searchEmployeeWithFirstName(firstName);
	}

	@GetMapping("/sort")
	public List<Employee> getEmployeesSortedByFirstName(@PathParam(value = "order") String order) {
		List<Employee> employees = null;
		if (order.equalsIgnoreCase(ASC)) {
			employees = this.employeeService.getAllEmployeesSortedByFirstName(Direction.ASC);
		} else if (order.equalsIgnoreCase(DESC)) {
			employees = this.employeeService.getAllEmployeesSortedByFirstName(Direction.DESC);
		}
		return employees;
	}
}
