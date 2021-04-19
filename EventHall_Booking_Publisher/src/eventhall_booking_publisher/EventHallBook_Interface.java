package eventhall_booking_publisher;

import java.util.ArrayList;
import java.util.HashMap;

public interface EventHallBook_Interface {
	
	//getting user inputs
	public EventHallBook_Impl getName();
	
	public EventHallBook_Impl getID();
	
	public EventHallBook_Impl getEmail();
	
	public EventHallBook_Impl getPhone();
	
	public EventHallBook_Impl getEventDate();
	
	public EventHallBook_Impl getHeadCount();
	
	public EventHallBook_Impl getMeal();
	
	public EventHallBook_Impl getFunctionType();

	public String getToday();
	
	public double Discount();
	
	public void lifeCycleMethod();
	
	public void getEventConfirmation();
	
	public HashMap<String, String> EventBookingCalculation();
	
}
