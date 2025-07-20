package Transaction;

import java.util.ArrayList;
import Ingredient.*;
/**
 * Controller of a transaction.
 */
public class TransactionController{
	/** Model of the transaction */
	TransactionModel model;
	/** View of the transaction */
	TransactionView view;

	/**
 	 * Construction for transaction.
   	 * Upon construction all transaction details are calculated, including ingredient amount and cost.
     	 * @param type The drink type
       	 * @param size The size of the drink. 
	 */
	public TransactionController(String type, String size){
		model = new TransactionModel();
		view = new TransactionView();

		model.setType(type);
		model.setSize(size.toLowerCase().charAt(0));

		switch(type.toLowerCase()){
			case "cafe americano": model.makeAmericano(); break;
			case "latte": model.makeLatte(); break;
			case "cappucino": model.makeCappucino(); break;
		}

		model.calculateCost();
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
		String size;
		float sizeFl = model.getFl();

		switch(model.getDrinkSize()){
			case 'S': size = "Small"; break;
			case 'M': size = "Medium"; break;
			case 'L': size = "Large"; break;
			default: size = ""; break;
		}

		switch(model.getDrinkType().toLowerCase()){
			case "cafe americano": 
				view.brewAmericano(size, (float)(sizeFl*(1.0/3.0)), 
				model.getIngredients().get(1).getAmt(), (float)(sizeFl/((1.0/3.0)/(18.0/19.0))),
				(float)(sizeFl/(2.0/3.0))); 
				break;

			case "latte":
				view.brewLatte(size, (float)(sizeFl*(1.0/5.0)), model.getIngredients().get(1).getAmt(),
				model.getIngredients().get(2).getAmt(), model.getIngredients().get(3).getAmt());
				break;

			case "cappucino":
				view.brewCappucino(size, (float)(sizeFl*(1.0/3.0)), model.getIngredients().get(1).getAmt(),
					model.getIngredients().get(2).getAmt(), model.getIngredients().get(3).getAmt());
				break;
		}
	}
}