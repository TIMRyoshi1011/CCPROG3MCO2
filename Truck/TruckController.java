package Truck;

import java.util.Scanner;
import java.util.ArrayList;
import StorageBin.*;
import Transaction.*;
import App.*;
import Espresso.*;
import Ingredient.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * A coffee trucks controller
 */
public class TruckController {
	/** The truck controller's model */
	public TruckModelAbstract model;
	/** The truck controller's view */
	private TruckView view;
	/** Scanner for the whole file */
	private Scanner scan = new Scanner(System.in);

	/** AppView frame being kept to keep the same frame*/
	private AppView appView;

	/**
	 * Initializes the model and view of the truck.
	 * Collects user information to add the details for the truck.
	 * @param type The type of the truck
	 */
	public TruckController(char type, AppView appView){
		this.view = new TruckView(appView);
		this.appView = appView;
		switch(type){
			case 'P':
				model = new PlusModel(); break;
			case 'R':
				model = new RegularModel(); break;
		}
	}

	/**
	 * Returns the truck's type
	 * @return The type of the truck.
	 */
	public char getType() {
		return model.getType();
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
	public ArrayList<TransactionController> getTransactions(){
		return model.getTransactions();
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
	public void setBins() {
		view.showSetStorageBins(
			model.getBins(),

			// ActionListener for editing bins
			e -> {
				JButton source = (JButton) e.getSource();
				int binIndex = (int) source.getClientProperty("binIndex");
				editStorageBin(model.getBin(binIndex), this::setBins);
			},

			// ActionListener for "Done" button
			e -> appView.setOutput("Exiting bin editing...")
		);
	}


	/**
	 * Selects an edit action for the storage bins
	 * @param bin The storage bin being edited.
	 * @param onExit A runnable for it to go back to the setBins() instance it was called from
	 */
	public void editStorageBin(StorageBin bin, Runnable onExit){
		view.showEditBin(
			bin,
			bin.getContents() == null,
			e -> setStorageBin(bin, () -> editStorageBin(bin, onExit)),
			e -> replenishStorageBin(bin, () -> editStorageBin(bin, onExit)),
			e -> {
				model.emptyBin(bin);
				appView.setOutput("Bin has been emptied.");
				editStorageBin(bin, onExit);
			},
			e-> onExit.run()
		);
	}

	/**
	 * Sets a storage bin, rewriting its entire contents.
	 * @param bin Bin to be edited
	 * @param onExit runnable to let it go back to the editStorageBin it was called from
	 */
	public void setStorageBin(StorageBin bin, Runnable onExit){
		ArrayList<ActionListener> listeners = new ArrayList<>();

		String[] types = {"scup", "mcup", "lcup", "coffee", "milk", "water", "syrup"};
		for (String type : types) {
			listeners.add(e -> {
				JButton source = (JButton) e.getSource();
				JTextField inputField = (JTextField) source.getClientProperty("inputField");
				String input = inputField.getText().trim();
				float amount = AppModel.toFloat(input);

				if (amount <= 0) {
					appView.setOutput("Please enter a valid positive amount.");
					return;
				}

				boolean success = model.setBin(bin, type, amount);
				if (!success) {
					appView.setOutput("Please check input: bin may exceed max capacity.");
				} else {
					appView.setOutput("Success! Bin set to " + type + " with " + amount + " units.");
					onExit.run();
				}
			});
		}

		view.showSetStorageBin(listeners);
	}

	/**
	 * Replenishes a storage bin's contents
	 * @param bin Bin to be edited
	 */
	public void replenishStorageBin(StorageBin bin, Runnable onExit){
		view.showReplenishBinForm(
			e -> {
				JButton source = (JButton) e.getSource();
				JTextField inputField = (JTextField) source.getClientProperty("inputField");
				String input = inputField.getText().trim();
				float amount = AppModel.toFloat(input);

				if (amount < 0) {
					appView.setOutput("Error in input!");
					return;
				}

				boolean success = model.replenishBin(bin, amount);
				if (!success) {
					appView.setOutput("Cannot fit in bin!");
				} else {
					appView.setOutput("Successfully replenished!");
				}

				onExit.run();
			},
			onExit
		);
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
		for (TransactionController transaction : model.getTransactions()){
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
		boolean end = false, exit, drinkIsAvail;
		ArrayList<String> menu;
		ArrayList<ExtraIngr> extraSyrups = new ArrayList<ExtraIngr>();
		String choice, choice2, choice3;
		int intChoice;
		Espresso espresso;

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
						if(model.getType() == 'P'){
							do{
								view.printFeedback("What kind of brew would you like? [standard, strong, light, custom]");
								
								choice3 = scan.nextLine();
								espresso = switch (choice3.toLowerCase().trim()){
									case "standard" -> new StandardBrew();
									case "light" -> new LightBrew();
									case "strong" -> new StrongBrew();
									case "custom" -> {
										int tempDrink = -1;
										do{
											view.printFeedback("Enter custom ratio. In 1 shot, 1 part coffee is to how many parts water?");
											choice3 = scan.nextLine();
											tempDrink = AppModel.toInt(choice3.trim());
										} while (tempDrink < 0);

										yield new CustomBrew(tempDrink);
									}
									default -> {
										view.printFeedback("Please check your input.");
										scan.nextLine();
										yield null;
									}
								};
							} while (espresso == null);

							do {
								view.printFeedback("Please enter how many extra shots you'd like (0 if none):");
								choice3 = scan.nextLine();
								intChoice = AppModel.toInt(choice3);
							} while (intChoice < 0);

							exit = false;
							do {
								ArrayList<String> availSyrups = model.getSyrups();
								extraSyrups = new ArrayList<ExtraIngr>();
								if (availSyrups.isEmpty()) exit = true;

								view.printFeedback("Choose a syrup to add:");
								for (int i = 0; i < availSyrups.size(); i++)
									view.printFeedback(String.format("- %s", availSyrups.get(i)));
								view.printFeedback("Enter 'END' to stop");

								choice3 = scan.nextLine();
								if (choice3.trim().equalsIgnoreCase("end")) exit = true;
								else if (!availSyrups.contains(choice3))
									view.printFeedback("Invalid input");
								else {
									view.printFeedback("Syrup added!");
									extraSyrups.add(new ExtraIngr(choice3, 1f));
								}
							} while (!exit);
						}

						else{
							espresso = new StandardBrew();
							intChoice = 0;
						}

						TransactionController newT = new TransactionController(choice, choice2, espresso, intChoice, extraSyrups);
						
						if (!model.isEspressoAvail(newT.getEspresso(), newT.getEspresso().getEspresso(), model.getIngrdientAmount())) {
							view.printFeedback("Not enough coffee or water for that brew.");
						}

						else{
							

							model.processTransaction(newT);

							newT.printBrew();
							newT.printTransaction();
						}
					}
				}

				else { view.printFeedback("Please check your input."); scan.nextLine();}
			}
		}
	}
}
