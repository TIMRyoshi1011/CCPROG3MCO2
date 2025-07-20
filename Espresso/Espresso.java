package Espresso;

/**
 * Abstract class for espressos, the template for different espresso brews.
 */
public abstract class Espresso{
	/** Ratio of water to 1 part coffee */
	private float waterRatio;
	/** Name of espresso brew */
	private String name;
	/** Price of a single espresso shot. Consistent throughout all espresso brews. */
	private static float price = 1.5;

	/** Total fl of espresso (in given drink) */
	private float espresso;
	/** Total g of coffee (in given drink) */
	private float coffee;
	/** Total fl of water (in given drink) */
	private float water;
	/** Number of extra shots */
	private int extraShots;

	/**
	 * Constructor for espresso.
	 * Sets the base information of the brew (ratio and name).
	 */
	public Espresso(float ratio, String name){
		this.waterRatio = ratio;
		this.name = name;
	}

	/**
	 * Brews the espresso.
	 * Sets the values of espresso, coffee, water, and extrashots
	 * @param extraShots Number of extra shots
	 * @param cupFl The amount of fl of espresso the drink should have (ignoring extra shots)
	 */
	public brewEspresso(int extraShots, float cupFl){
		int i;
		espresso = cupFl;
		coffee = cupFl * (1/(waterRatio + 1)) * 28.34952;
		water = cupFl * (waterRatio/(waterRatio + 1));

		this.extraShots = extraShots;
		for (i = 0; i < extraShots; i++){
			coffee += (1/(waterRatio + 1)) * 28.34952;
			water += (waterRatio/(waterRatio + 1));
			espresso += 1;
		}
	}

	/**
	 * Returns the amount of espresso total
	 * @return The amount of espresso
	 */
	public getEspresso(){
		return espresso;
	}

	/**
	 * Returns the amount of coffee total
	 * @return The amount of coffee
	 */
	public getCoffee(){
		return coffee;
	}

	/**
	 * Returns the amount of water total
	 * @return The amount of water
	 */
	public getWater(){
		return water;
	}

	/**
	 * Returns the amount of extra shots total
	 * @return The amount of extra shots
	 */
	public getExtraShots(){
		return extraShots;
	}

	/**
	 * Returns the price of a single shot of an espresso
	 * @return The price of a shot of espresso
	 */
	public static float getPrice(){
		return price;
	}

	/**
	 * Sets the price of a single shot of an espresso
	 * @param price The new espresso price
	 */
	public static void setPrice(float price){
		this.price = price;
	}
}