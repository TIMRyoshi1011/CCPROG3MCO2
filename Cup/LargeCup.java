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
}