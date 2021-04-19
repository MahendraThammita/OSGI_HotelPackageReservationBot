package eventhall_booking_publisher;

import booking_calculations_publisher.IEventHallBookingCalculations;
import java.util.HashMap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	
	public static boolean confirmStatus = false;
	ServiceRegistration publishServiceRegistration;
	static ServiceReference serviceReference;
	static BundleContext contextNew;
	private static HashMap<String, String> calculatedData;
	public static String confirmationMsg;


	public void start(BundleContext bundleContext) throws Exception {
		
		contextNew = bundleContext;
		
		System.out.println("Starting the event hall booking service");
		
		EventHallBook_Interface publisherService = new EventHallBook_Impl();
		publishServiceRegistration = bundleContext.registerService(EventHallBook_Interface.class.getName(), publisherService, null);	
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping the event hall booking service");
	}
	
	
	public static HashMap<String, String> callEventHallCalculation(){

		System.out.println("start subscribing calculation module");
		try {
			serviceReference = contextNew.getServiceReference(IEventHallBookingCalculations.class.getName());
			IEventHallBookingCalculations ihallBookingCalculations = (IEventHallBookingCalculations) contextNew.getService(serviceReference);
			calculatedData =  ihallBookingCalculations.CalculateFinalBill_ForHall(EventHallBook_Impl.hallBookingData);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return calculatedData;
		
	}
	
	
	//sending the booking confirmation

	public static String confirmHallBooking(){

		System.out.println("Sending data to the Calculation service to confirm the booking!!!");
		try {
			serviceReference = contextNew.getServiceReference(IEventHallBookingCalculations.class.getName());
			IEventHallBookingCalculations iRoomBookingCalculations = (IEventHallBookingCalculations) contextNew.getService(serviceReference);
			confirmationMsg =  iRoomBookingCalculations.ConfirmHallBooking(EventHallBook_Impl.bill);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return confirmationMsg;
		
	}    

}
