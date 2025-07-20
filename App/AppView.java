package App;

import java.util.ArrayList;
import Truck.*;
import Ingredient.*;

/**
 * View for the main app interface
 */
public class AppView {

	/* SUGGESTION: since lots of the programs parts concerns choosing an option from a set of lists, 
				   there could be a general option that prints a list of choices given the number
				   of choices and the labels of each choice. Unsure how to work around this with 
				   button inputs though, but will think about it when we reach the GUI implementation
				   stage. */

	/**
	 * Prints the main menu of the app.
	 */
	public void printMain(){
		clear();
		System.out.println("Welcome to JavaJeeps!\n");
		System.out.println("Select an Option:");
		System.out.println("1 - Create a coffee truck");
		System.out.println("2 - Simulate a coffee truck");
		System.out.println("3 - Dashboard");
		System.out.println("4 - Exit");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints a feedback label
	 */
	public void printFeedback(String feedback){
		System.out.println(feedback);
	}

	/**
	 * Prints the screen when the type's location is being set.
	 */
	public void printSetLocation(){
		AppView.clear();
		System.out.println("What location do you want your truck to stay in?");
		System.out.println("To keep business efficient, we're limiting it to one truck per city!");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints the screen when the user is setting the prices.
	 */
	public void printSetPrice(){
		clear();
		System.out.println("The prices of drinks for all coffee trucks are equal, and is determined by the amount of an ingredient and it's base price, as well as the cup size.\n");
		System.out.println("Below are the current prices for each ingredient:");
		System.out.printf("1 gram coffee bean: %.2f\n", Ingredient.getPrice("coffee"));
		System.out.printf("1fl of milk: %.2f\n", Ingredient.getPrice("milk"));
		System.out.printf("1fl of water: %.2f\n", Ingredient.getPrice("water"));
		System.out.printf("Small cup base price: %.2f\n", Ingredient.getPrice("scup"));
		System.out.printf("Medium cup base price: %.2f\n", Ingredient.getPrice("mcup"));
		System.out.printf("Large cup base price: %.2f\n", Ingredient.getPrice("lcup"));
		System.out.println();

		System.out.println("Enter an ingredient who's price you'd like to change ['water','milk','coffee','scup','mcup','lcup']. If you'd like to exit, enter END.");
		System.out.print(">> ");
	}

	/**
	 * Prints the screen allowing the user to pick a truck
	 * @param trucks Arraylist of trucks to print
	 */
	public void printTruckOptions(ArrayList<TruckController> trucks){
		int count = 1;

		clear();

		System.out.println("Choose a truck!"); 
		for (TruckController truck : trucks){
			System.out.printf("#%d || ", count);
			truck.truckBaseInfo();
			count++;
		}
		System.out.println("Enter \"END\" to exit.");
	}

	/**
	 * Prints the options the user can pick from when simulating a truck.
	 */
	public void printSimulateOptions(){
		clear();

		System.out.println("What would you like to do?");
		System.out.println("1 - Simulate sale");
		System.out.println("2 - View truck information");
		System.out.println("3 - Manage bins");
		System.out.println("4 - Maintenance");
		System.out.println("5 - Exit");
		System.out.println();
	}

	/**
	 * Prints the dashboard
	 * @param trucks The arraylist of trucks
	 * @param totalIngr Array containing amount of all ingredients
	 * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee
	 * @param combinedSales Total earnings of all trucks
	 * @param transacType Total amount of all types of drinks made
	 */
	public void printDashboard(ArrayList<TruckController> trucks, float[] totalIngr, float combinedSales, int[] transacType){
		clear();
		System.out.println("ALL TRUCKS:");

		/* Prints all trucks' base info */
		for (TruckController truck : trucks) truck.truckBaseInfo();

		/* Prints aggregate amount of ingredients all trucks have. 
		 * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee */
		System.out.println();
		System.out.println();
		System.out.println("Total amount of ingredients in all trucks:");

		pause();
		System.out.printf("\tSmall Cups: %.0f pcs", totalIngr[0]);
		pause();
		System.out.printf("\tMedium Cups: %.0f pcs", totalIngr[1]);
		pause();
		System.out.printf("\tLarge Cups: %.0f pcs", totalIngr[2]);
		pause();
		System.out.printf("\tCoffee: %.2f grams", totalIngr[3]);
		pause();
		System.out.printf("\tWater: %.2f fl", totalIngr[4]);
		pause();
		System.out.printf("\tMilk: %.2f fl\n", totalIngr[5]);

		System.out.println();

		/* Aggregate total. */
		System.out.printf("\nTotal amount of earnings: %.2f", combinedSales);
		System.out.println();


		/* Amount of orders for specific types of drinks as well as sizes.
		 * 0 = small, 1 = medium, 2 = large, 3 = cafe americano, 4 = latte, 5 = cappucino */
		System.out.printf("Total amount of sales: %f\n", combinedSales);
		System.out.println("\nOrder types:");

		pause();
		System.out.printf("\tCafe Americano: %d", transacType[3]);
		pause();
		System.out.printf("\tLatte: %d", transacType[4]);
		pause();
		System.out.printf("\tCappucino: %d", transacType[5]);

		System.out.println();
		System.out.println("Order sizes:");

		pause();
		System.out.printf("\tSmall: %d", transacType[0]);
		pause();
		System.out.printf("\tMedium: %d", transacType[1]);
		pause();
		System.out.printf("\tLarge: %d", transacType[2]);

		System.out.println();
	}

	/**
	 * Prints the screen when the user decides on what to do during maintenance
	 */
	public void printMaintenanceSelect(){
		AppView.clear();
		System.out.println("What would you like to do?");
		System.out.println("1 - Change location");
		System.out.println("2 - Set prices");
		System.out.println("3 - Exit");
		System.out.println();
		System.out.print(">> ");
	}

	/**
	 * Clears the console, for clarity purposes.
	 */
	public static void clear(){
		try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
	}

	/**
	 * Halts the program for .5 seconds.
	 * Used in printing statements.
	 */
	public static void pause(){		
			try {
			Thread.sleep(500); // Delay for 0.5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}