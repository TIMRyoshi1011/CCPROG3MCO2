import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller for the main app interface.
 */
public class AppController {
	/** Model for main app interface. */
	private AppModel model;
	/** View for main app interface. */
	private AppView view;
	/** Scanner to be used throughout the whole app implementation. */
	private Scanner scan = new Scanner(System.in);

	/**
	 * Constructor for the AppController.
	 * @param model The model of the controller.
	 * @param view the view of the controller.
	 */
	public AppController (AppModel model, AppView view){
		this.model = model;
		this.view = view;
	}

	/**
	 * The main menu of the whole app. It lets the user pick between the different app functions.
	 */
	public void mainMenu(){
		String input;
		int choice = 0;

		while (choice != 4){
			view.printMain();

			input = scan.nextLine();
			choice = model.toInt(input);

			switch(choice){
			case 1:
				// create truck
				break;
			case 2:
				// simulate truck
				break;
			case 3:
				// dashboard
				break;
			case 4:
				// exit
				view.printFeedback("Thank you for using JavaJeeps!");
				break;
			default:
				// invalid input
				view.printFeedback("Invalid option, please try again: ");
				break;
			}
		}

		scan.close();
		System.exit(0); // Terminates the program
	}

	/**
	 * Called when the user wants to create a new truck.
	 */
	public void createTruck(){
		String choice; int intChoice;
		CoffeeTruck tempTruck = new CoffeeTruck();
		boolean success, inptCheck, end;

		/* Set truck type */
		do {
			view.printSetType();
			choice = scan.nextLine();
			success = model.setType(tempTruck, choice);
			if (!success) {view.printFeedback("Invalid input! Press Enter to continue . . .");}
		} while (!success);

		/* Set truck location */
		do {
			view.printSetLocation();
			choice = scan.nextLine();
			success = model.setLocation(tempTruck, choice);
			if (!success) {view.printFeedback("There's already a truck here! Pick somewhere else!");}
		} while (!success);

		/* Set truck storage bins */
		do {
			view.printSetStorageBins(tempTruck);
			choice = scan.nextLine();
			intChoice = model.toInt(choice);

			if (intChoice < 1 || intChoice > truck.getNumBins()) inptCheck = false;
			else inptCheck = true;

			if (inptCheck) this.editStorageBin(tempTruck.getStorageBin(intChoice - 1));
			else if (choice.equals("END")) success = false;
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
					else view.private ("Please check input...");
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
					emptyBin(bin);
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