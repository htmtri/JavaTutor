package hw2;
import java.util.Arrays;

public class WordList {
    String[] words;
    int count;

    public WordList() {
        /*** TODO: Create new String array with size 2, and store in words
         Set count equal to 0 ***/
        this.words = new String[2];
        Arrays.fill(words, "");
        this.count = 0;

    }

    public int addWord(String w) {
        /*** TODO: Check which case the word, w, presents to your current list
         (1) w is in the list - do not add
         (2) words is not full and w is not in the list - add w, increment count
         (3) words is full - create new String array with two times the space,
         copy data from words to new array, set words equal
         to new array and then add w, increment count
         For all cases, return the current value of count ***/
        int check = findWord(w);
        int maxLength = words.length;
        if (!(check==-1)){return count;}
        else if (count == maxLength){
            String[] temp = new String[2*maxLength];
            Arrays.fill(temp, "");
            for (int i = 0; i < maxLength; i++){
                temp[i] = words[i];
            }
            temp[maxLength] = w;
            count += 1;
            words = temp;
            return count;
        }
        else {
            words[count] = w;
            count += 1;
            return count;
        }
    }

    public void removeWord(String w) {
        /*** TODO: Find w in words. If found, move all elements to right of w one space to
         the left and decrement count. Otherwise, do nothing ***/
        int check = findWord(w);
        if(!(check == -1)){
            String[] temp = words;
            for(int i = check; i < words.length-1;i++){
                words[i] = temp[i+1];
            }
            count -= 1;
        }
    }

    public int findWord(String w) {
        /*** TODO: Loop over all words until w is found. Return index of w, or -1 if not
         found ***/
        for (int i = 0; i < words.length;i++){
            if (w.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(WordList other) {
        if (count != other.count) {
            return false;
        } else {
            for (int i = 0; i < words.length; i++) {
                if (words[i] != other.words[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        String s = "There are " + count + " word" + ((words.length == 1)?"":"s") + " in the word list:\n";
        for (String w : words) {
            s = s + w + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        WordList wl = new WordList();
        wl.addWord("Dog");
        System.out.print(wl);
        wl.addWord("Dog");
        System.out.print(wl);
        wl.removeWord("Dog");
        wl.addWord("Cat");
        wl.addWord("Fish");
        wl.addWord("Horse");
        System.out.print(wl);
        if (wl.findWord("Cat") >= 0)
            System.out.println("Cat is in the word list");
        if (wl.findWord("Dog") >= 0)
            System.out.println("Dog is in the word list");
        WordList myList = new WordList();
        myList.addWord("Cat");
        myList.addWord("Fish");
        myList.addWord("Horse");
        if (wl.equals(myList))
            System.out.println("The two lists are the same");
    }
}
