/*
 * @class FlightConstants
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

package com.nagarro.constants;

/**
 * The FlightConstants Class is Used To
 * Define All Important Constants related 
 * to Flights Which are Used Inside the
 * Entire Application.
 * 
 * @author naveenjain
 *
 */

public class FlightConstants {
	
	/* Constants Related To The User Inputs. */
	public final static String DEPURTURE_LOCATION = "\nDepture Location(In 3 Letter Code)::";
	public final static String ARRIVAL_LOCATION = "\nArrival Location(In 3 Letter Code)::";
	public final static String FLIGHT_DATE = "\nDate Of Travelling(In dd-mm-yyyy)::";
	public final static String FLIGHT_CLASS = "\nFlight Class (B-(Business) or E-(Economy))::";
	public final static String OUTPUT_PREFRENCE = "\nOutput Preference (Fare or Duration or (fare,Duration) )::";
	
	/* Constants Related To The Exceptions Occur During Application Execution */
	public final static String DEPURTURE_CODE_EXCEPTION = "\n!! Depurture Location Should be Three Letter Code !!";
	public final static String DEPURTURE_INTEGER_EXCEPTION = "\n!! Depurture Location Should Not Be Number !!";
	public final static String ARRIVAL_CODE_EXCEPTION = "\n!! Arrival Location Should be Three Letter Code !!";
	public final static String ARRIVAL_INTEGER_EXCEPTION = "\n!! Arrival Location Should Not Be Number !!";
	public final static String DATE_EXCEPTION = "\n!! Date Should be In Format (dd-mm-yyyy) !!";
	public final static String FLIGHT_CLASS_EXCEPTION = "\n!! Business class Should be (Either B or E) !!";
	public final static String FLIGHT_OUTPUT_REFERENCE_EXCEPTION = "\n!! OutputPreference Should be in (Fare or Duration or both) !!";
	
	/* Constants Related To The Files and its Related Inputs */
	public final static String DATE_FORMAT = "dd-mm-yyyy";
	public final static String FILE_MODIFIED_FORMAT = "dd-mm-yyyy hh:mm:ss";
	public final static String FILE_LOCATION = "D:\\NagarroAssignment\\FlightSearch\\src\\";
	
	/* Some Constants related To The Output Purpose */
	public final static String COMPANY_NAME = "@~~@::Welcome To the NavFlights::@~~@";
	public final static String ENTER_NOTE = "\n::Enter The Details For Flight Search::";
	public final static String THANK_NOTE = "";
}
