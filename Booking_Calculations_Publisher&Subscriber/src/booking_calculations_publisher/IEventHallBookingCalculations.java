package booking_calculations_publisher;

import java.time.LocalDate;
import java.util.HashMap;

public interface IEventHallBookingCalculations {
	
	public HashMap<String, String> CalculateFinalBill_ForHall(HashMap<String, String> BookingInfo);
	
	public double CalculateregularDiscounts(int headCount, int meal , double totalPrice);
	
	public double CalculateSeasonalDiscount(int functionType, LocalDate eventDate , int meal , double totalPrice);
	
	public String ConfirmHallBooking(HashMap<String, String> BookingInfo);
}
