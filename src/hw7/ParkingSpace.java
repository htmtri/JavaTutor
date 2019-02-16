package hw7;

public class ParkingSpace {
    int spaceNum;
    char floor;
    boolean isCompact;
    boolean isOccupied;

    public ParkingSpace(int spaceNum,char floor,boolean isCompact){
        this.spaceNum = spaceNum;
        this.floor = floor;
        this.isCompact = isCompact;
        isOccupied = false;
    }

    public int getSpaceNum(){
        return spaceNum;
    }

    public char getFloor(){
        return floor;
    }

    public boolean getCompact(){
        return isCompact;
    }

    public boolean getOccupied(){
        return isOccupied;
    }

    public void setOccupied(boolean occupied){
        isOccupied = occupied;
    }

    public String toString(){
        String ans = "";
        ans = ans + floor + String.valueOf(spaceNum);
        if (isCompact){ans += " (C";}
        else {ans += " (N";}
        if (isOccupied){ans += " X)";}
        else {ans += " O)";}
        return ans;
    }

    /*public static void main(String[] args) {
        //ParkingSpace newSpace = new ParkingSpace(7,'C',true);
        //System.out.println(newSpace.toString());
    }*/
}
