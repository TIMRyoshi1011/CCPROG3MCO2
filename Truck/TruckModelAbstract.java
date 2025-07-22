package Truck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringBuilder;
import StorageBin.*;
import Ingredient.*;
import Transaction.*;

/**
 * A coffee truck's model abstract
 */
public abstract class TruckModelAbstract {
	/** Indicates the type of the truck. 'S' for special, 'R' for regular. */
	private final char TRUCK_TYPE;
	/** Represents the location of the truck. */
	private String truckLocation;
	/** The amount of money the truck earned from transactions. */
	private float moneyEarned = 0;
	/** ArrayList containing all transactions of the truck. */
	private ArrayList<TransactionController> TRANSACTIONS;
	/** ArrayList containing all storage bins of the truck. For a regular truck, only 8 bins. */
	protected ArrayList<StorageBin> STORAGEBINS;
	/** Number of bins */
	protected int numBins;

	/**
	 * Constructor for the truck model. Initializes some variables.
	 * It is assumed that when a truck is created all of its information is not initialized yet.
	 * In the creation process, the truck's information is added gradually.
	 */
	public TruckModelAbstract(char type){
		this.truckLocation = "";
		this.numBins = 0;
		this.STORAGEBINS = new ArrayList<StorageBin>();
        this.TRANSACTIONS = new ArrayList<TransactionController>();
        this.TRUCK_TYPE = type;
	}

	/**
	 * Returns the location of the truck
	 * @return Truck location
	 */
	public String getLocation(){
		return truckLocation;
	}

	/**
	 * Returns the number of bins
	 * @return Number of bins
	 */
	public int getNumBins(){
		return numBins;
	}

	/**
	 * Returns the type of the truck
	 * @return Truck type
	 */
	public char getType(){
		return TRUCK_TYPE;
	}

	/**
	 * Retirms the bin array list
	 * @return Bin array list
	 */
	public ArrayList<StorageBin> getBins(){
		return STORAGEBINS;
	}

	/**
	 * Get a bin given its index
	 * @param binIndx index of bin to be returned
	 * @return Bin under binIndx
	 */
	public StorageBin getBin(int binIndx){
		return STORAGEBINS.get(binIndx);
	}

	/**
	 * Get the total earnings of the truck
	 * @return total earnings
	 */
	public float getEarnings(){
		return moneyEarned;
	}

	/**
	 * Get the arraylist of transactions of the truck
	 * @return Arraylist transactions of truck
	 */
	public ArrayList<TransactionController> getTransactions(){
		return TRANSACTIONS;
	}

	/**
	 * Sets the location of the truck. Assumed input is valid
	 * @param locInput New location
	 */
	public void setLocation(String locInput){
		truckLocation = locInput;
	}

	/**
	 * Sets the contents of a storage bin.
	 * @param bin The bin with contents to be changed
	 * @param type The type of the new content
	 * @param amt The amount of the new content
	 * @return true if successful, false otherwise.
	 */
	public boolean setBin(StorageBin bin, String type, float amt){
		boolean result;
		result = bin.setBin(type, amt);
		return result;
	}

	/**
	 * Processes a new transaction and edits the necessary variables of the truck
	 * following a transaction. This means reducing the contents of its bins according 
	 * to the drink, increasing its money, and adding it to the trucks list of 
	 * transactions.
	 * @param newT The new transaction.
	 */
	public void processTransaction(TransactionController newT){
		moneyEarned += newT.getPrice();
		reduceBins(newT);
		TRANSACTIONS.add(newT);
	}

	/**
	 * Given the details of a drink made using its transaction info,
	 * the storage bin will be edited to deduce the ingredients used to make the drink.
	 * @param t The drink details
	 */
	public void reduceBins(TransactionController t){
		reduce("Coffee", t.getEspresso().getCoffee());
		reduce("Water", t.getEspresso().getWater());

		for (Ingredient ingr : t.getIngredients()){
			reduce(ingr.getType(), ingr.getAmt());
		}

		switch (t.getDrinkSize()){
			case 'S': reduce("Small", 1); break;
			case 'M': reduce("Medium", 1); break;
			case 'L': reduce("Large", 1); break;
		}
	}

	/**
	 * Helper function for reduceBins, given an ingredient and the amount of it to be 
	 * reduced, looks through all storage bins and reduces as needed.
	 * @param type The type of the ingredient
	 * @param amt The amount of the ingredient to be extracted.
	 */
	public void reduce(String type, float amt){
		for (StorageBin bin : STORAGEBINS){ 
			if (amt > 0 && bin.getContents().getType().equals(type)){

				if (bin.getContents().getAmt() < amt){
					bin.lessenContents(bin.getContents().getAmt());
					amt -= bin.getContents().getAmt();
				}

				else{
					bin.lessenContents(amt);
					amt = 0;
				}
			}
		}
	}

	/**
	 * Replenishes a storage bin
	 * @param bin The bin to be replenished
	 * @param amt The amt that will be added to the bin.
	 * @return true if successful, false otherwise. 
	 */
	public boolean replenishBin(StorageBin bin, float amt){
		boolean result;
		result = bin.replenishBin(amt);
		return result;
	}

