package com.airline.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.airline.dao.IPassengerDao;
import com.airline.entities.PassengerProfile;

@Service
public class PassengerAirlineService implements IPassengerService {

	@Autowired
	@Qualifier("dbRepository")
	private IPassengerDao airlineOperations;

	public PassengerAirlineService() {
		super();
	}

	public void createPassenger(PassengerProfile passenger) throws ClassNotFoundException, SQLException {
		airlineOperations.createPassenger(passenger);
	}

	public boolean updatePassenger(PassengerProfile passenger) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		flag = airlineOperations.updatePassenger(passenger);
		return flag;
	}

	public boolean deletePassenger(int profileId) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		flag = airlineOperations.deletePassenger(profileId);
		return flag;
	}

	public PassengerProfile findPassenger(int profileId) throws SQLException, ClassNotFoundException {
		PassengerProfile passenger = null;
		passenger = airlineOperations.findPassenger(profileId);
		return passenger;
	}

}
