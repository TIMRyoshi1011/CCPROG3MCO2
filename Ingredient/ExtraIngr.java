package Ingredient;

/**
 * Class for user input add-on ingredients like syrups or toppings
 * Inherits the Ingredient abstract class
 */
public class ExtraIngr extends Ingredient{
	/** Static variable representing its price */
	private static float price = 2.f;

	/**
	 * Constructor for water
	 * @param name The name of the new ingredient
	 * @param amt The amount of water in the bin or drink
	 */
	public void ExtraIngr (String name, float amt){
		super(name, amt);
	}

	/**
	 * Get the price of the extra ingredient
	 * @return The price of the extra ingredient
	 */
	public abstract float getPrice(){
		return price;
	}

	/**
	 * Set the price of the extra ingredient
	 * @param price The new price
	 */
	public abstract void setPrice(float price){
		this.price = price;
	}
}