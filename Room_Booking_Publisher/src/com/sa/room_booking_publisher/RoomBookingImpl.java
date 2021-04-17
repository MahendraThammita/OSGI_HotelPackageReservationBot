/**
 * 
 */
package com.sa.room_booking_publisher;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author akila liyanage
 *
 */
public class RoomBookingImpl implements IRoomBooking{
	
	//variables
	private String username,checkinDate,checkoutDate;
	private int headCount,nightsCount,childrenCount;
	Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	
	public RoomBookingImpl() {
		// TODO Auto-generated constructor stub
		
		System.out.println("Hi welcome to the Room Booking service, please proceed with the relevent information askig hereafter. Thank you");
	}

	@Override
	public RoomBookingImpl getUserName() {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the username : ");
	    this.username = scanner.nextLine();  // Read user input
		return this;
		
	}

	@Override
	public RoomBookingImpl headCount() {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the head count : ");
	    this.headCount = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl getNightCount() {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the night count : ");
	    this.nightsCount = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl getChildrenCount() {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the number of children : ");
	    this.childrenCount = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl checkInDate() {
		// TODO Auto-generated method stub
		
		System.out.println("Please enter the check in date : ");
	    this.checkinDate = scanner.nextLine();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl checkOutDate() {
		// TODO Auto-generated method stub
		
		return this;
	}

	@Override
	public void lifeCycleMethod() {
		// TODO Auto-generated method stub
		//channing the methods
		
		new RoomBookingImpl().getUserName().headCount().getNightCount().getChildrenCount().checkInDate().checkOutDate();
		
	}

	@Override
	public HashMap<String, String> toCalculation() {
		// TODO Auto-generated method stub
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("username", this.username);
		data.put("headcount", Integer.toString(this.headCount));
		return data;
	}

	


}
