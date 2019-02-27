/*
 * @class DataThread
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

package com.nagarro.thread;

import java.io.FileNotFoundException;
import java.text.ParseException;

import com.nagarro.service.FlightDataWriter;

/**
 * 
 * The DataThread Class is Used to create The
 * Thread which call the FlightDataWriter's Class
 * WriteIntoDataBase() Method.
 * 
 * @author naveenjain
 *
 */

public class DataThread implements Runnable{

	@Override
	public void run() {
		try {
			FlightDataWriter.writeIntoDataBase();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
