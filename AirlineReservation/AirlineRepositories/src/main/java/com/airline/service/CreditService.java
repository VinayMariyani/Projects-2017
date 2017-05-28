package com.airline.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.airline.dao.ICrediditCardDao;
import com.airline.entities.CreditCardDetails;

@Service
public class CreditService implements ICreditService{

	@Autowired
	@Qualifier("")
	private ICrediditCardDao creditOperations;

	public CreditService() {
		super();
	}

	public void createCreditInfo(CreditCardDetails creditCard) {
		try {
			creditOperations.createCreditInfo(creditCard);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		};
	}

	public boolean updateCreditInfo(CreditCardDetails creditCard) {
		boolean flag = false;
		try {
			flag = creditOperations.updateCreditInfo(creditCard);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteCreditInfo(int cardNumber) {
		boolean flag = false;
		try {
			flag = creditOperations.deleteCreditInfo(cardNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public CreditCardDetails readCreditInfo(int cardNumber) {
		CreditCardDetails creditCard = null;
		try {
			creditCard = creditOperations.readCreditInfo(cardNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return creditCard;
	}

}