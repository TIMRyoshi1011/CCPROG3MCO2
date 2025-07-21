package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Espresso.*;
/**
 * Controller of a transaction.
 */
public class TransactionController{
	/** Model of the transaction */
	AbstractTransactionModel model;
	/** View of the transaction */
	TransactionView view;

	/**
 	 * Construction for transaction.
   	 * Upon construction all transaction details are calculated, including ingredient amount and cost.
     	 * @param type The drink type
       	 * @param size The size of the drink. 
	 */
	public TransactionController(String type, String size){
		char shorthand = size.toUpperCase().charAt(0);
		view = new TransactionView();

		switch(type.toLowerCase()){
			case "cafe americano":
			case "americano":
				model = new CafeAmericanoModel(shorthand); break;
			case "latte": model = new LatteModel(shorthand); break;
			case "cappucino": model = new CappucinoModel(shorthand); break;
		}
	}

	/**
 	 * Returns the price of the transation.
   	 * @return Price of the transaction
     	 */
	public float getPrice(){
		return model.getPrice();
	}

	/**
	 * Returns the list of ingredients used in the transaction.
	 * @return The list of ingredients used in the transaction.
	 */
	public ArrayList<Ingredient> getIngredients(){
		return model.getIngredients();
	}

	/**
	 * Returns the espresso brew used in the transaction.
	 * @return The espresso brew used in the transaction.
	 */
	public Espresso getEspresso(){
		return model.getEspresso();
	}

	/**
	 * Returns the type of drink sold in the transaction.
	 * @return Type of drink sold.
	 */
	public String getDrinkType(){
		return model.getDrinkType();
	}

	/**
	 * Returns the size of the drink sold in the transaction.
	 * @return Size of drink sold.
	 */
	public char getDrinkSize(){
		return model.getDrinkSize();
	}

	/**
 	 * Prints all transaction info.
   	 */
	public void printTransaction(){
		view.printTransaction(model.getDrinkType(), model.getDrinkSize(), model.getPrice());
	}

	/**
	 * Prints the transaction brewing simulation
	 */
	public void printBrew(){
		view.brewDrink(model.getStringSize(), model.getDrinkType(), model.getEspresso().getEspresso(),
			model.getEspresso().getCoffee(), model.getEspresso().getWater(), model.getIngredients());
	}
}