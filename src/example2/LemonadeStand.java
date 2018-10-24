package example2;
import java.util.Scanner;

public class LemonadeStand {

    public int numRemaining;
    public double cost;
    public double revenue;

    public LemonadeStand(int numRemaining, double cost) {
        this.numRemaining = numRemaining;
        this.cost = cost;
        this.revenue = 0;
    }

    public boolean purchase(int num) {
        if (num > this.numRemaining) {
            return false;
        }
        else {
            this.numRemaining = this.numRemaining - num;
            this.revenue = this.revenue + (num * this.cost);
            System.out.printf("This will cost you $%.2f, please!\n", (num * this.cost));
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LemonadeStand ls = new LemonadeStand(25,0.25);

        System.out.println("Welcome to my lemonade stand! How many lemonades would you like?");
        int howMany = s.nextInt();

        if (!ls.purchase(howMany)) {
            System.out.println("I'm sorry, we don't have enough lemonade to satisfy you!");
        }
        else {
            System.out.println("Thanks for your purchase. Have a nice day!");
        }
    }
}
