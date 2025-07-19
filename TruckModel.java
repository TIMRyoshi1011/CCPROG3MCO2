/**
 * A coffee truck's model
 */
public class TruckModel {
	/** Indicates the type of the truck. 'S' for special, 'R' for regular. */
	private char truckType;
	/** Represents the location of the truck. */
	private String truckLocation;
	/** The amount of money the truck earned from transactions. */
	private float moneyEarned = 0;
	/** ArrayList containing all transactions of the truck. */
	private ArrayList<Transaction> TRANSACTIONS;
	/** ArrayList containing all storage bins of the truck. For a regular truck, only 8 bins. */
	private ArrayList<StorageBin> STORAGEBINS;
	/** Number of bins */
	private int numBins;

	/**
	 * Constructor for the truck model. Initializes some variables.
	 * It is assumed that when a truck is created all of its information is not initialized yet.
	 * In the creation process, the truck's information is added gradually.
	 */
	public TruckModel(){
		this.truckLocation = "";
		this.numBins = 0;
		this.STORAGEBINS = new ArrayList<StorageBin>();
        this.TRANSACTIONS = new ArrayList<Transaction>();
	}

	/**
	 * Returns the location of the truck
	 * @return Truck location
	 */
	public String getLocation(){
		return truckLocation;
	}

	/**
	 * Returns the number of bins
	 * @return Number of bins
	 */
	public int getNumBins(){
		return numBins;
	}

	/**
	 * Set the type of the truck and initializes or removes storage bins as needed.
	 * @param typeInpt The user's input.
	 * @return true if it was successful, false if not.
	 */
	public boolean setType(String typeInpt){
		if (type.equals("P")){
			this.truckType = 'P';

			if (numBins == 8) {
				for (int i = 0; i < 2; i++) {
	            STORAGEBINS.add(new StorageBin());
				}
			}
			else if (numBins = 0){
				for (int i = 0; i < 10; i++) {
	            STORAGEBINS.add(new StorageBin());
				}
			}

			return true; }

		if (type.trim().equalsIgnoreCase("R")){
			this.truckType = 'R';

			if (numBins == 10) {
				for (int i = 8; i < 10; i++) {
	            STORAGEBINS.remove(i);
				}
			}
			else if (numBins = 0){
				for (int i = 0; i < 8; i++) {
	            STORAGEBINS.add(new StorageBin());
				}
			}

			return true;
		}
		return false;
	}

	/**
	 * Sets the location of the truck. Assumed input is valid
	 * @param locInput New location
	 */
	public void setLocation(String locInput){
		truckLocation = locInput;
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

	/**
	 * Checks if a string input is able to be parsed into an int.
	 * @param strInput The string to be parsed.
	 * @return If successful, the int that the string was parsed into. If unsuccessful, -1
	 */
	public int toInt(String strInput){
		int result;

		try {
			result = Integer.parseInt(strInput);
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
			result = Float.parseFloat(strInput);
		} catch(NumberFormatException e) {result = -1;}

		return result;
	}
}