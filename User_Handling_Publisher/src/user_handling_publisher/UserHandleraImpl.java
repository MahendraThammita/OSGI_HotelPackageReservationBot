package user_handling_publisher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class UserHandleraImpl implements UserHandler {
	
	URL location = Activator.class.getProtectionDomain().getCodeSource().getLocation();	
	private String username = "";

	@Override
	public void Register() {


		System.out.println("Enter your Username : ");
		Scanner sc = new Scanner(System.in);
		String user = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		

		 try {
		      FileWriter myWriter = new FileWriter("C:\\osgi\\userManagement\\users.txt",true);
		      BufferedWriter bufferedWriter = new BufferedWriter(myWriter);
		      bufferedWriter.write( user + "," + pass + "\n");
		      bufferedWriter.close();
		      System.out.println("Successfully Registered. Please Login to proceed.");
		
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}

	@Override
	public String Login() {
	
		
		boolean valid = false;
		
		String tempUser = "";
		String tempPass = "";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username : ");
		String user = scanner.next();
		System.out.println("Password :");
		String pass = scanner.next();
		

		
		try {
			
		Scanner	sc = new Scanner(new File("C:\\osgi\\userManagement\\users.txt"));
		sc.useDelimiter("[,\n]");
		
		while(sc.hasNext() && !valid) {
			
			tempUser = sc.next();
			tempPass = sc.next();
			
			if(tempUser.trim().equals(user.trim()) && tempPass.trim().equals(pass.trim())) {
				
				valid = true;
					
			}
			
			
		}
			sc.close();
			
			if (valid == false) {
				
				System.out.println("Invalid User");
				Login();
			}
				
		} catch (Exception e) {
				
			System.out.println(e);
		}	
		
		return tempUser;
	}

}
