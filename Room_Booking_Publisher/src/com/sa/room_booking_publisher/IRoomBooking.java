/**
 * 
 */
package com.sa.room_booking_publisher;

/**
 * @author akila liyanage
 *
 */
public interface IRoomBooking {
	//get the user name form the subscriber
	public void getUserName(String username);
	
	//get the head count
	public void headCount(int count);
	
	//get the number of nights
	public void getNightCount(int count);
	
	//get the number of head count that are below age 12
	public void getChildrenCount(int count);
	
	//check in date
	public void checkInDate(String date);
	
	//check out date
	public void checkOutDate(String date);
	
	//lifecycle method
	public void lifeCycleMethod();
	
}
