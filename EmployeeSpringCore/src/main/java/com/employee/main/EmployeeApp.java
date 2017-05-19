package com.employee.main;


import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.employee.spring.ServiceImplementation.EmployeeDBservice;
import com.employee.spring.config.EmployeeAppConfig;



public class EmployeeApp {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(EmployeeAppConfig.class);
		
	//	Employee emp = appContext.getBean();
		
		EmployeeDBservice employeeService = appContext.getBean(EmployeeDBservice.class);
        try {
			System.out.println(employeeService.findAll());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

}
