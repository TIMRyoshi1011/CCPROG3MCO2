package Transaction;

import java.util.ArrayList;
import Ingredient.*;
import Cup.*;
import Espresso.*;

/**
 * Model for a transaction thats a cappucino
 * Inherits AbstractTransactionModel
 */
public class CappucinoModel extends AbstractTransactionModel {
	/**
	 * Constructor for a cappucino
	 * @param size The size of the drink
	 */
	public CappucinoModel(char size, Espresso espresso, int extraShots){
		super("cappucino", size);

		this.espresso = espresso;
		espresso.brewEspresso(extraShots, cup.getFl()*(1.0f/3.0f));
		drinkCost += espresso.getEspresso() * espresso.getPrice();

		Milk milk = new Milk(cup.getFl()*(2.0f/3.0f));
		drinkCost += milk.getPrice() * milk.getAmt();
		ingredients.add(milk);
	}

	/**
	 * Constructor for returnMenu()
	 * @param size The size of the cup
	 */
	public CappucinoModel(char size, char truckType) {
		this(size, (truckType == 'P' ? new LightBrew() : new StandardBrew()), 0);
	}
}