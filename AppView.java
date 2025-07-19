/**
 * View for the main app interface
 */
public class AppView {

	/* SUGGESTION: since lots of the programs parts concerns choosing an option from a set of lists, 
				   there could be a general option that prints a list of choices given the number
				   of choices and the labels of each choice. Unsure how to work around this with 
				   button inputs though, but will think about it when we reach the GUI implementation
				   stage. */

	/**
  	 * Prints the info of all trucks.
    	 */
	public void printTrucksInfo(ArrayList<CoffeeTruck> TRUCKS TRUCKS){
		for (CoffeeTruck truck : TRUCKS) {
	            truck.printTruckInfo();
	        }
	}

	/**
	 * Prints the main menu of the app.
	 */
	public void printMain(){
		clear();
		System.out.println("Welcome to JavaJeeps!\n");
		System.out.println("Select an Option:");
		System.out.println("1 - Create a coffee truck");
		System.out.println("2 - Simulate a coffee truck");
		System.out.println("3 - Dashboard");
		System.out.println("4 - Exit");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints a feedback label
	 */
	public void printFeedback(String feedback){
		System.out.println(feedback);
	}

	/**
	 * Prints the screen when the truck's type is being set.
	 */
	public void printSetType(){
		clear();
		System.out.println("Create a brand new coffee truck!");
		System.out.println("What kind of coffee truck would you like to make?");
		System.out.println("");
		System.out.println("P - JavaJeep+ (Not available yet!!!!)");
		System.out.println("R - JavaJeep Regular");
		System.out.println("");
		System.out.print(">> ");
		choice = scan.nextLine();
	}

	/**
	 * Prints the screen when the type's location is being set.
	 */
	public void printSetLocation(){
		clear();
		System.out.println("What location do you want your truck to stay in?");
		System.out.println("To keep business efficient, we're limiting it to one truck per city!");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints the screen when the user is looking at a trucks storage bin inventory,
	 * with the intent of changing its contents. 
	 * @param truck The truck which will have its storage bin altered.
	 */
	public void printSetStorageBins(CoffeeTruck truck){
		int counter = 1
		System.out.println("Here are the current contents of your storage bins:");

		for (StorageBin bin : truck.getStorageBins()){
			System.out.printf("BIN #%d... ", (counter));
			bin.printBinInfo();					
			System.out.print("\n");
			counter++;
		}

		System.out.println();
		System.out.println("Select a bin to edit, enter END to exit.");
		System.out.print(">> ");
	}

	/**
	 * Prints the max quantity of each ingredient. 
	 */
	public void printMaxQuantity(){
		clear();
		System.out.println("Max quantity for all items:");
		System.out.println("Small Cup - 80pcs [enter: 'scup']");
		System.out.println("Medium Cup - 64pcs [enter: 'mcup']");
		System.out.println("Large Cup - 40pcs [enter: 'lcup']");
		System.out.println("Coffee Beans - 1008grams [enter: 'coffee']");
		System.out.println("Milk - 640fl [enter: 'milk']");
		System.out.println("Water - 640fl [enter: 'water']");
	}

	/**
	 * Prints the screen when a storage bin is being edited
	 * @param bin The bin being edited.
	 * @param isEmpty Boolean checking if a bin is empty
	 */
	public void printEditBin(StorageBin bin, boolean isEmpty){
		bin.printBinInfo();
		System.out.println();
		System.out.println("1 - Set bin contents");
		if (!isEmpty){
			System.out.println("2 - Replenish bin contents");
			System.out.println("3 - Empty bin contents");
		}
		System.out.println("0 - Exit");
	}

	/**
	 * Prints the screen when the user is setting the prices.
	 */
	public void printSetPrice(){
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
	}

	/**
	 * Prints the base info (location, type) of a truck.
	 * @param truck The truck whos info is gonna be printed.
	 */
	public void printTruckBaseInfo(CoffeeTruck truck){
		System.out.printf("Type: %s || Location: %s\n", truck.getType(), truck.getLocation());
	}

	/**
	 * Prints the bin info of a truck
	 * @param truck The truck whos bin info is gonna be printed.
	 */
	public void printTruckBinInfo(CoffeeTruck truck){
		int counter = 1;
		System.out.println("Storage bins contain...");

		for (StorageBin bin : truck.getStorageBins()) {
			System.out.printf("Storage bin #%d - ", (counter));
			bin.printBinInfo();
			System.out.println();
			counter++;

			pause();
		}
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

	/**
	 * Prints the screen allowing the user to pick a truck to simulate
	 * @param trucks Arraylist of trucks to print
	 */
	public void printTruckOptions(ArrayList<CoffeeTruck> trucks){
		int count = 1;

		clear();

		System.out.println("Choose a truck to simulate!"); 
		while (CoffeeTruck truck : trucks){
			System.out.printf("#%d || ", count);
			truck.printBaseInfo();
			count++;
		}
		System.out.println("Enter \"END\" to exit.");
	}

	/**
	 * Prints the options the user can pick from when simulating a truck.
	 */
	public void printSimulateOptions(){
		clear();

		System.out.println("What would you like to do?");
		System.out.println("1 - Simulate sale");
		System.out.println("2 - View truck information");
		System.out.println("3 - Manage bins");
		System.out.println("4 - Maintenance");
		System.out.println("5 - Exit");
		System.out.println();
	}
}