package user_handling_publisher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class UserHandlerImpl implements UserHandler {
	
	URL location = Activator.class.getProtectionDomain().getCodeSource().getLocation();	
	
	private String username = "";
	
	public void setUsername(String name) {
		this.username = name;
	}

	@Override
	public void Register() {
		
		System.out.println("Enter your Username : ");
		Scanner sc = new Scanner(System.in);
		String user = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		 try {
		      FileWriter myWriter = new FileWriter(location.getPath()+"\\src\\users.txt",true);
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
			
		Scanner	sc = new Scanner(new File(location.getPath()+"\\src\\users.txt"));
		sc.useDelimiter("[,\n]");
		
		while(sc.hasNext() && !valid) {
			
			tempUser = sc.next();
			tempPass = sc.next();
			
			if(tempUser.trim().equals(user.trim()) && tempPass.trim().equals(pass.trim())) {
				
				setUsername(tempUser);
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
		return this.username;	
		
			

	}

}
