package hw3;
import java.util.Scanner;
import java.io.File;
public class HolidayRunner {
    public static void main(String[] args) {
        //File file = new File(".");
        //for(String fileNames : file.list()) System.out.println(fileNames);
        DeliveryMap d = new DeliveryMap("src/hw3/mapA.txt");
        ScannerClaus sc = new ScannerClaus(d);
        Scanner s = new Scanner(System.in);
        int playMode;
        char choice;
        System.out.println("Automate (1) or Play (2): ");
        playMode = s.nextInt();
        if (playMode == 1) {
            String moveset = sc.chooseMove(d);
            System.out.println(moveset);
            do {
                System.out.println(d.printMap());
                sc.move(d, moveset.charAt(0));
                moveset = moveset.substring(1);
                while (!moveset.isEmpty()&&!sc.isValid(d,moveset.charAt(0))){
                    moveset = moveset.substring(1);
                }
                if (moveset.isEmpty()){
                    moveset = sc.chooseMove(d);

                }
            } while (sc.getNumCarrots() > 0 && sc.getNumPresents() > 0);
        } else {
            do {
                System.out.println(d.printMap());
                System.out.println(sc);
                choice = s.next().toUpperCase().charAt(0);
                sc.move(d, choice);
            } while (choice != 'Q' && sc.getNumCarrots() > 0 && sc.getNumPresents() > 0);
        }
        if (sc.getNumCarrots() == 0) System.out.println("Your reindeer ran out of carrots and refuse to keep going!");
        else if (sc.getNumPresents() == 0) System.out.println("You delivered all of the presents! Ho ho!");
        System.out.println(sc.getPath());
    }
}