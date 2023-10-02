package OOP_Lab;
import java.util.Scanner;
public class PlaneApp {
    public static void main(String[] args){
        int userInput;
        Scanner sc = new Scanner(System.in);
        Plane myPlane = new Plane();
        System.out.println("Welcome to the plane app!");
        do{
            System.out.println("Kindly choose which function you want the plane app to perform from 1 to 7:");
            System.out.println("1: Show number of empty seats");
            System.out.println("2: Show the list of empty seats");
            System.out.println("3: Show the list of seat assignments by seat ID");
            System.out.println("4: Show the list of seat assignments by customer ID");
            System.out.println("5: Assign a customer to a seat");
            System.out.println("6: Remove a seat assignment");
            System.out.println("7: Exit");
            System.out.println("Enter the number of your choice: ");
            userInput = sc.nextInt();

            switch(userInput){
                case 1:
                    myPlane.showNumEmptySeats();
                    //prints out num of empty seats
                    break;
                case 2:
                    myPlane.showEmptySeats();
                    //prints out list of empty seats
                    break;
                case 3:
                    myPlane.showAssignedSeats(true);
                    break;
                case 4:
                    myPlane.showAssignedSeats(false);
                    break;
                case 5:
                    int inputSeatID, inputCustID;
                    System.out.println("Assigning Seat . . .");
                    System.out.print("Please enter SeatID: ");
                    inputSeatID = sc.nextInt();
                    System.out.print("Please enter Customer ID: ");
                    inputCustID = sc.nextInt();
                    myPlane.assignSeat(inputSeatID, inputCustID);
                    //if-else to check valid seat id
                    //insert assignment method here
                    break;
                case 6:
                    int seatIndex;
                    System.out.print("Enter SeatID to unassign customer from: ");
                    seatIndex = sc.nextInt();
                    myPlane.unAssignSeat(seatIndex);
                    System.out.println("Seat Unassigned!");
                    break;
                case 7:
                    System.out.println("Exiting PlaneApp...");
                    break;
                default:
                    System.out.println("Kindly enter a valid numerical choice from 1 to 7!");
            }
        }while(userInput<7);
    }
}
