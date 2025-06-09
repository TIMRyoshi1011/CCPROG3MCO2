/**
 * Represents a location and contains all details regarding the different locations.
 * @author Jacoba Luna & Marcus Ramos
 */
public class Location{

	/** Final string representing the name of the location. */
	private final String NAME;
	/** Final string representing the drink that customers of this location are
	 * more likely to order. */
	private final String FAVORED_DRINK;
	/** Final string representing the drink that customers of this location are
	 * less likely to order. */
	private final String DISLIKED_DRINK;
	/** Int representing whether or not there is an active coffeetruck in the location.
	 * -1 means that there are none.
	 * Integer values that are not -1 represent the index no. of the truck that resides 
	 * in the location.*/
	private int truck = -1;



	/**
	 * Constructor method, sets the final values for the location's name, favorite,
	 * and dislike.
	 * @param name Name of the location.
	 * @param favorite Drink the location is most likely to order.
	 * @param dislike Drink the location is least likely to order.
	 */
	public Location(String name, String favorite, String dislike){
		// blah
	}

	/**
	 * Sets a truck to start residing in the location.
	 * @return false if there is already a truck in the location. true if none.
	 */
	public boolean setTruck(int indx){
		return false;
	}

	/**
	 * Removes a truck from the location.
	 */
	public void removeTruck(){
		// blah
	}

	/**
	 * Returns the drink that the location is most likely to order.
	 * @return String representing favorite drink.
	 */
	public String getFavorite(){
		return "blah";
	}

	/**
	 * Returns the drink the location is least likely to order.
	 * @return String representing the disliked drink.
	 */
	public String getDislike(){
		return "blah";
	}
}