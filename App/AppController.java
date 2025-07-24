package App;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.text.Document;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Truck.*;

/**
 * Controller for the main app interface.
 */
public class AppController implements ActionListener {
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

		view.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create Truck")) {
			CreateTruck createTruck = new CreateTruck(); // <---------------------- Opens CreateTruck.java
			//createTruck();
		} 
		
		else if (e.getActionCommand().equals("Simulate Truck")) {
			SimulateScreen simulate = new SimulateScreen(); // <---------------------- Opens SimulateScreen.java
			//simulateTruck();
		} 
		
		else if (e.getActionCommand().equals("Dashboard")) {
			Dashboard dashboard = new Dashboard(); // <---------------------- Opens Dashboard.java
			//dashboard();
		} 
		
		else {
			//view.printFeedback("Unknown action" );
		}
	}

	/**
	 * Called when the user wants to create a new truck.
	 */
	public void createTruck(){
		String choice; int intChoice;
		boolean success = false, inptCheck, end;
		TruckController tempTruck = new TruckController('R');

		/* Set truck type */
		do {
			view.printSetType();
			choice = scan.nextLine();
			switch(choice.toUpperCase().charAt(0)){
				case 'P':
					tempTruck = new TruckController('P'); success = true; break;
				case 'R':
					tempTruck = new TruckController('R'); success = true; break;
				default:
					view.printFeedback("Invalid input! Press Enter to continue . . ."); success = false; break;
			}
		} while (!success);

		/* Set truck location */
		setTruckLocation(tempTruck);

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
						model.getTruck(truckIndx).simulateSale();
						break;
					case 2:
						// print info
						model.getTruck(truckIndx).truckFullInfo();
						scan.nextLine();
						break;
					case 3:
						// restock storage bins
						model.getTruck(truckIndx).setBins();
						break;
					case 4:
						// set maintenance
						truckMaintenance(model.getTruck(truckIndx));
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

					if (truckIndx >= 0 && truckIndx < model.getNumTrucks()){
						model.getTruck(truckIndx).truckFullInfo(); scan.nextLine();
					}
					else view.printFeedback("Truck index is not valid.");
					
				case 'n': end = true; break;
				default: {view.printFeedback("Please check your input"); scan.nextLine(); break;}
			}
		} while (!end);

	}

	/**
	 * Sets the location of a truck
	 * @param truck truck being edited
	 */
	public void setTruckLocation(TruckController truck){
		String choice;
		boolean success = true;
		do {
			view.printSetLocation();
			choice = scan.nextLine();
			success = model.setLocation(truck, choice);
			if (!success) {view.printFeedback("There's already a truck here! Pick somewhere else!"); scan.nextLine();}
		} while (!success);
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

				scan.nextLine();
			}
		}	
	}

	/**
	 * Maintain the truck. Change it's location or prices.
	 * @param truck truck being maintained
	 */
	public void truckMaintenance(TruckController truck){
		boolean end = false;
		String choice; int intChoice;

		while (!end){
			view.printMaintenanceSelect();
			choice = scan.nextLine();

			intChoice = AppModel.toInt(choice);
			if (intChoice == 1) setTruckLocation(truck);
			else if (intChoice == 2) editPrices();
			else if (intChoice == 3) end = true;
			else view.printFeedback("Please check your input.");
		}
	}
}