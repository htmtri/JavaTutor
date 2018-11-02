package hw5;
import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        int n = s.nextInt();
        if (isPrime(n)){System.out.println("The number "+ n + " is a prime.");}
        else {System.out.println("The number " + n + " is not a prime.");}
        s.close();
    }
    public static boolean isPrime(int n){
        if (n < 2){return false;}
        for (int i = 2;i<n;i++){
            if (n%i == 0){return false;}
        }
        return true;
    }
    
}
