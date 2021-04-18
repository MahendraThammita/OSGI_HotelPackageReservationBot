package booking_calculations_publisher;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;




public class RoomBookingCalculationsImpl implements IRoomBookingCalculations {
	
	double STANDARD_UnitPrice = 4000.00;
	double DELUXE_UnitPrice = 6000.00;
	double EXECUTIVE_UnitPrice = 10000.00;
	URL workspace = RoomBookingCalculationsImpl.class.getProtectionDomain().getCodeSource().getLocation();
	@Override
	public HashMap<String, String> CalculateFinalBill(HashMap<String, String> BookingInfo) {

		DateTimeFormatter converter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		
		String username = BookingInfo.get("username");
		int headcount = Integer.parseInt(BookingInfo.get("headcount"));
		int nightscount = Integer.parseInt(BookingInfo.get("nightscount"));
		int childrencount = Integer.parseInt(BookingInfo.get("childrencount"));
		LocalDate checkindate = LocalDate.parse(BookingInfo.get("checkindate") , converter);
		LocalDate checkoutdate = LocalDate.parse(BookingInfo.get("checkoutdate") , converter);
		int pack = Integer.parseInt(BookingInfo.get("package"));
		double netTotal = 0.00;
		double CouponDiscount = 0.00 , regularDiscount , seasonalDiscount;
		
		switch (pack) {
		case 1:
			netTotal = (STANDARD_UnitPrice * headcount) + (STANDARD_UnitPrice * 0.40 * childrencount);
			break;
		case 2:
			netTotal = (DELUXE_UnitPrice * headcount) + (DELUXE_UnitPrice * 0.40 * childrencount);
			break;
		case 3:
			netTotal = (EXECUTIVE_UnitPrice * headcount) + (EXECUTIVE_UnitPrice * 0.40 * childrencount);
			break;
		default:
			break;
		}
		
		if(BookingInfo.get("CouponNo") != null) {
			CouponDiscount = CouponDiscount(BookingInfo.get("username") , netTotal , BookingInfo.get("CouponNo"));
		}
		
		regularDiscount = RegularDiscount(pack, headcount, netTotal);
		seasonalDiscount = SeasonalDiscount(pack, checkindate, netTotal);
		
		double totalDiscount = CouponDiscount + regularDiscount + seasonalDiscount;
		double grossTotal = netTotal - totalDiscount;
		
		BookingInfo.put("CouponDiscount", Double.toString(CouponDiscount));
		BookingInfo.put("regularDiscount", Double.toString(regularDiscount));
		BookingInfo.put("seasonalDiscount", Double.toString(seasonalDiscount));
		BookingInfo.put("totalDiscount", Double.toString(totalDiscount));
		BookingInfo.put("grossTotal", Double.toString(grossTotal));
		
		return BookingInfo;
	}

	@Override
	public double CouponDiscount(String UserName , double netTotal , String CouponNo) {
		
			double cDiscount = 0.00;
			File coupons = new File(workspace.getPath() + "\\src\\coupons.txt");
			try {
				//BufferedReader bufferedReader = new BufferedReader(new FileReader(coupons));
				Scanner sc = new Scanner(new FileReader(coupons));
				while (sc.hasNextLine()) {
					String couponNoString = sc.next();
					String uNameString = sc.next();
					if(couponNoString.equals(CouponNo) && uNameString.equals(UserName)) {
						String disPerscent = sc.next();
						cDiscount = netTotal * (Double.parseDouble(disPerscent) / 100);
						break;
					}
					
					sc.nextLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public double RegularDiscount(int packageNo, int HeadCount , double netTotal) {
		double regularDiscount = 0.00;
		if(packageNo == 1) {
			if(HeadCount >= 20)
				regularDiscount = (STANDARD_UnitPrice * (90 / 100)) * HeadCount;
		}
		else if (packageNo == 2) {
			if(HeadCount >= 15)
				regularDiscount = (DELUXE_UnitPrice * (90 / 100)) * HeadCount;
		}
		else if (packageNo == 3) {
			if(HeadCount >= 10)
				regularDiscount = (EXECUTIVE_UnitPrice * (90 / 100)) * HeadCount;
		}
		
		return regularDiscount;
	}

	@Override
	public double SeasonalDiscount(int packageNo, LocalDate checkinDate , double netTotal) {
		double SeasonalDiscount = 0.00;
		if(checkinDate.getMonthValue() == 4 || checkinDate.getMonthValue() == 12) {
			switch (packageNo) {
			case 1:
				SeasonalDiscount = netTotal * (10 / 100);
				break;
			case 2:
				SeasonalDiscount = netTotal * (20 / 100);
				break;
			case 3:
				SeasonalDiscount = netTotal * (15 / 100);
				break;
			default:
				SeasonalDiscount = 0.00;
			}
		}
		return SeasonalDiscount;
	}

	@Override
	public String ConfirmRoomBooking(HashMap<String, String> BookingInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
