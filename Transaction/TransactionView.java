package Transaction;

import java.util.ArrayList;
import App.*;

/**
 * View of a transaction.
 */
public class TransactionView{
	/**
 	 * Prints all transaction info.
 	 * @param drinkType The type of drink
 	 * @param drinkSize The size of the drink
 	 * @param drinkCost The cost of the drink.
   	 */
	public void printTransaction(String drinkType, char drinkSize, float drinkCost){
		System.out.printf("Drink: %s, Size: %c, Cost %.2f", drinkType.substring(0, 1).toUpperCase() + drinkType.substring(1), Character.toUpperCase(drinkSize), drinkCost);
	}

	/**
	 * Prints transaction brewing simulation for americanos.
	 * @param size Size of the drink
	 * @param type The type of drink
	 * @param espresso Amt of espresso
	 * @param coffee Amt of coffee
	 * @param water Amt of water in espresso brew
	 * @param ingredients Ingredients other than espresso.
	 */
	public void brewDrink(String size, String type, float espresso, float coffee, 
		float water, ArrayList<Ingredient> ingredients){

		System.out.printf("Brewing %.2f fl espresso...\n", espresso);
		AppView.pause();
		System.out.printf("\t%.2f grams of coffee...\n", coffee);
		AppView.pause();
		System.out.printf("\t%.2f fl of water...\n", esWater);
		AppView.pause();

		for (Ingredient ingr : ingredients){
			System.out.printf("Adding %.2f fl of %s...\n\n", ingr.getAmt(), ingr.getType().toLowerCase());
			AppView.pause();
		}

		System.out.printf("%s %s successfully brewed!\n", size, type);
	}
}