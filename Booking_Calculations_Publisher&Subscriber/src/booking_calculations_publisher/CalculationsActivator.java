package booking_calculations_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;



public class CalculationsActivator implements BundleActivator {

	ServiceReference roomBundleReference;
	ServiceReference hallBundleReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Publisher Start");
		roomBundleReference = context.getServiceReference(IRoomBookingCalculations.class.getName());
		//roomBundleReference = context.getServiceReference(IRoomBookingCalculations.class.getName());
		IRoomBookingCalculations RoomService = (IRoomBookingCalculations)context.getService(roomBundleReference);
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(roomBundleReference);
		context.ungetService(hallBundleReference);
	}

}
