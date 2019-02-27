/*
 * @class FlightFilterResult
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

package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Flight;
import com.nagarro.constants.ComparatorConstant;
import com.nagarro.dto.UserInputReader;

/**
 * 
 * The FlightFilterResult Class Is Used To Sort the
 * Result Set Getting From The FlightResultSetGenerator
 * Class on The Basis Of User Sorting Preference such
 * as Fare, Duration or By Both.
 * 
 * @author naveenjain
 *
 */

public class FlightFilterResult {
	
	/* This Method Is Used To Sort The Result Set According To The User OutPut Preference */

	public static List<Flight> getFilterFlightResult(List<String> userinput){
		List<Flight> resultSet = FlightResultSetGenerator.getResultSet(userinput);
		List<String> outputprefrence = UserInputReader.setOutputPrefrence(userinput);
		if(outputprefrence.size() == 1) {
			if(outputprefrence.get(0).equalsIgnoreCase("fare")) {
				resultSet.sort(ComparatorConstant.COMPARE_BY_FARE);
			} else if(outputprefrence.get(0).equalsIgnoreCase("duration")) {
				resultSet.sort(ComparatorConstant.COMPARE_BY_DURATION);
			}
		} else {
			resultSet.sort(ComparatorConstant.COMPARE_BY_FARE_AND_DURATION);
		}
		return resultSet;				// return The Filtered Result Set To The Controller.
	}
}
