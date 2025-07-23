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
	public Ingredient (String type, float amt){
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
	 * Reduces the amount of the ingredient
	 * @param amt Amount to be reduced
	 */
	public void reduceAmt(float amt){
		this.amt -= amt;
	}

	/**
	 * Increases the amount of the ingredient
	 * @param amt Amount to be increased
	 */
	public void increaseAmt(float amt){
		this.amt += amt;
	}
}