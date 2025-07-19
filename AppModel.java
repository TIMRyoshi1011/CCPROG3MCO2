/**
 * Model for the main app interface
 */
public class AppModel {
	/** ArrayList containing all trucks. */
	private final ArrayList<CoffeeTruck> TRUCKS;
	/** The number of trucks made. */
	private int noOfTrucks;

	/**
 	 * Constructor for AppModel. Initializes all variables.
   	 */
	public AppModel(){
		this.TRUCKS = new ArrayList<CoffeeTruck>();
		this.noOfTrucks = 0;
	}

	/**
	 * Checks if a string input is able to be parsed into an int.
	 * @param strInput The string to be parsed.
	 * @return If successful, the int that the string was parsed into. If unsuccessful, -1
	 */
	public int toInt(String strInput){
		int result;

		try {
			result = strInput.parseInt(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}

	/**
	 * Checks if a string input is able to be parsed into a float.
	 * @param strInput The string to be parsed.
	 * @return If successful, the float that the string was parsed into. If unsuccessful, -1
	 */
	public float toFloat(String strInput){
		float result;

		try {
			result = strInput.parseFloat(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}

	/**
	 * Set the type of the truck.
	 * @param truck The truck to have its type be changed.
	 * @param typeInpt The user's input.
	 * @return true if it was successful, false if not.
	 */
	public void setType(CoffeeTruck truck, String typeInpt){
		boolean result;
		result = truck.setType(typeInpt.toUpperCase());
		return result;
	}

	/**
	 * Sets the location of the truck.
	 * @param truck The truck that will have its type be changed.
	 * @param locInpt The location inputted.
	 * @return true if it was successful, false if not.
	 */
	public void setLocation(CoffeeTruck truck, String locInpt){
		boolean result;
		result = truck.setLocation(locInpt, TRUCKS);
		return result;
	}

	/**
	 * Empties a storage bin
	 * @param bin The bin to be emptied.
	 */
	public void emptyBin(){
		bin.emptyBin();
	}

	/**
	 * Replenishes a storage bin
	 * @param bin The bin to be replenished
	 * @param amt The amt that will be added to the bin.
	 * @return true if successful, false otherwise. 
	 */
	public boolean replenishBin(StorageBin bin, float amt){
		boolean result;
		result = bin.replenishBin(amt);
		return result;
	}

	/**
	 * Sets the contents of a storage bin.
	 * @param bin The bin with contents to be changed
	 * @param type The type of the new content
	 * @param amt The amount of the new content
	 * @return true if successful, false otherwise.
	 */
	public boolean setBin(StorageBin bin, String type, float amt){
		boolean result;
		result = bin.setBin(type, amt);
		return result;
	}
}