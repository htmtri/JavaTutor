package example1;
import java.util.Scanner;
import java.lang.Math;

//Practice getting input using Wheel
public class Wheel {

	double radius;
	
	Wheel (double radius) {
		this.radius = radius;
	}
	
	double getCircumference(){
		return 2*Math.PI*radius;
	}
	
	double getArea() {
		return radius*radius*Math.PI;
	}
	
	public static void main(String[] args) {
		System.out.println("Please give a real number:");
		Scanner s = new Scanner(System.in);
		double d = s.nextDouble();
		
		
		Wheel w = new Wheel(d);
		
		System.out.println(w.getCircumference());
		System.out.println(w.getArea());
		
		s.close();
	}

}
