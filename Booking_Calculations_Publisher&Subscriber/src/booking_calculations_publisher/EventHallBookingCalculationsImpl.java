package booking_calculations_publisher;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class EventHallBookingCalculationsImpl implements IEventHallBookingCalculations{

	URL workspace = RoomBookingCalculationsImpl.class.getProtectionDomain().getCodeSource().getLocation();
	
	DateTimeFormatter converter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
	
	@Override
	public HashMap<String, String> CalculateFinalBill_ForHall(HashMap<String, String> BookingInfo) {
		String username = BookingInfo.get("username");
		int headcount = Integer.parseInt(BookingInfo.get("headcount"));
		int nightscount = Integer.parseInt(BookingInfo.get("nightscount"));
		int childrencount = Integer.parseInt(BookingInfo.get("childrencount"));
		LocalDate checkindate = LocalDate.parse(BookingInfo.get("checkindate") , converter);
		LocalDate checkoutdate = LocalDate.parse(BookingInfo.get("checkoutdate") , converter);
		int pack = Integer.parseInt(BookingInfo.get("package"));
		double CouponDiscount = Double.parseDouble(BookingInfo.get("CouponDiscount") );
		double regularDiscount = Double.parseDouble(BookingInfo.get("regularDiscount") );
		double seasonalDiscount = Double.parseDouble(BookingInfo.get("seasonalDiscount") );
		double totalDiscount = Double.parseDouble(BookingInfo.get("totalDiscount") );
		double grossTotal = Double.parseDouble(BookingInfo.get("grossTotal") );
		boolean Confirmation = Boolean.parseBoolean(BookingInfo.get("Confirmation") );
		return null;
	}

	@Override
	public double GeneratePrice(int headCount, int meal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double CalculateregularDiscounts(int headCount, int meal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double CalculateregularSeasonal(int eventType, String eventDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String ConfirmHallBooking(HashMap<String, String> BookingInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
