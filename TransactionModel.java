import java.util.ArrayList;
/**
 * Model of a transaction.
 */
public class TransactionModel{
	/** Character representation of drink size. */
	private char drinkSize;
	/** String representation of drink type. */
	private String drinkType;
	/** The total cost of the drink. */
	private float drinkCost;
	/** ArrayList of all ingredients used in the transaction. */
	private ArrayList<Ingredient> ingredients;
	/** Amount of fl in a cup, ignores extra custom ingredients. */
	private float sizeFl;

	/**
	 * Constructor for transaction model. Initalizes ingredients arraylist.
	 */
	public TransactionModel(){
		ingredients = new ArrayList<Ingredient>();
	}

	/**
	 * Sets the drink type
	 * @param type New drink type
	 */
	public void setType(String type){
		this.drinkType = type;
	}

	/**
	 * Sets the drink size 
	 * Also sets the amount of fl there should be and adds cup to ingredients list.
	 * @param size New drink size
	 */
	public void setSize(char size){
		this.drinkSize = size;

		switch(size){
        	case 's': sizeFl = 8; ingredients.add(new Ingredient("scup", 1)); break;
        	case 'm': sizeFl = 12; ingredients.add(new Ingredient("mcup", 1)); break;
        	case 'l': sizeFl = 16; ingredients.add(new Ingredient("lcup", 1)); break;
        	default: sizeFl = 0; break;
        }
	}

	/**
	 * Returns the amount of fl in the cup.
	 * @return amount of fl in the cup.
	 */
	public float getFl(){
		return sizeFl;
	}

	/**
	 * Makes a cafe americano.
	 * Adds the ingredients of a cafe americano into the ingredients list.
	 */
	public void makeAmericano(){
        /* 1/3 espresso, 2/3 water */
    	ingredients.add(new Ingredient("coffee", (float)(sizeFl*(1.0/3.0)*(1.0/19.0) * 28.34952)));
    	ingredients.add(new Ingredient("water", (float)((sizeFl*(1.0/3.0)*(18.0/19.0)) + (sizeFl*(2.0/3.0)))));
	}

	/**
	 * Makes a latte.
	 * Adds the ingredients of a latte into the ingredients list.
	 */
	public void makeLatte(){
		/* 1/5 espresso, 4/5 milk */
		ingredients.add(new Ingredient("coffee", (float)((sizeFl*(1.0/5.0)*(1.0/19.0) * 28.34952))));
		ingredients.add(new Ingredient("water", (float)(sizeFl*(1.0/5.0)*(18.0/19.0))));
		ingredients.add(new Ingredient("milk", (float)(sizeFl*(4.0/5.0))));
	}

	/**
	 * Makes a cappucino.
	 * Adds the ingredients of a cappucino into the ingredients list.
	 */
	public void makeCappucino(){
		/* 1/5 espresso, 4/5 milk */
		ingredients.add(new Ingredient("coffee", (float)(sizeFl*(1.0/3.0)*(1.0/19.0) * 28.34952)));
		ingredients.add(new Ingredient("water", (float)(sizeFl*(1.0/3.0)*(18.0/19.0))));
		ingredients.add(new Ingredient("milk", (float)(sizeFl*2.0/3.0)));
	}

	/**
	 * Calculates the total cost and sets it as its cost variable.
	 * Called at the end of making a drink.
	 */
	public void calculateCost(){
		this.drinkCost = 0;
		for (Ingredient ingr : ingredients){
			this.drinkCost += Ingredient.getPrice(ingr.getType()) * ingr.getAmt();
		}
	}
	
	/**
 	 * Returns the price of the transation.
   	 * @return Price of the transaction
     	 */
	public float getPrice(){
		return drinkCost;
	}

	/**
	 * Returns the list of ingredients used in the transaction.
	 * @return The list of ingredients used in the transaction.
	 */
	public ArrayList<Ingredient> getIngredients(){
		return ingredients;
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
		return drinkSize;
	}
}