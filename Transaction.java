import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a transaction.
 * A list of all transactions is recorded in all coffee trucks.
 * Records the type, ingredients used, and cost of a transation.
 * @author Coby Luna & Marcus Ramos
 */
public class Transaction{
	/** Character representation of drink size. */
	private char drinkSize;
	/** String representation of drink type. */
	private String drinkType;
	/** The total cost of the drink. */
	private float drinkCost;
	/** ArrayList of all ingredients used in the transaction. */
	private ArrayList<Ingredient> ingredients;

	/**
 	 * Construction for transaction.
   	 * Upon construction all transaction details are calculated, including ingredient amount and cost.
     	 * @param type The drink type
       	 * @param size The size of the drink. 
	 */
	public Transaction(String type, String size){
		int sizeFl;

		this.drinkType = type;
        this.drinkSize = size.charAt(0);
        this.drinkCost = 0;
        this.ingredients = new ArrayList<Ingredient>();

        switch(size.toLowerCase()){
        	case "s": sizeFl = 8; ingredients.add(new Ingredient("scup", 1)); break;
        	case "m": sizeFl = 12; ingredients.add(new Ingredient("mcup", 1)); break;
        	case "l": sizeFl = 16; ingredients.add(new Ingredient("lcup", 1)); break;
        	default: sizeFl = 0; break;
        }

        /* 1/3 espresso, 2/3 water */
        if (type.equalsIgnoreCase("cafe americano")){
        	ingredients.add(new Ingredient("coffee", (float)(sizeFl*(1.0/3.0)*(1.0/19.0) * 28.34952)));
        	ingredients.add(new Ingredient("water", (float)((sizeFl*(1.0/3.0)*(18.0/19.0)) + (sizeFl*(2.0/3.0)))));
		}

		/* 1/5 espresso, 4/5 milk */
		else if (type.equalsIgnoreCase("latte")){
			ingredients.add(new Ingredient("coffee", (float)((sizeFl*(1.0/5.0)*(1.0/19.0) * 28.34952))));
			ingredients.add(new Ingredient("water", (float)(sizeFl*(1.0/5.0)*(18.0/19.0))));
			ingredients.add(new Ingredient("milk", (float)(sizeFl*(4.0/5.0))));
		}

		/* 1/5 espresso, 4/5 milk */
		else if (type.equalsIgnoreCase("cappucino")){
			ingredients.add(new Ingredient("coffee", (float)(sizeFl*(1.0/3.0)*(1.0/19.0) * 28.34952)));
			ingredients.add(new Ingredient("water", (float)(sizeFl*(1.0/3.0)*(18.0/19.0))));
			ingredients.add(new Ingredient("milk", (float)(sizeFl*2.0/3.0)));
		}

		Iterator<Ingredient> it = ingredients.iterator();
		Ingredient tempIngr;

		while (it.hasNext()){
			tempIngr = it.next();
			this.drinkCost += Ingredient.getPrice(tempIngr.getType()) * tempIngr.getAmt();
		}
	}

	/**
 	 * Returns the price of the transation.
   	 * @return Price of the transaction
     	 */
	public float getPrice(){
		return drinkCost;
	}

	/**
	 * Returns the list of ingredients used in the transaction.
	 * @return The list of ingredients used in the transaction.
	 */
	public ArrayList<Ingredient> getIngredients(){
		return ingredients;
	}

	/**
 	 * Prints all transaction info.
   	 */
	public void printTransaction(){
		System.out.println("Drink: " + drinkType + ", Size: " + drinkSize + ", Cost: " + drinkCost + "\n");
	}

	/**
	 * Prints transaction brewing simulation.
	 */
	public void printBrew(){
		float sizeFl;
		float coffeeAmt = 0, waterAmt = 0, milkAmt = 0;

		for (Ingredient ingr : ingredients){
			switch (ingr.getType()) {
				case "coffee": coffeeAmt = ingr.getAmt(); break;
				case "water": waterAmt = ingr.getAmt(); break;
				case "milk":  milkAmt = ingr.getAmt(); break;
			}
		}

		switch (drinkSize){
			case 's': sizeFl = 8; break;
			case 'm': sizeFl = 12; break;
			case 'l': sizeFl = 16; break;
			default: System.out.println("error"); sizeFl = 1; break;
		}

		switch (drinkType.toLowerCase()){
			case "cafe americano": 
				/* 1/3rds espresso, 2/3rds water. */
				System.out.printf("Brewing %.2f fl espresso...\n", (sizeFl/(1.0/3.0)));
				JavaJeep.pause();
				System.out.printf("\t%.2f grams of coffee...\n", ingredients.get(1).getAmt());
				JavaJeep.pause();
				System.out.printf("\t%.2f fl of water...\n", (sizeFl/((1.0/3.0)/(18.0/19.0))));
				JavaJeep.pause();
				System.out.printf("Adding %.2f fl of water...\n\n", (sizeFl/(2.0/3.0)));
				JavaJeep.pause();
				break;

			case "latte": 
				/* 1/5ths espresso, 4/5ths milk. */
				System.out.printf("Brewing %.2f fl espresso...\n", (sizeFl/(1.0/5.0)));
				JavaJeep.pause();
				System.out.printf("\t%.2f grams of coffee...\n", ingredients.get(1).getAmt());
				JavaJeep.pause();
				System.out.printf("\t%.2f fl of water...\n", ingredients.get(2).getAmt());
				JavaJeep.pause();
				System.out.printf("Adding %.2f fl of milk...\n\n", ingredients.get(3).getAmt());
				JavaJeep.pause();
				break;

			case "cappucino": 
				/* 1/3rds espresso 2/3rds milk. */
				System.out.printf("Brewing %.2f fl espresso...\n", (sizeFl/(1.0/3.0)));
				JavaJeep.pause();
				System.out.printf("\t%.2f grams of coffee...\n", ingredients.get(1).getAmt());
				JavaJeep.pause();
				System.out.printf("\t%.2f fl of water...\n", ingredients.get(2).getAmt());
				JavaJeep.pause();
				System.out.printf("Adding %.2f of milk...\n\n", ingredients.get(3).getAmt());
				JavaJeep.pause();
				break;
		}

		switch(drinkSize){
			case 's': System.out.print("Small"); break;
			case 'm': System.out.print("Medium"); break;
			case 'l': System.out.print("Large"); break;
		}

		System.out.printf(" %s successfully brewed!\n", drinkType);
	}
}

