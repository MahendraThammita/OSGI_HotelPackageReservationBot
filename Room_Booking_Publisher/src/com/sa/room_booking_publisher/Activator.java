package com.sa.room_booking_publisher;

import booking_calculations_publisher.IRoomBookingCalculations;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	public static boolean sub = false;
	ServiceRegistration publishServiceRegistration;
	ServiceReference serviceReference;


	public void start(BundleContext context) throws Exception {
		System.out.println("Initilazing room booking service");
		
		IRoomBooking publisherService = new RoomBookingImpl();
		publishServiceRegistration = context.registerService(IRoomBooking.class.getName(), publisherService, null);
		
		while(sub) {
			System.out.println("start subscribing calculation module");
			serviceReference = context.getServiceReference(IRoomBookingCalculations.class.getName());
			@SuppressWarnings("unchecked")
			IRoomBookingCalculations iRoomBookingCalculations = (IRoomBookingCalculations) context.getService(serviceReference);
			iRoomBookingCalculations.CalculateFinalBill(publisherService.toCalculation());
			
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("De-registering room booking service");
		publishServiceRegistration.unregister();
	}

}
