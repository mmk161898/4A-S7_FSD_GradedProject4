package com.greatLearning.employeeManagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatLearning.employeeManagement.entity.Employee;
import com.greatLearning.employeeManagement.entity.Role;
import com.greatLearning.employeeManagement.entity.User;
import com.greatLearning.employeeManagement.repository.EmployeeRepository;
import com.greatLearning.employeeManagement.repository.RoleRepository;
import com.greatLearning.employeeManagement.repository.UserRepository;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RoleRepository roleRepository;

	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UserRepository userRepository;

	@Bean
	public void initialize() {
		Employee e1 = new Employee();
		e1.setFirstName("Meet");
		e1.setLastName("Mevada");
		e1.setEmail("meetmevada1998@gmail.com");
		this.employeeRepository.save(e1);
		Employee e2 = new Employee();
		e2.setFirstName("Honey");
		e2.setLastName("Mevada");
		e2.setEmail("honeymevada1998@gmail.com");
		this.employeeRepository.save(e2);

		Role r1 = new Role("ADMIN");
		Role r2 = new Role("USER");
		this.roleRepository.save(r1);
		this.roleRepository.save(r2);

		List<Role> roles = new ArrayList<>();
		roles.add(r2);

		List<Role> roles1 = new ArrayList<>();
		roles1.add(r2);
		roles1.add(r1);

		User user = new User();
		user.setUserName("Meet");
		user.setPassword(bCryptPasswordEncoder().encode("12345"));
		user.setRoles(roles);
		this.userRepository.save(user);

		User user1 = new User();
		user1.setUserName("Honey");
		user1.setPassword(bCryptPasswordEncoder().encode("12345"));
		user1.setRoles(roles1);
		this.userRepository.save(user1);
	}

}
