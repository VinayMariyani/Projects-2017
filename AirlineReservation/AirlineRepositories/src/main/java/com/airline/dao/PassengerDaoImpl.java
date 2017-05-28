package com.airline.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.airline.entities.PassengerProfile;
import com.airline.utils.HibernateUtils;

public class PassengerDaoImpl implements IPassengerDao{
	SessionFactory sf;

	public PassengerDaoImpl() {
		sf = HibernateUtils.getSessionFactory();
	}

	public void createPassenger(PassengerProfile passenger) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(passenger);
		transaction.commit();
		session.close();
	}

	public boolean updatePassenger(PassengerProfile passenger){
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession(); 
		Transaction transaction = session.beginTransaction();
		session.update(passenger);
		transaction.commit();
		session.close();
		return true;
	}

	public boolean deletePassenger(int profileId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		PassengerProfile passenger = (PassengerProfile) session.load(PassengerProfile.class, profileId);
		session.delete(passenger);
		transaction.commit();
		session.close();
		return true;
	}

	public PassengerProfile findPassenger(int profileId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		PassengerProfile passenger = (PassengerProfile) session.get(PassengerProfile.class, profileId);
		transaction.commit();
		session.close();
		return passenger;
	}
}
