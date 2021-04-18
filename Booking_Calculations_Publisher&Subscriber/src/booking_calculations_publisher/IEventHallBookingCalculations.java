package booking_calculations_publisher;

import java.util.HashMap;

public interface IEventHallBookingCalculations {
	
	public HashMap<String, String> CalculateFinalBill_ForHall(HashMap<String, String> BookingInfo);
	
	public double GeneratePrice(int headCount , int meal , int functionType);
	
	public double CalculateregularDiscounts(int headCount , int meal);
	
	public double CalculateregularSeasonal(int eventType , String eventDate);
	
	public String ConfirmHallBooking(HashMap<String, String> BookingInfo);
}
