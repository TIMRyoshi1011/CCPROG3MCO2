package Ingredient;

/**
 * Class for coffee
 * Inherits the Ingredient abstract class.
 * Mostly used to manage storage
 */
public class Coffee extends Ingredient{
	/** Static variable representing its price 
	 *  Since coffee is used exclusively when making an espresso brew,
	 *  Its price is dependant on the price of the espresso brew, making this
	 *  part useless. */
	private static float price = 0f;

	/**
	 * Constructor for water
	 * @param amt The amount of water in the bin or drink
	 */
	public Coffee (float amt){
		super("Coffee", amt);
	}
}