import java.util.ArrayList;

/**
 * Represents a transaction.
 * A list of all transactions is recorded in all coffee trucks.
 * Records the type, ingredients used, and cost of a transation.
 * @author Coby Luna & Marcus Ramos
 */
public class Transaction{
	/** Character representation of drink size. */
	private char drinkSize;
	/** String representation of drink type. */
	private String drinkType;
	/** The total cost of the drink. */
	private float drinkCost;
	/** ArrayList of all ingredients used in the transaction. */
	private ArrayList<Ingredient> ingredients;

	/**
 	 * Construction for transaction.
   	 * Upon construction all transaction details are calculated, including ingredient amount and cost.
     	 * @param type The drink type
       	 * @param size The size of the drink. 
	 */
	public Transactions(String type, char size){

	}

	/**
 	 * Returns the price of the transation.
   	 * @return Price of the transaction
     	 */
	public float getPrice(){
		return 0;
	}

	/**
 	 * Prints all transaction info.
   	 */
	public void printTransaction(){
		
	}
}
