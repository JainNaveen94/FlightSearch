/*
 * @class Flight
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

package com.nagarro.entity;

/** 
 * 
 * The Flight Class basically contant the properties
 * related to the Flights, their Constructors to Construct their Values and also Have A Getter/Setters
 * to get and Set The each Property of Flight Class.
 * 
 * @author naveenjain
 *
 */

public class Flight {
	String number;					// Flight Number.
	String deptLoc;					// Depture Location of Flight.
	String arriveLoc;				// Arrival Location of Flight.	
	String flyDate;					// Validity of Flight.
	String timeToFly;				// Time to Depture.
	double duration;				// Duration Of Flight.
	double fare;					// Fare Of Flight.
	String avilibilty;				// Seat Avilibility Of Flight.
	String flyClass;				// Class Of Flight.
	
	
	/* Constructor to Construct the Flight Object With Data */
	
	/* default Constructor */
	
	public Flight() {
		
	}
	
	/* Constructor to Set UserInput Values */
	
	public Flight(String deptLoc, String arriveLoc, String flyDate) {
		this.deptLoc = deptLoc;
		this.arriveLoc = arriveLoc;
		this.flyDate = flyDate;
	}
	
	/* 
	 * Constructor to be Used while Adding Flight Information 
	 * into The DataBase and Display It to The User.
	 */
	
	public Flight(String number, String deptLoc, String arriveLoc,
					String flyDate, String timeToFly, 
					double duration, double fare, String avilibility,
					String flyClass) {
		this.number = number;
		this.deptLoc = deptLoc;
		this.arriveLoc = arriveLoc;
		this.flyDate = flyDate;
		this.timeToFly = timeToFly;
		this.duration = duration;
		this.fare = fare;
		this.avilibilty = avilibility;
		this.flyClass = flyClass;
	}
	
	/* Getter/ Setter For The Flight Data */
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	
	public String getArriveLoc() {
		return arriveLoc;
	}
	public void setArriveLoc(String arriveLoc) {
		this.arriveLoc = arriveLoc;
	}
	
	public String getFlyDate() {
		return flyDate;
	}
	public void setFlyDate(String flyDate) {
		this.flyDate = flyDate;
	}
	
	public String getTimeToFly() {
		return timeToFly;
	}
	public void setTimeToFly(String timeToFly) {
		this.timeToFly = timeToFly;
	}
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	public String getAvilibilty() {
		return avilibilty;
	}
	public void setAvilibilty(String avilibilty) {
		this.avilibilty = avilibilty;
	}
	
	public String getFlyClass() {
		return flyClass;
	}
	public void setFlyClass(String flyClass) {
		this.flyClass = flyClass;
	}
	
	/* Override The toString Method For Display Purpose */
	
	@Override
	public String toString() {
		return this.number+","+this.deptLoc+","+this.arriveLoc+","
					+this.flyDate+","+this.timeToFly+","+this.duration+","
					+this.fare+","+this.avilibilty+","+this.flyClass;
		
	}
	
}
