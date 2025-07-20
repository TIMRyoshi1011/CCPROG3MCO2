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
}