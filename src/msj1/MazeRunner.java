package msj1;

import java.util.Scanner;

public class MazeRunner {

    static Maze mymap = new Maze();
    static Scanner in = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {
        while(!mymap.didIWin()) {
            Intro();
            String move = inputMove();
            while (!canImove(move)) {
                System.out.println("Cannot move in " + move + " direction.");
                if(mymap.isThereAPit(move)){
                    boolean jump = navigateJump();
                    if (jump){
                    mymap.jumpOverPit(move);
                    count += 1;
                    checkCount();
                    Intro();
                    }
                    else{System.out.println("No jump initiate.");}
                }

                move = inputMove();
            }
            nowMove(move);
            count +=1;
            checkCount();

        }

        System.out.println("Congratulation, you made it out alive!");
    }

    public static void checkCount(){
        switch (count){
            case 50: System.out.println("Warning: You have made 50 moves, " +
                    "you have 50 remaining before the maze exit closes.");
                    break;
            case 75: System.out.println("Alert! You have made 75 moves, " +
                    "you only have 25 moves left to escape.");
                    break;
            case 90: System.out.println("DANGER! You have made 90 moves, " +
                    "you only have 10 moves left to escape!!");
                    break;
            case 100: gameOver();
                    break;
        }
    }

    public static void gameOver(){
        System.out.println("Oh no! You took too long to escape, " +
                "and now the maze exit is closed FOREVER >:[");
        System.out.println("Sorry, but you didn't escape in time- you lose!");
        System.out.println("and you did it in " + count + " moves");
        System.exit(0);
    }

    private static boolean navigateJump(){
        System.out.println("There is a pit. Do you want to jump?");
        String jump = in.next().toLowerCase();
        if (jump.equals("y")){
            return true;
        }
        return false;
    }

    private static void nowMove(String s){
        if (s.equals("R")){
            mymap.moveRight();
        }
        else if (s.equals("L")){
            mymap.moveLeft();
        }
        else if (s.equals("D")) {
            mymap.moveDown();
        }
        else if (s.equals("U")) {
            mymap.moveUp();
        }
        else {
            throw new IllegalArgumentException("ERROR: You cannot move that way");
        }
    }

    public static String inputMove(){
        System.out.println("Where do you want to move? (L,R,U,D)");
        String input = in.next().toUpperCase();
        while(!(input.equals("R") || input.equals("L") || input.equals("U") || input.equals("D"))){
            System.out.println("Invalid Move. Only (L,R,U,D) allow.");
            input = in.next().toUpperCase();
        }
        return input;

    }

    private static boolean canImove(String s){
        if (s.equals("R")){
            return mymap.canIMoveRight();
        }
        else if (s.equals("L")){
            return mymap.canIMoveLeft();
        }
        else if (s.equals("D")) {
            return mymap.canIMoveDown();
        }
        else if (s.equals("U")) {
            return mymap.canIMoveUp();
        }
        else {
            return false;
        }
    }

    public static void Intro(){
        mymap.printMap();
    }
}
