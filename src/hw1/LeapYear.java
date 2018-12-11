package hw1;
import java.util.Scanner;

public class LeapYear {
	
	//method
	public boolean isLeapYear(int a) {
		if(a%4 == 0) {
			if(a%100 == 0 && !(a%400==0)) {return false;}
		return true;	
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please give a year:");
		int x = s.nextInt();
		s.close();
		LeapYear year = new LeapYear();
		boolean ans = year.isLeapYear(x);
		if (ans) {
			System.out.println("The year " + x + " is a leap year.");
		}
		else {
			System.out.println("The year " + x + " is not a leap year.");
		}
	}

}
