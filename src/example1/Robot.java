package example1;

public class Robot {

    String name; //define variable

    // create Robot constructor
    Robot (String name){
        this.name = name;
    }

    //create Robot method
    void speak(String msg) {
        System.out.println(msg + name);
    }


    public static void main(String[] args) {
        Robot a = new Robot("debbie");
        a.speak("It's me: ");

        Robot b = new Robot("bob");
        b.speak("My name is: ");
    }
}
