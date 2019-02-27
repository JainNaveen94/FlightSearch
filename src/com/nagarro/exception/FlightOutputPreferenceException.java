/*
 * @class FlightOutputPreferenceException
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

package com.nagarro.exception;

/**
 * 
 * The FileOutPutPreferenceException Class Is Used for
 * Define The Exception Which is Raised When User
 * Try To Enter The Wrong Preference.
 * 
 * It Inherit The Exception Class.
 * 
 * @author naveenjain
 *
 */

@SuppressWarnings("serial")
public class FlightOutputPreferenceException extends Exception{

	/* Default Constructor */
	
	public FlightOutputPreferenceException() {
		
	}
	
	/* Constructor Having String as a Parameter For User Define Message */
	
	public FlightOutputPreferenceException(String str) {
		super(str);
	}
}
