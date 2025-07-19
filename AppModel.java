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
	private JavaJeep(){
		this.TRUCKS = new ArrayList<CoffeeTruck>();
		this.noOfTrucks = 0;
	}

	/**
	 * Checks if a string input is able to be parsed into an int.
	 * @param strInput The string to be parsed.
	 * @return If successful, the int that the string was parsed into. If unsuccessful, -1
	 */
	private int toInt(String strInput){
		int result;

		try {
			result = strInput.parseInt(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}
}