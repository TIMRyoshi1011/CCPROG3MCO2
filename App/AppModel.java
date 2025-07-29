package App;

import java.util.ArrayList;
import Truck.*;
import Transaction.*;
import StorageBin.*;
import Ingredient.*;
import Espresso.*;
import Cup.*;

/**
 * Model for the main app interface
 */
public class AppModel {
	/** ArrayList containing all trucks. */
	private final ArrayList<TruckController> TRUCKS;
	/** The number of trucks made. */
	private int noOfTrucks;

	/**
 	 * Constructor for AppModel. Initializes all variables.
   	 */
	public AppModel(){
		this.TRUCKS = new ArrayList<TruckController>();
		this.noOfTrucks = 0;
	}

	/**
	 * Checks if a string input is able to be parsed into an int.
	 * @param strInput The string to be parsed.
	 * @return If successful, the int that the string was parsed into. If unsuccessful, -1
	 */
	public static int toInt(String strInput){
		int result;

		try {
			result = Integer.parseInt(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}

	/**
	 * Checks if a string input is able to be parsed into a float.
	 * @param strInput The string to be parsed.
	 * @return If successful, the float that the string was parsed into. If unsuccessful, -1
	 */
	public static float toFloat(String strInput){
		float result;

		try {
			result = Float.parseFloat(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}

	/**
	 * Returns the arraylist of trucks.
	 * @return Arraylist of trucks
	 */
	public ArrayList<TruckController> getTrucks(){
		return TRUCKS;
	}

	/**
	 * Gets the total amount of each ingredient in the TRUCKS array.
	 * @return array consisting of the amount of ingredients in each array. 
	 * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee
	 */
	public float[] getTotalIngredients(){
		float[] totalIngr = new float[6];
		Ingredient tempIngr;

		for (TruckController truck : TRUCKS){
			for (StorageBin bin : truck.getBins()){
				tempIngr = bin.getContents();
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
		}

		return totalIngr;
	}

	/**
	 * Returns the total combined amount of sales from each truck.
	 * @return Total combined sales
	 */
	public float getTotalEarnings(){
		float combinedSales = 0;
		for (TruckController truck : TRUCKS) combinedSales += truck.getEarnings();
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

		for (TruckController truck : TRUCKS){
			for (TransactionController transaction : truck.getTransactions()){
				switch(transaction.getDrinkSize()){
					case 's': case 'S':totalTransaction[0]++; break;
					case 'm': case 'M': totalTransaction[1]++; break;
					case 'l': case 'L': totalTransaction[2]++; break;
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
	 * Returns a truck given an index.
	 * It is ASSUMED that the truckIndx is a valid index.
	 * @param truckIndx the index of the truck to be returned
	 * @return the truck at index truckindx
	 */
	public TruckController getTruck(int truckIndx){
		return TRUCKS.get(truckIndx);
	}

	/**
	 * Sets the location of the truck.
	 * @param truck The truck that will have its type be changed.
	 * @param locInpt The location inputted.
	 * @return true if it was successful, false if not.
	 */
	public boolean setLocation(TruckController truck, String locInpt){
		boolean avail = true; // true = location is available

		for (TruckController iTruck : TRUCKS){
			if (iTruck.getLocation().equals(locInpt))
				avail = false; // false = location is not available
		}

		if (avail){
			truck.setLocation(locInpt);}
			
		return avail;
	}

	/** 
 	 * Sets the price of the ingredient. Price is static and affects all Ingredient instances. 
   	 * @param type The ingredient type that will have a new price.
     * @param price The new price
     * @return true if successful, false otherwise
	 */
	public boolean setPrice(String type, float price){
		boolean result = true;
		switch (type.toLowerCase()){
			case "espresso": Espresso.setPrice(price); break;
			case "water": Water.setPrice(price); break;
			case "milk": Milk.setPrice(price); break;
			case "extra": ExtraIngr.setPrice(price); break;
			case "scup": SmallCup.setPrice(price); break;
			case "mcup": MediumCup.setPrice(price); break;
			case "lcup": LargeCup.setPrice(price); break;
			default: result = false; break;
		}
		return result;
	}

	/**
	 * Adds a truck to the trucks arraylist.
	 * @param truck The truck to be added.
	 */
	public void addTruck(TruckController truck){
		this.TRUCKS.add(truck);
	}


}