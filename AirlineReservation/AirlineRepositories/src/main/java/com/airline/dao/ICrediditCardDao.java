package com.airline.dao;

import java.sql.SQLException;

import com.airline.entities.CreditCardDetails;

public interface ICrediditCardDao {
	void createCreditInfo(CreditCardDetails creditCard) throws ClassNotFoundException, SQLException;
	boolean updateCreditInfo(CreditCardDetails creditCard) throws ClassNotFoundException, SQLException;
	boolean deleteCreditInfo(int cardNumber) throws ClassNotFoundException, SQLException;
	CreditCardDetails readCreditInfo(int cardNumber) throws ClassNotFoundException, SQLException; 
}
