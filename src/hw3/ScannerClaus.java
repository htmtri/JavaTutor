package hw3;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class ScannerClaus {
    private int numPresents;
    private int numCarrots;
    private int x,y;
    private String path;

    public ScannerClaus(DeliveryMap d) {
        this.numPresents = d.getNumPresents();
        this.numCarrots = 5*this.numPresents;
        int[] pos = d.find('S');
        this.x = pos[1];
        this.y = pos[0];
        this.path = ""; }

    /** @return the number of carrots left for the reindeers */
    public int getNumCarrots(){
        return numCarrots;
    }


    /** @return the number of presents left to deliver */
    public int getNumPresents(){
        return numPresents;
    }


    /** @return the list of selected moves as a single String with no spaces
     *  followed by a new line, "Steps: " and then the number of moves
     * made. */
    public String getPath(){
        return path + "\n" + path.length();
    }

    /** Returns the character determining the next move for Scanner Claus
     * @param d the map Scanner Claus is navigating
     * @return the character representing the single next move for Scanner
     * Claus to make in delivering all the presents */
    public String chooseMove(DeliveryMap d){
        int count = 0;
        int[][] listp = new int[9][];
        int[] startp = d.find('S');
        String moveset = "";
        double[] dist = new double[9];
        int[] movep;
        int[] maxp;

        while (count < 9){
            int[] temp = d.find((char)(count+1+'0'));
            if (temp[0] == 0 || temp[1] == 0){temp[0] = 99;temp[1]=99;}
            listp[count] = temp;
            count++;
        }
        for (int i = 0; i < 9;i++){
            if (listp[i][0] == 99 || listp[i][1] == 99){dist[i] = 0;}
            else{dist[i] = Math.sqrt(Math.pow((listp[i][0] - startp[0]),2)+Math.pow((listp[i][1] - startp[1]),2));}
        }

        int mindex = findMinIndex(dist);
        int maxdex = findMaxIndex(dist);
        movep = listp[mindex];
        maxp = listp[maxdex];
        int maxdistance = Math.abs(maxp[0]-startp[0])+Math.abs(maxp[1]-startp[1]);

        if (this.numCarrots < maxdistance){
            moveset = choseCarrot(d);
        }
        else {
            moveset = findMoveSet(startp,movep);
        }
        return moveset;
    }

    public String choseCarrot(DeliveryMap d){
        int[] startp = d.find('S');
        int[][] listp;
        String moveset;
        double[] dist = new double[d.getTotalCarrot()];
        int[] movep;


        listp = d.findAll('C');

        for (int i = 0; i < dist.length;i++){
            if (listp[i][0] == 99 || listp[i][1] == 99){dist[i] = 0;}
            dist[i] = Math.sqrt(Math.pow((listp[i][0] - startp[0]),2)+Math.pow((listp[i][1] - startp[1]),2));
        }

        int mindex = findMinIndex(dist);
        movep = listp[mindex];
        moveset = findMoveSet(startp,movep);
        return moveset;
    }

    public String findMoveSet(int[] startp, int[] movep){
        String moveset = "";
        int ver = movep[0]-startp[0];
        int hor = movep[1]-startp[1];
        if (hor > 0) {
            for (int i = 0; i < hor; i++) {
                moveset += "D";
            }
        }
        if (hor < 0) {
            for (int i = 0; i > hor; i--) {
                moveset += "A";
            }
        }
        if (ver > 0) {
            for (int i = 0; i < ver; i++) {
                moveset += "S";
            }
        }
        if (ver < 0) {
            for (int i = 0; i > ver; i--) {
                moveset += "W";
            }
        }
        return moveset;
    }

    public int findMinIndex(double[] list){
        double minval = 99;
        int ans = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i] != 0 && list[i] < minval){
                minval = list[i];
                ans = i;
            }
        }
        return ans;
    }

    public int findMaxIndex(double[] list){
        double maxval = list[0];
        int ans = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i]> maxval){
                maxval = list[i];
                ans = i;
            }
        }
        return ans;
    }

    public boolean isValid(DeliveryMap d, char move){
        int[] startp = d.find('S');
        if(move == 'W'){
            if (d.getPosition(startp[0]-1,startp[1]) == 'X'){return false;}
            else return true;
        }
        else if (move == 'A'){
            if (d.getPosition(startp[0],startp[1]-1) == 'X'){return false;}
            else return true;
        }
        else if (move == 'S'){
            if (d.getPosition(startp[0]+1,startp[1]) == 'X'){return false;}
            else return true;
        }
        else if (move == 'D'){
            if (d.getPosition(startp[0],startp[1]+1) == 'X'){return false;}
            else return true;
        }
        return false;
    }

    public void move(DeliveryMap d, char dir) {
        int nextX = this.x;
        int nextY = this.y;
        switch (dir) {
            case 'W':
                nextY = this.y - 1;
                break;
            case 'A':
                nextX = this.x - 1;
                break;
            case 'S':
                nextY = this.y + 1;
                break;
            case 'D':
                nextX = this.x + 1;
                break;
            default:
                return;
        }
        char target = d.getPosition(nextY,nextX);
        if(target == 'C') this.numCarrots += 20;
        else if ((int)target > 48 && (int)target < 58) this.numPresents--;
        if(d.setPosition(nextY,nextX,false)) {
            d.setPosition(this.y,this.x,true);
            this.x = nextX; this.y = nextY; this.path += dir; this.numCarrots--; }
    }

    public String toString() {
        String msg = "Ho ho ho! (" + x + "," + y + ")\n";
        msg += "Carrots = " + this.numCarrots + "; Presents = " + this.numPresents + "\n";
        msg += "Press W (up), A (left), S (down), D (right), Q (quit)\n"; return msg; }
}
