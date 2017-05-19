package com.trng.spring.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.trng.spring.mvc.exceptions.EmployeeCreationException;
import com.trng.spring.mvc.model.Employee;


public interface IEmployeeService {

	boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	
	boolean deleteEmployee(int empId) throws ClassNotFoundException, SQLException;
	
	List<Employee> findAll() throws ClassNotFoundException, SQLException;
	
	void createEmployee(Employee employee) throws ClassNotFoundException, SQLException, EmployeeCreationException;
	
	Employee findEmployee(int empId) throws ClassNotFoundException, SQLException;
		
}
