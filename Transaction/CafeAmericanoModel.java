package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Cup.*;

/**
 * Model for a transaction thats a cafe americano
 * Inherits AbstractTransactionModel
 */
public class CafeAmericanoModel extends AbstractTransactionModel {
	/**
	 * Constructor for a cafe americano
	 * @param size The size of the drink
	 */
	public CafeAmericanoModel(char size){
		super("cafe americano", size);

		espresso = new StandardBrew();
		espresso.brewEspresso(0, cup.getFl()*(1.0f/3.0f));
		drinkCost += espresso.getEspresso() * espresso.getPrice();

		Water water = new Water(cup.getFl()*(2.0f/3.0f));
		drinkCost += water.getPrice * water.getAmt();
		ingredients.add(water);
	}
}