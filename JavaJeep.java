import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Main class for the JavaJeep program. Contains the main functions.
 * @author Coby Luna & Marcus Ramos
 */
public class JavaJeep{
	/** Singleton instance of JavaJeep. */
	private static JavaJeep javaJeepInstance = new JavaJeep();
	/** ArrayList containing all trucks. */
	private final ArrayList<CoffeeTruck> TRUCKS;
	/** The number of trucks made. */
	private int noOfTrucks;

	/**
 	 * Constructor for JavaJeep. Will only be called once, initializes all variables.
   	 */
	private JavaJeep(){
		TRUCKS = new ArrayList<CoffeeTruck>();
		noOfTrucks = 0;
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
	public void createTruck(){
		String choice, choice2;
		int intChoice = 0;
		float floatChoice;
		boolean success, end, inptCheck;
		CoffeeTruck tempTruck = new CoffeeTruck();
		Scanner scan = new Scanner(System.in);

		/* Setting truck type. */
		do {	
			this.clear();
			
			System.out.println("Create a brand new coffee truck!");
			System.out.println("What kind of coffee truck would you like to make?");
			System.out.println("");
			System.out.println("P - JavaJeep+ (Not available yet!!!!)");
			System.out.println("R - JavaJeep Regular");
			System.out.println("");
			System.out.print(">> ");
			choice = scan.nextLine();

			success = tempTruck.setType(choice.toUpperCase());
			if (!success){
				System.out.print("Invalid input! Press Enter to continue . . .");
				scan.nextLine();
			}
		} while (!success);

		/* Setting truck location. */
		do{	
			this.clear();

			System.out.println("What location do you want your truck to stay in?");
			System.out.println("To keep business efficient, we're limiting it to one truck per city!");
			System.out.println("");
			System.out.print(">> ");
			choice = scan.nextLine();

			success = tempTruck.setLocation(choice, TRUCKS);
			if (!success){
				System.out.println("There's already a truck here! Pick somewhere else!");
				scan.nextLine();
			}
		} while (!success);
		
		end = false;
		/* Setting storage bins. */
		do { 
			this.clear();
			System.out.println("Here are the current contents of your storage bins:");

			for (int i = 0; i < 8; i++){
				System.out.printf("BIN #%d... ", (i+1));
				tempTruck.getStorageBin(i).printBinInfo();					
				System.out.print("\n");
			}

			System.out.println();
			System.out.println("Select a bin to edit, enter END to exit.");
			System.out.print(">> ");
			choice = scan.nextLine();
			System.out.println();

			inptCheck = true; // checking input
			if (choice.toUpperCase().equals("END")) {end = true;}
			else{
				try {
					intChoice = Integer.parseInt(choice);
					if (intChoice < 1 || intChoice > 8){
						inptCheck = false;
					}
						
				} catch (NumberFormatException e) {inptCheck = false;}
			}

			while (inptCheck && !end){
				this.clear();

				System.out.println("Max quantity for all items:");
				System.out.println("Small Cup - 80pcs [enter: 'scup']");
				System.out.println("Medium Cup - 64pcs [enter: 'mcup']");
				System.out.println("Large Cup - 40pcs [enter: 'lcup']");
				System.out.println("Coffee Beans - 1008grams [enter: 'coffee']");
				System.out.println("Milk - 640fl [enter: 'milk']");
				System.out.println("Water - 640fl [enter: 'water']");
				System.out.println();

				System.out.print("Type: ");
				choice = scan.nextLine().toLowerCase();
				System.out.print("Amount: ");
				choice2 = scan.nextLine();
				System.out.println();

				try{
					floatChoice = Float.parseFloat(choice2);
					inptCheck = tempTruck.fillStorageBin((intChoice-1), choice, floatChoice);
					if (inptCheck){
						System.out.print("Success! Press Enter to continue . . .");
						inptCheck = false;
					}
					else {
						System.out.print("Incorrect input, check if type matches the enter keywords and if the amount doesn't exceed max capacity. Press Enter to continue . . .");
					}
					
				} catch (NumberFormatException e){
					System.out.print("Not a valid input! Press Enter to continue . . .");
				}
			
				scan.nextLine();
			}
			
		} while(!end);
		
		/* Setting prices. */
		end = false;
		do { 
			this.clear();
			
			System.out.println("The prices of drinks for all coffee trucks are equal, and is determined by the amount of an ingredient and it's base price, as well as the cup size.\n");
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

			if (choice.toUpperCase().equals("END")) end = true;

			else if (choice.equals("milk") || choice.equals("water") || choice.equals("coffee") ||
				 choice.equals("scup") || choice.equals("mcup") || choice.equals("lcup")) {
				System.out.println("Enter the new price: (THIS IS EFFECTIVE FOR ALL TRUCKS)");
				System.out.print(">> ");
				choice2 = scan.nextLine();
				System.out.println();

				try{
					floatChoice = Float.parseFloat(choice2);
					Ingredient.setPrice(choice, floatChoice);
					System.out.print("Successfully changed! Press Enter to continue . . .");
					scan.nextLine();
					
				} catch (NumberFormatException e){
					System.out.print("Not a valid input! Press Enter to continue . . .");
					scan.nextLine();
				}
			}

			else {System.out.print("Not a valid input! Press Enter to continue . . ."); scan.nextLine();}
		} while (!end);

		this.clear();

		System.out.println("Congratulations! Your truck has successfully been created.");
		System.out.println();
		System.out.println("Below are the base information regarding the new truck:");
		tempTruck.printBaseInfo();
		System.out.println();
		tempTruck.printBinInfo();
		this.TRUCKS.add(tempTruck);
		noOfTrucks++;
		System.out.print("\nPress Enter to continue . . .");
		scan.nextLine();
	}

	/**
	 * Simulates a truck. When choosing to simulate a truck, the user can: 
	 * - Simulate a sale
	 * - View truck informaiton
	 * - Restock bins and perform maintenance.
	 */
	public void simulateTruck(){
		String choice; int intChoice;
		boolean end = false, exitTruck;
		int truckIndx;
		int count;
		Iterator<CoffeeTruck> itTruck;
		Scanner scan = new Scanner(System.in);

		do {
			itTruck = TRUCKS.iterator(); count = 1; truckIndx = -1; exitTruck = true;

			this.clear();

			System.out.println("Choose a truck to simulate!"); 
			while (itTruck.hasNext()){
				System.out.printf("#%d || ", count);
				itTruck.next().printBaseInfo();
				count++;
			}
			System.out.println("Enter \"END\" to exit.");

			System.out.println();
			choice = scan.nextLine();

			try {
				intChoice = Integer.parseInt(choice);

				if (intChoice > 0 && intChoice <= TRUCKS.size()){
					truckIndx = intChoice - 1;
				}

				else {System.out.print("Invalid input! Press Enter to try again."); scan.nextLine();}
			}

			catch (Exception e) {
				if (choice.toUpperCase().equals("END")) {end = true;}
				else {System.out.print("Invalid input! Press Enter to try again."); scan.nextLine();}
			}



			while (truckIndx > -1){

				this.clear();

				System.out.println("What would you like to do?");
				System.out.println("1 - Simulate sale");
				System.out.println("2 - View truck information");
				System.out.println("3 - Manage bins");
				System.out.println("4 - Maintenance");
				System.out.println("5 - Exit");
				System.out.println();

				choice = scan.nextLine();

				try {
					intChoice = Integer.parseInt(choice);

					if (intChoice > 0 && intChoice < 6) {
						switch(intChoice){
							case 1: 
								TRUCKS.get(truckIndx).simulateSale();
								scan.nextLine();
								break;
							case 2:
								clear();
								TRUCKS.get(truckIndx).printTruckInfo();
								// insert menu
								// insert transactions
								break;
							case 3: 
								TRUCKS.get(truckIndx).restockStorageBins();
								break;
							case 4:
								TRUCKS.get(truckIndx).setMaintenance();
								break; 
							case 5:
								truckIndx = -1;
								break;
						}
					}

					else {System.out.println("Invalid input! Please try again."); scan.nextLine(); System.out.println("bfskjdfks");}
				}

				catch (Exception e) {
					System.out.println("Invalid input! Please try again."); scan.nextLine();}

			}

		} while (!end);
	}

	/**
	 * Provides a birds-eye view of all trucks.
	 */
	public void dashboard(){
		float coffee = 0, milk = 0, water = 0, scup = 0, mcup = 0, lcup = 0;
		int americano = 0, latte = 0, cappucino = 0, small = 0, medium = 0, large = 0, sales = 0;
		float combinedSales = 0;
		int numBins, i;
		Ingredient tempIngr;
		Scanner scan = new Scanner(System.in); String choice; int intChoice;
		boolean exit = false;

		do {
			JavaJeep.clear();
			System.out.println("ALL TRUCKS:");

			/* Prints base information of all trucks and their types as well as collects their data. */
			for (CoffeeTruck truck : TRUCKS){
				truck.printBaseInfo();

				if (truck.getType() == 'R') numBins = 8; else numBins = 12;

				/* Gets the amount of ingredients truck contains. */
				for (i = 0; i < numBins; i++){
					tempIngr = truck.getStorageBin(i).getContents();
					if (tempIngr != null){
						switch(tempIngr.getType().toLowerCase()){
							case "milk": milk += tempIngr.getAmt(); break;
							case "water": water += tempIngr.getAmt(); break;
							case "coffee": coffee += tempIngr.getAmt(); break;
							case "scup": scup += tempIngr.getAmt(); break;
							case "mcup": mcup += tempIngr.getAmt(); break;
							case "lcup": lcup += tempIngr.getAmt(); break;
						}
					}
				}

				/* Gets total sales */
				combinedSales += truck.getEarnings();

				/* Gets transaction details. */
				for (Transaction transaction : truck.getTransactions()){
					sales++;

					switch(transaction.getDrinkType().toLowerCase()){
						case "cafe americano": americano ++; break;
						case "latte": latte++; break;
						case "cappucino": cappucino++; break;
					}

					switch(transaction.getDrinkSize()){
						case 's': small++; break;
						case 'm': medium++; break;
						case 'l': large++; break;
					}
				}

			}

			/* Prints aggregate amount of ingredients all trucks have. */
			System.out.println();
			System.out.println();
			System.out.println("Total amount of ingredients in all trucks:");

			JavaJeep.pause();
			System.out.printf("\tCoffee: %.2f grams", coffee);
			JavaJeep.pause();
			System.out.printf("\tWater: %.2f fl", water);
			JavaJeep.pause();
			System.out.printf("\tMilk: %.2f fl\n", milk);
			JavaJeep.pause();
			System.out.printf("\tSmall Cups: %.0f pcs", scup);
			JavaJeep.pause();
			System.out.printf("\tMedium Cups: %.0f pcs", mcup);
			JavaJeep.pause();
			System.out.printf("\tLarge Cups: %.0f pcs", lcup);

			System.out.println();

			/* Aggregate total. */
			System.out.printf("\nTotal amount of earnings: %.2f", combinedSales);
			System.out.println();


			/* Amount of orders for specific types of drinks as well as sizes. */
			System.out.printf("Total amount of orders: %d\n", sales);
			System.out.println("\nOrder types:");

			JavaJeep.pause();
			System.out.printf("\tCafe Americano: %d", americano);
			JavaJeep.pause();
			System.out.printf("\tLatte: %d", latte);
			JavaJeep.pause();
			System.out.printf("\tCappucino: %d", cappucino);

			System.out.println();
			System.out.println("Order sizes:");

			JavaJeep.pause();
			System.out.printf("\tSmall: %d", small);
			JavaJeep.pause();
			System.out.printf("\tMedium: %d", medium);
			JavaJeep.pause();
			System.out.printf("\tLarge: %d", large);

			System.out.println();

			/* Option to view information of specific truck. */
			System.out.println();
			System.out.println("Is there a specific truck you'd like to see information about?");
			System.out.println("Or, enter \"END\" to exit.");

			for (i = 0; i < noOfTrucks; i++){
				System.out.printf("#%d || ", i+1);
				TRUCKS.get(i).printBaseInfo();
			}

			choice = scan.nextLine();

			if (!choice.equalsIgnoreCase("end")){
				try {
					intChoice = Integer.parseInt(choice);

					if (intChoice > 0 && intChoice <= noOfTrucks){
						// print truck info
					}

					else {
						System.out.println("That's an invalid input!");
						scan.nextLine();
					}
				}

				catch (Exception e){
					System.out.println("That's an invalid input!");
					scan.nextLine();
				}
			}

			else {
				exit = true;
			}

		} while (!exit);
	}

	/**
 	 * Main method for the full JavaJeep program.
   	 */
	public static void main(String args[]){
		int choice = 0;
		Scanner scan = new Scanner(System.in);

		while (choice != 4){

			JavaJeep.getInstance().clear();

			System.out.println("Welcome to JavaJeeps!\n");
			System.out.println("Select an Option:");
			System.out.println("1 - Create a coffee truck");
			System.out.println("2 - Simulate a coffee truck");
			System.out.println("3 - Dashboard");
			System.out.println("4 - Exit");
			System.out.println("");
			System.out.print(">> ");
			do {								
				choice = scan.nextInt();   

				if(choice > 4 || choice < 1)
					System.out.print("Invalid option, please try again: ");
				
			} while (choice > 4 || choice < 1);

			switch(choice) {
				case 1: 
					JavaJeep.getInstance().createTruck();
					break;

				case 2: 
					JavaJeep.getInstance().simulateTruck();
					break;   

				case 3: 
					JavaJeep.getInstance().dashboard();
					break;

				case 4:
					System.out.println("Thank you for using JavaJeeps!");
					break;
			}
		}
		scan.close();
		System.exit(0);
	}

	/**
	 * Clears the console, for clarity purposes.
	 */
	public static void clear(){
		try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
	}

	/**
	 * Halts the program for .5 seconds.
	 * Used in printing statements.
	 */
	public static void pause(){		
			try {
			Thread.sleep(500); // Delay for 0.5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

