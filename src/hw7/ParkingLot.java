package hw7;

public class ParkingLot {
    ParkingSpace[] parkingLot;
    int numSpaces;
    int numFloors;

    public ParkingLot(int numSpaces, int numFloors){
        this.numFloors = numFloors;
        this.numSpaces = numSpaces;
        parkingLot = new ParkingSpace[numFloors*numSpaces];
        int s = 0;
        for (int i = 0; i < numFloors; i++){
            for (int j = 0; j < numSpaces;j++){
                if (j < 4) {parkingLot[s] = new ParkingSpace(j, (char)(65 + i), true);}
                else {parkingLot[s] = new ParkingSpace(j, (char)(65 + i), false);}
                s++;
            }
        }
    }


    public ParkingSpace enterLot(boolean iscompact){
        if (iscompact){
            int s = 0;
            for(int i = 0; i < numFloors; i++){
                for(int j = 0; j < 4; j++){
                    if(!parkingLot[s].getOccupied()){
                        parkingLot[s].setOccupied(true);
                        return parkingLot[s];}
                    s++;
                }
                s = s+numSpaces-4;
            }
        }
        else{
            int s = 4;
            for(int i = 0; i < numFloors; i++){
                for(int j = 4; j < numSpaces; j++){
                    if(!parkingLot[s].getOccupied()){
                        parkingLot[s].setOccupied(true);
                        return parkingLot[s];}
                    s++;
                }
                s = s+4;
            }
        }
        System.out.println("Not enough space");
        System.exit(1);
        return parkingLot[0];
    }

    public void leaveLot(ParkingSpace ps){
        int ns = ps.getSpaceNum();
        char fl = ps.getFloor();
        int s = ((int)fl-65)*numSpaces + ns;
        parkingLot[s].setOccupied(false);
    }

    public static void main(String[] args) {
        ParkingLot p = new ParkingLot(5,5);
        p.enterLot(true);
        p.enterLot(false);
        p.enterLot(false);
        p.enterLot(false);
        p.enterLot(false);
        p.enterLot(false);
        p.leaveLot(new ParkingSpace(4,'B',false));
        p.enterLot(false);
        for (int i = 0; i < 25 ; i++){
            System.out.println(p.parkingLot[i].toString());
        }
    }
}