	/**
	 * Empties a storage bin
	 * @param bin The bin to be emptied.
	 */
	public void emptyBin(StorageBin bin){
		bin.emptyBin();
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
		ArrayList<String> menu = new ArrayList<String>();
		HashMap<String, Float> inventory = getIngrdientAmount();
		AbstractTransactionModel tempDrink;
		boolean isAvail;
		StringBuilder strTemp;

		char[] cupShorthands = {'S', 'M', 'L'};
		String[] drinks = {"Cafe Americano", "Latte", "Cappucino"};
		Class<? extends AbstractTransactionModel>[] drinkTypes = new Class[] {
			CafeAmericanoModel.class,
			LatteModel.class,
			CappuccinoModel.class
		};

		for (int i = 0; i < drinks.length; i++){
			strTemp = new StringBuilder(drink + " [");
			isAvail = false;

			for (char size : cupShorthands){
				tempDrink = drinkTypes[i].getConstructor(char.class).newInstance(size);

				if (hasCup(size, inventory) && areIngredientsAvailable(tempDrink, inventory)){
					strTemp.append(" ").append(size);
					isAvail = true;
				}
			}

			if (isAvail){
				strTemp.append(" ]");
				menu.add(strTemp.toString());
			}
		}

		return menu;
	}

	/**
	 * Given an espresso shot, checks if there is enough for it.
	 * @param espressoType The class of the espresso to be made
	 * @param flAmt The amount of fl the espresso will be
	 * @param waterAmt The amount of water the drink already has that is unrelated to the espresso, if any
	 * @param inventory The amount of each ingredient the truck has
	 * @return true if there is enough, false if not.
	 */
	public boolean isEspressoAvail(Class<? extends Espresso> espressoType, float flAmt, HashMap<String, Flaot> inventory){
		Espresso shot = espressoType.getConstructor().newInstance();

		if (inventory.getOrDefault("Coffee", 0.0f) < shot.getCoffee() ||
			inventory.getOrDefault("Water", 0.0f) < shot.getWater() + waterAmt){
			return false;
		}

		return true;
	}

	/**
	 * Given a drink, checks if the inventory is enough for it.
	 * @param drink The drink object to be checked
	 * @param inventory The hashmap of the inventory
	 * @return true if enough ingredients, false otherwise.
	 */
	public boolean areIngredientsAvailable(AbstractTransactionModel drink, HashMap<String, Float> inventory){
		float amtAvail;

		for (Ingredient ingr : drink.getIngredients()){
			amtAvail = inventory.getOrDefault(ingr.getType(), 0.0f);
			if (amtAvail < ingr.getAmt()) return false;
		}

		if (isEspressoAvail(StandardBrew.class, drink.getEspresso(), inventory)){
			return true;
		}

		return false;
	}

	/**
	 * Checks if a cup is available
	 * @param size The char shorthand of the size
	 * @param inventory The inventory of the truck
	 * @return true if it is available, false if not.
	 */
	public boolean hasCup(char size, Map<String, Float> inventory){
		switch(size){
			case 'S': return inventory.getOrDefault("Small", 0.0f) > 0; 
			case 'M': return inventory.getOrDefault("Medium", 0.0f) > 0; 
			case 'L': return inventory.getOrDefault("Large", 0.0f) > 0; 
			default: return false;
		}
	}

	/**
	 * Returns a hashmap showing the amount of each ingredient in the truck.
	 * The hashmap has a String and a Float. String for the ingredient name and float
	 * for the amount.
	 * @return Hashmap showing the amount of ingredients on the truck.
	 */
	public HashMap<String, Float> getIngrdientAmount(){
		HashMap<String, Float> inventory = new HashMap<String, Float>();
		Ingredient ingr; String type;

		for (StorageBin bin : STORAGEBINS){
			ingr = bin.getContents();
			if (ingr != null){
				type = ingr.getType();
				inventory.put(type, inventory.getOrDefault(type, 0.0f) + ingr.getAmt());
			}
		}

		return inventory;
	}

	/**
	 * Using the menu array from returnMenu(), check if a drink is available.
	 * @param drink The name of the drink (i.e., "Latte")
	 * @param size 1 character string depicting size of drink (i.e., "S", "L")
	 * @return true if drink is available, false otherwise.
	 */
	public boolean isDrinkAvailable(String inptDrink, String inptSize){
		int openBracket, closeBracket;
		String sizes;
		String[] availableSizes;

		for (String item : this.returnMenu()) {
			if (item.toLowerCase().startsWith(inptDrink.toLowerCase())) {
				openBracket = item.indexOf('[');
				closeBracket = item.indexOf(']');

				sizes = item.substring(openBracket + 1, closeBracket).trim();

				availableSizes = sizes.trim().split("\\s+");
				for (String size : availableSizes) {
					if (size.trim().equalsIgnoreCase(inptSize.trim())) {
						return true;}
				}
			}
		}

		return false;
	}
}