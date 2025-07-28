package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Cup.*;
import Espresso.*;
/**
 * Abstract for a transaction model.
 * There are different models for different kinds of drinks
 */
public class AbstractTransactionModel{
	/** Character representation of drink size. */
	private char drinkSize;
	/** String representation of drink type. */
	private String drinkType;
	/** The total cost of the drink. */
	protected float drinkCost;

	/** The cup used in the drink */
	protected Cup cup;
	/** The espresso used in the drink */
	protected Espresso espresso;
	/** Arraylist of the additional ingredients used */
	protected ArrayList<Ingredient> ingredients;

	/**
	 * Constructor for transaction model. Initalizes ingredients arraylist.
	 * @param drinkType The type of drink
	 * @param size The size of the drink (in shorthand form)
	 */
	public AbstractTransactionModel(String drinkType, char size){
		this.drinkType = drinkType;
		drinkSize = size;

		switch (size){
			case 'S': cup = new SmallCup(1); break;
			case 'M': cup = new MediumCup(1); break;
			case 'L': cup = new LargeCup(1); break;
			default: cup = new SmallCup(1); break;
		}

		drinkCost = cup.getPrice();
		ingredients = new ArrayList<Ingredient>();
		drinkCost += espresso.getEspresso() * espresso.getPrice();
	}

	/**
	 * Returns the amount of fl in the cup.
	 * @return amount of fl in the cup.
	 */
	public float getFl(){
		return cup.getFl();
	}
	
	/**
 	 * Returns the price of the transation.
   	 * @return Price of the transaction
     	 */
	public float getPrice(){
		return drinkCost;
	}

	/**
	 * Returns the type of drink sold in the transaction.
	 * @return Type of drink sold.
	 */
	public String getDrinkType(){
		return drinkType;
	}

	/**
	 * Returns the size of the drink sold in the transaction.
	 * @return Size of drink sold.
	 */
	public char getDrinkSize(){
		return cup.getShorthand();
	}

	/**
	 * Returns the size of the drink in string format
	 * @return Size of drink in string format
	 */
	public String getStringSize(){
		return cup.getType();
	}

	/**
	 * Returns the list of ingredients used in the transaction.
	 * @return The list of ingredients used in the transaction.
	 */
	public ArrayList<Ingredient> getIngredients(){
		return ingredients;
	}

	/**
	 * Returns the espresso used in the transaction.
	 * @return The espresso used in the transaction.
	 */
	public Espresso getEspresso(){
		return espresso;
	}

	/**
	 * Adds a syrup to the drink
	 * @param syrup Syrup to be added
	 */
	public void addSyrup(ExtraIngr syrup){
		ingredients.add(syrup);
		drinkCost += syrup.getPrice();
	}
}