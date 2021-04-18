/**
 * 
 */
package com.sa.room_booking_publisher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;

import org.osgi.framework.FrameworkUtil;

/**
 * @author akila liyanage
 *
 */
public class RoomBookingImpl implements IRoomBooking{
	
	//variables
	private String username,checkinDate,checkoutDate;
	private int headCount,nightsCount,childrenCount,packageNo;
	Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	String dir = System.getProperty("user.dir");	//get the current working dir
	public static HashMap<String, String> data = new HashMap<String, String>();
	
	public RoomBookingImpl() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	public RoomBookingImpl(String name) {
		// TODO Auto-generated constructor stub
		
		System.out.println("Hi " + name + " welcome to the Room Booking service, please proceed with the relevent information askig hereafter. Thank you. \n");
	}
	
	

	@Override
	public RoomBookingImpl getUserName(String username) {
		// TODO Auto-generated method stub
		
	    this.username = username; // Read user input
		return this;
		
	}

	@Override
	public RoomBookingImpl headCount() {
		// TODO Auto-generated method stub
		
		System.out.print("Please enter the head count : ");
	    this.headCount = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl getNightCount() {
		// TODO Auto-generated method stub
		
		System.out.print("Please enter the night count : ");
	    this.nightsCount = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl getChildrenCount() {
		// TODO Auto-generated method stub
		
		System.out.print("Please enter the number of children : ");
	    this.childrenCount = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl checkInDate() {
		// TODO Auto-generated method stub
		
		System.out.print("Please enter the check in date (dd-MM-yyyy) : ");
	    this.checkinDate = scanner.next();  // Read user input
		return this;
	}

	@Override
	public RoomBookingImpl checkOutDate() {
		// TODO Auto-generated method stub
		
		return this;
	}
	

	@Override
	public RoomBookingImpl packages() {
		// TODO Auto-generated method stub
		
		System.out.println("Please select ur desired package =) ");
		System.out.println("1.STANDARD");
		System.out.println("\t + Luxury bath amenities");
		System.out.println("\t + Rain shower");
		System.out.println("\t + Lounge area");
		System.out.println("");
		System.out.println("2.DELUXE ");
		System.out.println("\t + Luxury bath amenities");
		System.out.println("\t + Private courtyard");
		System.out.println("\t + Rain shower");
		System.out.println("");
		System.out.println("3.EXECUTIVE ");
		System.out.println("\t + Luxury bath amenities");
		System.out.println("\t + Deep-soaking bathtub & rain shower");
		System.out.println("\t + Rain shower plus Sea view");
		System.out.println("");
		
		System.out.println("Please enter the selected package number : ");
	    this.packageNo = scanner.nextInt();  // Read user input
		return this;
	}

	@Override
	public void lifeCycleMethod(String username) {
		// TODO Auto-generated method stub
		//channing the methods
		
		RoomBookingImpl bookingImpl = new RoomBookingImpl(username).getUserName(username).packages().headCount().getNightCount().getChildrenCount();
		bookingImpl.checkInDate();
		bookingImpl.toCalculation();
		
		
	}

	@Override
	public HashMap<String, String> toCalculation() {
		// TODO Auto-generated method stub
		
		System.out.println("Sending data to the calculation service");
		
		
		data.put("username", this.username);
		data.put("headcount", Integer.toString(this.headCount));
		data.put("nightscount:", Integer.toString(this.nightsCount));
		data.put("childrencount:", Integer.toString(this.childrenCount));
		data.put("checkindate", this.checkinDate);
		data.put("checkoutdate", this.checkoutDate);
		data.put("package", Integer.toString(this.packageNo));
		System.out.println(data);
		Activator.callCalculationService();
		Activator.sub = true;
		return data;
	}


}
