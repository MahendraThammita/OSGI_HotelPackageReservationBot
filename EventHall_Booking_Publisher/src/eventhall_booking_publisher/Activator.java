package eventhall_booking_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting the event hall booking service");
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping the event hall booking service");
	}

}
