package com.employee.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.rest.exceptions.EmployeeCreationException;
import com.employee.rest.model.Employee;
import com.employee.rest.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
	
	@Autowired
	IEmployeeService employeeService;

	@RequestMapping(value= "/{empId}", method=RequestMethod.POST)
	public ResponseEntity<?> getEmployee(@PathVariable String id){
		Employee employee = null;	
			try {
				employee = employeeService.findEmployee(Integer.parseInt(id));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			if(employee == null){
				return ResponseEntity.noContent().build();
			}
			else{
				return new ResponseEntity<>(employee,HttpStatus.OK);
			}	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> viewAllEmployees(){
		System.out.println("View All Employees Called");	
		try {
				return employeeService.findAll();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}
	}

	@RequestMapping(value="/create",method=RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		try {
			employeeService.createEmployee(employee);
		} catch (ClassNotFoundException | SQLException | EmployeeCreationException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(employee, HttpStatus.CREATED);	
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT, consumes = {"application/json"})
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		boolean flag;
		try {
			flag = employeeService.updateEmployee(employee);			
			if(flag==true){
				return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
			}
			else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	@RequestMapping(value="/{empId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable String id){
		boolean flag;
		try {
			flag = employeeService.deleteEmployee(Integer.parseInt(id));

			if(flag==true){
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
	

