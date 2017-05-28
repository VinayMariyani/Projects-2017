package com.airline.service;

import com.airline.entities.CreditCardDetails;

public interface ICreditService {
	void createCreditInfo(CreditCardDetails creditCard);
	boolean updateCreditInfo(CreditCardDetails creditCard);
	boolean deleteCreditInfo(int cardNumber);
	CreditCardDetails readCreditInfo(int cardNumber); 
}
