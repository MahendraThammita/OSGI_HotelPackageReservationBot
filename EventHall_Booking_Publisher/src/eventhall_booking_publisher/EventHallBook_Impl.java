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
		System.out.print("Enter the date of your function: ");  
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
		
		System.out.println("Please select ur desired meal package =) ");
		System.out.println("1.Package 1");
		System.out.println("2.Package 2");
		System.out.println("3.Package 3");
		System.out.println("");
		
		System.out.print("Please enter the selected event number : ");
		meal = sc.nextInt();
		return this;
	}
	
	@Override
	public String getToday() {
		// TODO Auto-generated method stub
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	    LocalDate localDate = LocalDate.now();
	    String currentDate = dtf.format(localDate);
		
		return currentDate;
	}

	@Override
	public double Discount() {
//		// TODO Auto-generated method stub
//		
//		String currentDate = getToday();
		
		return 0;
	}

	@Override
	public void lifeCycleMethod() {
		// TODO Auto-generated method stub

		EventHallBook_Impl hallBook =  new EventHallBook_Impl().getName().getID().getEmail().getPhone().getEventDate().getHeadCount().getMeal();
		hallBook.toCalculation();
		
		
	}

	

	@Override
	public EventHallBook_Impl getFunctionType() {
		
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
	public void getConfirmation() {
		// TODO Auto-generated method stub
		
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
		
		
		System.out.print("Do you want to proceed with the booking? (y/n) : ");
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
		
		System.out.println(Activator.confirmHallBooking() + "Thank you for using Room Booking Service =) ");
		
	}
	
	
	@Override
	public HashMap<String, String> toCalculation() {
		// TODO Auto-generated method stub
		
		
		hallBookingData.put("name", this.name);
		hallBookingData.put("id", Integer.toString(this.idNum));
		hallBookingData.put("email:", this.email);
		hallBookingData.put("phone:", Integer.toString(this.phNo));
		hallBookingData.put("eventDate", this.eventDate);
		hallBookingData.put("headCount", Integer.toString(this.headCount));
		hallBookingData.put("meal", Integer.toString(this.meal));
		hallBookingData.put("functionType", Integer.toString(this.functionType));
		
		return hallBookingData;
		
	}

}
