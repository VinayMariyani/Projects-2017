package com.trng.spring.mvc.model;

public class Employee{

	public enum Gender{
		FEMALE,MALE;
	}

	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	Gender gender;

	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, double salary,int gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		if(gender == 1){
			this.gender = Gender.MALE;
		}else if(gender == 2){
			this.gender = Gender.FEMALE;
		}
	}

	public double calculateHRA(){
		double hra = (salary)*(20.00/100.00);
		return hra;		
	}

	public double calculateGrossSal(){	
		double grossSal = this.salary + calculateHRA();
		return grossSal;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", LastName=" + lastName + ", salary=" + salary
				 + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		return true;
	}


}
