/*
 * @class FlightClient
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

package com.nagarro.view;

import com.nagarro.controller.FlightOutputGenerator;

/**
 * 
 * The FlightClient class is The Main Class
 * Which Contain the Main Function.
 * 
 * @author naveenjain
 *
 */

public class FlightClient {
	
	/* The Main Function Of The FlightSearch Application */

	public static void main(String[] args) {
		
		FlightOutputGenerator.outputGenerator();
	}

}
