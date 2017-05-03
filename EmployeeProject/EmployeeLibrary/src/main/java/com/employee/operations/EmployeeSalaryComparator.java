package com.employee.operations;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		// Then compare by marks, high marks first.
		if (e1.getSalary() > e2.getSalary())
			return AFTER;
			
		if (e1.getSalary() < e2.getSalary())
			return BEFORE;

		return EQUAL;
	}
	
}