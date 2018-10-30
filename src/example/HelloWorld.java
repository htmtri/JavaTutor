package example;
import java.lang.Math;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        //xyBalancePractice();
        //System.out.println(repeatFront("xyz",3));

        /*String a = "";
        a += "0";
        if (a == "0") {
            System.out.println("a is 0!");
        } else if (a == "1") {
            System.out.println("a is 1!");
        } else if (a == "a") {
            System.out.println("a is a!");
        } else {
            System.out.println("a is something else!");
        }
*/

        /*for (int k = 0;k < 3;k++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(i);
                }
            }
            System.out.println();
        }*/

        /*for (int i = 1; i < 8; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
        System.out.println();
        }*/

        /*String hello = "Hello";
        for(int i = 0;i<=hello.length();i++) {
                System.out.println(hello.substring(0,i));
        }
        for(int i = 1;i<=hello.length();i++){
            System.out.println(hello.substring(i));
        }*/

        //double a = Double.MAX_VALUE;
        //System.out.println(a);

        /*int z = 0;
        for ( int x = 10; x > 0; x--) {
            for ( int y = x; y < 10; y++) {
                z += (x + y);
            }
        }
        System.out.println(z);*/

        /*String s = "What is the answer?";
        for ( int a = 1; a < s.length(); a += 2) {
            s = s.charAt(a) + s.substring(a);
            System.out.println(a);
        }
        System.out.println(s);*/

        /*double x1 = Math.cos(Math.PI);
        System.out.println(x1);
        double x2 = 8/3;
        System.out.println(x2);
        double x3 = 9.0/2;
        System.out.println(x3);
        final double GRAVITY = 9.81;
        double z1 = Math.sqrt(GRAVITY);
        System.out.println(z1);
        double y1 = 5.0/1.0+2.0*3.0;
        System.out.println(y1);
        int a1 = 6,b1 = 10;
        float c1 = (float)a1/(float)b1;
        System.out.println(c1);
        int a2 = Integer.MAX_VALUE;
        System.out.println(a2);
        */
    }
    
    public static void xyBalancePractice(){
        System.out.println("Please enter a string: ");
        Scanner s = new Scanner(System.in);
        String test = s.next();
        System.out.println(xyBalance(test));
        s.close();
    }
    
    public static boolean xyBalance(String str) {
        char x = 'x';
        char y = 'y';
        int xx = -1;
        int yy = -1;
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) == (int) x) {
                int temp = i;
                if (i > xx) {xx = i;}
            }
        }
        for(int i = 0;i<str.length();i++){
            if((int)str.charAt(i) == (int)y){
                int temp = i;
                if (i>yy){yy = i;}
            }
        }
        if (yy >= xx){return true;}
        return false;
    }

    public static String repeatFront(String str, int n) {
        String ans = "";
        for(int i = n;i>=0;i--){
            ans += str.substring(0,i);
        }
        return ans;
    }
}
