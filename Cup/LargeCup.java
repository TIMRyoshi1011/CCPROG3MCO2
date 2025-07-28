package Cup;

/**
 * A large cup. Inherits the Cup class.
 */
public class LargeCup extends Cup{
	/** Price for the cup */
	private static float price = 70f;

	/**
	 * Constructor for LargeCup
	 * @param amt The amount of cups in a given drink or bin
	 */
	public LargeCup(float amt){
		super("Large", 16f, 'L', amt);
	}

	/**
	 * Returns the price of the base price of the cup.
	 * @return The price of the cup
	 */
	public static float getPrice(){
		return price;
	}

	/**
	 * Sets the price of the cup.
	 * @param price The new price of the cup
	 */
	public static void setPrice(float p){
		price = p;
	}
}