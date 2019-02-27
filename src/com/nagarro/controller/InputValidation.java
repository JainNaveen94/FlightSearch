/*
 * @class InputValidation
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.nagarro.constants.FlightConstants;
import com.nagarro.exception.CanNotBeIntegerException;
import com.nagarro.exception.CodeErrorException;
import com.nagarro.exception.FlightClassException;
import com.nagarro.exception.FlightOutputPreferenceException;

/**
 * 
 * The InputValidation Class is Used to Valid
 * All The User Input According to the Constraints
 * Define in the Problem Statement.
 * 
 * @author naveenjain
 */

public class InputValidation {
	
	// Scanner Class Object used to Get Input From The User.
	public static Scanner sc = new Scanner(System.in);

	/* Used to Get Valid Departure Location From The User */
	
	public static String getDepurtureLocation() {
		boolean check1 = true;
		boolean check2 = true;
		@SuppressWarnings("unused")
		int numeric;
		String depurture = "";
		do {
			check2 = true;
			try{
				System.out.print(FlightConstants.DEPURTURE_LOCATION);
				depurture = sc.next();				// Departure Location Of Flight.
				try {
					numeric = Integer.parseInt(depurture);
				} catch(NumberFormatException e) {
					check2 = false;
				}
				
				if(check2 == true) {
					throw new CanNotBeIntegerException();
				}
				if(depurture.length() != 3) {
					throw new CodeErrorException();
				}
				check1 = false;
			} catch (CodeErrorException exception) {
				System.out.print(FlightConstants.DEPURTURE_CODE_EXCEPTION);
			} catch (CanNotBeIntegerException exception) {
				System.out.print(FlightConstants.DEPURTURE_INTEGER_EXCEPTION);
			}
		}while(check1 == true);
		return depurture.toUpperCase();
	}
	
	/* Used to Get Valid Arrival Location From The User */
	
	public static String getArrivalLocation() {
		boolean check1 = true;
		boolean check2 = true;
		@SuppressWarnings("unused")
		int numeric;
		String arrival = "";
		do {
			check2 = true;
			try{
				System.out.print(FlightConstants.ARRIVAL_LOCATION);
				arrival = sc.next();				// Arrival Location Of Flight.
				try {
					numeric = Integer.parseInt(arrival);
				} catch(NumberFormatException e) {
					check2 = false;
				}
				
				if(check2 == true) {
					throw new CanNotBeIntegerException();
				}
				if(arrival.length() != 3) {
					throw new CodeErrorException();
				}
				check1 = false;
			} catch (CodeErrorException exception) {
				System.out.print(FlightConstants.ARRIVAL_CODE_EXCEPTION);
			} catch (CanNotBeIntegerException exception) {
				System.out.print(FlightConstants.ARRIVAL_INTEGER_EXCEPTION);
			}
		}while(check1 == true);
		return arrival.toUpperCase();
	}
	
	/* Used to Get Valid Date Of Flight From The User */
	
	public static String getDateOfFlight() {
		boolean check1 = true;
		String date = "";
		do {
			System.out.print(FlightConstants.FLIGHT_DATE);
			date = sc.next();				// Date Of Flight.
			SimpleDateFormat format = new SimpleDateFormat(FlightConstants.DATE_FORMAT);
				try {
					@SuppressWarnings("unused")
					Date checkdate = format.parse(date);
					check1 = false;
				} catch (ParseException exception) {
					System.out.print(FlightConstants.DATE_EXCEPTION);
				}
		}while(check1 == true);
		return date;
	}
	
	/* Used to Get Valid Flight Class From The User */
	
	public static String getClassOfFlight() {
		boolean check1 = true;
		String classoffly = "";
		do {
			try {
				System.out.print(FlightConstants.FLIGHT_CLASS);
				classoffly = sc.next();			// Class Of Flight.
				
				if(classoffly.equalsIgnoreCase("B") || classoffly.equalsIgnoreCase("E")) {
					check1 = false;
				} else {
					throw new FlightClassException();
				}
			} catch (FlightClassException exception) {
				System.out.print(FlightConstants.FLIGHT_CLASS_EXCEPTION);
			} 
		}while(check1 == true);
		return classoffly;
	}
	
	/* Used to get the Valid sorting option from the user */
	
	public static String getOutputPreference() {
		String outputpreference = "";
		boolean check1 = true;
		do {
			try {
				System.out.print(FlightConstants.OUTPUT_PREFRENCE);
				outputpreference = sc.next();			// Sorted Option For Sort The Result.
				
				if(outputpreference.equalsIgnoreCase("fare") ||
						outputpreference.equalsIgnoreCase("duration") ||
						outputpreference.equalsIgnoreCase("fare,duration")) {
					check1 = false;
				} else {
					throw new FlightOutputPreferenceException();
				}
			} catch(FlightOutputPreferenceException exception) {
				System.out.print(FlightConstants.FLIGHT_OUTPUT_REFERENCE_EXCEPTION);
			}
		}while(check1 == true);
		return outputpreference;
	}
	
	/* Used to Get The Valid Option for Type Of Search From The User */
	
	public static int getValidOption() {
		int option = 0;
		boolean check = true;
		do {
			try {
				FlightOutputGenerator.DisplayOption();
				option = sc.nextInt();				// Option Of Type Of Search Again.
				if(option < 1 || option > 2) {
					throw new Exception();
				}
				check = false;
			} catch(InputMismatchException e) {
				System.out.println("option should be Number");
				sc.next();
			} catch(Exception e) {
				System.out.print("Option should either 1 or 2");
			}
		}while(check == true);
		return option;
	}
	
	/* Used to Get the Valid Choice For Search Again From The User */
	
	public static String getValidChoice() {
		String choice = "";
		boolean check = true;
		do {
			try {
				FlightOutputGenerator.displayForSearch();
				choice = sc.next();					// choice of Search Again.
				@SuppressWarnings("unused")
				int valid = Integer.parseInt(choice);
				System.out.println("You Can't Enter Number Here");
			} catch (NumberFormatException e) {
				check = false;
			}
		}while(check==true);
		return choice;
	}
	
}
