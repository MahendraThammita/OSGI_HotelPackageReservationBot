package booking_service_subscriber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {
	
private String username = "";

public void setUsername(String name) {
	this.username = name;
}
	
public void Register() {
	
	System.out.println("Enter your Username : ");
	Scanner sc = new Scanner(System.in);
	String user = sc.next();
	System.out.println("Enter Password");
	String pass = sc.next();

	 try {
	      FileWriter myWriter = new FileWriter("C:\\Users\\UDITHA J\\eclipse-workspace\\Booking_Service_Subscriber\\src\\users.txt",true);
	      BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
	      bufferedWriter.write( user + "," + pass + "\n");
	      bufferedWriter.close();
	      System.out.println("Successfully Registered. Please Login to proceed.");
	      Login();
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}


public void Login() {
	
	boolean valid = false;
	
	String tempUser = "";
	String tempPass = "";
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Username : ");
	String user = scanner.next();
	System.out.println("Password :");
	String pass = scanner.next();
	
	try {
		
	Scanner	sc = new Scanner(new File("C:\\Users\\UDITHA J\\eclipse-workspace\\Booking_Service_Subscriber\\src\\users.txt"));
	sc.useDelimiter("[,\n]");
	
	while(sc.hasNext() && !valid) {
		
		tempUser = sc.next();
		tempPass = sc.next();
		
		if(tempUser.trim().equals(user.trim()) && tempPass.trim().equals(pass.trim())) {
			
			valid = true;
			setUsername(tempUser);	
		}
		
		else {
			System.out.println("User Not Found!");
			Login();
		}
	}
		sc.close();
			
	} catch (Exception e) {
			
		System.out.println(e);
	}	
}
	
	
	
	


	public void start(BundleContext bundleContext) throws Exception {
		
		
		System.out.println("1.Login \t 2.Signup");
		
		Scanner sc = new Scanner(System.in);
		int auth = sc.nextInt();
		
		if(auth == 1) {
			
			Login();
		}
		
		else if (auth == 2) {
			
			Register();
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
			}
			else if (option == 2) {
				System.out.println("Event Hall Booking Selected");
			}
			
		}
		
		}
		
			
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
