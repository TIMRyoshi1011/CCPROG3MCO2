package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Cup.*;
import Espresso.*;

/**
 * Model for a transaction thats a cafe americano
 * Inherits AbstractTransactionModel
 */
public class CafeAmericanoModel extends AbstractTransactionModel {
	/**
	 * Constructor for a cafe americano
	 * @param size The size of the drink
	 */
	public CafeAmericanoModel(char size, Espresso espresso, int extraShots){
		super("cafe americano", size);

		this.espresso = espresso;
		espresso.brewEspresso(extraShots, cup.getFl()*(1.0f/3.0f));
		drinkCost += espresso.getEspresso() * espresso.getPrice();

		Water water = new Water(cup.getFl()*(2.0f/3.0f));
		drinkCost += water.getPrice() * water.getAmt();
		ingredients.add(water);
	}

	/**
	 * Constructor for returnMenu()
	 * @param size The size of the cup
	 */
	public CafeAmericanoModel(char size) {
	    this(size, new StandardBrew(), 0);  // default to standard, no extra shots
	}
}