/*
 * @class DataBase
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

package com.nagarro.dao;

import java.util.Date;
import java.util.HashMap;

import com.nagarro.entity.Flight;

/**
 * The DataBase class of FlightSearch Project
 * basically used for Storing the Flight 
 * Information into the DataBase From File 
 * which is HashMap.
 * 
 * @author naveenjain
 *
 */

public class DataBase {

	/* Fields */
	
	private static DataBase database = null;	// DataBase Class Instance for Excess The DataBase.
	private HashMap<String, Date> datafileinfo = new HashMap<>(); 	// Used to Store The Update Time Information Of Flight Files. 
	private HashMap<String, HashMap<String, Flight>> companyflightinfo = new HashMap<>(); // Used To Store The Flight Information from Files.
	
	/* Constructor */
	
	private DataBase() {
		
	}
	
	/* Methods */
	
	/* Used to Get The Instance Of Database Class. */
	public static DataBase getDataBase() {
		if(database == null) {
			database = new DataBase();
		}
		return database;				// return the Database instance.
	}
	
	/* Used to Get The DataFileInfo From The DataBase. */
	public HashMap<String, Date> getDataFileInfo(){
		return datafileinfo;			// return the List Of DataFileInfo.
	}
	
	/* Used to Get The Flight Information Company wise From The DataBase. */
	public HashMap<String, HashMap<String, Flight>> getCompanyFlightInfo(){
		return companyflightinfo;		// return the List Of CompanyListInfo.
	}
	
}
