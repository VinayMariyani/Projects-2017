package com.airline.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.airline.entities.CreditCardDetails;
import com.airline.utils.HibernateUtils;

public class CreditCardDaoImpl implements ICrediditCardDao {

	SessionFactory sf;

	public CreditCardDaoImpl() {
		sf = HibernateUtils.getSessionFactory();
	}
	
	public void createCreditInfo(CreditCardDetails creditCard) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(creditCard);
		transaction.commit();
		session.close();	
	}

	public boolean updateCreditInfo(CreditCardDetails creditCard) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession(); 
		Transaction transaction = session.beginTransaction();
		session.update(creditCard);
		transaction.commit();
		session.close();
		return true;
	}

	public boolean deleteCreditInfo(int cardNumber) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		CreditCardDetails creditCard = (CreditCardDetails) session.load(CreditCardDetails.class, cardNumber);
		session.delete(creditCard);
		transaction.commit();
		session.close();
		return true;
	}

	public CreditCardDetails readCreditInfo(int cardNumber) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		CreditCardDetails creditCard = (CreditCardDetails) session.get(CreditCardDetails.class, cardNumber);
		transaction.commit();
		session.close();
		return creditCard;
	}

}
