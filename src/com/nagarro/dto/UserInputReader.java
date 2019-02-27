/*
 * @class UserInputReader
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

package com.nagarro.dto;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.nagarro.entity.Flight;

/**
 * 
 * The UserInput Reader Class Is Used To 
 * Segregate The User Input According To 
 * The System Requirement and Then return
 * to the Classes which Required That.
 * 
 * @author naveenjain
 *
 */

public class UserInputReader {
	
	/* This Method is Used To set The Flight Object According to the Users Need. */
	
	public static Flight setFlightInput(List<String> userinput) {
		// Used to set the Departure Location , Arrival Location 
		// And The Date Of Flight Into The Flight Object.
		Flight flight = new Flight(userinput.get(0), 
										userinput.get(1), 
										userinput.get(2));
		return flight;		// return the Flight Class Object having Input Parameters.
	}
	
	/* This Method Is Used To Set The Type Of Flight Class That User Want. */
	
	public static String setFlightClass(List<String> userinput) {
		String flyclass = userinput.get(3);		// set the flight class into String Object.
		return flyclass;						// return The Flight Class Input of User.
	}
	
	/* This Method Is Used To Set the Sorting Prefrence Of User. */
	
	public static List<String> setOutputPrefrence(List<String> userinput){
		List<String> outputpref = new LinkedList<>(); // used to Store The Sorting Preference.
		String[] outpref = (userinput.get(4).split(","));
		outputpref = Arrays.asList(outpref);
		return outputpref;							// return The List of Sorting Preference.
	}
	
}
