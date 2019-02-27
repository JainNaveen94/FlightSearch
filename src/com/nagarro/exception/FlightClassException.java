/*
 * @class FlightClassException
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
 * The FlightClassException Class Is Used for
 * Define The Exception Which is Raised When User
 * Try To Enter The Flight Class Other Then 
 * B- Business Or
 * E- Economy.
 * 
 * It Inherit The Exception Class.
 * 
 * @author naveenjain
 *
 */

@SuppressWarnings("serial")
public class FlightClassException extends Exception{

	/* Default Constructor */
	
	public FlightClassException() {
		
	}
	
	/* Constructor Having String as a Parameter For User Define Message */
	
	public FlightClassException(String str) {
		super(str);
	}
}
