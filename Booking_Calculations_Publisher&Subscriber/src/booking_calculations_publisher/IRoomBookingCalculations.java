package booking_calculations_publisher;

import java.time.LocalDate;
import java.util.HashMap;

public interface IRoomBookingCalculations {

	public HashMap<String, String> CalculateFinalBill(HashMap<String, String> BookingInfo);
	
	public double CouponDiscount(String UserName , double netTotal , String CouponNo); 
	
	public double RegularDiscount(int packageNo , int HeadCount , double netTotal); 
	
	public double SeasonalDiscount(int packageNo , LocalDate checkinDate , double netTotal); 
	
	public String ConfirmRoomBooking(HashMap<String, String> BookingInfo);
	
}
