import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents a coffee truck.
 * @author Coby Luna & Marcus Ramos
 */
public class CoffeeTruck {
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

	/**
 	 * Constructor for a CoffeeTruck. 
   	 * Only initalizes empty variables, variables will be set using different methods in truck creation.
     	 */
	public CoffeeTruck(){
		this.truckLocation = "";
		this.STORAGEBINS = new ArrayList<>();
	        this.TRANSACTIONS = new ArrayList<>();
	
	        for (int i = 0; i < 8; i++) {
	            STORAGEBINS.add(new StorageBin());
	        }
	}

	/**
 	 * Fills a storage bin with new items. 
   	 * @param storageBinIndx The index of the storage bin to be changed in the storageBins array. 0 if bin #1, and so on.
     	 */
	public boolean fillStorageBin(int storageBinIndx, String type, float amt){
		if (storageBinIndx >= 0 && storageBinIndx < STORAGEBINS.size()) {
	            return STORAGEBINS.get(storageBinIndx).setBin(type, amt);
	        }
	
	        return false;
	}

	/**
	 * Returns a storage bin given its index.
	 * @param binIndex The index of the storage bin.
	 * @return The storage bin under the given index.
	 */
	public StorageBin getStorageBin(int binIndex){
		return STORAGEBINS.get(binIndex);
	}

	/**
 	 * Set the type of the coffee truck. FINAL, only called once.
   	 * @param type The type of the truck in single character string form. P for JJ+, R for regular.
     	 * @return True if successful, false otherwise.
       	 */
	public boolean setType(String type) {
		/*if (type.equals("P")){
			this.truckType = 'P';
			return true; }*/
		if (type.equals("R")){
			this.truckType = 'R';
			return true;
		}
		return false;
	}

	/**
 	 * Sets the location of the truck.
   	 * Additionally, checks if inputted location is in-use by other trucks. (Results in a fail)
   	 * @param location The new location of the truck.
     	 * @param trucks The arraylist of trucks, to check their location.
     	 * @return True if successful, false otherwise. 
       	 */
	public boolean setLocation(String location, ArrayList<CoffeeTruck> trucks) {
		Iterator<CoffeeTruck> it = trucks.iterator();
		boolean avail = true; // true = location is available

		while (it.hasNext() && avail){
			if (it.next().truckLocation.equals(location))
				avail = false; // false = location is not available
		}

		if (avail){
			this.truckLocation = location;}
			
		return avail;
	}

