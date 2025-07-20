package Truck;

import java.util.ArrayList;
import StorageBin.*;
import Ingredient.*;
import Transaction.*;

/**
 * A coffee truck's model
 */
public class TruckModel {
	/** Indicates the type of the truck. 'S' for special, 'R' for regular. */
	private char truckType;
	/** Represents the location of the truck. */
	private String truckLocation;
	/** The amount of money the truck earned from transactions. */
	private float moneyEarned = 0;
	/** ArrayList containing all transactions of the truck. */
	private ArrayList<TransactionController> TRANSACTIONS;
	/** ArrayList containing all storage bins of the truck. For a regular truck, only 8 bins. */
	private ArrayList<StorageBin> STORAGEBINS;
	/** Number of bins */
	private int numBins;

	/**
	 * Constructor for the truck model. Initializes some variables.
	 * It is assumed that when a truck is created all of its information is not initialized yet.
	 * In the creation process, the truck's information is added gradually.
	 */
	public TruckModel(){
		this.truckLocation = "";
		this.numBins = 0;
		this.STORAGEBINS = new ArrayList<StorageBin>();
        this.TRANSACTIONS = new ArrayList<TransactionController>();
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
		return truckType;
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
	 * Set the type of the truck and initializes or removes storage bins as needed.
	 * @param type The user's input.
	 * @return true if it was successful, false if not.
	 */
	public boolean setType(String type){
		if (type.equals("P")){
			this.truckType = 'P';

			if (numBins == 8) {
				numBins = 10;
				for (int i = 0; i < 2; i++) {
	            STORAGEBINS.add(new StorageBin());
				}
			}
			else if (numBins == 0){
				numBins = 10;
				for (int i = 0; i < 10; i++) {
	            STORAGEBINS.add(new StorageBin());
				}
			}

			return true; }

		if (type.trim().equalsIgnoreCase("R")){
			this.truckType = 'R';

			if (numBins == 10) {
				numBins = 8;
				for (int i = 8; i < 10; i++) {
	            STORAGEBINS.remove(i);
				}
			}
			else if (numBins == 0){
				numBins = 8;
				for (int i = 0; i < 8; i++) {
	            STORAGEBINS.add(new StorageBin());
				}
			}

			return true;
		}
		return false;
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
		reduceBins(newT.getIngredients());
		TRANSACTIONS.add(newT);
	}

	/**
	 * Given the details of a drink made using its transaction info,
	 * the storage bin will be edited to deduce the ingredients used to make the drink.
	 * @param ingredientsUsed Arraylist containing the ingredients used in making the drink
	 */
	public void reduceBins(ArrayList<Ingredient> ingredientsUsed){
		float amtLeft;

		for (Ingredient ingr : ingredientsUsed){
			amtLeft = ingr.getAmt();
			for (StorageBin bin : STORAGEBINS){ 
				if (amtLeft > 0 && bin.getContents().getType().equals(ingr.getType())){

					if (bin.getContents().getAmt() < amtLeft){
						bin.lessenContents(bin.getContents().getAmt());
						amtLeft -= bin.getContents().getAmt();
					}

					else{
						bin.lessenContents(amtLeft);
						amtLeft = 0;
					}
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

		/* Not very happy with the efficiency of the code here lols... 
		if u find a better way logic-wise to write this just go ahead */

		ArrayList<String> menu = new ArrayList<String>();
		double milk = 0, coffee = 0, water = 0, scup = 0, mcup = 0, lcup = 0;
		double ratio1, ratio2, ratio3;
		Ingredient tempIngr; String tempStr;

		for (StorageBin bin : STORAGEBINS){
			tempIngr = bin.getContents();

			if (tempIngr != null){	
				switch(tempIngr.getType()){
					case "milk": milk += tempIngr.getAmt(); break;
					case "water": water += tempIngr.getAmt(); break;
					case "coffee": coffee += tempIngr.getAmt(); break;
					case "scup": scup += tempIngr.getAmt(); break;
					case "mcup": mcup += tempIngr.getAmt(); break;
					case "lcup": lcup += tempIngr.getAmt(); break;
				}
			}
		}
		coffee = coffee / 28.34952; /* Converting from grams to fl */


		/* small = 8fl, med = 12fl, large = 16fl */

		/* cafe americano: 1/3 espresso, 2/3 water. */
		tempStr = "Cafe Americano [";
		ratio1 = (1.0/3.0)/(1.0/19.0); // Ratio of coffee
		ratio2 = (1.0/3.0)/(18.0/19.0); // Ratio of water in espresso
		ratio3 = 2.0/3.0; // Ratio of water

		if (coffee >= 8/ratio1 && water >= ((8/ratio2) + (8/ratio3))){
			if (scup > 0) tempStr += " S";

			if (coffee > 12/ratio1 && water >= ((12/ratio2) + (12/ratio3))){
				if (mcup > 0) tempStr += " M";

				if (coffee > 16/ratio1 && water >= ((16/ratio2) + (16/ratio3))){
					if (lcup > 0) tempStr += " L";}
			}

		}

		if (!tempStr.equals("Cafe Americano [")) {tempStr += " ]"; menu.add(tempStr);}

		/* latte: 1/5 espresso, 4/5 milk */
		tempStr = "Latte [";
		ratio1 = (1.0/5.0)/(1.0/19.0); // ratio for coffee
		ratio2 = (1.0/5.0)/(18.0/19.0); // ratio for water
		ratio3 = (4.0/5.0); // ratio for milk

		if (coffee >= 8/ratio1 && water >= 8/ratio2 && milk >= 8/ratio3){
			if (scup > 0) tempStr += " S";

			if (coffee >= 12/ratio1 && water >= 12/ratio2 && milk >= 12/ratio3){
				if (mcup > 0) tempStr += " M";

				if (coffee >= 16/ratio1 && water >= 16/ratio2 && milk >= 16/ratio3){
					if (lcup > 0) tempStr += " L";}
			}
		}

		if (!tempStr.equals("Latte [")) {tempStr += " ]"; menu.add(tempStr);}

		/* cappucino: 1/3 espresso, 2/3 milk */
		tempStr = "Cappucino [";
		ratio1 = (1.0/3.0)/(1.0/19.0); // ratio for coffee
		ratio2 = (1.0/3.0)/(18.0/19.0); // ratio for water
		ratio3 = (2.0/3.0); // ratio for milk

		if (coffee >= 8/ratio1 && water >= 8/ratio2 && milk >= 8/ratio3){
			if (scup > 0) tempStr += " S";

			if (coffee >= 12/ratio1 && water >= 12/ratio2 && milk >= 12/ratio3){
				if (mcup > 0) tempStr += " M";

				if (coffee >= 16/ratio1 && water >= 16/ratio2 && milk >= 16/ratio3){
					if (lcup > 0) tempStr += " L";}
			}
		}

		if (!tempStr.equals("Cappucino [")) {tempStr += " ]"; menu.add(tempStr);}

		return menu;
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