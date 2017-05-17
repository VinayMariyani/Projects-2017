package com.trng.spring.mvc;

import java.sql.SQLException;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trng.spring.mvc.exceptions.EmployeeCreationException;
import com.trng.spring.mvc.model.Employee;
import com.trng.spring.mvc.service.IEmployeeService;
import com.trng.spring.mvc.validators.EmployeeValidator;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@Autowired
	EmployeeValidator employeeValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}

	@RequestMapping(value= "/viewEmployee", method=RequestMethod.POST)
	public ModelAndView getEmployee(@RequestParam /*@Valid*/ String id/*,BindingResult result*/){
		ModelAndView modelAndView = new ModelAndView();	
		Employee employee;
		/*if(result.hasErrors()){
			modelAndView.setViewName("createEmployee");
			return modelAndView;
		}*/
		try {
			employee = employeeService.findEmployee(Integer.parseInt(id));
			if(employee ==null){
				modelAndView.addObject("message", "Employee Not found ");	
			}
			else{
				modelAndView.addObject("employee", employee);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			modelAndView.addObject("message", "Employee not found with given Id");
			e.printStackTrace();
		}
		modelAndView.setViewName("displayEmployee");
		return modelAndView;
	}

	@RequestMapping(value="/newEmployee")
	public ModelAndView createEmployee() {
		ModelAndView modelAndView = new ModelAndView();			
		modelAndView.addObject((new Employee()));
		modelAndView.setViewName("createEmployee");
		return modelAndView;
	}

	@RequestMapping(value="/createEmployee", method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute @Valid Employee employee,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();	
		if(result.hasErrors()){
			modelAndView.setViewName("createEmployee");
			return modelAndView;
		}
		try {
			employeeService.createEmployee(employee);
			modelAndView.addObject("message", "Employee created Successfully");	
		} catch (ClassNotFoundException | SQLException | EmployeeCreationException e) {
			modelAndView.addObject("message", "Error creating the Employee");
			e.printStackTrace();
		}

		modelAndView.setViewName("createEmployee");
		return modelAndView;	
	}

	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute @Valid Employee employee,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			modelAndView.setViewName("displayEmployee");
			return modelAndView;
		}
		boolean flag;
		try {
			flag = employeeService.updateEmployee(employee);			
			if(flag==true){
				modelAndView.addObject("message","Employee Updated Successfully");
			}
			else{
				modelAndView.addObject("message","Error Updating Employee");
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			modelAndView.addObject("message","Error  Updating Employee");
			e.printStackTrace();
		}

		modelAndView.setViewName("displayEmployee");
		return modelAndView;		
	}

	@RequestMapping(value="/deleteEmployee",method=RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		boolean flag;
		try {
			flag = employeeService.deleteEmployee(employee.getId());

			if(flag==true){
				modelAndView.addObject("message", "Employee deleted Successfully");
			}
			else{
				modelAndView.addObject("message", "Employee Not found");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			modelAndView.addObject("message", "Employee Not found");
			e.printStackTrace();
		}
		modelAndView.setViewName("displayEmployee");
		return modelAndView;
	}
	
	@RequestMapping(value= "/viewAll", method=RequestMethod.POST)
	public ModelAndView viewAll(){
		ModelAndView modelAndView = new ModelAndView();	
		List<Employee> employees;
		try {
			employees = employeeService.findAll();
			modelAndView.addObject("employees", employees);
			if(employees == null){
				modelAndView.addObject("message","Error in retrieving the Employees");
			}
		} catch (ClassNotFoundException | SQLException e) {
			modelAndView.addObject("message","Error in retrieving the Employees");
			e.printStackTrace();
		}
		modelAndView.setViewName("displayAll");
		return modelAndView;
	}


}