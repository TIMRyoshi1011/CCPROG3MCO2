import java.util.ArrayList;
import java.util.Scanner;

public class JavaJeep{
	private static JavaJeep javaJeepInstance = new JavaJeep();
	private final ArrayList<CoffeeTrucks> TRUCKS;
	private final ArrayList<Location> LOCATIONS;
	private int noOfTrucks;
	private static float combinedSales;

	private JavaJeep(){
		noOfTrucks = 0;
		combinedSales = 0;
	}

	public static JavaJeep getInstance(){
		if (javaJeepInstance == null) {
            javaJeepInstance = new JavaJeep();  
        }
		return javaJeepInstance;
	}

	public void printTrucksInfo(){

	}

	public boolean createTruck(String location){

	}

	public static void main(String args[]){
		int choice;
	        Scanner scan = new Scanner(System.in);
	
	        System.out.println("\nWelcome to JavaJeeps!\n");
	        System.out.println("Select an Option:");
	        System.out.println("1 - Create Regular Coffee Truck (JavaJeep)");
	        System.out.println("2 - Create Special Coffee Truck (JavaJeep+)");
	        System.out.println("3 - Exit");
	        System.out.print("Enter Option: ");
	
	        do {
	            choice = scan.nextInt();
	
	            if (choice < 1 || choice > 3)
	                System.out.print("Invalid Option, Please Try Again: ");
	
	        } while (choice < 1 || choice > 3);

	        // do {
	            switch(choice) {
	                case 1: 
	                    System.out.println("Regular Coffee Truck (JavaJeep)"); 
	                    // insert codes here
	                    break;
	
	                case 2: 
	                    System.out.println("Special Coffee Truck (JavaJeep+)"); 
	                    break;   
	
	                default:
	                    System.out.println("Thank You for using JavaJeeps!");
	           }
	        // } while (choice != 3);
	
	        scan.close();
	        System.exit(0);
	}
}
