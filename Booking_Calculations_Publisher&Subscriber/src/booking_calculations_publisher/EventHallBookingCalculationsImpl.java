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
		
		String name = BookingInfo.get("name");
		String email = BookingInfo.get("email");
		int id = Integer.parseInt(BookingInfo.get("id"));
		int headCount = Integer.parseInt(BookingInfo.get("headCount"));
		int meal = Integer.parseInt(BookingInfo.get("meal"));
		int functionType = Integer.parseInt(BookingInfo.get("functionType"));
		LocalDate eventDate = LocalDate.parse(BookingInfo.get("eventDate") , converter);
		
		return BookingInfo;
	}

	@Override
	public double GeneratePrice(int headCount, int meal , int functionType) {
		if(functionType == 1) {
			
		}
		else if (functionType == 2) {
			
		}
		else {
			
		}
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
