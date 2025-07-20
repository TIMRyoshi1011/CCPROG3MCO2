package Cup;

/**
 * A medium cup. Inherits the Cup class.
 */
public class MediumCup extends Cup{
	/** Price for the cup */
	private static float price = 60;

	/**
	 * Constructor for MediumCup
	 */
	public MediumCup(){
		super("Medium", 12, 'M');
	}
}