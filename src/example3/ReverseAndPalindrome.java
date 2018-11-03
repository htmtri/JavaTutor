package example3;
import java.util.Scanner;

public class ReverseAndPalindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a string:");
        String in = s.next();
        System.out.println(reverse1(in));


        s.close();
        assert "olleh".equals(reverse1("hello"));
        assert "ih".equals(reverse1("hi"));
        assert "s".equals(reverse1("s"));
        assert "".equals(reverse1(""));
        assert "".equals(reverse1(null));

        assert isPalin1("") == true;
        assert isPalin1(null) == true;
        assert isPalin1("x") == true;
        assert isPalin1("xx") == true;
        assert isPalin1("level") == true;
        assert isPalin1("henway") == false;
        assert isPalin1("racecar") == true;

        assert isPalin2("") == true;
        assert isPalin2(null) == true;
        assert isPalin2("x") == true;
        assert isPalin2("xx") == true;
        assert isPalin2("level") == true;
        assert isPalin2("henway") == false;
        assert isPalin2("racecar") == true;
    }

    public static String reverse1(String s){
        if (s == null){return "";}
        String ans = "";
        int slength = s.length();
        for (int i = slength; i>0 ;i--){
            ans += s.charAt(i-1);
        }
        return ans;
    }

    public static boolean isPalin1(String s){
        if (s == null){return true;}
        if(s.equals(reverse1(s))){return true;}
        return false;
    }

    public static boolean isPalin2(String s){
        if (s == null){return true;}
        int k = s.length();
        for(int i = 0; i < k/2; i++){
            if (s.charAt(i) != s.charAt(k-1-i)){return false;}
        }
        return true;
    }
}
