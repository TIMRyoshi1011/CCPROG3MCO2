package Cup;

/**
 * Abstract class for cups.
 */
public abstract class Cup{
	/** Name of the cup */
	private String name;
	/** Amount of fl the cup can hold. */
	private float fl;
	/** A shorthand character for the cup, used in view */
	private char shorthand;

	/**
	 * Constructor for the class.
	 */
	public Cup(String name, float fl, char shorthand){
		this.name = name;
		this.fl = fl;
		this.shorthand = shorthand;
	}

	/**
	 * Returns the name of the cup.
	 * @return name of the cup.
	 */
	public String getName(){
		return name;
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