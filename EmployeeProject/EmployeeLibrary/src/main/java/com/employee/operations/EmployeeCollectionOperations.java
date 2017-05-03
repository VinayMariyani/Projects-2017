package com.employee.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeCollectionOperations implements EmployeeOperations {

	private List<Employee> employees;
	private int arraySize;

	public EmployeeCollectionOperations(int size) {
		employees = new ArrayList<>(size);
	}

	public void createEmployee(Employee employee){

		employees.add(employee);	
	}

	public Employee findEmployee(int empId){
		for(int i=0;i<employees.size();i++){

			if(employees.get(i).getId() == empId ){
				return employees.get(i);
			}
		}
		return null;	
	}

	public List<Employee> findAll(){
		return employees;
	}

	public boolean deleteEmployee(int empId){	
		boolean flag = false;
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getId() == empId){
				employees.remove(i);									//delete by making it null
				flag = true;
			}
		}
		return flag;
	}

	public boolean updateEmployee(Employee employee){
		boolean flag = false;
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getId() == employee.getId()){
				employees.set(i, employee);
				flag = true;
			}
		}
		return flag;
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
		for(int i=0;i<arraySize;i++){
			if(employees.get(i).getId() == empId){
				grossSal = employees.get(i).calculateGrossSal();
				break;
			}
		}
		return grossSal;
	}

	public Set<Employee> uniqueElements(){		
		Set<Employee> employeeSet = new HashSet<>(employees);
		return employeeSet;	
	}

	public List<Employee> sortedListNames(){
		
		Collections.sort(employees, new EmployeeComparator());
		return employees;

	}

	public List<Employee> sortedListSalary() {
		Collections.sort(employees, new EmployeeSalaryComparator());
		return employees;
	}

	public Map<Double,Integer> salaryWiseCount(){
		Map<Double,Integer> employeeMap = new HashMap<>();

		for(Employee emp:employees){
			if(employeeMap.containsKey(emp.getSalary())){
				employeeMap.put(emp.getSalary(), employeeMap.get(emp.getSalary())+1);
			}
			else{
				employeeMap.put(emp.getSalary(),1);
			}
		}
		return employeeMap;



	}



}