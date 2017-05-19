package com.trng.spring.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.trng.spring.mvc.exceptions.EmployeeCreationException;
import com.trng.spring.mvc.jdbc.IEmployeeRepository;
import com.trng.spring.mvc.model.Employee;

@Service
public class EmployeeDBservice implements IEmployeeService {
	
	@Autowired
	@Qualifier("dbRepository")
	private IEmployeeRepository employeeOperations;

	/*public EmployeeDBservice(IEmployeeRepository employeeOperations) {
		this.employeeOperations = employeeOperations;
	}*/

	//EmployeeOperations employeeOperations = new EmployeeJdbcImpl();
	
	public EmployeeDBservice() {
		super();
	}

	@Override
	public boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		boolean flag = employeeOperations.updateEmployee(employee);
		return flag;
	}

	@Override
	public boolean deleteEmployee(int empId) throws ClassNotFoundException, SQLException {
		boolean flag = employeeOperations.deleteEmployee(empId);
		return flag;
	}

	@Override
	public List<Employee> findAll() throws ClassNotFoundException, SQLException {
		List<Employee> employees= employeeOperations.findAll();
		return employees;
	}

	@Override
	public Employee findEmployee(int empId) throws ClassNotFoundException, SQLException {
		Employee employee = employeeOperations.findEmployee(empId);
		return employee;
	}

	@Override
	public void createEmployee(Employee employee)
			throws ClassNotFoundException, SQLException, EmployeeCreationException {
		employeeOperations.createEmployee(employee);
		
	}


	public double displayHRA(int empId) {
		double hra = employeeOperations.displayHRA(empId);
		return hra;
	}

	public double displayGrossSal(int empId) {
		double grossSal = employeeOperations.displayGrossSal(empId);
		return grossSal;
	}

}
