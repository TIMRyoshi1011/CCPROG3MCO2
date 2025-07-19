import java.util.ArrayList;
/**
 * Model for the main app interface
 */
public class AppModel {
	/** ArrayList containing all trucks. */
	private final ArrayList<CoffeeTruck> TRUCKS;
	/** The number of trucks made. */
	private int noOfTrucks;

	/**
 	 * Constructor for AppModel. Initializes all variables.
   	 */
	public AppModel(){
		this.TRUCKS = new ArrayList<CoffeeTruck>();
		this.noOfTrucks = 0;
	}

	/**
	 * Checks if a string input is able to be parsed into an int.
	 * @param strInput The string to be parsed.
	 * @return If successful, the int that the string was parsed into. If unsuccessful, -1
	 */
	public int toInt(String strInput){
		int result;

		try {
			result = strInput.parseInt(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}

	/**
	 * Checks if a string input is able to be parsed into a float.
	 * @param strInput The string to be parsed.
	 * @return If successful, the float that the string was parsed into. If unsuccessful, -1
	 */
	public float toFloat(String strInput){
		float result;

		try {
			result = strInput.parseFloat(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}

	/**
	 * Set the type of the truck.
	 * @param truck The truck to have its type be changed.
	 * @param typeInpt The user's input.
	 * @return true if it was successful, false if not.
	 */
	public boolean setType(CoffeeTruck truck, String typeInpt){
		boolean result;
		result = truck.setType(typeInpt.toUpperCase());
		return result;
	}

	/**
	 * Sets the location of the truck.
	 * @param truck The truck that will have its type be changed.
	 * @param locInpt The location inputted.
	 * @return true if it was successful, false if not.
	 */
	public void setLocation(CoffeeTruck truck, String locInpt){
		boolean result;
		result = truck.setLocation(locInpt, TRUCKS);
		return result;
	}

	/**
	 * Empties a storage bin
	 * @param bin The bin to be emptied.
	 */
	public void emptyBin(){
		bin.emptyBin();
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
 	 * Sets the price of the ingredient. Price is static and affects all Ingredient instances. 
   	 * @param type The ingredient type that will have a new price.
     * @param price The new price
     * @return true if successful, false otherwise
	 */
	public boolean setPrice(String type, float price){
		boolean result;
		result = Ingredient.setPrice(type, price);
		return result;
	}

	/**
	 * Adds a truck to the trucks arraylist.
	 * @param truck The truck to be added.
	 */
	public void addTruck(CoffeeTruck truck){
		this.TRUCKS.add(truck);
	}

	/**
	 * Returns the arraylist of trucks.
	 * @return Arraylist of trucks
	 */
	public ArrayList<CoffeeTruck> getTrucks(){
		return TRUCKS;
	}

	/**
	 * Gets the total amount of each ingredient in the TRUCKS array.
	 * @return array consisting of the amount of ingredients in each array. 
	 * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee
	 */
	public float[] getTotalIngredients(){
		float[] totalIngr = new float[6];

		for (CoffeeTruck truck : TRUCKS){
			tempIngr = truck.getStorageBin(i).getContents();
			if (tempIngr != null){
				switch(tempIngr.getType().toLowerCase()){
					case "scup": totalIngr[0] += tempIngr.getAmt(); break;
					case "mcup": totalIngr[1] += tempIngr.getAmt(); break;
					case "lcup": totalIngr[2] += tempIngr.getAmt(); break;
					case "milk": totalIngr[3] += tempIngr.getAmt(); break;
					case "water": totalIngr[4] += tempIngr.getAmt(); break;
					case "coffee": totalIngr[5] += tempIngr.getAmt(); break;
				}
			}
		}

		return totalIngr;
	}

	/**
	 * Returns the total combined amount of sales from each truck.
	 * @return Total combined sales
	 */
	public float getTotalEarnings(){
		float combinedSales;
		for (CoffeeTruck truck : TRUCKS) combinedSales += truck.getEarnings();
		return combinedSales;
	}

	/**
	 * Returns the total amount of sales for every item
	 * @return int arraylist showing total amount of sales for every item
	 * 0 = small, 1 = medium, 2 = large
	 * 3 = cafe americano, 4 = latte, 5 = cappucino
	 */
	public int[] getTotalTransactionTypes(){
		int[] totalTransaction = new int[6];

		for (CoffeeTruck truck : TRUCKS){
			for (Transaction transaction : truck.getTransactions()){
				switch(transaction.getDrinkSize()){
					case 's': totalTransaction[0]++; break;
					case 'm': totalTransaction[1]++; break;
					case 'l': totalTransaction[2]++; break;
				}

				switch(transaction.getDrinkType().toLowerCase()){
					case "cafe americano": totalTransaction[3] ++; break;
					case "latte": totalTransaction[4]++; break;
					case "cappucino": totalTransaction[5]++; break;
				}
			}
		}

		return totalTransaction;
	}

	/**
	 * Returns the total number of trucks
	 * @return Total number of trucks
	 */
	public int getNumTrucks(){
		return noOfTrucks;
	}

	/**
	 * Returns a truck given an index
	 * @param truckIndx the index of the truck to be returned
	 * @return the truck at index truckindx
	 */
	public CoffeeTruck getTruck(int truckIndx){
		return TRUCKS.get(truckIndx);
	}
}