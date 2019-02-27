/*
 * @class FlightFileReader
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

package com.nagarro.dto;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The FlightFileReader Class is Used to Read ,
 * Create and return the List Of Files Available
 * in a Directory of Flight Files.
 * 
 * @author naveenjain
 *
 */

public class FlightFileReader {
	
	/* This Method Is Used To Read The Files Available in the Folder. */
	
	public static List<String> getFilesList(final File folder){
		List<String> files = new LinkedList<>();		// Used to Store List Of Files Names
		for(final File entry: folder.listFiles()) {
				if(entry.getName().contains(".csv")) {	// Only If File Is a CSV File.
					files.add(entry.getName());			// it add the file name into the List.
				}
		}
		return files;									// return The List Of File Name.
	}
}
