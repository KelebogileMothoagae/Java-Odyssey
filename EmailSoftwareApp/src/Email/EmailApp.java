package Email;

import java.util.Scanner;

/*
 * @author Mothoagae Kelebogile 
 * This class is used to instantiate variables to be used for our email app
 */
public class EmailApp {

	// Declare variable to use for the app
	private String password;
	private String name;
	private String surname;
	private String Email;
	private String department;
	private int defaultlength = 8;
	private String Symbols;

	// argument constructor
	public EmailApp(String Name, String Surname, String companySuffix) {
		this.name = Name;
		this.surname = Surname;

		int max = 100;
		int min = 0;
		int getrand = (int) (Math.random() * ((max - min + 1) + min));

		System.out.println("Name & Surname :" + " " + this.name + " " + this.surname + "\n");
		this.password = createPass(defaultlength);

		this.department = setDepartment();
		System.out.println("Department: " + this.department + "\n");
		this.Symbols = getRandSymbols();

		
		// combine
		this.Email = this.name.toLowerCase() + this.Symbols + this.surname.toLowerCase() + getrand + "@"
				+ this.department + "." + companySuffix;
		System.out.println("Your Email: " + this.Email + "\n");
		System.out.println("Your Email Password : " + this.password + "\n");
	}

//function for generating random symbols for email name
	public String getRandSymbols() {
		String setSymbol = "_.";
		char[] randomsymbols = new char[1];
		for (int i = 0; i < 1; i++) {
			int rand = (int) (Math.random() * setSymbol.length());
			randomsymbols[i] = setSymbol.charAt(rand);
		}
		return new String(randomsymbols);
	}

	// Function for determining the department type
	private String setDepartment() {
		System.out.println(
				"DEPARTMENT CODES:-\n1 Sales\n2 Accounting\n3 Marketing\n4 Software Engineering \n5 HR\n6 Administration \n7  IT \n8 Student"
						+ "\n");
		System.out.println("Enter Department Number eg.(1,2,3..):-");
		try (Scanner input = new Scanner(System.in)) {

			int depchoice = input.nextInt();
			if (depchoice == 1) {
				return "sales";
			} else if (depchoice == 2) {
				return "acc";
			} else if (depchoice == 3) {
				return "mar";
			} else if (depchoice == 4) {
				return "dev";
			} else if (depchoice == 5) {
				return "hr";
			} else if (depchoice == 6) {
				return "admin";
			} else if (depchoice == 7) {
				return "it";
			} else if (depchoice == 8) {
				return "student";
			} else {

				return "";
			}
		}
	}

	// Generate a random password
	private String createPass(int length) {
		String passwordSet = "ABCDEFGHIJKLNMOPQRSTUVWSYZ213456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}

		return new String(password);
	}

}
