package com.sa.room_booking_publisher;

import booking_calculations_publisher.IRoomBookingCalculations;

import java.util.HashMap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	public static boolean sub = false;
	ServiceRegistration publishServiceRegistration;
	static ServiceReference serviceReference;
	static BundleContext contextNew;
	private static HashMap<String, String> calData;
	public static String confirmationMsg;


	public void start(BundleContext context) throws Exception {
		contextNew = context;
		
		
		System.out.println("Initilazing room booking service");
		
		IRoomBooking publisherService = new RoomBookingImpl();
		publishServiceRegistration = context.registerService(IRoomBooking.class.getName(), publisherService, null);
		
//		System.out.println("start subscribing calculation module");
//		serviceReference = context.getServiceReference(IRoomBookingCalculations.class.getName());
//		@SuppressWarnings("unchecked")
//		IRoomBookingCalculations iRoomBookingCalculations = (IRoomBookingCalculations) context.getService(serviceReference);
//		iRoomBookingCalculations.CalculateFinalBill(publisherService.toCalculation());
		
//		while(Activator.sub) {
//			System.out.println("start subscribing calculation module");
//			serviceReference = context.getServiceReference(IRoomBookingCalculations.class.getName());
//			@SuppressWarnings("unchecked")
//			IRoomBookingCalculations iRoomBookingCalculations = (IRoomBookingCalculations) context.getService(serviceReference);
//			iRoomBookingCalculations.CalculateFinalBill(publisherService.toCalculation());
//			
//		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("De-registering room booking service");
		publishServiceRegistration.unregister();
	}
	
	public static HashMap<String, String> callCalculationService(){

		System.out.println("start subscribing calculation module");
		try {
			serviceReference = contextNew.getServiceReference(IRoomBookingCalculations.class.getName());
			IRoomBookingCalculations iRoomBookingCalculations = (IRoomBookingCalculations) contextNew.getService(serviceReference);
			calData =  iRoomBookingCalculations.CalculateFinalBill(RoomBookingImpl.data);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return calData;
		
	}
	
	public static String confirmBooking(){

		System.out.println("Sending data to the Calculation service to confirm the booking!!!");
		try {
			serviceReference = contextNew.getServiceReference(IRoomBookingCalculations.class.getName());
			IRoomBookingCalculations iRoomBookingCalculations = (IRoomBookingCalculations) contextNew.getService(serviceReference);
			confirmationMsg =  iRoomBookingCalculations.ConfirmRoomBooking(RoomBookingImpl.finalBill);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return confirmationMsg;
		
	}

}
