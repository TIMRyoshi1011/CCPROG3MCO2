import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a coffee truck.
 * @author Coby Luna & Marcus Ramos
 */
public class CoffeeTruck {
	/** Indicates the type of the truck. 'S' for special, 'R' for regular. */
	private char truckType;
	/** Represents the location of the truck. */
	private String truckLocation;
	/** The amount of money the truck earned from transactions. */
	private float moneyEarned = 0;
	/** ArrayList containing all transactions of the truck. */
	private ArrayList<Transaction> TRANSACTIONS;							//changed the names to uppercase (updated the uml)
	/** ArrayList containing all storage bins of the truck. For a regular truck, only 8 bins. */
	private ArrayList<StorageBin> STORAGEBINS;

	/**
 	 * Constructor for a CoffeeTruck. 
   	 * Only initalizes empty variables, variables will be set using different methods in truck creation.
     	 */
	public CoffeeTruck(){
		this.truckLocation = "";
		this.STORAGEBINS = new ArrayList<>();
	        this.TRANSACTIONS = new ArrayList<>();
	
	        for (int i = 0; i < 8; i++) {
	            STORAGEBINS.add(new StorageBin());
	        }
	}

	/**
 	 * Fills a storage bin with new items. 
   	 * @param storageBinIndx The index of the storage bin to be changed in the storageBins array. 0 if bin #1, and so on.
     	 */
	public boolean fillStorageBin(int storageBinIndx, String type, float amt){
		if (storageBinIndx >= 0 && storageBinIndx < STORAGEBINS.size()) {			//changed the inside of if statement to storageBinIndx (was index)
	            return STORAGEBINS.get(storageBinIndx).setBin(type, amt);
	        }
	
	        return false;
	}

	/**
	 * Returns a storage bin given its index.
	 * @param binIndex The index of the storage bin.
	 * @return The storage bin under the given index.
	 */
	public StorageBin getStorageBin(int binIndex){
		return STORAGEBINS.get(binIndex);
	}

	/**
 	 * Set the type of the coffee truck. FINAL, only called once.
   	 * @param type The type of the truck in single character string form. P for JJ+, R for regular.
     	 * @return True if successful, false otherwise.
       	 */
	public boolean setType(String type) {
		/*if (type.equals("P")){
			this.truckType = 'P';						// changed .TRUCK_TYPE to .truckType (still closed the P for now)
			return true; }*/
		if (type.equals("R")){
			this.truckType = 'R';
			return true;
		}
		return false;
	}

	/**
 	 * Sets the location of the truck.
   	 * Additionally, checks if inputted location is in-use by other trucks. (Results in a fail)
   	 * @param location The new location of the truck.
     	 * @param trucks The arraylist of trucks, to check their location.
     	 * @return True if successful, false otherwise. 
       	 */
	public boolean setLocation(String location, ArrayList<CoffeeTruck> trucks) {
		Iterator<CoffeeTruck> it = trucks.iterator();
		boolean avail = true; // true = location is available

		while (it.hasNext() && avail){
			if (it.next().truckLocation.equals(location))
				avail = false; // false = location is not available
		}

		if (avail){
			this.truckLocation = location;}
			
		return avail;
	}

	/**
 	 * Returns the menu of the truck.
   	 * Menu refers to the coffee items and their corresponding cup sizes that can be made considering the inventory in the bins.
     	 * For example, if there is no milk, then Lattes and Cappucinos will not be on the menu.
       	 * If there's only enough milk to make a small latte, then that will also be indicated.
	 * This function calculates and returns a list of Strings that represents all the possible drinks the truck can make.
  	 * @return a String array of all possible drinks the truck can make given inventory.
    	 */
	public ArrayList<String> returnMenu() {
		ArrayList<String> menu = new ArrayList<>();							// added this object (causes an error if there's no object)
		// TODO: Populate the menu based on available inventory in STORAGEBINS
		return menu;
	}

	/**
 	 * Simulates a sale. In simulating, it performs:
   	 * 1. Customer ordering a drink. Display menu. (unsure if this is randomized or user input, will consult with sir)
     	 * 2. Calculate the amount of ingredients for the drink
       	 * 3. Deduce that amount from the respective storage bins.
	 * 4. Create a new transaction variable containing all information, add it to transactions list.
  	 * 5. Print all information.
    	 */
	public void simulateSale() {
		Transaction t = new Transaction("Latte", 'M');
		moneyEarned += t.getPrice();
		TRANSACTIONS.add(t);
	}

	/**
 	 * Prints the info of the truck.
   	 */
	public void printTruckInfo() {
		System.out.println("Truck at: " + truckLocation + " | Earned: " + moneyEarned);
		System.out.println("Storage bins contain...");

		for (int i = 0; i < 8; i++) {
			System.out.printf("Storage bin #%d - ", (i+1));
			STORAGEBINS.get(i).printBinInfo();						// changed storageBins[i] to STORAGEBINS.get(i)
			System.out.println();
		}

		/* Print menu */
		
		/* Print transaction info */
		
	}

	/**
 	 * Called when a truck is initially made to show its basic information, including type, location, and storage bin contents.
   	 */
	public void printBaseInfo() {
		Iterator<StorageBin> it = STORAGEBINS.iterator();
		System.out.printf("Location: %s || Type %s\n", truckLocation, truckType);
		System.out.println();
		System.out.println("Storage bins contain...");

		for (int i = 0; i < 8; i++) {
			System.out.printf("Storage bin #%d - ", (i+1));
			STORAGEBINS.get(i).printBinInfo();							// changed storageBins[i] to STORAGEBINS.get(i)
			System.out.println();
		}
	}
}
