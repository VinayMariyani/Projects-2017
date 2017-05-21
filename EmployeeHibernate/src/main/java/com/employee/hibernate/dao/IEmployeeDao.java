package com.employee.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import com.employee.hibernate.pojo.Employee;

public interface IEmployeeDao {

	boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException;

	boolean deleteEmployee(int empId) throws ClassNotFoundException, SQLException;

	public List<Employee> findAll() throws ClassNotFoundException, SQLException;

	Employee findEmployee(int empId) throws ClassNotFoundException, SQLException;

	void createEmployee(Employee employee) throws ClassNotFoundException, SQLException, EmployeeCreationException;
	
	List<Employee> sort(String criteria) throws SQLException;

	double displayGrossSal(int empId);

	double displayHRA(int empId);
}
