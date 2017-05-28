package com.airline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PassengerProfile")
public class PassengerProfile {

	@Id
	private int profileId;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	@Column(name="phoneNo")
	private Long tel_no;
	private String email_id;
	
	
	public PassengerProfile() {
		
	}

	
	public PassengerProfile(int profileId, String password, String firstName, String lastName, String address,
			Long tel_no, String email_id) {
		super();
		this.profileId = profileId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.tel_no = tel_no;
		this.email_id = email_id;
	}



	public int getProfileId() {
		return profileId;
	}


	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getTel_no() {
		return tel_no;
	}


	public void setTel_no(Long tel_no) {
		this.tel_no = tel_no;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	@Override
	public String toString() {
		return "PassengerProfile [profileId=" + profileId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", tel_no=" + tel_no + ", email_id=" + email_id
				+ "]";
	}
	
	
}
