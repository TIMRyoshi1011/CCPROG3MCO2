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
		TruckController tempTruck = new TruckController();
		boolean success, inptCheck, end;

		/* Set truck type */
		tempTruck.setType();

		/* Set truck location */
		do {
			view.printSetLocation();
			choice = scan.nextLine();
			success = model.setLocation(tempTruck, choice);
			if (!success) {view.printFeedback("There's already a truck here! Pick somewhere else!");}
		} while (!success);

		/* Set truck storage bins */
		tempTruck.setBins();

		/* Set prices */
		editPrices();

		/* Complete */
		view.clear();
		view.printFeedback("Truck successfully created!");
		tempTruck.truckBaseInfo();
		tempTruck.truckBinInfo();
		model.addTruck(tempTruck);
		scan.nextLine();
	}

	/**
	 * Simulates a truck. When choosing to simulate a truck, the user can: 
	 * - Simulate a sale
	 * - View truck informaiton
	 * - Restock bins and perform maintenance.
	 */
	public void simulateTruck(){
		String choice;
		boolean end = false, exitTruck = true;
		int truckIndx, intChoice;

		do{
			/* Selecting a truck to simulate */
			view.printTruckOptions(model.getTrucks());
			choice = scan.nextLine();
			truckIndx = model.toInt(choice) - 1;

			if (choice.equalsIgnoreCase("END")) end = true;
			else if (truckIndx < 0) view.printFeedback("Please check your input!");
			else exitTruck = false;

			while (!exitTruck){

				/* Selecting what to do with chosen truck. */
				view.printSimulateOptions();
				choice = scan.nextLine();
				intChoice = model.toInt(choice);

				switch(intChoice){
					case 1:
						// simulate sale
						break;
					case 2:
						// print info
						break;
					case 3:
						// restock storage bins
						break;
					case 4:
						// set maintenance
						break;
					case 5:
						// exit
						exitTruck = true;
						break;
					default:
						view.printFeedback("Please check your input!");
				}

			}
		} while(!end);
	}

	/**
	 * Provides a birds-eye view of all trucks.
	 */
	public void dashboard(){
		boolean end = false;
		String choice;
		int truckIndx, i;

		do {
			view.printDashboard(model.getTrucks(), model.getTotalIngredients(), 
				model.getTotalEarnings(), model.getTotalTransactionTypes());

			view.printFeedback("Is there a specific truck you'd like to see? (y/n)");
			choice = scan.nextLine();

			switch(choice.toLowerCase().charAt(0)){
				case 'y': 
					view.printTruckOptions(model.getTrucks());
					choice = scan.nextLine();
					truckIndx = model.toInt(choice);

					if (truckIndx >= 0 && truckIndx < model.getNumTrucks())
						model.getTruck(truckIndx).truckFullInfo();
					else view.printFeedback("Truck index is not valid.");
					
				case 'n': end = true; break;
				default: {view.printFeedback("Please check your input"); scan.nextLine(); break;}
			}
		} while (!end);

	}

	/**
	 * Controls the app when the prices are being edited.
	 */
	public void editPrices(){
		String choice, choice2;
		float floatChoice;
		boolean success, end = false;

		while (!end){
			view.printSetPrice();
			choice = scan.nextLine();

			if (choice.toUpperCase().equals("END")) end = true;
			else{
				view.printFeedback("Enter the new price: (THIS IS EFFECTIVE FOR ALL TRUCKS)");
				choice2 = scan.nextLine();
				floatChoice = model.toFloat(choice2);
				success = model.setPrice(choice, floatChoice);

				if (success) view.printFeedback("Price successfully changed!");
				else view.printFeedback("Please check your input...");
			}
		}	
	}
}