package Ingredient;

/**
 * Class for milk
 * Inherits the Ingredient abstract class
 */
public class Milk extends Ingredient{
	/** Static variable representing its price */
	private static float price = 2.f;

	/**
	 * Constructor for milk
	 * @param amt The amount of milk in the bin or drink
	 */
	public void Milk (float amt){
		super("Milk", amt);
	}

	/**
	 * Get the price of milk
	 * @return The price of milk
	 */
	public abstract float getPrice(){
		return price;
	}

	/**
	 * Set the price of milk
	 * @param price The new price
	 */
	public abstract void setPrice(float price){
		this.price = price;
	}
}