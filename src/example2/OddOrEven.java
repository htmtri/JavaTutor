package example2;
import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.print("Please give an even integer: ");
            n = s.nextInt();
            if (n % 2 == 0){
                System.out.println("Even Int");
            }
            else{
                System.out.println("Odd Int");
            }
        } while (n%2 != 0);

        s.close();
    }
}
