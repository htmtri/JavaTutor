package hw3;
import java.util.Scanner;

public class EmailGenerator {
	
	//method
	public String makeUserName(String a, String b) {
		return ""+a.toLowerCase().charAt(0)+b.toLowerCase();
	}
	
	public String makeEmail(String a, String b) {
		return a + (char) 64 + b;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Please type first name:");
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		System.out.println("Please type last name");
		String b = s.nextLine();
		EmailGenerator e = new EmailGenerator();
		String name = e.makeUserName(a, b);
		String email = e.makeEmail(name, "purdue.edu");
		System.out.println("This user’s e-mail is: " + email);
		s.close();
	}

}
