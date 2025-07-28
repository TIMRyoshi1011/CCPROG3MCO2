package Truck;

import java.util.Scanner;
import java.util.ArrayList;
import StorageBin.*;
import Transaction.*;
import App.*;
import Espresso.*;
import Ingredient.*;

/**
 * A coffee trucks controller
 */
public class TruckController {
	/** The truck controller's model */
	private TruckModelAbstract model;
	/** The truck controller's view */
	private TruckView view;
	/** Scanner for the whole file */
	private Scanner scan = new Scanner(System.in);

	/**
	 * Initializes the model and view of the truck.
	 * Collects user information to add the details for the truck.
	 * @param type The type of the truck
	 */
	public TruckController(char type){
		this.view = new TruckView();
		switch(type){
			case 'P':
				model = new PlusModel(); break;
			case 'R':
				model = new RegularModel(); break;
		}
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
			else if (inptCheck) editStorageBin(model.getBin(intChoice-1));
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
							AppView.pause();

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