/*
 * @class CanNotBeIntegerException
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
 * The CanNotBeIntegerException Class Is Used for
 * Define The Exception Which is Raised When User
 * Try To Enter The Integer Value But Application
 * Want Text Input.
 * 
 * It Inherit The Exception Class.
 * 
 * @author naveenjain
 *
 */

@SuppressWarnings("serial")
public class CanNotBeIntegerException extends Exception{
	
	/* Default Constructor. */
	
	public CanNotBeIntegerException() {
		
	}
	
	/* Constructor Having String as a Parameter For User Define Message */
	
	public CanNotBeIntegerException(String str) {
		super(str);
	}

}
