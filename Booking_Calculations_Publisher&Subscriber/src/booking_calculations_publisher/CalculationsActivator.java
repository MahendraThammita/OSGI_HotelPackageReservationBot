package booking_calculations_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class CalculationsActivator implements BundleActivator {

	ServiceReference roomBundleReference;
	ServiceReference hallBundleReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		//roomBundleReference = context.getServiceReference(ServicePublish.class.getName());
		//ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		//System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(roomBundleReference);
		context.ungetService(hallBundleReference);
	}

}
