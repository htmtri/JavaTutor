package msj1;

public class Crypto {
    public static void main(String[] args) {
        String in = "bob";
        String cyphertext = encrypt(in,5,3);
        String plaintext = decrypt(cyphertext,5);
        System.out.println(plaintext);
    }

    // Generate special character list
    private static String specialChar(){
        String ans = "";
        for(int i = 32;i<48;i++){
            ans += (char)i;
        }
        for(int i = 58;i<65;i++){
            ans += (char)i;
        }
        for(int i = 91;i<97;i++){
            ans += (char)i;
        }
        for(int i = 123;i<127;i++){
            ans += (char)i;
        }
        return ans;
    }

    private static String alphabetChar(){
        String result = "";
        for (int i = 65;i < 91;i++){
            result += (char)i;
        }
        return result;
    }

    private static String normalizeText(String s) {
        String ans = s;
        String spec = specialChar();
        for(int i = 0;i < spec.length();i++){
            String temp = ""+spec.charAt(i);
            if (ans.contains(temp)){
                ans = ans.replace(temp,"");
            }
        }

        ans = ans.toUpperCase();

        return ans;
    }

    private static String obify(String s){
        String result = "";
        String allVowels = "AEIOUY";
        for (int i = 0; i < s.length();i++){
            String temp = ""+s.charAt(i);
            if(allVowels.contains(temp)){result = result + "OB"+temp;}
            else{result += temp;}
        }
        return result;
    }

    private static String caesarify(String s, int n){
        String result = "";

        String alphabet = alphabetChar();

        String sAlphabet = shiftAlphabet(n);

        for(int i = 0;i < s.length();i++){
            int temp = alphabet.indexOf(s.charAt(i));
            result += sAlphabet.charAt(temp);
        }

        return result;
    }

    private static String shiftAlphabet(int shift){
        int start = 0;
        if (shift < 0){
            start = (int) 'Z' + shift + 1;
        }
        else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char)start;
        for(;currChar <='Z';++currChar){
            result = result + currChar;
        }
        if(result.length() < 26){
            for (currChar = 'A';result.length() < 26; ++currChar){
                result = result + currChar;
            }
        }
        return result;
    }

    private static String groupify(String s,int n){
        String result = "";

        if (s.length()<=n){
            String temp = "";
            for (int i = n-s.length(); i>0; i--){
                temp += "x";
            }
            return result + s + temp;
        }
        else {
            return groupify(s.substring(0,n),n)+ " " + groupify(s.substring(n),n);
        }

    }

    public static String encrypt(String s, int shift, int group){
        return groupify(caesarify(obify(normalizeText(s)),shift),group);
    }

    private static String ungroupify(String s){
        String result = s.replace(" ","");
        result = result.replace("x","");
        return result;
    }

    private static String uncaesarify(String s, int n){
        String result = "";

        String alphabet = alphabetChar();

        String sAlphabet = shiftAlphabet(n);

        for(int i = 0;i < s.length();i++){
            int temp = sAlphabet.indexOf(s.charAt(i));
            result += alphabet.charAt(temp);
        }

        return result;
    }

    private static String unobify(String s){
        String result = s.replace("OBOB","x");
        result = result.replace("OB","");
        result = result.replace("x","OB");
        return result;
    }

    public static String decrypt(String s, int n){
        return unobify(uncaesarify(ungroupify(s),n));
    }

}
