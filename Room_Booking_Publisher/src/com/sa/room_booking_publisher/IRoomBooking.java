/**
 * 
 */
package com.sa.room_booking_publisher;

import java.util.HashMap;

/**
 * @author akila liyanage
 *
 */
public interface IRoomBooking {
	//get the user name form the subscriber
	public RoomBookingImpl getUserName();
	
	//get the head count
	public RoomBookingImpl headCount();
	
	//get the number of nights
	public RoomBookingImpl getNightCount();
	
	//get the number of head count that are below age 12
	public RoomBookingImpl getChildrenCount();
	
	//check in date
	public RoomBookingImpl checkInDate();
	
	//check out date
	public RoomBookingImpl checkOutDate();
	
	//lifecycle method
	public void lifeCycleMethod();
	
	//exporting data to the calculations service
	public HashMap<String, String> toCalculation();
	
}
