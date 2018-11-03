package example;
import java.lang.Math;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        int a = in.nextInt();
        Converter c = new Converter();
        System.out.println(c.convertToBinary(a));

        in.close();
    }

    String convertToBinary(int n){
        String ans = "";
        String prefix = "";
        if (n==0){
            return "0b0";
        }

        if (n<0){
            prefix = "-0b";
        }
        else {
            prefix = "0b";
        }


        while (Math.abs(n)>0) {
            if (Math.abs(n) % 2 == 0) {
                ans = "0" + ans;
            } else {
                ans = "1" + ans;
            }
            n = n / 2;
        }
        ans = prefix + ans;
        return ans;

    }
}
