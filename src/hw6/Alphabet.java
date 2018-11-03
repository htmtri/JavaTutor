package hw6;
import java.util.Scanner;

public class Alphabet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = in.nextLine();
		//Alphabet Alphabet = new Alphabet();
		System.out.println("The missing letters are: "+whatsMissing(s));
		
		in.close();
		
		assert whatsMissing("abc").equals("defghijklmnopqrstuvwxyz");
		assert whatsMissing("hello darkness my old friend").equals("bcgjpqtuvwxz");
		assert whatsMissing("hi mom").equals("abcdefgjklnpqrstuvwxyz");
		
	}
	
	public static String whatsMissing(String s) {
		String unique = uniqueChar(s);
		String ans = "";
		for (int i = 97;i < 123;i++) {
			String temp = ""+(char)i;
			if (!unique.contains(temp)) {
				ans += temp;
			}
		}
		
		return ans;
	}
	
	
	static String uniqueChar(String s) {
		String ans = "";
		for(int i = 0;i < s.length();i++) {
			String temp = ""+s.charAt(i);
			if (!ans.contains(temp)) {
				ans += temp;
			}
			
		}
		return ans;
	}

}
