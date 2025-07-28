package Cup;

import Ingredient.*;
/**
 * Abstract class for cups.
 */
public abstract class Cup extends Ingredient{
	/** Amount of fl the cup can hold. */
	private float fl;
	/** A shorthand character for the cup, used in view */
	private char shorthand;

	/**
	 * Constructor for the class.
	 * @param name The name of the cup
	 * @param fl THe amount of fl the cup can hold
	 * @param shorthand The shorthand of the cup
	 * @param price The price of the cup
	 * @param amt The amount of cups in a given storage bin, or drink
	 */
	public Cup(String name, float fl, char shorthand, float amt){
		super(name, amt);
		this.fl = fl;
		this.shorthand = shorthand;
	}

	/**
	 * Returns the amount of fl of the cup.
	 * @return amount of fl of the cup.
	 */
	public float getFl(){
		return fl;
	}

	/**
	 * Returns the shorthand of the cup.
	 * @return shorthand of the cup.
	 */
	public char getShorthand(){
		return shorthand;
	}
}