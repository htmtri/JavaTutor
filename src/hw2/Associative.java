package hw2;
import java.util.Scanner;

public class Associative {
	
	//var
	int x,y,z;
	
	//constructor
	public Associative(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//methods
	public int firstTwo() {
		return (x+y)*z;
	}
	public int lastTwo() {
		return x+(y*z);
	}
	
	public static void main(String[] args) {
		System.out.println("Please give an interger:");
		Scanner s1 = new Scanner(System.in);
		int a = s1.nextInt();
		System.out.println("Please give 2nd interger:");
		int b = s1.nextInt();
		System.out.println("Please give 3rd interger:");
		int c = s1.nextInt();
		s1.close();
		
		Associative ans = new Associative(a, b, c);
		int ans1 = ans.firstTwo();
		int ans2 = ans.lastTwo();
		System.out.println("Grouping the first two terms, (" + a +" + " + b +
				") * "+ c + " = " + ans1);
		System.out.println("Grouping the last two terms, " + a +" + (" + b +
				" * "+ c + ") = " + ans2);
	}

}
