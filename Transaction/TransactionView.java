package Transaction;

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
	 * @param espresso Amt of espresso
	 * @param coffee Amt of coffee
	 * @param esWater Amt of water in espresso brew
	 * @param water Amt of water outside of espresso brew
	 */
	public void brewAmericano(String size, float espresso, float coffee, float esWater, float water){
		/* 1/3rds espresso, 2/3rds water. */
		System.out.printf("Brewing %.2f fl espresso...\n", espresso);
		AppView.pause();
		System.out.printf("\t%.2f grams of coffee...\n", coffee);
		AppView.pause();
		System.out.printf("\t%.2f fl of water...\n", esWater);
		AppView.pause();
		System.out.printf("Adding %.2f fl of water...\n\n", water);
		AppView.pause();

		System.out.printf("%s cafe americano successfully brewed!\n", size);
	}

	/**
	 * Prints transaction brewing simulation for lattes.
	 * @param size Size of the drink
	 * @param espresso Amt of espresso
	 * @param coffee Amt of coffee
	 * @param water Amt of water
	 * @param milk Amt of milk
	 */
	public void brewLatte(String size, float espresso, float coffee, float water, float milk){
		/* 1/5ths espresso, 4/5ths milk. */
		System.out.printf("Brewing %.2f fl espresso...\n", espresso);
		AppView.pause();
		System.out.printf("\t%.2f grams of coffee...\n", coffee);
		AppView.pause();
		System.out.printf("\t%.2f fl of water...\n", water);
		AppView.pause();
		System.out.printf("Adding %.2f fl of milk...\n\n", milk);
		AppView.pause();

		System.out.printf("%s latte successfully brewed!\n", size);
	}

	/**
	 * Prints transaction brewing simulation for cappucino.
	 * @param size Size of the drink
	 * @param espresso Amt of espresso
	 * @param coffee Amt of coffee
	 * @param water Amt of water
	 * @param milk Amt of milk
	 */
	public void brewCappucino(String size, float espresso, float coffee, float water, float milk){
		/* 1/3rds espresso 2/3rds milk. */
		System.out.printf("Brewing %.2f fl espresso...\n", espresso);
		AppView.pause();
		System.out.printf("\t%.2f grams of coffee...\n", coffee);
		AppView.pause();
		System.out.printf("\t%.2f fl of water...\n", water);
		AppView.pause();
		System.out.printf("Adding %.2f fl of milk...\n\n", milk);
		AppView.pause();

		System.out.printf("%s cappucino successfully brewed!\n", size);
	}
}