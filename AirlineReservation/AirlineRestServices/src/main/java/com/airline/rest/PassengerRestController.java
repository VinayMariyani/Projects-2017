package com.airline.rest;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airline.entities.PassengerProfile;
import com.airline.service.IPassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerRestController {

	@Autowired
	IPassengerService passengerService;

	@RequestMapping(value= "/{profileId}", method=RequestMethod.POST)
	public ResponseEntity<?> getPassenger(@PathVariable String profileId){
		PassengerProfile passenger = null;	
		try {
			passenger = passengerService.findPassenger(Integer.parseInt(profileId));
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(passenger == null){
			return ResponseEntity.noContent().build();
		}
		else{
			return new ResponseEntity<>(passenger,HttpStatus.OK);
		}	
	}


	@RequestMapping(value="/create",method=RequestMethod.POST, consumes={"application/json"})
	public ResponseEntity<?> createEmployee(@RequestBody PassengerProfile passenger){
		try {
			passengerService.createPassenger(passenger);
		} catch (ClassNotFoundException | SQLException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(passenger, HttpStatus.CREATED);	
	}

	@RequestMapping(value="/update",method=RequestMethod.PUT, consumes = {"application/json"})
	public ResponseEntity<?> updateEmployee(@RequestBody PassengerProfile passenger){
		boolean flag;
		try {
			flag = passengerService.updatePassenger(passenger);			
			if(flag==true){
				return new ResponseEntity<>(passenger, HttpStatus.ACCEPTED);
			}
			else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	@RequestMapping(value="/{profileId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePassenger(@PathVariable String profileId){
		boolean flag;
		try {
			flag = passengerService.deletePassenger(Integer.parseInt(profileId));
			if(flag==true){
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}


