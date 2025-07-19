import java.util.ArrayList;
/**
 * A coffee truck's view
 */
public class TruckView {
	/**
	 * Prints the screen when the truck's type is being set.
	 */
	public void printSetType(){
		AppView.clear();
		System.out.println("Create a brand new coffee truck!");
		System.out.println("What kind of coffee truck would you like to make?");
		System.out.println("");
		System.out.println("P - JavaJeep+ (Not available yet!!!!)");
		System.out.println("R - JavaJeep Regular");
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
	 * Prints the screen when the user is looking at a trucks storage bin inventory,
	 * with the intent of changing its contents. 
	 * @param truck The truck which will have its storage bin altered.
	 */
	public void printSetStorageBins(ArrayList<StorageBin> bins){
		int counter = 1;
		AppView.clear();
		System.out.println("Here are the current contents of your storage bins:");

		for (StorageBin bin : bins){
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
	 * Prints the screen when a storage bin is being edited
	 * @param bin The bin being edited.
	 * @param isEmpty Boolean checking if a bin is empty
	 */
	public void printEditBin(StorageBin bin, boolean isEmpty){
		AppView.clear();
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
	 * Prints the max quantity of each ingredient. 
	 */
	public void printMaxQuantity(){
		AppView.clear();
		System.out.println("Max quantity for all items:");
		System.out.println("Small Cup - 80pcs [enter: 'scup']");
		System.out.println("Medium Cup - 64pcs [enter: 'mcup']");
		System.out.println("Large Cup - 40pcs [enter: 'lcup']");
		System.out.println("Coffee Beans - 1008grams [enter: 'coffee']");
		System.out.println("Milk - 640fl [enter: 'milk']");
		System.out.println("Water - 640fl [enter: 'water']");
	}

	/**
	 * Prints the base info (location, type) of a truck.
	 * @param type The type of the truck to be printed
	 * @param location The location of the truck to be printed
	 */
	public void printTruckBaseInfo(char type, String location){
		System.out.printf("Type: %c || Location: %s\n", type, location);
	}

	/**
	 * Prints the bin info of a truck
	 * @param truck The truck whos bin info is gonna be printed.
	 */
	public void printTruckBinInfo(ArrayList<StorageBin> bins){
		int counter = 1;
		System.out.println("Storage bins contain...");

		for (StorageBin bin : bins) {
			System.out.printf("Storage bin #%d - ", (counter));
			bin.printBinInfo();
			System.out.println();
			counter++;

			AppView.pause();
		}
	}

	/**
	 * Prints the full info of a truck. Transaction, type, location, menu, and bins
	 * @param type The type of the truck
	 * @param location the location of the truck
	 * @param bins the storage bins of the truck
	 * @param transacs The transactions of the truck
	 * @param menu The menu of the truck
	 */
	public void printTruckFullInfo(char type, String location, ArrayList<StorageBin> bins,
			ArrayList<Transaction> transacs, ArrayList<String> menu){
		printTruckBaseInfo(type, location);
		printTruckBinInfo(bins);

		System.out.println("\nMenu: ");
		printMenu(menu);
		
		System.out.println("\nTransactions: ");
		for (Transaction transaction : transacs){
			transaction.printTransaction();
		}
	}

	/**
	 * Prints the contents of the menu
	 * @param menu The menu to be printed
	 */
	public void printMenu(ArrayList<String> menu) {
		System.out.println("AVAILABLE ITEMS:");

		for (String item : menu) {
			System.out.println(item);
		}
		System.out.println();
	}
}