package com.employee.operations;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;

		if (e1.getFirstName().compareTo(e2.getFirstName()) > 0)
			return AFTER;
		if (e1.getFirstName().compareTo(e2.getFirstName()) < 0)
			return BEFORE;

		
		if (e1.getLastName().compareTo(e2.getLastName()) < 0)
			return AFTER;
		if (e1.getLastName().compareTo(e2.getLastName()) > 0)
			return BEFORE;			

		return EQUAL;
	}
}
