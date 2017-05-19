package com.employee.spring.ServiceInterfaces;

import java.sql.SQLException;
import java.util.List;
import com.employee.operations.Employee;
import com.employee.operations.EmployeeCreationException;

public interface IEmployeeService {

	boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException;
	
	boolean deleteEmployee(int empId) throws ClassNotFoundException, SQLException;
	
	List<Employee> findAll() throws ClassNotFoundException, SQLException;
	
	void createEmployee(Employee employee) throws ClassNotFoundException, SQLException, EmployeeCreationException;
	
	Employee findEmployee(int empId) throws ClassNotFoundException, SQLException;
		
}
