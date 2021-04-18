package user_handling_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {
	
<<<<<<< HEAD
	ServiceRegistration userServiceRegistration;

	

	public void start(BundleContext context) throws Exception {
		
		UserHandler userHandler = new UserHandlerImpl();
		userServiceRegistration = context.registerService(UserHandler.class.getName(),userHandler, null);
=======
	ServiceRegistration userhServiceRegistration;



	public void start(BundleContext context) throws Exception {
		
		System.out.println("user service started");
        UserHandler userHandler = new UserHandleraImpl();
		
		userhServiceRegistration = context.registerService(UserHandler.class.getName(),userHandler, null);
		
>>>>>>> 317e252f5a23af989c3b345982fd50da79ad7d5e
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
<<<<<<< HEAD
		
		System.out.println("Service Stopped...");
		userServiceRegistration.unregister();
		
=======
	
		userhServiceRegistration.unregister();
>>>>>>> 317e252f5a23af989c3b345982fd50da79ad7d5e
	}

}
