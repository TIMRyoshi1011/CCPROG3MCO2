package Ingredient;

/**
 * Abstract class for ingredients that are not espressos or cups.
 * This includes water, milk, and any special toppings or syrups the user adds.
 */
public abstract class Ingredient{
	/** The type of ingredient it is (milk, water, etc) */
	private String type;
	/** The amount of the ingredient in use. Used when instantiated in a bin or drink. */
	private float amt;

	/**
	 * Constructor for an ingredient.
	 * @param type The type of ingredient
	 * @param amt The amount of the ingredient
	 */
	public void Ingredient (String type, float amt){
		this.type = type;
		this.amt = amt;
	}

	/**
	 * Get the type of the ingredient
	 * @return The type of the ingredient
	 */
	public String getType(){
		return type;
	}

	/** 
	 * Get the amount of the ingredient present
	 * @return The amount of the ingredient
	 */
	public float getAmt(){
		return amt;
	}

	/**
	 * Get the price of the ingredient
	 * @return The price of the ingredient
	 */
	public abstract float getPrice();

	/**
	 * Set the price of the ingredient
	 * @param price The new price
	 */
	public abstract void setPrice(float price);
}