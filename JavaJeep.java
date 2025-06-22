import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Integer;			// we don't need this, causes an error 
//import java.util.Float;			// we don't need this, causes an error
import java.util.Iterator;

/**
 * Main class for the JavaJeep program. Contains the main functions.
 * @author Coby Luna & Marcus Ramos
 */
public class JavaJeep{
	/** Singleton instance of JavaJeep. */
	private static JavaJeep javaJeepInstance = new JavaJeep();
	/** ArrayList containing all trucks. */
	private final ArrayList<CoffeeTruck> TRUCKS;								//changed CoffeeTrucks to CoffeeTruck
	/** The number of trucks made. <--- I dont think this is really that useful anymore lol but keeping it in for now  */
	private int noOfTrucks;
	/** static variable for the combined amount of sales. */
	private static float combinedSales;

	/**
 	 * Constructor for JavaJeep. Will only be called once, initializes all variables.
   	 */
	private JavaJeep(){
		TRUCKS = new ArrayList<CoffeeTruck>();
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
	public void createTruck(){							//changed boolean to void (doesn't really return anything) (also changed uml)
		String choice, choice2;
		int intChoice = 0;							//added an instance of 0
		float floatChoice;
		boolean success, end, inptCheck;
		CoffeeTruck tempTruck = new CoffeeTruck();
		Scanner scan = new Scanner(System.in);

		do {	// Setting the truck type.
			/* Clear screen ansi. Should probs turn to method. */
			System.out.print("\033[H\033[2J");
    			System.out.flush();
			
			System.out.println("Create a brand new coffee truck!");
			System.out.println("What kind of coffee truck would you like to make?");
			System.out.println("");
			System.out.println("P - JavaJeep+ (Not available yet!!!!)");
			System.out.println("R - JavaJeep Regular");
			System.out.println("");
			System.out.print(">> ");							//changed println to print only
			choice = scan.nextLine();

			success = tempTruck.setType(choice);
			if (!success){
				System.out.println("Invalid input!");
				scan.nextLine();
			}
		} while (!success);

		do{	// Sets location
			/* Clear screen ansi. Should probs turn to method. */
			System.out.print("\033[H\033[2J");
				System.out.flush();

			System.out.println("What location do you want your truck to stay in?");
			System.out.println("To keep business efficient, we're limiting it to one truck per city!");
			System.out.println("");
			System.out.print(">> ");									//changed println to print only
			choice = scan.nextLine();

			success = tempTruck.setLocation(choice, TRUCKS);
			if (!success){
				System.out.println("There's already a truck here! Pick somewhere else!");
				scan.nextLine();
			}
		} while (!success);
		
		end = false; 												// Set end to false before use
		do { // Assigning storage bins
			/* Clear screen ansi. Should probs turn to method. */
			System.out.print("\033[H\033[2J");
				System.out.flush();

			//it = tempTruck.getStorageBin();								// commented this out for now (causes error)
			System.out.println("Here are the current contents of your storage bins:");

			for (int i = 0; i < 8; i++){
				System.out.printf("BIN #%d... ", (i+1));
				//tempTruck.getStorageBin(i).printBinInfo();						// also commented this out for now (causes error)
				System.out.print("\n");
			}

			System.out.println();
			System.out.println("Select a bin to edit, enter END to exit.");
			System.out.print(">> ");
			choice = scan.nextLine();
			System.out.println();

			inptCheck = true; // checking input
			if (choice.equals("END")) {end = true;}							//removed : and added { }
			else{
				try {
					intChoice = Integer.parseInt(choice);
					if (intChoice < 1 || intChoice > 8){
						inptCheck = false;
					}
						
				} catch (NumberFormatException e) {inptCheck = false;}				//added { }
			}

			while (inptCheck && !end){
				/* Clear screen ansi. Should probs turn to method. */
				System.out.print("\033[H\033[2J");
	    			System.out.flush();

				System.out.println("Max quantity for all items:");
				System.out.println("Small Cup - 80pcs [enter: 'scup']");
				System.out.println("Medium Cup - 64pcs [enter: 'mcup']");
				System.out.println("Large Cup - 40pcs [enter: 'lcup']");
				System.out.println("Coffee Beans - 1008grams [enter: 'coffee']");
				System.out.println("Milk - 640fl [enter: 'milk']");
				System.out.println("Water - 640fl [enter: 'water']");
				System.out.println();

				System.out.print("Type: ");
				choice = scan.nextLine();
				System.out.print("Amount: ");								//removed , before Amount
				choice2 = scan.nextLine();
				System.out.println();

				try{
					floatChoice = Float.parseFloat(choice2);
					inptCheck = tempTruck.fillStorageBin(intChoice, choice, floatChoice);
					if (inptCheck){
						System.out.println("Success!");
						inptCheck = false;
					}
					else {
						System.out.println("Incorrect input, check if type matches the enter keywords and if the amount doesn't exceed max capacity.");
					}
					
				} catch (NumberFormatException e){
					System.out.println("Not a valid input!");
				}
			
				scan.nextLine();
			}
			
		} while(!end);
		
		do { // edit prices
			/* Clear screen ansi. Should probs turn to method. */
			System.out.print("\033[H\033[2J");
			System.out.flush();
			
			System.out.println("The prices of drinks for all coffee trucks are equal, and is determined by the amount of an ingredient and it's base price, as well as the cup size.");
			System.out.println("Below are the current prices for each ingredient:");
			System.out.printf("1 gram coffee bean: %.2f\n", Ingredient.getPrice("coffee"));
			System.out.printf("1fl of milk: %.2f\n", Ingredient.getPrice("milk"));
			System.out.printf("1fl of water: %.2f\n", Ingredient.getPrice("water"));
			System.out.printf("Small cup base price: %.2f\n", Ingredient.getPrice("scup"));
			System.out.printf("Medium cup base price: %.2f\n", Ingredient.getPrice("mcup"));
			System.out.printf("Large cup base price: %.2f\n", Ingredient.getPrice("lcup"));
			System.out.println();

			System.out.println("Enter an ingredient who's price you'd like to change ['water','milk','coffee','scup','mcup','lcup']. If you'd like to exit, enter END.");
			System.out.print(">> ");
			choice = scan.nextLine();
			System.out.println();

			if (choice.equals("END")) end = true;

			else if (choice.equals("milk") || choice.equals("water") || choice.equals("coffee") ||
				 choice.equals("scup") || choice.equals("mcup") || choice.equals("lcup")) {
				System.out.println("Enter the new price: (THIS IS EFFECTIVE FOR ALL TRUCKS)");
				System.out.print(">> ");
				choice2 = scan.nextLine();
				System.out.println();

				try{
					floatChoice = Float.parseFloat(choice2);
					Ingredient.setPrice(choice, floatChoice);				//capitalized C in floatchoice
					System.out.println("Successfully changed!");
					scan.nextLine();
					
				} catch (NumberFormatException e){
					System.out.println("Not a valid input!");
					scan.nextLine();
				}
			}

			else {System.out.println("Not a valid input!"); scan.nextLine();}
		} while (!end);

		/* Clear screen ansi. Should probs turn to method. */
		System.out.print("\033[H\033[2J");
		System.out.flush();

		System.out.println("Congratulations! Your truck has successfully been created.");
		System.out.println();
		System.out.println("Below are the base information regarding the new truck:");
		tempTruck.printBaseInfo();
		TRUCKS.add(tempTruck);
		scan.nextLine();
	}

	/**
 	 * Main method for the full JavaJeep program.
   	 */
	public static void main(String args[]){
		int choice;
		Scanner scan = new Scanner(System.in);

		System.out.println("\nWelcome to JavaJeeps!\n");
		System.out.println("Select an Option:");
		System.out.println("1 - Create a coffee truck");
		System.out.println("2 - Simulate a coffee truck");
		System.out.println("3 - Dashboard");
		System.out.println("4 - Exit");
		System.out.println("");
		System.out.print(">> ");
		do {										// changed the logic here (initailly was causing an infinite loop)
			choice = scan.nextInt();

			if(choice > 4 || choice < 1)
				System.out.print("Invalid option, please try again: ");
			
		} while (choice > 4 || choice < 1);

		JavaJeep newTruck = new JavaJeep();

		switch(choice) {
			case 1: 
				System.out.println("Creating coffee truck!"); 
				newTruck.createTruck();
				break;

			case 2: 
				System.out.println("Choose a truck to simulate!"); 
				break;   

			case 3: 
				System.out.println("Dashboard");
				break;

			case 4:
				System.out.println("Thank you for using JavaJeeps!");
				break;
		}
		scan.close();
		System.exit(0);
	}
}

