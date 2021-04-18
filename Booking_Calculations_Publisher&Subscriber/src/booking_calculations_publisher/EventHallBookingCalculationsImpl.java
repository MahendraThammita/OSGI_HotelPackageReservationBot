package booking_calculations_publisher;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventHallBookingCalculationsImpl implements IEventHallBookingCalculations{
	
	Map<Integer, Double> functionPrices = new HashMap<Integer, Double>(){{
		put(1 , 400000.00);
		put(2 , 200000.00);
		put(3 , 150000.00);
		put(4 , 300000.00);
		put(5 , 100000.00);
	}};
	
	Map<Integer, Double> MealPackPrices = new HashMap<Integer, Double>(){{
		put(1 , 4000.00);
		put(2 , 3000.00);
		put(3 , 2000.00);
	}};
	
	Double packagePrice , mealPrice;

	URL workspace = RoomBookingCalculationsImpl.class.getProtectionDomain().getCodeSource().getLocation();
	
	DateTimeFormatter converter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
	
	@Override
	public HashMap<String, String> CalculateFinalBill_ForHall(HashMap<String, String> BookingInfo) {
		
		Double totalPrice = 0.00 , regularDiscount = 0.00 , seasonalDiscount = 0.00;
		
		String name = BookingInfo.get("name");
		String email = BookingInfo.get("email");
		int id = Integer.parseInt(BookingInfo.get("id"));
		int headCount = Integer.parseInt(BookingInfo.get("headCount"));
		int meal = Integer.parseInt(BookingInfo.get("meal"));
		int functionType = Integer.parseInt(BookingInfo.get("functionType"));
		LocalDate eventDate = LocalDate.parse(BookingInfo.get("eventDate") , converter);
		
		packagePrice = functionPrices.get(functionType);
		mealPrice = headCount * MealPackPrices.get(meal);
		
		totalPrice = packagePrice = mealPrice;
		
		regularDiscount = CalculateregularDiscounts(headCount, meal , totalPrice);
		seasonalDiscount = CalculateSeasonalDiscount(functionType, eventDate , meal ,totalPrice);
		
		double Totaldiscount = regularDiscount + seasonalDiscount;
		double FinalAmmount = totalPrice - Totaldiscount;
		
		BookingInfo.put("totalPrice", Double.toString(totalPrice));
		BookingInfo.put("regularDiscount", Double.toString(regularDiscount));
		BookingInfo.put("seasonalDiscount", Double.toString(seasonalDiscount));
		BookingInfo.put("Totaldiscount", Double.toString(Totaldiscount));
		BookingInfo.put("FinalAmmount", Double.toString(FinalAmmount));
		
		return BookingInfo;
	}

	@Override
	public String ConfirmHallBooking(HashMap<String, String> BookingInfo) {
		
		return null;
	}

	@Override
	public double CalculateregularDiscounts(int headCount, int meal, double totalPrice) {
		if(headCount >= 50 && headCount < 100 && meal == 1)
			return totalPrice * (2 / 100);
		else if (headCount >= 100 && headCount < 200 && meal == 2)
			return totalPrice * (3 / 100);
		else if (headCount >= 100 && headCount < 200 && meal == 3)
			return totalPrice * (5 / 100);
		else
			return 0.00;
	}

	@Override
	public double CalculateSeasonalDiscount(int functionType, LocalDate eventDate, int meal ,double totalPrice) {
		if (functionType == 1 && eventDate.getMonthValue() == 6) {
			if(meal == 3)
				return totalPrice * (3 / 100);
			else if (meal == 2)
				return totalPrice * (4 / 100);
			else if (meal == 1)
				return totalPrice * (6 / 100);
			else 
				return 0.00;
		}
		else if (functionType == 2 && eventDate.getMonthValue() == 12) {
			if(meal == 3)
				return totalPrice * (1 / 100);
			else if (meal == 2)
				return totalPrice * (3 / 100);
			else if (meal == 1)
				return totalPrice * (4 / 100);
			else 
				return 0.00;
		}
		else {
			return 0.00;
		}
		
	}
	
}
