import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the JavaJeep program. Contains the main functions.
 * @author Coby Luna & Marcus Ramos
 */
public class JavaJeep{
	/** Singleton instance of JavaJeep. */
	private static JavaJeep javaJeepInstance = new JavaJeep();
	/** ArrayList containing all trucks. */
	private final ArrayList<CoffeeTrucks> TRUCKS;
	/** The number of trucks made. <--- I dont think this is really that useful anymore lol but keeping it in for now  */
	private int noOfTrucks;
	/** static variable for the combined amount of sales. */
	private static float combinedSales;

	/**
 	 * Constructor for JavaJeep. Will only be called once, initializes all variables.
   	 */
	private JavaJeep(){
		TRUCKS = new ArrayList<>();
		noOfTrucks = 0;
		combinedSales = 0;
	}

	/**
 	 * Method to get the singleton instance of JavaJeep.
   	 * @return singleton instance of JavaJeep.
     	 */
	public static JavaJeep getInstance(){
		if (javaJeepInstance == null) {
            javaJeepInstance = new JavaJeep();  
        }
		return javaJeepInstance;
	}

	/**
  	 * Prints the info of all trucks.
    	 */
	public void printTrucksInfo(){
		for (CoffeeTruck truck : TRUCKS) {
	            truck.printTruckInfo();
	        }
	}

	/**
 	 * Creates a new truck.
   	 * @return True if truck is successfully created, false otherwise.
     	 */
	public boolean createTruck(){
		if (TRUCKS.size() < 10) {
	            TRUCKS.add(new CoffeeTruck("DefaultLocation"));
	            noOfTrucks++;
	            return true;
	        }
		
	        return false;
	}

	/**
 	 * Main method for the full JavaJeep program.
   	 */
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
