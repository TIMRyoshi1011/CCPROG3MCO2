package Ingredient;

/**
 * Class for water
 * Inherits the Ingredient abstract class
 */
public class Water extends Ingredient{
	/** Static variable representing its price */
	private static float price = .5f;

	/**
	 * Constructor for water
	 * @param amt The amount of water in the bin or drink
	 */
	public Water (float amt){
		super("Water", amt);
	}

	/**
	 * Get the price of water
	 * @return The price of water
	 */
	public static float getPrice(){
		return price;
	}

	/**
	 * Set the price of water
	 * @param price The new price
	 */
	public static void setPrice(float p){
		price = p;
	}
}