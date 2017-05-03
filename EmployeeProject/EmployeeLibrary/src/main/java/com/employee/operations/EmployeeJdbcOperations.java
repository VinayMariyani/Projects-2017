package com.employee.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.employee.operations.Employee.Gender;

public class EmployeeJdbcOperations implements EmployeeOperations{
	private String url = "jdbc:mysql://localhost:3306/vinay?autoReconnect=true&useSSL=false";
	private String username = "root";
	private String password = "8492";
	private List<Employee> employees;

	public boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		int value;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "update employee set firstName=?, lastName=?, salary=?,gender=? where empId=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, employee.getFirstName());
			statement.setString(2,employee.getLastName());
			statement.setDouble(3, employee.getSalary());
			statement.setString(4,employee.getGender().toString());
			statement.setInt(5,employee.getId());
			value=statement.executeUpdate();
		}

		if(value>0)
			return true;
		else
			return false;
	}

	public boolean deleteEmployee(int empId) throws ClassNotFoundException, SQLException{	
		int value;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "delete from employee where empId = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, empId);
			value = statement.executeUpdate();
		}
		if(value > 0){
			return true;
		}
		return false;
	}

	public List<Employee> findAll() throws ClassNotFoundException, SQLException{
		employees = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "SELECT empId, firstName, lastName, salary, gender FROM employee";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("empId"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
				employees.add(employee);
			}
		}  
		return employees;
	}


	public void createEmployee(Employee employee) throws ClassNotFoundException, SQLException, EmployeeCreationException{
		employees.add(employee);
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "insert into employee(empId,firstName,lastName,salary,gender) values(?,?,?,?,?) ";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, employee.getId());
			statement.setString(2, employee.getFirstName());
			statement.setString(3, employee.getLastName());
			statement.setDouble(4, employee.getSalary());
			statement.setString(5, employee.getGender().toString());
			statement.executeUpdate();
		}
		catch(SQLException e){
			throw new EmployeeCreationException(" Problem in creating the Employee");
		}
	}

	public Employee findEmployee(int empId) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "Select empId,firstName,lastName,salary,gender from vinay.employee where empId = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, empId);
			ResultSet rs = statement.executeQuery();		
			while(rs.next()){
				Employee employee = new Employee();
				employee.setId(rs.getInt("empId"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
				return employee;					
			}	
		}
		return null;
	}

	public double displayHRA(int empId){
		double hra=0;
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getId() == empId){
				hra = employees.get(i).calculateHRA();
				break;
			}
		}
		return hra;
	}

	public double displayGrossSal(int empId){
		double grossSal=0;
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getId() == empId){
				grossSal = employees.get(i).calculateGrossSal();
				break;
			}
		}
		return grossSal;
	}

	public Set<Employee> uniqueElements() throws ClassNotFoundException, SQLException{		
		Set<Employee> set = new HashSet<Employee>(findAll());			
		return set;
	}

	public List<Employee> sortedListNames() throws ClassNotFoundException, SQLException{
		employees = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "Select empId,firstName,lastName,salary,gender from employee order by firstName";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()){
				Employee employee = new Employee();
				employee.setId(rs.getInt("empId"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
				employees.add(employee);
			}
		}
		return employees;
	}

	public List<Employee> sortedListSalary() throws ClassNotFoundException, SQLException{
		employees = new ArrayList<>();
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "Select empId,firstName,lastName,salary,gender from employee order by salary";
			PreparedStatement statement = con.prepareStatement(query);
			statement.executeQuery();	
			ResultSet rs = statement.executeQuery();		
			while(rs.next()){
				Employee employee = new Employee();
				employee.setId(rs.getInt("empId"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
				employees.add(employee);
			}
		}
		return employees;
	}

	public Map<Double,Integer> salaryWiseCount() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Map<Double, Integer> employeeMap = new HashMap<Double,Integer>();
		try (Connection con = DriverManager.getConnection(url,username,password);) {
			String query = "select salary,count(salary) from employee group by salary";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				employeeMap.put(rs.getDouble("salary"),rs.getInt(2));     
			}
		}  
		return employeeMap;
	}
}