	/**
 	 * Returns the menu of the truck.
   	 * Menu refers to the coffee items and their corresponding cup sizes that can be made considering the inventory in the bins.
     	 * For example, if there is no milk, then Lattes and Cappucinos will not be on the menu.
       	 * If there's only enough milk to make a small latte, then that will also be indicated.
	 * This function calculates and returns a list of Strings that represents all the possible drinks the truck can make.
  	 * @return a String array of all possible drinks the truck can make given inventory.
    	 */
	public ArrayList<String> returnMenu() {

		/* Not very happy with the efficiency of the code here lols... 
		if u find a better way logic-wise to write this just go ahead */

		ArrayList<String> menu = new ArrayList<String>();
		double milk = 0, coffee = 0, water = 0, scup = 0, mcup = 0, lcup = 0;
		double ratio1, ratio2, ratio3;
		Iterator<StorageBin> itBin = STORAGEBINS.iterator();
		Ingredient tempIngr; String tempStr;

		while (itBin.hasNext()){
			tempIngr = itBin.next().getContents();

			if (tempIngr != null){	
				switch(tempIngr.getType()){
					case "milk": milk += tempIngr.getAmt(); break;
					case "water": water += tempIngr.getAmt(); break;
					case "coffee": coffee += tempIngr.getAmt(); break;
					case "scup": scup += tempIngr.getAmt(); break;
					case "mcup": mcup += tempIngr.getAmt(); break;
					case "lcup": lcup += tempIngr.getAmt(); break;
				}
			}
		}
		coffee = coffee / 28.34952; /* Converting from grams to fl */


		/* small = 8fl, med = 12fl, large = 16fl */

		/* cafe americano: 1/3 espresso, 2/3 water. */
		tempStr = "Cafe Americano [";
		ratio1 = (1.0/3.0)/(1.0/19.0); // Ratio of coffee
		ratio2 = (1.0/3.0)/(18.0/19.0); // Ratio of water in espresso
		ratio3 = 2.0/3.0; // Ratio of water

		if (coffee >= 8/ratio1 && water >= ((8/ratio2) + (8/ratio3))){
			if (scup > 0) tempStr += " S";

			if (coffee > 12/ratio1 && water >= ((12/ratio2) + (12/ratio3))){
				if (mcup > 0) tempStr += " M";

				if (coffee > 16/ratio1 && water >= ((16/ratio2) + (16/ratio3))){
					if (lcup > 0) tempStr += " L";}
			}

		}

		if (!tempStr.equals("Cafe Americano [")) {tempStr += " ]"; menu.add(tempStr);}

		/* latte: 1/5 espresso, 4/5 milk */
		tempStr = "Latte [";
		ratio1 = (1.0/5.0)/(1.0/19.0); // ratio for coffee
		ratio2 = (1.0/5.0)/(18.0/19.0); // ratio for water
		ratio3 = (4.0/5.0); // ratio for milk

		if (coffee >= 8/ratio1 && water >= 8/ratio2 && milk >= 8/ratio3){
			if (scup > 0) tempStr += " S";

			if (coffee >= 12/ratio1 && water >= 12/ratio2 && milk >= 12/ratio3){
				if (mcup > 0) tempStr += " M";

				if (coffee >= 16/ratio1 && water >= 16/ratio2 && milk >= 16/ratio3){
					if (lcup > 0) tempStr += " L";}
			}
		}

		if (!tempStr.equals("Latte [")) {tempStr += " ]"; menu.add(tempStr);}

		/* cappucino: 1/3 espresso, 2/3 milk */
		tempStr = "Cappucino [";
		ratio1 = (1.0/3.0)/(1.0/19.0); // ratio for coffee
		ratio2 = (1.0/3.0)/(18.0/19.0); // ratio for water
		ratio3 = (2.0/3.0); // ratio for milk

		if (coffee >= 8/ratio1 && water >= 8/ratio2 && milk >= 8/ratio3){
			if (scup > 0) tempStr += " S";

			if (coffee >= 12/ratio1 && water >= 12/ratio2 && milk >= 12/ratio3){
				if (mcup > 0) tempStr += " M";

				if (coffee >= 16/ratio1 && water >= 16/ratio2 && milk >= 16/ratio3){
					if (lcup > 0) tempStr += " L";}
			}
		}

		if (!tempStr.equals("Cappucino [")) {tempStr += " ]"; menu.add(tempStr);}

		return menu;
	}

	/**
	 * Using the menu array from returnMenu(), check if a drink is available.
	 * @param drink The name of the drink (i.e., "Latte")
	 * @param size 1 character string depicting size of drink (i.e., "S", "L")
	 * @return true if drink is available, false otherwise.
	 */
	public boolean isDrinkAvailable(String inptDrink, String inptSize){
		int openBracket, closeBracket;
		String sizes;
		String[] availableSizes;

		for (String item : this.returnMenu()) {
			if (item.toLowerCase().startsWith(inptDrink.toLowerCase())) {
				openBracket = item.indexOf('[');
				closeBracket = item.indexOf(']');

				sizes = item.substring(openBracket + 1, closeBracket).trim();

				availableSizes = sizes.trim().split("\\s+");
				for (String size : availableSizes) {
					if (size.trim().equalsIgnoreCase(inptSize.trim())) {
						return true;}
				}
			}
		}

		return false;
	}

