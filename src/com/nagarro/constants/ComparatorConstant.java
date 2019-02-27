/*
 * @class ComparatorConstant
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

import java.util.Comparator;

/**
 * The ComparatorConstant Class Is Basically 
 * Used To Create the Constants For The 
 * Comparator object which is used for filter
 * the result based on the selection of particular
 * comparator Defined in this class.
 * 
 * @author naveenjain
 */

import com.nagarro.entity.Flight;

public class ComparatorConstant {	
	/* Used To Compare on The Basis Of Flight Fares */
	public static Comparator<Flight> COMPARE_BY_FARE = Comparator.comparing(Flight::getFare);
	
	/* Used To Compare on The Basis Of Flight Durations */
	public static Comparator<Flight> COMPARE_BY_DURATION = Comparator.comparing(Flight::getDuration);
	
	/* Used To Compare on The Basis Of Flight Fares and Durations */
	public static Comparator<Flight> COMPARE_BY_FARE_AND_DURATION = Comparator.comparing(Flight::getFare).thenComparing(Flight::getDuration);

}
