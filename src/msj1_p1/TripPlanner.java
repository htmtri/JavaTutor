package msj1_p1;
import java.util.Scanner;
import java.lang.Math;;

public class TripPlanner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Input name: ");
		String name = s.nextLine();
		System.out.println("Hello "+name);
		System.out.print("Destination: ");
		String des = s.nextLine();
		System.out.println(des + " is a great choice.");
		getBudget();
		getTimeDiff();
		System.out.print("Please enter latitude of home and destination:");
		double la1 = s.nextDouble();
		double la2 = s.nextDouble();
		System.out.print("Please enter longtitude of home and destination:");
		double lo1 = s.nextDouble();
		double lo2 = s.nextDouble();
		double ans = hav(la1,la2,lo1,lo2);
		System.out.print("Distance between home and destination: "+ ans + " earth's radius");
		s.close();
	}
	
	//method
	public static void getBudget() {
		Scanner s = new Scanner(System.in);
		System.out.print("How long do will you stay (days)?");
		int duration = s.nextInt();
		System.out.print("What is your total budget?");
		int budget = s.nextInt();
		double dailyb = (int)(budget/duration*100)/100.0;
		
		System.out.println("You will spend: "+duration+" days travelling");
		System.out.println("Your daily budget will be: "+ dailyb);
	}
	public static void getTimeDiff() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter time zone difference: ");
		int timediff = s.nextInt();
		int midnighttime = (0 + timediff)%(24);
		int lunchtime = (12 + timediff)%(24);
		System.out.println("Local time at midnight: "+ midnighttime);
		System.out.println("Local time at noon: "+ lunchtime);
	}
	public static double hav(double la1,double la2,double lo1,double lo2) {
		return 2*Math.asin(Math.sqrt(Math.pow(Math.sin((la1-la2)/2),2)+
				Math.cos(la1)*Math.cos(la2)*Math.pow(Math.sin((lo1-lo2)/2),2)));
	}

}
