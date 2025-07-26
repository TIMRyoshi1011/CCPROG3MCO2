package App;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Truck.*;

/**
 * Controller for the main app interface.
 */
public class AppController implements ActionListener, DocumentListener {
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
		view.setDocumentListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create Truck")) {
			clearGUI();
			view.createNewTruck();
			//createTruck();
		} 
		
		else if (e.getActionCommand().equals("Simulate Truck")) {
			clearGUI();
			view.truckSimulate();
			//simulateTruck();
		} 
		
		else if (e.getActionCommand().equals("Dashboard")) {
			clearGUI();
			view.dashboard();
			// dashboardController();
		} 

		else if (e.getActionCommand().equals("JavaJeep+")) {
            System.out.println("P"); //placeholder for test/ to delete
            // Pass S to the model
        }

		else if (e.getActionCommand().equals("JavaJeep")) {
            System.out.println("R");  //placeholder for test/ to delete
            // Pass R to the model
        }

        else if (e.getActionCommand().equals("Proceed")) {
			if (view.location.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a location.");
                return; // Do not proceed if the text field is empty
            }

			else {
				System.out.println(view.getLoc());  // Send getLoc() to the model - placeholder for test/ to delete 
				removeUpdate(null);
				clearGUI();
				view.setTruckBins();
			}
        }

		else if (e.getActionCommand().equals("BIN #1")) {
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals("BIN #2")) {  
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals("BIN #3")) {
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals("BIN #4")) {
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals("BIN #5")) {
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals("BIN #6")) { 
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals("BIN #7")) {
			clearGUI();
			view.setAmounts(); 
        }

		else if (e.getActionCommand().equals("BIN #8")) {
			clearGUI();
			view.setAmounts();
        }

		else if (e.getActionCommand().equals(">")) { 
			clearGUI();
			view.setPrices();
        }

		else if (e.getActionCommand().equals("Small Cup")) {
            System.out.println("Small Cup");  // Send Small Cup to the model - placeholder for test/ to delete
        }

        else if (e.getActionCommand().equals("Medium Cup")) {
            System.out.println("Medium Cup");  // Send Medium Cup to the model - placeholder for test/ to delete
        }

        else if (e.getActionCommand().equals("Large Cup")) {
            System.out.println("Large Cup");  // Send Large Cup to the model - placeholder for test/ to delete
        }

        else if (e.getActionCommand().equals("Coffee Beans")) {
            System.out.println("Coffee Beans");  // Send Coffee Beans to the model - placeholder for test/ to delete
        }

        else if (e.getActionCommand().equals("Milk")) {
            System.out.println("Milk");  // Send Milk to the model - placeholder for test/ to delete
        }

        else if (e.getActionCommand().equals("Water")) {
            System.out.println("Water");  // Send Water to the model - placeholder for test/ to delete
        }

		else if (e.getActionCommand().equals("Enter")) {
            if (view.amount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter an amount.");
                return; 
            }

            else {
                System.out.println(view.getAmount());  // Send getAmount() to the model - placeholder for test/ to delete
                removeUpdate(null); 
				clearGUI();
				view.setTruckBins();
            }
        }

        else if (e.getActionCommand().equals("Save")) {
            if (view.price.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a price.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(view.getPrice());  // Send getPrice() to the model - placeholder for test/ to delete
				removeUpdate(null);
                System.out.println("Saved");  //placeholder, to remove
            }
        }

        else if (e.getActionCommand().equals("Confirm")) {
            clearGUI();
			view.truckInfo();
        }

		else if (e.getActionCommand().equals("Main Menu")) {
			clearGUI();
            view.homeScreen();
        }

		else if (e.getActionCommand().equals("Next")) {
            if (view.toSimulate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a Truck No.");
                return; // Do not proceed if the text field is empty
            }
            else {
                System.out.println(view.getSimulation()); // Pass getSimulation() to the model - placeholder for test/ to delete
				removeUpdate(null);
                clearGUI();
				view.optionList();
            } 
        }

		else if (e.getActionCommand().equals("Simulate Sale")) {
            clearGUI();
			view.choose();
        }

        else if (e.getActionCommand().equals("View Truck Information")) {
            clearGUI();
			view.simulateTruckInfo();
        }

        else if (e.getActionCommand().equals("Manage Bins")) {
			clearGUI();
            view.simulateTruckBins();
        }

        else if (e.getActionCommand().equals("Maintenance")) {
			clearGUI();
            view.maintainance();
        }

		else if (e.getActionCommand().equals("Back to Main Menu")) {
			clearGUI();
            view.homeScreen();
		}

		else if (e.getActionCommand().equals("Yes")) {
			clearGUI();
            view.order();
        }

        else if (e.getActionCommand().equals("No")) {
            clearGUI();
			view.optionList();
        }

		else if (e.getActionCommand().equals("Small")) {
            if (view.drink.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a drink.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(view.getDrink());  // Pass getDrink() to the model - placeholder for test/ to delete
				removeUpdate(null);
				clearGUI();
                view.orderHere();
            }
        }

        else if (e.getActionCommand().equals("Medium")) {
            if (view.drink.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a drink.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(view.getDrink());  // Pass getDrink() to the model - placeholder for test/ to delete
				removeUpdate(null);
                clearGUI();
                view.orderHere();
            }
        }

        else if (e.getActionCommand().equals("Large")) {
            if (view.drink.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a drink.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(view.getDrink());  // Pass getDrink() to the model - placeholder for test/ to delete
				removeUpdate(null);
                clearGUI();
                view.orderHere();
            }
        }

		else if (e.getActionCommand().equals("Back")) {
            clearGUI();
			view.optionList();
        }

		else if (e.getActionCommand().equals("Return")) {
            clearGUI();
			view.optionList();
        }

		else if (e.getActionCommand().equals("BIN 1")) {
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 2")) {  
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 3")) {
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 4")) {
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 5")) {
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 6")) { 
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 7")) {
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("BIN 8")) {
			clearGUI();
			view.simulateAmounts();
        }

		else if (e.getActionCommand().equals("<")) { 
			clearGUI();
			view.optionList();
        }

		else if (e.getActionCommand().equals("Previous")) {
            if (view.amount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter an amount.");
                return; 
            }

            else {
                System.out.println(view.getAmount());  // Send getAmount() to the model - placeholder for test/ to delete
                removeUpdate(null); 
                clearGUI();
                view.simulateTruckBins();
            }
        }

		else if (e.getActionCommand().equals("Continue")) {
            if (view.mLocation.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a location.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(view.getMLoc()); // Pass getTextField() to the model - placeholder for test/ to delete
                removeUpdate(null); // Clear the text field after proceeding
				clearGUI();
                view.mSetPrices();
            }
        }

        else if (e.getActionCommand().equals("confirm")) {
            clearGUI();
			view.optionList();
        }

		else if (e.getActionCommand().equals("yes")) {
            //clearGUI();
            System.out.println("yes");
        }

		else if (e.getActionCommand().equals("no")) {
            clearGUI();
            view.homeScreen();
        }
		
		else {
			//view.printFeedback("Unknown action" );
		}
	}

	@Override
    public void insertUpdate(DocumentEvent e) {
        // Handle text insertion
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Handle text removal
		view.location.setText("");
		view.amount.setText("");
		view.price.setText("");
		view.toSimulate.setText("");
		view.drink.setText("");
		view.mLocation.setText("");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change

    }

	public void clearGUI() {
		view.mainPanel.removeAll();
		view.mainPanel.revalidate();
		view.mainPanel.repaint();
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
				createTruck();
				break;
			case 2:
				// simulate truck
				simulateTruck();
				break;
			case 3:
				// dashboard
				dashboardController();
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
	public void dashboardController(){
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