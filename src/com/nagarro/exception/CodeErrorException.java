/*
 * @class CodeErrorException
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
 * The CodeErrorException Class Is Used for
 * Define The Exception Which is Raised When User
 * Try To Enter The wrong code or try to enter the 
 * code which is greater than or less then 3 Character.
 * 
 * It Inherit The Exception Class.
 * 
 * @author naveenjain
 *
 */

@SuppressWarnings("serial")
public class CodeErrorException extends Exception {

	/* Default Constructor */
	
	public CodeErrorException() {
		
	}
	
	/* Constructor Having String as a Parameter For User Define Message */
	
	public CodeErrorException(String str) {
		super(str);
	}
}
