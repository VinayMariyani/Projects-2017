package com.airline.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCardDetails")
public class CreditCardDetails {

	@Id
	@JoinColumn(name = "profileId")
	private int profileId;
	private int cardNumber;
	private String cardType;
	private int expiration_month;
	private int expiration_year;
	
	public CreditCardDetails() {
		
	}

	public CreditCardDetails(int cardNumber, String cardType, int expiration_month, int expiration_year, int profileId) {
		super();
		this.profileId = profileId;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expiration_month = expiration_month;
		this.expiration_year = expiration_year;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getExpiration_month() {
		return expiration_month;
	}

	public void setExpiration_month(int expiration_month) {
		this.expiration_month = expiration_month;
	}

	public int getExpiration_year() {
		return expiration_year;
	}

	public void setExpiration_year(int expiration_year) {
		this.expiration_year = expiration_year;
	}

	@Override
	public String toString() {
		return "CreditCardDetails [profileId=" + profileId + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", expiration_month=" + expiration_month + ", expiration_year=" + expiration_year + "]";
	}
	
	
}
