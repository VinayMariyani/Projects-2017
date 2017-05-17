package com.trng.spring.mvc.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trng.spring.mvc.model.Employee;


@Component
public class EmployeeValidator implements Validator {
	
	public boolean supports(Class<?> claz) {
		return Employee.class.equals(claz);
	}

	public void validate(Object arg0, Errors errors) {
		Employee employee = (Employee) arg0;
		ValidationUtils.rejectIfEmpty(errors,"id","employee.empid.error","id should be a number");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "employee.firstName.error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "employee.lastName.error");
		ValidationUtils.rejectIfEmpty(errors, "salary", "employee.salary.error");
		ValidationUtils.rejectIfEmpty(errors, "gender", "employee.gender.error");
	}

}
