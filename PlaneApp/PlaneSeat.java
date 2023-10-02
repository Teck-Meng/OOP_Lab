package OOP_Lab.PlaneApp;
public class PlaneSeat{
    private int seatID;
    private boolean assigned = false;
    private int customerID;

    PlaneSeat(int seatID){
        this.seatID = seatID;
        this.customerID = Integer.MAX_VALUE;
        //For sorting in plane class
    }

    public int getSeatID(){
        return this.seatID;
    }

    public int getCustomerID(){
        return this.customerID;
    }

    public boolean isOccupied(){
        return this.assigned;
    }

    public void assign(int customerID){
        this.customerID = customerID;
        this.assigned = true;
    }

    public void unAssign(){
        this.customerID = Integer.MAX_VALUE;
        this.assigned = false;
    }



}
