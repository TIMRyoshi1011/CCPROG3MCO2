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
}