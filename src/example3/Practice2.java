package example3;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        longestName(s,7);
    }
    public static void longestName(Scanner s, int n){
        int temp = -1;
        String ans = "";
        int tiecounter = 0;
        for (int i = 1;i<=n;i++){
            System.out.print("name #"+ i +"? ");
            String str = s.next();
            if (str.length() == temp){tiecounter = 1;}
            else if (str.length() > temp){
                temp = str.length();
                ans = str;
                tiecounter = 0;
            }
        }
        System.out.println(ans.substring(0,1).toUpperCase()+ans.substring(1).toLowerCase() + " is the longest name");
        if (tiecounter == 1){System.out.println("(There is a tie.)");}
    }
}
