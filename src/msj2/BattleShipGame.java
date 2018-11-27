package msj2;
import sun.security.provider.certpath.OCSP;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class BattleShipGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Battle Ship game");
        System.out.println("Right now the sea is empty");
        BattleShipGame g = new BattleShipGame();
        g.initMaps();
        g.printMap();
        g.initPlayer();
        g.initAI();
        g.printMap();
        //g.printMap(true);
        System.out.println("Game Start!");
        g.startGame();

    }

    Random r = new Random();
    Scanner s = new Scanner(System.in);
    String[][] printedMap;
    String[][] OceanMap;
    private boolean cheat = false;
    boolean gameover;
    private int playerCount = 5;
    private int AICount = 5;

    public void initMaps(){
        OceanMap = new String[10][10];
        for(int j = 0; j < OceanMap.length;j++){Arrays.fill(OceanMap[j]," ");}
        printedMap = new String[12][12];
        String[] header = {" ","0","1","2","3","4","5","6","7","8","9"," "};
        printedMap[0] = header;
        printedMap[11] = header;
        for(int i = 1; i < printedMap.length-1; i++){
            printedMap[i][0] = String.valueOf(i-1);
            printedMap[i][11] = String.valueOf(i-1);
        }
    }

    public void printMap(boolean cheat){
        for(int i = 1; i < printedMap.length-1;i++){
            for (int j = 1; j < printedMap[i].length-1;j++){
                String temp = OceanMap[i-1][j-1];
                if (cheat){
                    printedMap[i][j] = temp;
                }
                else{
                    if (temp.equals("2")){printedMap[i][j] = " ";}
                    else if (temp.equals(".")){printedMap[i][j] = " ";}
                    else if (temp.equals("@")){printedMap[i][j] = "-";}
                    else{printedMap[i][j] = temp;}
                }
            }
        }
        for(int l = 0; l < printedMap.length;l++){
            for(int m =0; m < printedMap[l].length;m++){
                System.out.print(printedMap[l][m]);
            }
            System.out.println();
        }
    }

    public void printMap(){
        printMap(cheat);
    }


    public void initAI(){
        int xpos;
        int ypos;
        for(int i = 0; i < 5; i++) {
            do {
                xpos = r.nextInt(10);
                ypos = r.nextInt(10);
            } while (!islegal(xpos, ypos));
            updateOceanMap(xpos,ypos,"2");
        }
    }

    boolean islegal(int x, int y){
        if (x < 0 || x > 9 || y < 0 || y > 9){
            return false;
        }
        if (OceanMap[x][y].equals(" ")){
           return true;
        }
        return false;
    }

    void updateOceanMap(int x,int y,String t){
        OceanMap[x][y] = t;
    }

    public void initPlayer(){
        int xpos;
        int ypos;
        int count=0;
        boolean legal;
        for(int i = 0; i < 5; i++) {
            do {
                System.out.println("Enter x-pos of your ship: ");
                xpos = s.nextInt();
                System.out.println("Enter y-pos of your ship: ");
                ypos = s.nextInt();
                legal = islegal(xpos,ypos);
                if (!legal){System.out.println("Invalid position.");}
            } while (!legal);
            updateOceanMap(xpos,ypos,"1");
            count++;
            System.out.println("Remaining ship: " + (5-count));
        }
    }

    public void startGame(){
        gameover = false;
        while(!gameover) {
            playerTurn();
            printMap();
            checkGameState();
            if (gameover){return;}
            AITurn();
            //printMap(true);
            checkGameState();
        }
    }

    private void checkGameState(){
        if (playerCount == 0){
            gameover = true;
            System.out.println("You lose!!!");
        }
        else if (AICount == 0){
            gameover = true;
            System.out.println("You win!!!");
        }
    }

    void playerTurn(){
        int xpos;
        int ypos;
        do {
            System.out.println("Please enter x-coordinate of your shot:");
            xpos = s.nextInt();
            System.out.println("Please enter y-coordinate of your shot: ");
            ypos = s.nextInt();
        }while(!isallowed(xpos,ypos,1));
        String shot = OceanMap[xpos][ypos];
        if (shot.equals("2")){
            updateOceanMap(xpos,ypos,"!");
            AICount--;
            System.out.println("You sunk the enemy ship.");
        }
        else if (shot.equals("1")){
            updateOceanMap(xpos,ypos,"x");
            playerCount--;
            System.out.println("You sunk your own ship");
        }
        else if (shot.equals(" ")){
            updateOceanMap(xpos,ypos,"-");
            System.out.println("You missed");
        }
        else if (shot.equals(".")){
            updateOceanMap(xpos,ypos,"@");
            System.out.println("You missed");
        }

    }

    void AITurn(){
        int xpos;
        int ypos;
        do{
            xpos = r.nextInt(10);
            ypos = r.nextInt(10);
        } while(!isallowed(xpos,ypos,2));
        String shot = OceanMap[xpos][ypos];
        if(shot.equals("1")){
            updateOceanMap(xpos,ypos,"x");
            playerCount--;
            System.out.println("Computer hits one of our ship");
            printMap();
        }
        else if (shot.equals("2")){
            updateOceanMap(xpos,ypos,"!");
            AICount--;
            System.out.println("Computer hits its own ship");
            printMap();
        }
        else if (shot.equals(" ")){
            updateOceanMap(xpos,ypos,".");
            System.out.println("Computer misses");
        }
        else if (shot.equals("-")){
            updateOceanMap(xpos,ypos,"@");
            System.out.println("Computer misses");
        }
    }

    boolean isallowed(int x, int y,int t){
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            if (t == 1){System.out.println("Out of bound.");}
            return false;
        }
        String temp = OceanMap[x][y];
        if (t == 1){
            if (temp.equals("-")||temp.equals("@")||temp.equals("!")||temp.equals("x")){
                System.out.println("This spot have already been hit.");
                return false;
            }
        }
        if (t == 2){
            if (temp.equals(".")||temp.equals("@")||temp.equals("!")||temp.equals("x")){
                return false;
            }
        }
        return true;
    }
}
