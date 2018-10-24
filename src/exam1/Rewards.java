package exam1;
import java.util.Scanner;

public class Rewards {

	  public int points;

	  /** @param points int to record current point level
	  */
	  public Rewards(int points) {
	  	//TODO: constructor definition
	   	this.points = points;
	  }

	  /** @return String of possible choices
	  */
	  public String showRewards() {
	  	//TODO: showRewards definition
	    String s = "";
	   	if (points >= 50){
	    	s += "1) free coffee - 50 pts\n";
	   	}
	   	if (points >= 100){
	   	    s += "2) free baked good - 100 pts\n";
	   	}
	   	if (points >= 200){
	   	    s += "3) free specialty coffee - 200 pts\n";
	   	}
	   	if (points >= 5000){
	   	    s+= "4) 1% store ownership - 5000 pts\n";
	   	}
	   	return s;
	  }

	  /** @param choice int to
	  *	  @return String reward chosen
	  */
	  public String getReward(int choice) {
		//TODO: getReward definition
		  if (choice == 1) {
	    	 if (points < 50){return "You do not have enough points for that reward.";}
	    	 else {int a = points - 50;
	           	return "You have selected a free coffee. Points remaining: " + Integer.toString(a);}
		  }
		  else if (choice == 2) {
		      if (points < 100){return "You do not have enough points for that reward.";}
		      else {int a = points - 100;
		           return "You have selected a free baked good!. Points remaining: " + Integer.toString(a);}
		  }
		  else if (choice == 3) {
	    	 if (points < 200){return "You do not have enough points for that reward.";}
		     else {int a = points - 100;
		           return "You have selected a free specialty coffee!. Points remaining :" + Integer.toString(a);}
		  }
		  else if(choice == 4) {
	    	 if (points < 5000){return "You do not have enough points for that reward.";}
		     else {int a = points - 5000;
		           return "You have selected a 1% store ownership. Points remaining :" + Integer.toString(a);}

		  }
		  else {
	    	 return "Wrong choice";
	    }
	  }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter amount of points:");
		int points = s.nextInt();
		Rewards r = new Rewards(points);
		System.out.println(r.showRewards());
		System.out.println("Please choose reward:");
		int choice = s.nextInt();
		System.out.println(r.getReward(choice));
		s.close();
	}

}
