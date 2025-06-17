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
	public Transaction(String type, char size){
		this.drinkType = type;
	        this.drinkSize = size;
	        this.ingredients = new ArrayList<>();
	        //this.drinkCost = insert operations here;
	}

	/**
 	 * Returns the price of the transation.
   	 * @return Price of the transaction
     	 */
	public float getPrice(){
		return drinkCost;
	}

	/**
 	 * Prints all transaction info.
   	 */
	public void printTransaction(){
		System.out.println("Drink: " + drinkType + ", Size: " + drinkSize + ", Cost: " + drinkCost);
	}
}
