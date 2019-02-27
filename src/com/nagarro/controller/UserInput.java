/*
 * @class UserInput
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

package com.nagarro.controller;

import java.util.LinkedList;
import java.util.List;
import com.nagarro.constants.FlightConstants;

/**
 * The UserInput Class Is Used To Get And  
 * Create The List Of Input From The User.
 * 
 * @author naveenjain
 *
 */

public class UserInput {
	
	/* 
	 * This Method is Used to get The User Input from the User by
	 * Calling the Methods Of InputValidation Class and Then Create
	 * a List And return it
	 */
	
	public static List<String> getInput(){
		List<String> userinput = new LinkedList<>();		// Used to Store User Input as a List Of String.
		System.out.println("*****************************************");
		System.out.println(FlightConstants.COMPANY_NAME);
		System.out.println("*****************************************");
		System.out.println(FlightConstants.ENTER_NOTE);
			userinput.add(InputValidation.getDepurtureLocation());	// used to get departure Location.
			userinput.add(InputValidation.getArrivalLocation());	// used to get arrival Location.
			userinput.add(InputValidation.getDateOfFlight());		// used to get Date Of Flight.
			userinput.add(InputValidation.getClassOfFlight());		// used to get the Class Of Flight.
			userinput.add(InputValidation.getOutputPreference());	// Used to get the Sorting Preference.
		return userinput;											// return the list of User Input.
	}
}
