package com.airline.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.airline.entities.PassengerProfile;
import com.airline.service.IPassengerService;


@Controller
@RequestMapping("/Passenger")
public class PassengerController {

	@Autowired
	IPassengerService passengerService;

	@RequestMapping(value= "/viewPassenger", method=RequestMethod.POST)
	public ModelAndView getPassenger(@RequestParam String profileId){
		
		ModelAndView modelAndView = new ModelAndView();		
			PassengerProfile passenger = null;
			try {
				passenger = passengerService.findPassenger(Integer.parseInt(profileId));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				modelAndView.addObject("message", "Passenger not found with given Id");
				e.printStackTrace();
			}
			if(passenger ==null){
				modelAndView.addObject("message", "Passenger Not found ");	
			}
			else{
				modelAndView.addObject("employee", passenger);
			}
		modelAndView.setViewName("displayPassenger");
		return modelAndView;
	}

	@RequestMapping(value="/newPassenger")
	public ModelAndView createPassenger() {
		ModelAndView modelAndView = new ModelAndView();			
		modelAndView.addObject((new PassengerProfile()));
		modelAndView.setViewName("createPassenger");
		return modelAndView;
	}

	@RequestMapping(value="/createPassenger", method=RequestMethod.POST)
	public ModelAndView createPassenger(@ModelAttribute PassengerProfile passenger,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();	
		if(result.hasErrors()){
			modelAndView.setViewName("createPassenger");
			return modelAndView;
		}
			try {
				passengerService.createPassenger(passenger);
			} catch (ClassNotFoundException | SQLException e) {
				modelAndView.addObject("message", "Passenger cannot be created");
				e.printStackTrace();
			}
			modelAndView.addObject("message", "Passenger created Successfully");	

		modelAndView.setViewName("createPassenger");
		return modelAndView;	
	}

	@RequestMapping(value="/updatePassenger",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute PassengerProfile passenger,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			modelAndView.setViewName("displayPassenger");
			return modelAndView;
		}
		boolean flag = false;
			try {
				flag = passengerService.updatePassenger(passenger);
			} catch (ClassNotFoundException | SQLException e) {
				modelAndView.addObject("message", "Passenger not found with given Id");
				e.printStackTrace();
			}			
			if(flag==true){
				modelAndView.addObject("message","Passenger Updated Successfully");
			}
			else{
				modelAndView.addObject("message","Error Updating Passenger");
			}

		modelAndView.setViewName("displayPassenger");
		return modelAndView;		
	}

	@RequestMapping(value="/deletePassenger",method=RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute PassengerProfile passenger){
		ModelAndView modelAndView = new ModelAndView();
		boolean flag = false;
			try {
				flag = passengerService.deletePassenger(passenger.getProfileId());
			} catch (ClassNotFoundException | SQLException e) {
				modelAndView.addObject("message", "Passenger not found with given Id");
				e.printStackTrace();
			}

			if(flag==true){
				modelAndView.addObject("message", "Passenger deleted Successfully");
			}
			else{
				modelAndView.addObject("message", "Passenger Not found");
			}
		modelAndView.setViewName("displayEmployee");
		return modelAndView;
	}
	
	}