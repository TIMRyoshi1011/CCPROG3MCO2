package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Cup.*;
import Espresso.*;

/**
 * Model for a transaction thats a latte
 * Inherits AbstractTransactionModel
 */
public class LatteModel extends AbstractTransactionModel {
	/**
	 * Constructor for a latte
	 * @param size The size of the drink
	 */
	public LatteModel(char size, Espresso espresso, int extraShots){
		super("latte", size);

		this.espresso = espresso;
		espresso.brewEspresso(extraShots, cup.getFl()*(1.0f/5.0f));
		drinkCost += espresso.getEspresso() * espresso.getPrice();

		Milk milk = new Milk(cup.getFl()*(4.0f/5.0f));
		drinkCost += milk.getPrice() * milk.getAmt();
		ingredients.add(milk);
	}
}