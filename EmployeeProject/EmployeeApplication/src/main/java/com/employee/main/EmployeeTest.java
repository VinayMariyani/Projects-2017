package com.employee.main;

import static com.employee.main.EmployeeUtil.getChoice;
import static com.employee.main.EmployeeUtil.readEmployee;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.employee.operations.Employee;
import com.employee.operations.EmployeeCreationException;
import com.employee.operations.EmployeeJdbcOperations;
import com.employee.operations.EmployeeOperations;


public class EmployeeTest {

	static Scanner scInput ;
	Employee employee = null;
	EmployeeOperations employeeOperations= null; //interface obj
	public static void main(String[] args) {
		EmployeeTest employeeTest = new EmployeeTest();
		employeeTest.getSize();
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
				} catch (EmployeeCreationException e) {

					System.out.println("Employee cannot be created.Try Again !!");
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
				} catch (EmployeeCreationException e) {
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

	private void getSize() {
		try{
			employeeOperations = new EmployeeJdbcOperations();
			try {
				employeeOperations.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		catch(InputMismatchException e){
			System.out.println("Number of Records should be an integer.");
			getSize();
		}

		
	}

	private void displaySalaryCount() {
		Map<Double, Integer> employeeMap = null;
		try {
			employeeMap = ((EmployeeJdbcOperations)employeeOperations).salaryWiseCount();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("error in counting salary");
		}
		for (Entry<Double, Integer> entry : employeeMap.entrySet()) {
			System.out.println(entry.getKey() + " : " +  entry.getValue());
		}
	}

	private void sortSalary() {
		List<Employee> employees = null;
		try {
			employees = ((EmployeeJdbcOperations)employeeOperations).sortedListSalary();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Sorting error");
		}
		for(Employee empl:employees){
			System.out.println(empl);
		}
	}

	private void sortNames() {
		List<Employee> employees = null;
		try {
			employees = ((EmployeeJdbcOperations)employeeOperations).sortedListNames();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		for(Employee empl:employees){
			System.out.println(empl);
		}
	}

	private void getUniqueElements() {
		Set<Employee> emp = null;
		try {
			emp = ((EmployeeJdbcOperations)employeeOperations).uniqueElements();
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