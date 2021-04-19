package eventhall_booking_publisher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EventHallBook_Impl implements EventHallBook_Interface{
	
	private String name, email, eventDate;
	private int phNo, idNum, headCount , functionType, meal;
	public static HashMap<String, String> hallBookingData = new HashMap<String, String>();
	public static HashMap<String, String> bill;
	public static String confirmationMsg;
	
	Scanner sc= new Scanner(System.in);
	
	
	
	public EventHallBook_Impl() {
		System.out.println("Hello Welcome to the Event Hall Reservation service!");
		System.out.println("Our Hotel is contained with two luxurious reception halls");
		System.out.println("And also we have got intersting discounts for you all.");
	}

	@Override
	public EventHallBook_Impl getName() {
		// TODO Auto-generated method stub
		System.out.print("Enter your name: ");  
		this.name = sc.nextLine();
		return this;
		
	}
	
	@Override
	public EventHallBook_Impl getID() {
		// TODO Auto-generated method stub
		System.out.print("Enter your identity number: ");  
		this.idNum = sc.nextInt();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getEmail() {
		// TODO Auto-generated method stub
		System.out.print("Enter your email: ");  
		email = sc.next();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getPhone() {
		// TODO Auto-generated method stub
		System.out.print("Enter your phone number: ");  
		phNo = sc.nextInt();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getEventDate() {
		// TODO Auto-generated method stub
		System.out.print("Enter the date of your function (YYYY-MM-DD): ");  
		eventDate = sc.next();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getHeadCount() {
		// TODO Auto-generated method stub
		System.out.print("Enter the head count of your function: ");  
		headCount = sc.nextInt();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getMeal() {
		
		//select the meal package
		System.out.println("Please select ur desired meal package =) ");
		System.out.println("[1].Basic - Maximum headcount - 100");
		System.out.println("[2].Standard - Maximum headcount - 200 | ");
		System.out.println("[3].Package 3");
		System.out.println("");
		
		//gain the input of meal
		System.out.print("Please enter the selected event number : ");
		meal = sc.nextInt();
		return this;
	}
	
	@Override
	public String getToday() {
		// TODO Auto-generated method stub
		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
//	    LocalDate localDate = LocalDate.now();
//	    String currentDate = dtf.format(localDate);
		
		return null;
	}

	@Override
	public double Discount() {
//		// TODO Auto-generated method stub
//		
//		String currentDate = getToday();
		
		return 0;
	}

	

	@Override
	public EventHallBook_Impl getFunctionType() {
		//display all the event packages
		System.out.println("Please select ur Event type =) ");
		System.out.println("1.Party");
		System.out.println("\t + Lunch or Dinner");
		System.out.println("\t + Welcome Drink");
		System.out.println("\t + Can Choose one between Open area and Banquet hall");
		System.out.println("");
		System.out.println("2.Wedding");
		System.out.println("\t + Lunch or Dinner");
		System.out.println("\t + Welcome Drink");
		System.out.println("\t + Can be aranged the flower themes based on your selection");
		System.out.println("\t + Open buffet");
		System.out.println("");
		System.out.println("3.Workshops");
		System.out.println("\t + Lunch or Dinner");
		System.out.println("\t + Welcome Drink");
		System.out.println("\t + Can Choose one between Open area and Banquet hall");
		System.out.println("\t + Can be aranged the projectors and stuff");
		System.out.println("");
		System.out.println("4.Conferences");
		System.out.println("\t + Lunch or Dinner");
		System.out.println("\t + Welcome Drink");
		System.out.println("\t + Can Choose one between Open area and Banquet hall");
		System.out.println("\t + Can be aranged the projectors and stuff");
		System.out.println("");
		System.out.println("5.Other");
		
		System.out.println("Please enter the selected event number : ");
		functionType = sc.nextInt();
		return this;
	}
	
	@Override
	public void callFunctions() {
		// TODO Auto-generated method stub

		//making a lifecycle method to call all the functions
		EventHallBook_Impl hallBook =  new EventHallBook_Impl().getName().getID().getEmail().getPhone().getEventDate().getHeadCount().getMeal().getFunctionType();
		hallBook.EventBookingCalculation();
		hallBook.getEventConfirmation();
		
		
	}
	
	

	@Override
	public void getEventConfirmation() {
		// TODO Auto-generated method stub
		
		
		//Printing the final bill
		System.out.println("\n");
		System.out.println("---------- Your Final bill summary---------\n");
		
		System.out.println("Your name\t: "+bill.get("name"));
		System.out.println("Your ID\t: "+bill.get("id"));
		System.out.println("Head Count\t: "+bill.get("headCount"));
		System.out.println("Function Meal\t: "+bill.get("meal"));		
		System.out.println("Function Type\t: "+bill.get("functionType"));
		System.out.println("Event Date\t: "+bill.get("eventDate"));
		System.out.println("Regular Discount\t: "+bill.get("regularDiscount"));
		System.out.println("Seasonal Discount\t: "+bill.get("seasonalDiscount"));
		System.out.println("Total Discount\t: "+bill.get("Totaldiscount"));
		System.out.println("Final Amount\t: "+bill.get("FinalAmmount"));
		
		
		//getting the bill confirmation
		System.out.print("Do you want to proceed with this reservation? (y/n) : ");
		confirmationMsg = sc.next();
		
		while(true) {
			if(confirmationMsg.equals("y")) {
				bill.put("Confirmation", "true");
				break;
			}else if(confirmationMsg.equals("n")) {
				bill.put("Confirmation", "false");
				break;
			}else {
				System.out.print("Invalid input please enter y/n");
				confirmationMsg = sc.next();
			}
		}
		
		System.out.println(Activator.confirmHallBooking() + "Thank you for using Event Hall Booking Service!");
		
	}
	
	
	@Override
	public HashMap<String, String> EventBookingCalculation() {
		// TODO Auto-generated method stub
		
		//passing the input scans
		hallBookingData.put("name", this.name);
		hallBookingData.put("id", Integer.toString(this.idNum));
		hallBookingData.put("email:", this.email);
		hallBookingData.put("phone:", Integer.toString(this.phNo));
		hallBookingData.put("eventDate", this.eventDate);
		hallBookingData.put("headCount", Integer.toString(this.headCount));
		hallBookingData.put("meal", Integer.toString(this.meal));
		hallBookingData.put("functionType", Integer.toString(this.functionType));
		bill = Activator.callEventHallCalculation();
		Activator.confirmStatus = true;
		
		return hallBookingData;
		
	}

}
