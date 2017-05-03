package com.employee.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.employee.operations.Employee;
import com.employee.operations.EmployeeCreationException;


public class EmployeeUtil {
	static Scanner scInput;

	public static Employee readEmployee() throws EmployeeCreationException{
		int empId=0;
		double salary=0;
		int gender=0;
		String firstName=null;
		String lastName = null;
		scInput = new Scanner(System.in);	
		System.out.print("Enter Employee id:");
		try{
		empId = scInput .nextInt();
		System.out.print("Enter Employee firstname:");
		firstName = scInput.next();
		System.out.print("Enter Employee lastname:");
		lastName = scInput.next();
		System.out.print("Enter Employee Salary(should be greater than 10000):");
		salary = scInput.nextDouble();
		System.out.println("Select the gender");
		System.out.println("	1.Male");
		System.out.println("	2.Female");
		gender = scInput.nextInt();
		if(gender != 1 && gender!= 2){
			System.out.println(" Enter proper input !!!! Press 1 for Male, 2 for Female ");
			readEmployee();
		}
		else{
			Employee employee = new Employee(empId, firstName, lastName, salary, gender);
			
			if(employee.getSalary() <= 10000){
				System.out.println("Salary is less than 10000.Enter Salary of Employee id "+employee.getId()+ " again");
				int sal = scInput.nextInt();
				employee.setSalary(sal);
			}
			//System.out.println(employee);
			return employee;
		}
		
		}
		catch(InputMismatchException e){
			throw new EmployeeCreationException("Wrong type inputs entered.Enter details again");
		}
		
		return null;
	
	}

	public static int getChoice() throws InputMismatchException{
		int choice = 0;
		scInput = new Scanner(System.in);
		System.out.println();
		System.out.println("   ||| MENU |||   ");
		System.out.println("1. Create Employee");
		System.out.println("2. Read(View) Employee");
		System.out.println("3. View all Employees");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Calculate HRA");
		System.out.println("7. Calculate Gross Salary");
		System.out.println("8. Unique Employee names list in the System");
		System.out.println("9. Sort the Employees");
		System.out.println("10.Display Salary Wise Count");
		System.out.println("11. Exit");

		System.out.print("Select a choice :");
		if(scInput.hasNextInt()){
			choice = scInput.nextInt();
		}
		return choice;

	}

	
}

