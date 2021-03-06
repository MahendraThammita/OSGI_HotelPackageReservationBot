/**
 * 
 */
package com.sa.room_booking_publisher;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	private String username,checkinDate,checkoutDate,coupen,confirm;
	private int headCount,nightsCount,childrenCount,packageNo;
	private Date checkOutDate;
	Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	String dir = System.getProperty("user.dir");	//get the current working dir
	public static HashMap<String, String> data = new HashMap<String, String>();
	public static HashMap<String, String> finalBill;
	SimpleDateFormat checkInDate;
	
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
		
		System.out.print("Please enter the check in date (yyyy-MM-dd) : ");
	    this.checkinDate = scanner.next();  // Read user input
	    checkInDate = new SimpleDateFormat("yyyy-MM-dd");  
		return this;
	}

	@Override
	public RoomBookingImpl checkOutDate() {
		// TODO Auto-generated method stub
		
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(checkInDate.parse(checkinDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DATE, this.nightsCount);  // number of days to add
		checkoutDate = checkInDate.format(c.getTime());  // dt is now the new date
		
		return this;
	}
	

	@Override
	public RoomBookingImpl packages() {
		// TODO Auto-generated method stub
		
		ITableView packageTable = new TableViewImpl();
		packageTable.setShowVerticalLines(true);
		packageTable.setHeaders("No","Package Name","Package Details");
		packageTable.addRow("1","STANDARD","Luxury bath amenities | Rain shower | Lounge area");
		packageTable.addRow("2","DELUXE","Luxury bath amenities |  Private courtyard | Rain shower");
		packageTable.addRow("3","EXECUTIVE","Luxury bath amenities | Deep-soaking bathtub & rain shower | Rain shower plus Sea view");
		
		packageTable.print();
		
//		System.out.println("Please select ur desired package =) ");
//		System.out.println("1.STANDARD");
//		System.out.println("\t + Luxury bath amenities");
//		System.out.println("\t + Rain shower");
//		System.out.println("\t + Lounge area");
//		System.out.println("");
//		System.out.println("2.DELUXE ");
//		System.out.println("\t + Luxury bath amenities");
//		System.out.println("\t + Private courtyard");
//		System.out.println("\t + Rain shower");
//		System.out.println("");
//		System.out.println("3.EXECUTIVE ");
//		System.out.println("\t + Luxury bath amenities");
//		System.out.println("\t + Deep-soaking bathtub & rain shower");
//		System.out.println("\t + Rain shower plus Sea view");
//		System.out.println("");
		
		System.out.print("Please enter the selected package number : ");
	    this.packageNo = scanner.nextInt();  // Read user input
		return this;
	}
	
	@Override
	public RoomBookingImpl coupenDet() {
		// TODO Auto-generated method stub
		
		System.out.print("Do ypu have any coupen codes available with you? (y/n) : ");
	    this.coupen = scanner.next();  // Read user input
	    while(true){
	    	if(coupen.equals("y")) {
		    	System.out.print("Please enter the coupen code : ");
		    	this.coupen = scanner.next();
		    	break;
		    }else if(this.coupen.equals("n")) {
		    	this.coupen = null;
		    	break;
		    }else {
		    	System.out.println("Invalid input, please enter y/n : ");
		    }
	    }
	    
	    return this;
	}

	@Override
	public void lifeCycleMethod(String username) {
		// TODO Auto-generated method stub
		//channing the methods
		
		RoomBookingImpl bookingImpl = new RoomBookingImpl(username).getUserName(username).packages().headCount().getNightCount().getChildrenCount().coupenDet();
		bookingImpl.checkInDate();
		bookingImpl.checkOutDate();
		bookingImpl.toCalculation();
		bookingImpl.getConfirmation();
		
		
	}

	@Override
	public HashMap<String, String> toCalculation() {
		// TODO Auto-generated method stub
		
		System.out.println("Sending data to the calculation service");
		
		
		data.put("username", this.username);
		data.put("headcount", Integer.toString(this.headCount));
		data.put("nightscount", Integer.toString(this.nightsCount));
		data.put("childrencount", Integer.toString(this.childrenCount));
		data.put("checkindate", this.checkinDate);
		data.put("checkoutdate", this.checkoutDate);
		data.put("package", Integer.toString(this.packageNo));
		data.put("CouponNo", this.coupen);
		finalBill = Activator.callCalculationService();
		Activator.sub = true;
		return data;
	}

	@Override
	public void getConfirmation() {
		// TODO Auto-generated method stub
		
		ITableView bill = new TableViewImpl();
		
		System.out.println("\n");
		System.out.println("---------- Your Final bill summary\n");
		bill.setShowVerticalLines(true);
		bill.setHeaders("Feature","Price/Number");
		bill.addRow("User Name",finalBill.get("username"));
		bill.addRow("Check In Date",finalBill.get("checkindate"));
		bill.addRow("Chek Out Date",finalBill.get("checkoutdate"));
		bill.addRow("Head Count",finalBill.get("headcount"));
		bill.addRow("No of Children",finalBill.get("childrencount"));
		bill.addRow("Selected Package",finalBill.get("package"));
		bill.addRow("Seasonal Discount",finalBill.get("seasonalDiscount"));
		bill.addRow("Regular Discount",finalBill.get("regularDiscount"));
		bill.addRow("Coupen Discount",finalBill.get("CouponDiscount"));
		bill.addRow("Total Discount",finalBill.get("totalDiscount"));
		bill.addRow("FINAL PRICE",finalBill.get("grossTotal"));
		bill.print();
		
		System.out.print("Do you want to proceed with the booking? (y/n) : ");
		confirm = scanner.next();
		
		while(true) {
			if(confirm.equals("y")) {
				finalBill.put("Confirmation", "true");
				break;
			}else if(confirm.equals("n")) {
				finalBill.put("Confirmation", "false");
				break;
			}else {
				System.out.print("Invalid input please enter y/n");
				confirm = scanner.next();
			}
		}
		
		System.out.println(Activator.confirmBooking() + "Thank you for using Room Booking Service =) ");

	}




}
