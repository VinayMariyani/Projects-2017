package com.employee.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.employee.operations.Employee;

@Configuration
@ComponentScan(basePackages={"com.employee.spring.*"})
public class EmployeeAppConfig {
	
	@Bean
	public Employee getEmployee(){
		return new Employee();
	}
	
}
