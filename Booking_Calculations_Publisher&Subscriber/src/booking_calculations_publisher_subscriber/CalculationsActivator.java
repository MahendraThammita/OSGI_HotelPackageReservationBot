package booking_calculations_publisher_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class CalculationsActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		CalculationsActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		CalculationsActivator.context = null;
	}

}
