package eventhall_booking_publisher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EventHallBook_Impl implements EventHallBook_Interface{
	
	private String name, email, meal, eventDate;
	private int phNo, idNum, headCount;
	
	Scanner sc= new Scanner(System.in);
	
	
	
	public EventHallBook_Impl() {
		System.out.println("Hello Welcome to the Event Hall Reservation service!");
		System.out.println("Our Hotel is contained with two luxurious reception halls");
		System.out.println("And also we have got intersting discounts for you all.");
	}

	@Override
	public EventHallBook_Impl getName() {
		// TODO Auto-generated method stub
		System.out.println("Enter your name: ");  
		this.name = sc.nextLine();
		return this;
		
	}
	
	@Override
	public EventHallBook_Impl getID() {
		// TODO Auto-generated method stub
		System.out.println("Enter your identity number: ");  
		this.idNum = sc.nextInt();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getEmail() {
		// TODO Auto-generated method stub
		System.out.println("Enter your email: ");  
		email = sc.nextLine();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getPhone() {
		// TODO Auto-generated method stub
		System.out.println("Enter your phone number: ");  
		phNo = sc.nextInt();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getEventDate() {
		// TODO Auto-generated method stub
		System.out.println("Enter the date of your function: ");  
		eventDate = sc.nextLine();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getHeadCount() {
		// TODO Auto-generated method stub
		System.out.println("Enter the head count of your function: ");  
		headCount = sc.nextInt();
		return this;
	}
	
	@Override
	public EventHallBook_Impl getMeal() {
		// TODO Auto-generated method stub
		System.out.println("You can choose your meal that you are expecting to have in your function (Lunch/Evening Tea/Dinner)");
		System.out.println("Enter your meal: ");
		meal = sc.nextLine();
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

		new EventHallBook_Impl().getName().getID().getEmail().getPhone().getEventDate().getHeadCount().getMeal();
		
	}

	@Override
	public HashMap<String, String> toCalculation() {
		// TODO Auto-generated method stub
		
		HashMap<String, String> hallBookingData = new HashMap<String, String>();
		hallBookingData.put("name", this.name);
		hallBookingData.put("id", Integer.toString(this.idNum));
		hallBookingData.put("email:", this.email);
		hallBookingData.put("phone:", Integer.toString(this.phNo));
		hallBookingData.put("eventDate", this.eventDate);
		hallBookingData.put("headCount", Integer.toString(this.headCount));
		hallBookingData.put("meal", this.meal);
		
		return hallBookingData;
		
	}
	

}
