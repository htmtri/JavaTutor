package example1;

public class Practice {

	public static void main(String[] args) {
        String s1, s2;
        int length;
        char c1, c5;

		  s1 = "West Lafayette, Indiana, USA";
        length = s1.length();
    	  c1 = s1.charAt(1);
    	  c5 = s1.charAt(5);
    	  s2 = ""+c1+c5;


        /*** DO NOT edit the print statements below ***/
        System.out.println("The string \"" + s1 + "\" is " + length + " characters long.");
        System.out.println("Character 1 of s1 is '" + c1 + "' and character 5 is '" + c5 + "'.");
        System.out.println("The new string s2 is \"" + s2 + "\".");
	}

}
