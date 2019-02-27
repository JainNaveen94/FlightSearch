/*
 * @class FlightOutputGenerator
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

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.nagarro.dto.UserInputReader;
import com.nagarro.entity.Flight;
import com.nagarro.service.FlightFilterResult;
import com.nagarro.thread.DataThread;

/**
 * The FlightOutputGenerator Class is Used for
 * Generate the Output Of Available Flights
 * based on The User Input.
 * 
 * @author naveenjain
 */

public class FlightOutputGenerator {
	
	/* Method Used To Generate and Pass The List Of Available Flights to the Console for display */

	public static void outputGenerator() {
		
		// Calling Of Thread For DataBase Creation by using the ScheduleExecutorService Class Object Service.
		// Thread is called to write or update the Flight Data From Files into the Database in Every 5 seconds .
		ScheduledExecutorService service = Executors
				.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(new DataThread(), 0, 5, TimeUnit.SECONDS);
		
		// Used to get the UserInputs Initially.
		List<String> userinput = UserInput.getInput();
		
		// Used for get the Choice input of search Again from The User.
		String choice = "yes";
		
		// Used for get the Option input for type of search from the user.
		int option = 1;
		
		do {
			
			// List Of New UserInputs is Created by Calling getInput() of UserInput Class.
			if(option == 2) {
				userinput = UserInput.getInput();
			} 
			
			// Used to get The Class Of Flight through the UserInput List.
			String classoffly = UserInputReader.setFlightClass(userinput);
			
			/* Here Result Is Getting And Pass to view For Display. */
			
			// Getting of Final result List of Available For Display To The User.
			List<Flight> finalresult = FlightFilterResult.getFilterFlightResult(userinput);
			
			if(finalresult.isEmpty()) {
				DisplayNull();		// If Database doesn't Have a Flight or Doesn't have a single data into it.
			} else {
				if(classoffly.equalsIgnoreCase("b")) {				// Check The Class Of Flight.
					displayBusinessResult(finalresult);				// if class of flight is Business.
				} else {
					displayResult(finalresult);						// if class of flight is Economy.
				}
			}
			choice = InputValidation.getValidChoice();		// it will take input for search again.
			if(choice.equalsIgnoreCase("y") 
					|| choice.equalsIgnoreCase("yes")) {
				option = InputValidation.getValidOption();	// it will take input for type of search.
			}
		}while(choice.equalsIgnoreCase("yes") || 
				choice.equalsIgnoreCase("Y"));
		service.shutdown();									// Used to Stop the DataThread running in Background.
		DisplayThank();
	}
	
	/* This Method Display The Final Result of Business Class Clients */
	
	private static void displayBusinessResult(List<Flight> finalresult) {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("@--@::Flight Search Result::@--@");
		for(Flight flight: finalresult) {
			System.out.println();
			System.out.println("************************************");
			System.out.println("Flight Number 	  ::" + flight.getNumber());
			System.out.println("Depurture Loc 	  ::" + flight.getDeptLoc());
			System.out.println("Arrival Loc   	  ::" + flight.getArriveLoc());
			System.out.println("Date Of Flight	  ::" + flight.getFlyDate());
			System.out.println("Time Of Flight	  ::" + flight.getTimeToFly());
			System.out.println("Duration Of Flight::" + flight.getDuration());
			System.out.println("Fare Of Flight	  ::" + (flight.getFare()+flight.getFare()*0.4));
			System.out.println("************************************");
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
	}
	
/* This Method Display The Final Result of Economy Class Clients */
	
	private static void displayResult(List<Flight> finalresult) {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("@--@::Flight Search Result::@--@");
		for(Flight flight: finalresult) {
			System.out.println();
			System.out.println("************************************");
			System.out.println("Flight Number 	  ::" + flight.getNumber());
			System.out.println("Depurture Loc 	  ::" + flight.getDeptLoc());
			System.out.println("Arrival Loc   	  ::" + flight.getArriveLoc());
			System.out.println("Date Of Flight	  ::" + flight.getFlyDate());
			System.out.println("Time Of Flight	  ::" + flight.getTimeToFly());
			System.out.println("Duration Of Flight::" + flight.getDuration());
			System.out.println("Fare Of Flight	  ::" + flight.getFare());
			System.out.println("************************************");
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}
	
	/* This Method Display the Option Of Search Again */
	
	public static void displayForSearch() {
		System.out.print("\nDo You Want To Search Again::");
	}
	
	/* This Method Display the Type Of Search */
	
	public static void DisplayOption() {
		System.out.print("\n********::@Search Options@::********");
		System.out.print("\n1. For Search With Same Inputs.");
		System.out.print("\n2. For Search With New Inputs.");
		System.out.print("\nEnter Option::");
		System.out.println();
	}

	/* This Method is Used To Display the Empty result Note if Final result set is null */
	
	private static void DisplayNull() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~!@~~@::Sorry::@~~@!~~~~~~~~~~~~~~~~");
		System.out.println("::Currently We Have No Flight For You::");
	}
	
	/* This Method Is Used To Display The Thank You Message to The User after its Operation Is Finished */
	
	private static void DisplayThank() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("@~@::ThankYou For Your Visit::@~@");
		System.out.println("We Are Happy To Help You");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
}
