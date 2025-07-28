package Cup;

/**
 * A medium cup. Inherits the Cup class.
 */
public class MediumCup extends Cup{
	/** Price for the cup */
	private static float price = 60f;

	/**
	 * Constructor for MediumCup
	 * @param amt The amount of cups in a given drink or bin
	 */
	public MediumCup(float amt){
		super("Medium", 12f, 'M', amt);
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