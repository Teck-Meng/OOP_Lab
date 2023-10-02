package OOP_Lab;
import java.util.Scanner;

public class Plane {
    private PlaneSeat[] seat;
    //seat ID of 1 to 12 in order
    private int numEmptySeat;
    private final int TOTAL = 12; //const for total no. of seats

    Plane(){
        seat = new PlaneSeat[TOTAL];
        numEmptySeat = TOTAL;
        for(int i = 0;i<TOTAL;i++){
            seat[i] = new PlaneSeat(i+1);
        }
    }

    private PlaneSeat[] sortSeats(){
        PlaneSeat[] returnArray = new PlaneSeat[TOTAL];
            
            for(int i = 0;i<TOTAL;i++){
                returnArray[i] = new PlaneSeat(seat[i].getSeatID());
                if(seat[i].isOccupied()){
                    returnArray[i].assign(seat[i].getCustomerID());
                }
            }
            //clone planeseat array

            //ADD SORTING ALGO HERE
            for(int i = 1;i<TOTAL;i++){
                for(int j = i;j>0;j--){
                    if(returnArray[j].getCustomerID()<returnArray[j-1].getCustomerID()){
                        int a = returnArray[j].getSeatID();
                        int b = returnArray[j].getCustomerID();
                        returnArray[j] = new PlaneSeat(returnArray[j-1].getSeatID());
                        returnArray[j].assign(returnArray[j-1].getCustomerID());
                        returnArray[j-1] = new PlaneSeat(a);
                        returnArray[j-1].assign(b);
                    }
                }
            }
            
        
        return returnArray;
    }

    public void showNumEmptySeats(){
        System.out.println("There are "+numEmptySeat+" empty seats.");
    }

    public void showEmptySeats(){
        System.out.println("The following seats are empty:");
        for(int i = 0;i<TOTAL;i++){
            if(!seat[i].isOccupied()){
                System.out.println("SeatID "+seat[i].getSeatID());
            }
        }
    }

    public void showAssignedSeats(boolean bySeatId){
        System.out.println("The seat assignments are as follow:");
        if(bySeatId){
            for(int i = 0;i<TOTAL;i++){
                if(seat[i].isOccupied()){
                    System.out.println("SeatID "+seat[i].getSeatID()+" assigned to CustomerID "+seat[i].getCustomerID()+".");
                }
            }
        }
        else{
            PlaneSeat[] sortedArray = sortSeats();
            for(int i = 0;i<TOTAL-numEmptySeat;i++){
                    if(sortedArray[i].isOccupied()){
                        System.out.println("SeatID "+sortedArray[i].getSeatID()+" assigned to CustomerID "+sortedArray[i].getCustomerID());
                    }
                
            }
            //clone and print sorted custid array
        }
    }

    public void assignSeat(int seatId, int cust_id){
        if(!seat[seatId-1].isOccupied()){
            seat[seatId-1].assign(cust_id);
            System.out.println("Seat Assigned!");
            numEmptySeat--;
        }
        else{
            System.out.println("Seat already assigned to a customer.");
        }
        
    }

    public void unAssignSeat(int seatId){
        seat[seatId-1].unAssign();
        numEmptySeat++;
    }

    
}
