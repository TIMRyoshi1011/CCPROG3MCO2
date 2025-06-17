/**
 * Represents a storage bin.
 * 8 of these are intialized in a standard coffee truck.
 * @author Coby Luna & Marcus Ramos
 */
public class StorageBin{
	/** The ingredient contents of the storage bin. */
	private Ingredient contents;

	/**
 	 * Constructor for the storage bin.
   	 * A list of storage bins are automatically created when a truck is made, and this is the only time a storage bin is made.
	 * Following this, all storage bins are automatically initiated empty.
  	 */
	public StorageBin(){
	
	}

	/**
 	 * This completely changes, or sets (if it is empty) a storage bin's contents with a new item.
   	 * @param type The type of item the storage bin will hold.
     	 * @param amt The amount of the item the storage bin will hold.
       	 * @return true if bin's contents was successfully set. False otherwise.
	 */
	public boolean setBin(String type, float amt){

	}

	/**
 	 * This replenishes the bin, AKA adds more of the item already in the bin.
   	 * @param amt The amount that will be replenished.
     	 * @return True if successfully replenished, false otherwise. Fails either because bin is empty or the max capacity is reached.
       	 */
	public boolean replenishBin(float amt){

	}

	/**
 	 * This removes all contents of the bin and makes it empty.
   	 */
	public void emptyBin(){

	}

	/**
 	 * Decreases the quantity of items in the bin.
   	 * This is ONLY called when an order is made, and the required amount of ingredients for the drink is taken from the bin.
     	 * The inventory of the truck is already considered in making the menu, and as such, it is assumed that this will always be a successful method.
       	 * @param amt The amount to be decreased from the bin.
	 */
	public void lessenContents(float amt){
	
	}

	/**
 	 * Prints the info of the bin.
   	 * This includes the amount of items in the bin and the type of items in the bin.
     	 */
	public void printBinInfo(){

	}
}
