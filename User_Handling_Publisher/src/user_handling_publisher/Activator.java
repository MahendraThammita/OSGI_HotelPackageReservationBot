package user_handling_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {
	
	ServiceRegistration userhServiceRegistration;



	public void start(BundleContext context) throws Exception {
		
		System.out.println("user service started");
        UserHandler userHandler = new UserHandleraImpl();
		
		userhServiceRegistration = context.registerService(UserHandler.class.getName(),userHandler, null);
		
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
	
		userhServiceRegistration.unregister();
	}

}
