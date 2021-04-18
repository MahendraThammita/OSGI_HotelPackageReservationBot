package booking_calculations_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;




public class CalculationsActivator implements BundleActivator {

	ServiceRegistration roomBundleRegistration;
	ServiceRegistration hallBundleRegistration;

	public void start(BundleContext context) throws Exception {
		
		//Room Services Registration
		IRoomBookingCalculations RoomService = new RoomBookingCalculationsImpl();
		roomBundleRegistration = context.registerService(IRoomBookingCalculations.class.getName(), RoomService, null);
		
		//Event Hall Services Registration
		IEventHallBookingCalculations HallService = new EventHallBookingCalculationsImpl();
		hallBundleRegistration = context.registerService(IEventHallBookingCalculations.class.getName(), HallService, null);
	}

	public void stop(BundleContext context) throws Exception {
		roomBundleRegistration.unregister();
		hallBundleRegistration.unregister();
	}

}
