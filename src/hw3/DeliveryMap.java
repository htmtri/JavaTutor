package hw3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeliveryMap {
    private char map[][];
    private int rows;
    private int cols;
    private int numPresents;
    private int totalCarrot;

    public DeliveryMap(String fileName) {
        Scanner s;
        try {
            s = new Scanner(new File(fileName));
            this.rows = s.nextInt();
            this.cols = s.nextInt();
            this.numPresents = s.nextInt();
            this.totalCarrot = s.nextInt();
            map = new char[rows][cols];
            String mapInput = s.nextLine();
            for (int r = 0; r < rows; r++) {
                mapInput = s.nextLine();
                for (int c = 0; c < cols; c++) {
                    map[r][c] = mapInput.charAt(c);
                }
            }
        } catch (Exception e) {
            System.err.print(e);
        }
    }

    public int getNumPresents() {
        return numPresents;
    }

    public char getPosition(int r, int c) {
        return map[r][c];
    }

    public int getTotalCarrot(){
        return totalCarrot;
    }

    public boolean setPosition(int r, int c, boolean previous) {
        if (map[r][c] == 'X') {
            return false;
        } else if (previous) {
            map[r][c] = '.';
        } else {
            map[r][c] = 'S';
        }
        return true;
    }

    public int[] find(char toFind) {
        int[] pos = new int[2];
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (map[r][c] == toFind) {
                    pos[0] = r; pos[1] = c;
                    return pos;
                }
            }
        }
        return pos; }

    public int[][] findAll(char toFind){
        int[][] ans = new int[totalCarrot][2];
        int i = 0;
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if (map[r][c] == toFind) {
                    ans[i][0] = r;
                    ans[i][1] = c;
                    i++;
                }
            }
        }
        return ans;
    }

    public String printMap() {
        String out = "";
        for (char[] r : map) {
            for (char c : r) {
                out += c;
            }
            out += "\n";
        }
        return out; }
}
