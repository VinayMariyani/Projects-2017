package com.employee.hibernate.app;

import static com.employee.hibernate.app.EmployeeUtil.getChoice;
import static com.employee.hibernate.app.EmployeeUtil.readEmployee;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.employee.hibernate.bean.SalaryCount;
import com.employee.hibernate.dao.EmployeeCreationException;
import com.employee.hibernate.dao.EmployeeDao;
import com.employee.hibernate.dao.IEmployeeDao;
import com.employee.hibernate.pojo.Employee;



public class EmployeeApp {

	static Scanner scInput ;
	Employee employee = null;
	IEmployeeDao employeeOperations= null; 
	
	public EmployeeApp(){
    	employeeOperations=new EmployeeDao();
	}
	
	public static void main(String[] args) {
		EmployeeApp employeeTest = new EmployeeApp();
		//employeeTest.getSize();
		System.out.println("************Employee System**********");   	
		int choice = 0;	
		do{
			try{
				choice = getChoice();
			}
			catch(InputMismatchException e){
				System.out.println("Choice should be an integer.Try again !!");
				getChoice();
			}
			switch(choice){
			case 1: 
				try {
					employeeTest.addEmployee();
				} catch ( Exception e1) {
					System.out.println("Employee cannot be created.Try Again with different id !!");
				}
				break;
			case 2:
				employeeTest.displayEmployeeInfo();			
				break;
			case 3:
				employeeTest.displayAll();
				break;
			case 4:
				try {
					employeeTest.updateEmployee();
				} catch (Exception e) {
					System.out.println("Employee cannot be Updated.Try again !!");
				}
				break;
			case 5:
				employeeTest.deleteEmployee();
				break;
			case 6:
				employeeTest.displayHra();
				break;			
			case 7:
				employeeTest.displayGrossSal();
				break;			
			case 8:
				employeeTest.getUniqueElements();
				break;	
			case 9:
				System.out.println("1.Sort by names");
				System.out.println("2.Sort by Salary");
				try{
					scInput = new Scanner(System.in);
					int option = scInput.nextInt();
					if(option == 1){
						employeeTest.sortNames();
					}
					else if(option == 2){
						employeeTest.sortSalary();
					}
				}
				catch(InputMismatchException e){
					System.out.println("Select correct choice");
				}
				break;
			case 10:
				employeeTest.displaySalaryCount();
				break;
			case 11: 
				System.out.println("......End of Application......");
				break;
			default :
				System.out.println("Invalid Choice.Enter a valid choice !!");
				break;
			}
		}while(choice!=11);
	}

	private void displaySalaryCount() {
		List<SalaryCount> employees = null;
		try {
			employees = ((EmployeeDao)employeeOperations).salaryWiseCount();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("error in counting salary");
		}
		
		Map<Double,Long> salaryCountResults = new HashMap<Double,Long>();
		
		for(SalaryCount count: employees ){
			salaryCountResults.put(count.getSalary(), (long) count.getCount());
		}
		salaryCountResults.forEach((k,v)->System.out.println("Salary : " + k + " Count : " + v));
	}

	private void sortSalary() {
		List<Employee> employees = null;
		try {
			employees = ((EmployeeDao)employeeOperations).sort("salary");
		} catch (SQLException e) {
			System.out.println("Sorting error");
		}
		for(Employee empl:employees){
			System.out.println(empl);
		}
	}

	private void sortNames() {
		List<Employee> employees = null;
		try {
			employees = ((EmployeeDao)employeeOperations).sort("firstName");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(Employee empl:employees){
			System.out.println(empl);
		}
	}

	
	private void getUniqueElements() {
		Set<Employee> emp = null;
		try {
			emp = ((EmployeeDao)employeeOperations).uniqueElements();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Unique Employees based on names are: ");
		for(Employee empl:emp){
			System.out.println(empl);
		}
	}

	private void displayGrossSal() {
		int empId = readEmployeeid();
		double grossSal =employeeOperations.displayGrossSal(empId);
		if(grossSal == 0){
			System.out.println("Employee id not found");
		}
		else{
			System.out.println("Gross Salary of employee id "+empId+ " is : " +  grossSal);
		}
	}

	private void displayHra() {
		int empId = readEmployeeid();
		double hra =employeeOperations.displayHRA(empId);
		if( hra == 0){
			System.out.println("Employee id not found");
		}
		else{
			System.out.println("Hra of employee id "+empId+ " is : " +hra);
		}
	}

	private void deleteEmployee() {
		int empId = readEmployeeid();			
		boolean flag = false;
		try {
			flag = employeeOperations.deleteEmployee(empId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (flag == true){
			System.out.println("Successfully Deleted");
		}
		else{
			System.out.println("---Unable to Delete -- Employee with id " + empId + " not present");
		}
	}

	private void updateEmployee() throws EmployeeCreationException {
		System.out.println("Enter Employees data for update");

		employee = readEmployee();
		boolean flag = false;
		try {
			flag = employeeOperations.updateEmployee(employee);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag == true){
			System.out.println("Successfully Updated");
		}
		else{
			System.out.println("---Unable to Update --Employee with id "+ employee.getId() +" not present");
		}
	}

	private int readEmployeeid() {
		// TODO Auto-generated method stub
		scInput = new Scanner(System.in);
		int empId = 0;
		try{
			System.out.println("Enter the employee id:");
			empId = scInput.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Id should be of integer type");
			readEmployeeid();

		}

		return empId;
	}

	private void displayAll() {		
		List<Employee> employees = null;
		try {
			employees = employeeOperations.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		for( Employee employee : employees){
			if(employee!= null){
				System.out.println(employee);
			}
		}
	}

	private boolean displayEmployeeInfo() {
		// TODO Auto-generated method stub
		int empId = readEmployeeid();
		Employee employee = null;
		try {
			employee = employeeOperations.findEmployee(empId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(employee!=null){
			System.out.println(employee);
			return true;
		}
		else{
			System.out.println("Employee with id" +empId+ " not present in the system");
			return false;
		}
	}

	private void addEmployee() throws EmployeeCreationException {
		Employee employee = null;
		try{
			employee = readEmployee();

		}
		catch(InputMismatchException e){
			System.out.println("Invalid type of data entered.Enter valid information to add the employee");
			employee = readEmployee();
		}
		try {
			employeeOperations.createEmployee(employee);
			System.out.println("employee created sucessfully in the system");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot create employee - duplicate entry");
		}

	}

}