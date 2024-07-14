import java.util.Scanner;

import Email.EmailApp;

public class Main {

	public static void main(String[] args) {

		//company suffix domain
				System.out.println("Please Enter the Domain name for email address eg.(yahoo.com,gmail.co.za,companyname.co.za)"+"\n");
		
				
				Scanner scan = new Scanner(System.in);
			String	domain = scan.next();
			System.out.println("Enter the First Name of Employee/Employer");
			String Name = scan.next();
			System.out.println("Enter the Last Name of Employee/Employer");
			String LName = scan.next();
		EmailApp email = new EmailApp(Name,LName,domain);
		
}
		
	}

