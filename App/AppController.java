package App;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
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

	char truckType;
	TruckController tempTruck;
	String choice, choice2;
	float floatChoice;
	int binNo;

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

	/**
	 * Sets the acton performed of the buttons in the program
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create Truck")) {
			clearGUI();
			view.createNewTruck();
			// /createTruck();
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

			tempTruck = new TruckController('P'); 
			truckType = 'P';

			view.mainPanel.add(Box.createVerticalStrut(25));
       		view.label2 = new JLabel("Enter Location: ");
			view.label2.setFont(new Font("Arial", Font.BOLD, 15));
			view.mainPanel.add(view.label2);
			view.label2.setAlignmentX(Component.CENTER_ALIGNMENT);

			view.mainPanel.add(view.location);
			view.location.setAlignmentX(Component.CENTER_ALIGNMENT);
			view.mainPanel.add(Box.createVerticalStrut(5));
			view.mainPanel.add(view.sProceed);
			view.sProceed.setAlignmentX(Component.CENTER_ALIGNMENT);
			view.mainPanel.revalidate();
			view.mainPanel.repaint();
        }

		else if (e.getActionCommand().equals("JavaJeep")) {

			tempTruck = new TruckController('R'); 
			truckType = 'R';
			view.mainPanel.add(Box.createVerticalStrut(25));
       		view.label2 = new JLabel("Enter Location: ");
			view.label2.setFont(new Font("Arial", Font.BOLD, 15));
			view.mainPanel.add(view.label2);
			view.label2.setAlignmentX(Component.CENTER_ALIGNMENT);

			view.mainPanel.add(view.location);
			view.location.setAlignmentX(Component.CENTER_ALIGNMENT);
			view.mainPanel.add(Box.createVerticalStrut(5));
			view.mainPanel.add(view.rProceed);
			view.rProceed.setAlignmentX(Component.CENTER_ALIGNMENT);
			view.mainPanel.revalidate();
			view.mainPanel.repaint();
        }

        else if (e.getActionCommand().equals("Proceed")) {
			if (view.location.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a location.");
                return; // Do not proceed if the text field is empty
            }

			else {
				model.setLocation(tempTruck, view.getLoc());  
				removeUpdate(null);
				clearGUI();
				view.rSetTruckBins();
			}
        }

		else if (e.getActionCommand().equals("proceed")) {
			if (view.location.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a location.");
                return; // Do not proceed if the text field is empty
            }

			else {
				model.setLocation(tempTruck, view.getLoc());   
				removeUpdate(null);
				clearGUI();
				view.sSetTruckBins();
			}
        }

		else if (e.getActionCommand().equals("BIN #1")) {
			clearGUI();
			view.setAmounts();
			binNo = 0;
        }

		else if (e.getActionCommand().equals("BIN #2")) {  
			clearGUI();
			view.setAmounts();
			binNo = 1;
        }

		else if (e.getActionCommand().equals("BIN #3")) {
			clearGUI();
			view.setAmounts();
			binNo = 2;
        }

		else if (e.getActionCommand().equals("BIN #4")) {
			clearGUI();
			view.setAmounts();
			binNo = 3;
        }

		else if (e.getActionCommand().equals("BIN #5")) {
			clearGUI();
			view.setAmounts();
			binNo = 4;
        }

		else if (e.getActionCommand().equals("BIN #6")) { 
			clearGUI();
			view.setAmounts();
			binNo = 5;
        }

		else if (e.getActionCommand().equals("BIN #7")) {
			clearGUI();
			view.setAmounts(); 
			binNo = 6;
        }

		else if (e.getActionCommand().equals("BIN #8")) {
			clearGUI();
			view.setAmounts(); 
			binNo = 7;
        }

		else if (e.getActionCommand().equals("BIN #9")) {
			clearGUI();
			view.setAmounts();
			binNo = 8;
        }

		else if (e.getActionCommand().equals("BIN #10")) {
			clearGUI();
			view.setAmounts();
			binNo = 9;
        }

		else if (e.getActionCommand().equals(">")) { 
			clearGUI();
			view.setPrices();
        }

		else if (e.getActionCommand().equals("Small Cup")) {
			choice = "scup"; // set choice to scup
        }

        else if (e.getActionCommand().equals("Medium Cup")) {
			choice = "mcup"; // set choice to mcup
        }

        else if (e.getActionCommand().equals("Large Cup")) {
			choice = "lcup"; // set choice to lcup
        }

        else if (e.getActionCommand().equals("Coffee Beans")) {
			choice = "coffee"; // set choice to coffee
        }

        else if (e.getActionCommand().equals("Milk")) {
			choice = "milk"; // set choice to milk
        }

        else if (e.getActionCommand().equals("Water")) {
			choice = "water"; // set choice to water
        }

		else if (e.getActionCommand().equals("Espresso")) {
			choice = "espresso"; // set choice to espresso
        }

		else if (e.getActionCommand().equals("Extra")) {
			choice = "extra"; // set choice to extra
        }

		else if (e.getActionCommand().equals("Enter")) {
            if (view.amount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter an amount.");
                return; 
            }

            else {
				String toConvert = view.getAmount();
				tempTruck.model.setBin(tempTruck.model.getBin(binNo), choice, stringToFloat(toConvert));
                
				if(binNo == 0) {
					view.Bin1 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 1) {
					view.Bin2 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 2) {
					view.Bin3 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 3) {
					view.Bin4 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 4) {
					view.Bin5 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 5) {
					view.Bin6 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 6) {
					view.Bin7 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 7) {
					view.Bin8 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 8) {
					view.Bin9 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 9) {
					view.Bin10 = "Type: " + choice + ", Amount: " + view.getAmount();
				}

				else if(binNo == 9) {
					view.Bin10 = "Type: " + choice + ", Amount: " + view.getAmount();
				}
				removeUpdate(null); 
				clearGUI();
				if(truckType == 'R')
					view.rSetTruckBins(); 
				else if(truckType == 'P')
					view.sSetTruckBins(); 
            }
        }

		else if (e.getActionCommand().equals("Exit")) {
			clearGUI();
			if(truckType == 'R')
				view.rSetTruckBins(); 
			else if(truckType == 'P')
				view.sSetTruckBins(); 
		}

        else if (e.getActionCommand().equals("Save")) {
            if (view.price.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a price.");
                return; // Do not proceed if the text field is empty
            }

            else {
				model.setPrice(choice, stringToFloat(view.getPrice())); // setting price

				if(choice == "espresso") {
					view.prc1 = view.getPrice();
				}

				else if(choice == "milk") {
					view.prc2 = view.getPrice();
				}

				else if(choice == "water") {
					view.prc3 = view.getPrice();
				}

				else if(choice == "scup") {
					view.prc4 = view.getPrice();
				}

				else if(choice == "mcup") {
					view.prc5 = view.getPrice();
				}

				else if(choice == "lcup") {
					view.prc6 = view.getPrice();
				}

				else if(choice == "extra") {
					view.prc7 = view.getPrice();
				}
				
				JOptionPane.showMessageDialog(view, "Saved");
				removeUpdate(null);
				clearGUI();
				view.setPrices();
            }
        }

        else if (e.getActionCommand().equals("Confirm")) {
            clearGUI();
			view.truckInfo();
			view.mainPanel.add(Box.createVerticalStrut(35));

			view.label2 = new JLabel("Type: " + tempTruck.getType() + " || Location: " + tempTruck.getLocation()); 
			view.label2.setFont(new Font("Arial", Font.BOLD, 25));
			view.mainPanel.add(view.label2);
			view.label2.setAlignmentX(Component.CENTER_ALIGNMENT);

			view.mainPanel.add(Box.createVerticalStrut(35));

			view.label3 = new JLabel("Storage Bins Contain...");
			view.label3.setFont(new Font("Arial", Font.BOLD, 25));
			view.mainPanel.add(view.label3);
			view.label3.setAlignmentX(Component.RIGHT_ALIGNMENT);
			view.mainPanel.add(Box.createVerticalStrut(10));

			JLabel bin1Cnts = new JLabel("Storage Bin #1 - " + view.Bin1); 
			bin1Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin1Cnts);
			bin1Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin2Cnts = new JLabel("Storage Bin #2 - " + view.Bin2); 
			bin2Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin2Cnts);
			bin2Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin3Cnts = new JLabel("Storage Bin #3 - " + view.Bin3);
			bin3Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin3Cnts);
			bin3Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin4Cnts = new JLabel("Storage Bin #4 - " + view.Bin4);
			bin4Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin4Cnts);
			bin4Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin5Cnts = new JLabel("Storage Bin #5 - " + view.Bin5); 
			bin5Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin5Cnts);
			bin5Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin6Cnts = new JLabel("Storage Bin #6 - " + view.Bin6);
			bin6Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin6Cnts);
			bin6Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin7Cnts = new JLabel("Storage Bin #7 - " + view.Bin7); 
			bin7Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin7Cnts);
			bin7Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			JLabel bin8Cnts = new JLabel("Storage Bin #8 - " + view.Bin8);
			bin8Cnts.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(bin8Cnts);
			bin8Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

			if(truckType == 'P') {
				JLabel bin9Cnts = new JLabel("Storage Bin #9 - " + view.Bin9);
				bin9Cnts.setFont(new Font("Arial", Font.BOLD, 20));
				view.mainPanel.add(bin9Cnts);
				bin9Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);

				JLabel bin10Cnts = new JLabel("Storage Bin #10 - " + view.Bin10);
				bin10Cnts.setFont(new Font("Arial", Font.BOLD, 20));
				view.mainPanel.add(bin10Cnts);
				bin10Cnts.setAlignmentX(Component.RIGHT_ALIGNMENT);
			}

			view.mainPanel.add(Box.createVerticalStrut(35));

			view.mainPanel.add(view.mainMenu);
			view.mainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
			view.revalidate();
			view.repaint();
		}

		else if (e.getActionCommand().equals("Main Menu")) {
			clearGUI();
            view.homeScreen();
			view.Bin1 = "BIN is empty";
			view.Bin2 = "BIN is empty";
			view.Bin3 = "BIN is empty";
			view.Bin4 = "BIN is empty";
			view.Bin5 = "BIN is empty";
			view.Bin6 = "BIN is empty";
			view.Bin7 = "BIN is empty";
			view.Bin8 = "BIN is empty";
			view.Bin9 = "BIN is empty";
			view.Bin10 = "BIN is empty";

			view.prc1 = "1.50";
			view.prc2 = "2.50";
			view.prc3 = "0.50";
			view.prc4 = "50.00";
			view.prc5 = "60.00";
			view.prc6 = "70.00";
			view.prc7 = "2.00";
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
				System.out.println("Small"); //placeholder for test/ to delete
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
				System.out.println("Medium"); //placeholder for test/ to delete
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
				System.out.println("large"); //placeholder for test/ to delete
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
                view.maintainance();
            }
        }

        else if (e.getActionCommand().equals("confirm")) {
            clearGUI();
			view.maintainance();
        }

		else if (e.getActionCommand().equals("Change Location")) {
			clearGUI();
            view.mSetLocation();
        }

		else if (e.getActionCommand().equals("Set Prices")) {
			clearGUI();
			view.mSetPrices();
        }

		else if (e.getActionCommand().equals("return")) {
			clearGUI();
			view.optionList();
        }

		else if (e.getActionCommand().equals("yes")) {
			clearGUI();
			view.mainPanel.add(Box.createVerticalStrut(15));
			view.label1 = new JLabel("Choose a truck to simulate:");
			view.label1.setFont(new Font("Arial", Font.BOLD, 20));
			view.mainPanel.add(view.label1);
			view.mainPanel.add(Box.createVerticalStrut(15));

			view.label2 = new JLabel("#1 || Type: _ || Location: ______           /* To add more */"); //<------------replace with values from CreateTruck
			view.label2.setFont(new Font("Arial", Font.BOLD, 15));
			view.mainPanel.add(view.label2);

			view.mainPanel.add(Box.createVerticalStrut(15));
			JLabel choice = new JLabel("Enter Number: ");
			choice.setFont(new Font("Arial", Font.BOLD, 13));
			view.mainPanel.add(choice);

			view.mainPanel.add(view.toSimulate);
			view.mainPanel.add(Box.createVerticalStrut(5));
			view.mainPanel.add(view.dnxt);
			view.mainPanel.revalidate();
			view.mainPanel.repaint();
        }

		else if (e.getActionCommand().equals("no")) {
            clearGUI();
            view.homeScreen();
        }

		else if (e.getActionCommand().equals("next")) {
			if (view.toSimulate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please enter a Truck No.");
                return; // Do not proceed if the text field is empty
            }
            else {
                System.out.println(view.getSimulation()); // Pass getSimulation() to the model - placeholder for test/ to delete
				removeUpdate(null);
                clearGUI();
				view.homeScreen(); //<---------------------- not supposed to be this one
            } 
        }
		
		else {
			//view.printFeedback("Unknown action" );
		}
	}

	/**
	 * Converts a string to an int
	 * @param str the string to be converted
	 * @return int value
	 */
	public static int stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + str + " is not a valid number.");
            return 0; 
        }
    }

	/**
	 * Converts a string to a float
	 * @param str the string to be converted
	 * @return float value
	 */
	public static float stringToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + str + " is not a valid float.");
            return 0.0f; 
        }
    }

	/**
	 * For inserting update in a text field
	 * @param e to handle document event
	 */
	@Override
    public void insertUpdate(DocumentEvent e) {
        // Handle text insertion
    }

	/**
	 * For removing update in a text field
	 * @param e to handle document event
	 */
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

	/**
	 * For changing update in a text field
	 * @param e to handle document event
	 */
    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change

    }

	/**
	 * Clears the GUI
	 */
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