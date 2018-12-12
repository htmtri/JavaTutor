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

        while (count < 9){
            int[] temp = d.find((char)(count+1+'0'));
            if (temp[0] == 0 || temp[1] == 0){temp[0] = 99;temp[1]=99;}
            listp[count] = temp;
            count++;
        }
        for (int i = 0; i < 9;i++){
            dist[i] = Math.sqrt(Math.pow((listp[i][0] - startp[0]),2)+Math.pow((listp[i][1] - startp[1]),2));
        }

        int mindex = findMinIndex(dist);
        movep = listp[mindex];
        int ver = movep[0]-startp[0];
        int hor = movep[1]-startp[1];
        if(hor > 0) {
            for (int i = 0; i < hor; i++) {
                moveset += "D";
            }
        }
        if (hor < 0) {
            for (int i = 0; i > hor; i--) {
                moveset += "A";
            }
        }
        if (ver >0) {
            for (int i = 0; i < ver; i++) {
                moveset += "S";
            }
        }
        if (ver <0) {
            for (int i = 0; i > ver; i--) {
                moveset += "W";
            }
        }

        return moveset;
    }

    public int findMinIndex(double[] list){
        double mval = list[0];
        int ans = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i]< mval){
                mval = list[i];
                ans = i;
            }
        }
        return ans;
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
