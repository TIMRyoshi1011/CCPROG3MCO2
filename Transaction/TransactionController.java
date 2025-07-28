package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Espresso.*;
/**
 * Controller of a transaction.
 */
public class TransactionController{
	/** Model of the transaction */
	private AbstractTransactionModel model;
	/** View of the transaction */
	private TransactionView view;

	/**
 	 * Construction for transaction.
   	 * Upon construction all transaction details are calculated, including ingredient amount and cost.
     	 * @param type The drink type
       	 * @param size The size of the drink.
       	 * @param espresso The brew of the espresso
       	 * @param extraShots The num of extrashots
       	 * @param extraIngr ArrayList of extra syrups 
	 */
	public TransactionController(String type, String size, Espresso espresso, int extraShots,
		ArrayList<ExtraIngr> extraIngr){
		char shorthand = size.toUpperCase().charAt(0);
		view = new TransactionView();

		switch(type.toLowerCase()){
			case "cafe americano":
			case "americano":
				model = new CafeAmericanoModel(shorthand, espresso, extraShots); break;
			case "latte": model = new LatteModel(shorthand, espresso, extraShots); break;
			case "cappucino": model = new CappucinoModel(shorthand, espresso, extraShots); break;
		}

		for (ExtraIngr ingr : extraIngr) model.addSyrup(ingr);
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