package msj1;
import java.util.*;


public class OddEvenGame {
    public static void main(String[] args) {
        //init
        Scanner s = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\".");
        System.out.println("What's your name?");
        String name = s.next();
        System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
        String choice = s.next();
        if (choice.equals("O")){System.out.println(name +
                "has picked odds!. The computer will be evens.");}
        else if (choice.equals("E")){System.out.println(name +
                "has picked evens!. The computer will be odds.");}
        else {
            System.out.println("Wrong input");
            System.exit(0);
        }
        System.out.println("**************************************************************");
        //play
        System.out.println("How many fingers do you want to put out?");
        int user = s.nextInt();
        Random rand = new Random();
        int comp = rand.nextInt(6);
        int ans = user+comp;
        System.out.println("The computer plays " + comp + " fingers.");
        System.out.println("**************************************************************");
        //score
        System.out.println(user + " + " + comp + " = " + ans);
        if (ans%2==0){
            System.out.println(ans + " is ...even!");
            if (choice.equals("E")){System.out.println("That means "+name+" wins! :)");}
            else {System.out.println("Computer wins! :(");}
        }
        else{
            System.out.println(ans + " is ...odds!");
            if (choice.equals("O")){System.out.println("That means "+name+" wins! :)");}
            else {System.out.println("Computer wins! :(");}
        }
        System.out.println("**************************************************************");
        s.close();
    }
}
