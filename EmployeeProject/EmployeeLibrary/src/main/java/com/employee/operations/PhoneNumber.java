package com.employee.operations;

public class PhoneNumber {

	String AreaCode;
	String number;
	Employee owner;
	String type;
	
	
	
	public String getAreaCode() {
		return AreaCode;
	}
	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int id;
}
