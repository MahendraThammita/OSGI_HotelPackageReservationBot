package com.sa.room_booking_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	
	ServiceRegistration publishServiceRegistration;


	public void start(BundleContext context) throws Exception {
		System.out.println("Initilazing room booking service");
		
		IRoomBooking publisherService = new RoomBookingImpl();
		publishServiceRegistration = context.registerService(IRoomBooking.class.getName(), publisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("De-registering room booking service");
		publishServiceRegistration.unregister();
	}

}