	/**
 	 * Simulates a sale. In simulating, it performs:
   	 * 1. Customer ordering a drink. Display menu.
     	 * 2. Calculate the amount of ingredients for the drink
       	 * 3. Deduce that amount from the respective storage bins.
	 * 4. Create a new transaction variable containing all information, add it to transactions list.
  	 * 5. Print all information.
    	 */
	public void simulateSale() {
		ArrayList<String> menu;
		Iterator<String> it;
		Scanner scan = new Scanner(System.in);

		String drinkType, drinkSize, exit;
		boolean end = false, drinkIsAvail;

		while (!end){
			menu = this.returnMenu();
			JavaJeep.clear();
			if (menu.size() == 0){
				System.out.println("NO AVAILABLE ITEMS.");
				System.out.println("Press enter to return to menu.");
				end = true;
			}

			else { 
				/* Printing menu*/
				System.out.println("AVAILABLE ITEMS:");
				it = menu.iterator();
				while (it.hasNext()) {System.out.println(it.next());}
				System.out.println();

				/* Asking if user would like to exit */
				System.out.print("Would you like to make an order? (y/n): ");
				exit = scan.nextLine().trim();

				if (exit.equalsIgnoreCase("n")) {end = true; System.out.print("Come back again! Press enter to continue . . .");}

				else if(exit.equalsIgnoreCase("y")) {
					/* Getting user input */
					System.out.print("What drink would you like?: ");
					drinkType = scan.nextLine().trim();
					System.out.print("What size would you like? [S M L]: ");
					drinkSize = scan.nextLine().trim();

					drinkIsAvail = this.isDrinkAvailable(drinkType, drinkSize);
					System.out.println();

					if (drinkIsAvail){
						System.out.println("Here is a simulation of your order: ");
						Transaction newT = new Transaction(drinkType, drinkSize);

						try {
							Thread.sleep(1000); // Delay for 1 second
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						newT.printTransaction();
						this.moneyEarned += newT.getPrice();

						boolean found;
						for (Ingredient ingr : newT.getIngredients()){
							found = false;
							System.out.printf("");
							for (StorageBin bin : STORAGEBINS){ 
								if (!found && bin.getContents().getType().equals(ingr.getType())){
									bin.lessenContents(ingr.getAmt());
									found = true;
									/* if (bin.getContents().getAmt() < ingr.getAmt() */
								}
							}
						}

						this.TRANSACTIONS.add(newT);
						this.printBinInfo();

						System.out.print("Press enter to return . . .");
						scan.nextLine();

					}

					else {System.out.println("That drink is not available!"); scan.nextLine();}
				}
			}
		}

	}

	/**
 	 * Prints the info of the truck.
   	 */
	public void printTruckInfo() {
		System.out.println("Type: " + truckType + " | Truck at: " + truckLocation + " | Earned: " + moneyEarned);
		System.out.println("\nStorage bins contain...");

		for (int i = 0; i < 8; i++) {
			System.out.printf("Storage bin #%d - ", (i+1));
			STORAGEBINS.get(i).printBinInfo();
			System.out.println();
		}

		/* Print menu */
		
		/* Print transaction info */
		
	}

	/**
 	 * Prints the base information of a truck, aka its location and type.
   	 */
	public void printBaseInfo() {
		Iterator<StorageBin> it = STORAGEBINS.iterator();
		System.out.printf("Type: %s || Location: %s\n", truckType, truckLocation);
	}

	/**
	 * Prints information regarding the trucks' storage bins.
	 */
	public void printBinInfo(){
		System.out.println("Storage bins contain...");

		for (int i = 0; i < 8; i++) {
			System.out.printf("Storage bin #%d - ", (i+1));
			STORAGEBINS.get(i).printBinInfo();
			System.out.println();
		}
	}

	public void restockStorageBins() {
		String choice, choice2;
		int intChoice = 0;
		float floatChoice;
		boolean end, inptCheck;
		Scanner scan = new Scanner(System.in);

		end = false;
		do { 
			JavaJeep.clear();
			System.out.println("Here are the current contents of your storage bins:");

				printBinInfo();					
				System.out.print("\n");

			System.out.println();
			System.out.println("Select a bin to edit, enter END to exit.");
			System.out.print(">> ");
			choice = scan.nextLine();
			System.out.println();

			inptCheck = true; // checking input
			if (choice.toUpperCase().equals("END")) {end = true;}
			else{
				try {
					intChoice = Integer.parseInt(choice);
					if (intChoice < 1 || intChoice > 8){
						inptCheck = false;
					}
						
				} catch (NumberFormatException e) {inptCheck = false;}
			}

			while (inptCheck && !end){
				JavaJeep.clear();

				System.out.println("Max quantity for all items:");
				System.out.println("Small Cup - 80pcs [enter: 'scup']");
				System.out.println("Medium Cup - 64pcs [enter: 'mcup']");
				System.out.println("Large Cup - 40pcs [enter: 'lcup']");
				System.out.println("Coffee Beans - 1008grams [enter: 'coffee']");
				System.out.println("Milk - 640fl [enter: 'milk']");
				System.out.println("Water - 640fl [enter: 'water']");
				System.out.println();

				System.out.print("Type: ");
				choice = scan.nextLine().toLowerCase();
				System.out.print("Amount: ");
				choice2 = scan.nextLine();
				System.out.println();

				try{
					floatChoice = Float.parseFloat(choice2);
					inptCheck = fillStorageBin((intChoice-1), choice, floatChoice);
					if (inptCheck){
						System.out.print("Success! Press Enter to continue . . .");
						inptCheck = false;
					}
					else {
						System.out.print("Incorrect input, check if type matches the enter keywords and if the amount doesn't exceed max capacity. Press Enter to continue . . .");
					}
					
				} catch (NumberFormatException e){
					System.out.print("Not a valid input! Press Enter to continue . . .");
				}

				scan.nextLine();
			}
			
		} while(!end);
	}
		
	public void setMaintenance() {
		String choice, choice2;
		float floatChoice;
		Scanner scan = new Scanner(System.in);

			JavaJeep.clear();
			System.out.println("What location do you want your truck to stay in?");
			System.out.print(">> ");
			choice = scan.nextLine();

			this.truckLocation = choice;
		
			JavaJeep.clear();	
			System.out.println("Below are the current prices for each ingredient:");
			System.out.printf("1 gram coffee bean: %.2f\n", Ingredient.getPrice("coffee"));
			System.out.printf("1fl of milk: %.2f\n", Ingredient.getPrice("milk"));
			System.out.printf("1fl of water: %.2f\n", Ingredient.getPrice("water"));
			System.out.printf("Small cup base price: %.2f\n", Ingredient.getPrice("scup"));
			System.out.printf("Medium cup base price: %.2f\n", Ingredient.getPrice("mcup"));
			System.out.printf("Large cup base price: %.2f\n", Ingredient.getPrice("lcup"));
			System.out.println();

			System.out.println("Enter an ingredient who's price you'd like to change ['water','milk','coffee','scup','mcup','lcup'].");
			System.out.print(">> ");
			choice = scan.nextLine();
			System.out.println();

			if (choice.equals("milk") || choice.equals("water") || choice.equals("coffee") ||
				 choice.equals("scup") || choice.equals("mcup") || choice.equals("lcup")) {
				System.out.println("Enter the new price: (THIS IS EFFECTIVE FOR THIS TRUCK ONLY)");
				System.out.print(">> ");
				choice2 = scan.nextLine();
				System.out.println();

				try{
					floatChoice = Float.parseFloat(choice2);
					Ingredient.setPrice(choice, floatChoice);
					System.out.print("Successfully changed! Press Enter to continue . . .");
					scan.nextLine();
					
				} catch (NumberFormatException e){
					System.out.print("Not a valid input! Press Enter to continue . . .");
					scan.nextLine();
				}
			}

			else {System.out.print("Not a valid input! Press Enter to continue . . ."); scan.nextLine();}
	}
}

