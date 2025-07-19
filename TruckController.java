import java.util.Scanner;

/**
 * A coffee trucks controller
 */
public class TruckController {
	/** The truck controller's model */
	private TruckModel model;
	/** The truck controller's view */
	private TruckView view;
	/** Scanner for the whole file */
	private Scanner scan = new Scanner(System.in);

	/**
	 * Initializes the model and view of the truck.
	 * Collects user information to add the details for the truck.
	 */
	public TruckController(){
		this.model = new TruckModel();
		this.view = new TruckView();
	}

	/**
	 * Returns the truck's location.
	 * This is necessary for trucks to see if a location has already been taken.
	 * @return Truck's location
	 */
	public String getLocation(){
		return model.getLocation();
	}

	/**
	 * Sets the type of the truck
	 */
	public void setType(){
		String choice;
		boolean success;

		do {
			view.printSetType();
			choice = scan.nextLine();
			success = model.setType(choice);
			if (!success) {view.printFeedback("Invalid input! Press Enter to continue . . .");}
		} while (!success);
	}

	/**
	 * Sets the location of the truck
	 * Assumed that input is valid.
	 * @param inptLocation
	 */
	public void setLocation(String inptLocation){
		model.setLocation(inptLocation);
	}

	/**
	 * Given list of bins, choose a bin to set.
	 */
	public void setBins(){
		boolean inptCheck, success;

		do {
			view.printSetStorageBins(tempTruck);
			choice = scan.nextLine();
			intChoice = model.toInt(choice);

			if (intChoice < 1 || intChoice > model.getNumBins()) inptCheck = false;
			else inptCheck = true;

			if (inptCheck) editStorageBin(tempTruck.getStorageBin(intChoice - 1));
			else if (choice.toUpperCase().equals("END")) success = false;
			else {view.printFeedback("Please check your input..."); scan.nextLine();}
		} while (!success);
	}

		/**
	 * Controls the app when a storage bin is being edited.
	 * @param bin The storage bin being edited.
	 */
	public void editStorageBin(StorageBin bin){
		String choice, choice2; int intChoice; float floatChoice;
		boolean exit = false, success;

		while (!exit){
			view.printEditBin(bin, bin.getContents() == null);
			choice = scan.nextLine();
			intChoice = model.toInt(choice);

			switch(intChoice){
				case 1:
					// setbin
					view.printMaxQuantity();
					view.printFeedback("Type:");
					choice = scan.nextLine();
					view.printFeedback("Amount:");
					choice2 = scan.nextLine();
					floatChoice = model.toFloat(choice2);

					if (floatChoice != -1){
						success = model.setBin(bin, choice, floatChoice);
						if (!success) view.printFeedback("Please check input...");
						else view.printFeedback("Success! Press enter to continue.");
					}
					else view.printFeedback("Please check input...");
					scan.nextLine();
					break;

				case 2:
					// replenish
					view.printFeedback("What is the new quantity of the item?");
					choice = scan.nextLine();
					floatChoice = model.toFloat(choice);

					if (floatChoice >= 0){
						success = model.replenishBin(bin, floatChoice);
						if (!success) view.printFeedback("Can not fit in bin!");
						else view.printFeedback("Successfully replenished!");
					}
					else view.printFeedback("Error in input!");
					scan.nextLine();
					break;

				case 3:
					// empty
					model.emptyBin(bin);
					view.printFeedback("Bin has been emptied!");
					scan.nextLine();
					break;

				case 0:
					// exit
					exit = true;
					break;

				default:
					view.printFeedback("Invalid input!");
					scan.nextLine();
			}
		}
	}
}