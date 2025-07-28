package Cup;

/**
 * A small cup. Inherits the Cup class.
 */
public class SmallCup extends Cup{
	/** Price for the cup */
	private static float price = 50f;

	/**
	 * Constructor for SmallCup
	 * @param amt The amount of cups in a given drink or bin
	 */
	public SmallCup(float amt){
		super("Small", 8f, 'S', amt);
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