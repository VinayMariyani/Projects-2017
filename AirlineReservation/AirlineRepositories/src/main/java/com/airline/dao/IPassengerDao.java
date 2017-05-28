package com.airline.dao;

import java.sql.SQLException;

import com.airline.entities.PassengerProfile;

public interface IPassengerDao {
	void createPassenger(PassengerProfile passenger) throws ClassNotFoundException, SQLException;
	boolean updatePassenger(PassengerProfile passenger) throws ClassNotFoundException, SQLException;
	boolean deletePassenger(int profileId) throws ClassNotFoundException, SQLException;
	PassengerProfile findPassenger(int profileId) throws ClassNotFoundException, SQLException; 
}
