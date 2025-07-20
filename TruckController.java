import java.util.Scanner;
import java.util.ArrayList;

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
	 * Get the storage bins of a truck
	 * @return arraylist of storagebins
	 */
	public ArrayList<StorageBin> getBins(){
		return model.getBins();
	}

	/**
	 * Get the total earnings of the truck
	 * @return total earnings
	 */
	public float getEarnings(){
		return model.getEarnings();
	}

	/**
	 * Get the arraylist of transactions of the truck
	 * @return Arraylist transactions of truck
	 */
	public ArrayList<Transaction> getTransactions(){
		return model.getTransactions();
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
		boolean inptCheck, success = false;
		String choice; int intChoice;

		do {
			view.printSetStorageBins(model.getBins());
			choice = scan.nextLine();
			intChoice = AppModel.toInt(choice);

			System.out.println(model.getNumBins());
			if (intChoice < 1 || intChoice > model.getNumBins()) inptCheck = false;
			else inptCheck = true;

			if (choice.toUpperCase().equals("END")) success = true;
			else if (inptCheck) editStorageBin(model.getBin(intChoice));
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
			intChoice = AppModel.toInt(choice);

			switch(intChoice){
				case 1:
					// setbin
					view.printMaxQuantity();
					view.printFeedback("Type:");
					choice = scan.nextLine();
					view.printFeedback("Amount:");
					choice2 = scan.nextLine();
					floatChoice = AppModel.toFloat(choice2);

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
					floatChoice = AppModel.toFloat(choice);

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

	/**
	 * Prints the base info (location, type) of a truck.
	 * @param truck The truck whos info is gonna be printed.
	 */
	public void truckBaseInfo(){
		view.printTruckBaseInfo(model.getType(), model.getLocation());
	}

	/**
	 * Prints the bin info of a truck
	 * @param truck The truck whos bin info is gonna be printed.
	 */
	public void truckBinInfo(){
		view.printTruckBinInfo(model.getBins());
	}

	/**
	 * Prints the full info of a truck. Transaction, type, location, menu, and bins
	 * @param truck The truck whos information is gonna be printed
	 */
	public void truckFullInfo(){
		view.printTruckBaseInfo(model.getType(), model.getLocation());
		view.printTruckBinInfo(model.getBins());

		System.out.println("\nMenu: ");
		view.printMenu(model.returnMenu());
		
		System.out.println("\nTransactions: ");
		for (Transaction transaction : model.getTransactions()){
			transaction.printTransaction();
		}
	}

	/**
 	 * Simulates a sale. In simulating, it performs:
   	 * 1. Customer ordering a drink. Display menu.
     	 * 2. Calculate the amount of ingredients for the drink
       	 * 3. Deduce that amount from the respective storage bins.
	 * 4. Create a new transaction variable containing all information, add it to transactions list.
  	 * 5. Print all information.
	 */
	public void simulateSale(){
		boolean end = false, drinkIsAvail;
		ArrayList<String> menu;
		String choice, choice2;

		while (!end){
			menu = model.returnMenu();

			if (menu.size() == 0){
				AppView.clear();
				view.printFeedback("NO AVAILABLE ITEMS");
				scan.nextLine();
				end = true;
			}

			else{
				view.printMenu(menu);

				view.printFeedback("Would you like to make an order? (y/n)");
				choice = scan.nextLine().trim();

				if (choice.toLowerCase().charAt(0) == 'n'){
					view.printFeedback("Come back again!");
					end = true;
					scan.nextLine();
				}

				else if (choice.toLowerCase().charAt(0) == 'y'){
					/* Start simulating drink */
					view.printFeedback("What drink would you like?");
					choice = scan.nextLine();
					view.printFeedback("What size would you like?");
					choice2 = scan.nextLine();

					drinkIsAvail = model.isDrinkAvailable(choice, choice2);

					if (drinkIsAvail){
						Transaction newT = new Transaction(choice, choice2);

						AppView.pause();

						model.processTransaction(newT);

						newT.printBrew();
						newT.printTransaction();
					}
				}

				else { view.printFeedback("Please check your input."); scan.nextLine();}
			}
		}
	}
}