package Cup;

/**
 * A small cup. Inherits the Cup class.
 */
public class SmallCup extends Cup{
	/** Price for the cup */
	private static float price = 50;

	/**
	 * Constructor for SmallCup
	 */
	public SmallCup(){
		super("Small", 8, 'S');
	}
}