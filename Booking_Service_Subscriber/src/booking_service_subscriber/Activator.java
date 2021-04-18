package booking_service_subscriber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import user_handling_publisher.UserHandler;
import com.sa.room_booking_publisher.IRoomBooking;

import eventhall_booking_publisher.EventHallBook_Interface;




public class Activator implements BundleActivator {
	
ServiceReference serviceReference;
URL location = Activator.class.getProtectionDomain().getCodeSource().getLocation();	

private String username = "";

public void setUsername(String name) {
	this.username = name;
}
	

<<<<<<< HEAD
=======
	
>>>>>>> 317e252f5a23af989c3b345982fd50da79ad7d5e
	public void start(BundleContext context) throws Exception {
		
		
		System.out.println("1.Login \t 2.Signup");
		
		Scanner sc = new Scanner(System.in);
		int auth = sc.nextInt();
		
		serviceReference = context.getServiceReference(UserHandler.class.getName());
		UserHandler userHandler = (UserHandler)context.getService(serviceReference);
		
		if(auth == 1) {
			
			setUsername(userHandler.Login());
		}
		
		else if (auth == 2) {
			
<<<<<<< HEAD
	
=======
>>>>>>> 317e252f5a23af989c3b345982fd50da79ad7d5e
			userHandler.Register();
			setUsername(userHandler.Login());
		}
		
		
		System.out.println("Hi "+username+" I'm no one. virtual assistant of ABC Hotel"+"\n"+"How can I help you..?");
		System.out.println("1.Room reservation"+"\t"+"2.Event Hall Booking"+"\n"+"Please select your option:");
		
		
		while(true) {
			
		
		int option = sc.nextInt();
		
		if((option != 1) && (option != 2)) {
			
			System.out.println("Invalid Input. Try Again: \n");
		
		
		}
		
		else {
			
			if (option == 1) {
				System.out.println("Room Reservation Selected");
				serviceReference = context.getServiceReference(IRoomBooking.class.getName());
				IRoomBooking iRoomBooking = (IRoomBooking)context.getService(serviceReference);
				iRoomBooking.lifeCycleMethod(username);
				
			}
			else if (option == 2) {
				System.out.println("Event Hall Booking Selected");
				serviceReference = context.getServiceReference(EventHallBook_Interface.class.getName());
				EventHallBook_Interface eventHallBook_Interface = (EventHallBook_Interface)context.getService(serviceReference);
				eventHallBook_Interface.lifeCycleMethod();
			}
			
		}
		
		}
		
			
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Subscriber Stopped");
		context.ungetService(serviceReference);
	}

}
