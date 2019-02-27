/*
 * @class FlightDataWriter
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

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.nagarro.constants.FlightConstants;
import com.nagarro.dao.DataBase;
import com.nagarro.dto.FlightFileReader;
import com.nagarro.entity.Flight;

/**
 * 
 * FlightDataWriter Class Is Used To Write The
 * Flight related Data into The DataBase.
 * 
 * @author naveenjain
 *
 */

public class FlightDataWriter {
	
	/* Location of the Folder Where Flight Files Are Exist. */
	
	private static final File mainfile = new File(FlightConstants.FILE_LOCATION);
	
	/* This Method Is Used To Write The Data Into The DataBase. */
	
	public static void writeIntoDataBase() throws FileNotFoundException, ParseException {
		
		// Used ToFormt The Date As Per Application Requirement.
		SimpleDateFormat format = new SimpleDateFormat(FlightConstants.FILE_MODIFIED_FORMAT);
		
		// Used to Get The List Of File Names Available Inside The Main Folder Having Flight Informations.
		List<String> files = FlightFileReader.getFilesList(mainfile);
		
		// Used To get the DataBase Instance By Calling GetDataBase() Method Of DataBase Class.
		DataBase database = DataBase.getDataBase();
		
		// Used to Verify That is There is any File Which is Being Deleted inside The Main Folder Having Flight Information.
		fileVerification(files, database);
		
		// This is The Main Logic That How The Application Read Data And Write Into The DataBase.
		if(database.getDataFileInfo() != null) {			// This is Work Only If Our DataBase Is Already Being Filled By DataThread.
			for(String str: files) {						// Perform Iteration On Each File Name Contain List Of Files.
				File file = new File(FlightConstants.FILE_LOCATION + "\\" + str);	// creation of File object by using file name and path Of File.
				if(database.getDataFileInfo().containsKey(str)) {					// If File is already Exist Into The DataBase.
					Date currentTime = format.parse(format.format(file.lastModified()));	// used to Store The Current Time Of File name in The List Of Files.
					Date oldTime = database.getDataFileInfo().get(str);						// used to Store The Old Time of The File Which is fetched From The dataBase.
					if(currentTime.after(oldTime)) {										// if Date is Modified or not Same.
						database.getDataFileInfo().put(str, currentTime);						// Update The File Modified Time into The DataBase.
						writeFromFile(database, str, file);										// Update That Particular File Which Time is Modified into the DataBase.
					} 
				} else {															// If File is Not Exist Into The DataBase.									
					database.getDataFileInfo().put(str, format.parse(format.format(file.lastModified()))); // Entry Of New File Into The DataBase.
					writeFromFile(database, str, file);													   // Entry Of New Flight Information from New File Into The DataBase.
				}
			}
		} else {											// This Is Work only one time When DataThread Execute its Task For First Time.
			for(String str: files) {						// Perform Iteration On Each File Name Contain List Of Files.
				File file = new File(FlightConstants.FILE_LOCATION + "\\" + str);	// creation of File object by using file name and path Of File.
				database.getDataFileInfo().put(str, format.parse(format.format(file.lastModified())));		// Make an Entry Of Flight File Into The Database's DataInfo HashMap Collection. 
				writeFromFile(database, str, file);															// Make an Entry of FLightInformation Into The DataBase's CompanyFlightInfo HashMap Collection.
			}
		}
	}
	
	/* 
	 * This Method is Used to Write The Flight Information into HashMap<String(FileName), Flight>
	 *  and The put it into The DataBase's CompanyFlightInfo HashMap Collection with FileName As 
	 *  Key Of HashMap.
	 */
	
	public static void writeFromFile(DataBase database, String str, File file) throws FileNotFoundException {
		Flight flight = null;							// Flight Class Object For Store Flight Related Information.
		HashMap<String, Flight> build = new HashMap<>();// HashMap of FlightInformation for particular Company.
		@SuppressWarnings("resource")
		Scanner filescan = new Scanner(file);			// Scanner Object Used to Scan File's Row.
		Scanner datascan = null;						// Scanner Object Used to Scan File's Column. 
		
		// used to skip first line from each file
		if(filescan.hasNextLine()) {
			filescan.nextLine();
		}
		
		int index = 0;									// Used to Store Flight Data into FlightObject Column wise.
		
		while(filescan.hasNextLine()) {					// This Loop is Used to Iterate Each Row Of a File.
			datascan = new Scanner(filescan.nextLine());
			datascan.useDelimiter("\\|");					// Column Separater inside the CSV File.
			flight = new Flight();							// Creation of New Flight Object.
			
			while(datascan.hasNext()) {						// This Loop is Used to Iterate Each Column Of a File.
				String data = datascan.next();
				switch(index) {
				case 0 :									// For 1st Column.
					flight.setNumber(data);					// set Flight Number.
					break;
				case 1:										// For 2nd Column.
					flight.setDeptLoc(data);				// set Flight Departure Location.
					break;
				case 2:										// For 3rd Column.
					flight.setArriveLoc(data);				// set Flight Arrival Location.
					break;
				case 3:										// For 4th Column.
					flight.setFlyDate(data);				// set Flight Date of Fly.
					break;
				case 4:										// For 5th Column.
					flight.setTimeToFly(data);				// set Flight Time Of Fly.
					break;
				case 5:										// For 6th Column.
					flight.setDuration(Double.parseDouble(data));// set the Duration Of Flight.
					break;
				case 6:										// For 7th Column.
					flight.setFare(Double.parseDouble(data));	// set The Fare of Flight.
					break;
				case 7:										// For 8th Column.
					flight.setAvilibilty(data);				// set The Seat Availability Of Flight.
					break;
				case 8:										// For 9th Column.
					flight.setFlyClass(data);				// set The Classes of Flight a Particular Flight Have.
					break;
				}
				index++;									// increment for Column Excess.
			}
			index = 0;										// put back to Zero for New Row.
			build.put(flight.getNumber()+flight.getFlyDate(), flight);	// it put each Flight Object After iteration
																		// of each row Of a File into to The HashMap.
		}
		database.getCompanyFlightInfo().put(str, build);// It Put The HashMap into the Database's CompanyFligthInfo
															// HashMap With FileName as a Key.
	}
	
	/* 
	 * This Method is Used to Verify That the File Inside The DataBase Is Still Exist Or Not 
	 * So IF it Not Exist then Delete All The Entries Of That File From The DataBase 
	 * And If Exist then do Nothing */
	
	public static void fileVerification(List<String> files, DataBase database) {
		// use to Get The Collection Of DataFileInfo From The DataBase.
		Collection<String> companyinfo = database.getDataFileInfo().keySet();
		
		for(String str: companyinfo) {				// Iterate through the Collection Of DataFlightInfo Of Database.
			if(!files.contains(str)) {				// If File Not Found or Deleted From The Main Folder.
				database.getDataFileInfo().remove(str);	// Remove Entry From the DataFileInfo HashMap OF DataBase.
				database.getCompanyFlightInfo().remove(str);// Remove Entry From the CompanyFlightInfo HashMap of 
															// DataBase.
			}
		}
	}
	
}
