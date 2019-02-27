/*
 * @class FlightResultSetGenerator
 * 
 * @version 1.8
 * 
 * @copyright nagarro@2019
 * 
 * @author naveenjain
 * 
 * @createDate 21/02/2019 at 11:00 AM
 * 
 * @lastUpdateBy naveenjain
 * 
 * @lastUpdateDate 23/02/2019 at 11:59 AM
 */

package com.nagarro.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.nagarro.dao.DataBase;
import com.nagarro.dto.UserInputReader;
import com.nagarro.entity.Flight;

/**
 * 
 * The FlightResultSetGenerator Class Is Used To
 * Create and Return The Result Set According To 
 * The User's Input.
 * 
 * @author naveenjain
 *
 */

public class FlightResultSetGenerator {
	
	/* 
	 * This Method Is Used to return The Final ResultSet Of Available Flights 
	 * According To The User's Input To the FlightFilterResult Class  
	 */
	
	public static List<Flight> getResultSet(List<String> userinput){
		// instance of DataBase
		DataBase database = DataBase.getDataBase();
		
		// used to get each List of Flights from CompanyFlightInfo HashMap Of DataBase.
		List<Flight> resultSet = new ArrayList<>();	
		
		// Used To get the Object Of Flight Created For The User's Input.
		Flight inputflight = UserInputReader.setFlightInput(userinput);
		
		// it Get the HashMaps of FlightInformation from The DataBase's 
		// CompanyFlightInfo HashMap Values.
		Collection<HashMap<String, Flight>> flightInfo = database
				.getCompanyFlightInfo().values();
		
		// Iterate The Collection for Each HashMap Of Flight Information.
		for(HashMap<String, Flight> col: flightInfo){
			
			// Fetch the FlightInfomation Values into Collection of Flights
			Collection<Flight> flightcol = col.values();
			
			// for each Collection Of Flight Call the getResultSetByUserInput() Method
			// to get The list of Available flights.
			List<Flight> tempflight = getResultSetByUserInput(inputflight, flightcol);
			
			// add each entry of temp list into final result set.
			tempflight.stream().forEach(resultSet::add);
		}
		
		// this basically filter the Final Result set by Calling the Method 
		// getResultSetByBusinessClass(), if The Class Of FLY is Business.
		if(UserInputReader.setFlightClass(userinput).equalsIgnoreCase("B")) {
			resultSet = getResultSetByBusinessClass(resultSet);
		}
		return resultSet;
	}
	
	/* 
	 * This Basically fetch The Available Flight from The List Of 
	 * All Flights According to The User's Input
	 */
	
	public static List<Flight> getResultSetByUserInput(Flight inputflight, 
													Collection<Flight> flightinfo) {
		
		// used to Store the Available Flights.
		List<Flight> resultSet = new ArrayList<>();	
		
		// Use The Java 8 Feature to fetch the Flights from the list of flights 
		// according to user's Input and store it into resultSet.
		flightinfo.stream().filter(x->x.getDeptLoc().equals(inputflight.getDeptLoc()) && 
				  x.getArriveLoc().equals(inputflight.getArriveLoc()) && 
				  x.getFlyDate().equals(inputflight.getFlyDate()) &&
				  x.getAvilibilty().equalsIgnoreCase("Y")).forEach(resultSet::add);
		return resultSet;	// return the resultSet of Available Flight. 
	}
	
	/* 
	 * This Method Is Used to Filter The ResultSet if The 
	 * Fly Class enter By the is Business class
	 */
	
	public static List<Flight> getResultSetByBusinessClass(List<Flight> resultSet) {
			// Used to Store The Filter Result set.
			List<Flight> updateResultSet = new ArrayList<>();
			
			//Used to Filtered the result set
			resultSet.stream().filter(x->x.getFlyClass().equals("EB") || 
										 x.getFlyClass().equals("BE")).
											forEach(updateResultSet::add);
			
			return updateResultSet;		// return the filtered resultSet.
	}
}
