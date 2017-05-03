package com.employee.operations;

import java.util.Arrays;
import java.util.List;

public class EmployeeArrayOperations implements EmployeeOperations {

	private Employee[] employees;
	private int arraySize;
	
	public EmployeeArrayOperations(int size) {
		// TODO Auto-generated constructor stub
		employees = new Employee[size];
	}

	public void createEmployee(Employee employee){
		if(arraySize == employees.length){
			employees = Arrays.copyOf(employees, arraySize*2);
		}
			//System.out.println(arraySize);
			employees[arraySize++] = employee;	
			/*for(Employee emp:employees)
			System.out.println(emp);*/
	}

	public Employee findEmployee(int empId){
		for(int i=0;i<arraySize;i++){

			if(employees[i].getId() == empId){
				return employees[i];
			}
		}
		return null;	
	}

	public List<Employee> findAll(){
		return Arrays.asList(employees);
	}

	public boolean deleteEmployee(int empId){	
		boolean flag = false;
		for(int i=0;i<arraySize;i++){
			if(employees[i].getId() == empId){
				employees[i] = null;									//delete by making it null
				for(int j=i;j<arraySize-1;j++){				
					employees[j] = employees[j+1];                       // shift
				}
				arraySize--;
				employees[arraySize]=null;
				flag = true;
			}
		}
		return flag;
	}

	public boolean updateEmployee(Employee employee){
		boolean flag = false;
		for(int i=0;i<arraySize;i++){
			if(employees[i].getId() == employee.getId()){
				employees[i] = employee;
				flag = true;
			}
		}
		return flag;
	}

	public double displayHRA(int empId){
		double hra=0;
		for(int i=0;i<arraySize;i++){
			if(employees[i].getId() == empId){
				hra = employees[i].calculateHRA();
				break;
			}
		}
		return hra;
	}

	public double displayGrossSal(int empId){
		double grossSal=0;
		for(int i=0;i<arraySize;i++){
			if(employees[i].getId() == empId){
				grossSal = employees[i].calculateGrossSal();
				break;
			}
		}
		return grossSal;
	}
}