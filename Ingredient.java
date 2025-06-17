/**
 * Repressents the ingredient.
 * A variable in the StorageBin and Transaction class.
 * Contains static attributes for the prices of all ingredients.
 * For the sake of simplicity, cups are also considered ingredients.
 * @author Coby Luna & Marcus Ramos
 */
public class Ingredient{
	/** The ingredient type of this specific ingredient instance. 
	 * In the StorageBin class, if the bin is empty the type is defaulted to "EMPTY"*/
	private String ingredientType;
	/** In the StorageBin class, this represents the amount of ingredients in the storage bin.
 	 * In the Transaction class, this represents the amount of ingredients in the drink. */
	private float ingredientAmt;

	/** Static variable for the price of 1 small cup. */
	private static float smallCupPrice;
	/** Static variable for hte price of 1 medium cup. */
	private static float mediumCupPrice;
	/** Static variable for the price of 1 large cup. */
	private static float largeCupPrice;

	/** Static variable for the price of 1 gram of coffeebeans. */
	private static float coffeePrice;
	/** Static variable for the price of 1 fl of milk. */
	private static float milkPrice;
	/** Static variable for the price of 1 fl of water. */
	private static float waterPrice;

	/** 
 	 * Ingredient constructor. Ingredient is typically instantiated in StorageBin and Transaction class. 
 	 * @param type The type of ingredient ("Small cup", "Medium cup", "Large cup", "Coffee", "Milk", "Water")
   	 * @param amt The amount of the ingredient.
 	 */
	public Ingredient(String type, float amt){
		this.ingredientType = type;
        	this.ingredientAmt = amt;
	}

	/** 
 	 * Sets the price of the ingredient. Price is static and affects all Ingredient instances. 
   	 * @param type The ingredient type that will have a new price.
     	 * @param price The new price
	 */
	public void setPrice(String type, float price){
		switch (type.toLowerCase()) {
	            case "small": 
			smallCupPrice = price; 
			break;
	
	            case "medium": 
			mediumCupPrice = price; 
			break;

	            case "large": 
			largeCupPrice = price; 
			break;
	
	            case "coffee": 
			coffeePrice = price; 
			break;
	
	            case "milk": 
			milkPrice = price; 
			break;
					
	            case "water": 
			waterPrice = price; 
			break;
	        }
	}
		
	/** 
 	 * Returns the type of ingredient in the StorageBin or Transaction instance. 
   	 * @return The type of the ingredient
     	 */
	public String getType(){
		return ingredientType;
	}

	/** 
 	 * Returns the amount of ingredient in the StorageBin or Transaction instance. 
   	 * @return The amount of ingredient in the instance.
     	 */
	public float getAmt(){
		return ingredientAmt;
	}

	/**
	 * Returns the price of an ingredient
  	 * @param type The ingredient who's price will be returned.
    	 * @return The price of the ingredient.
      	 */
	public float getPrice(String type){
		switch (type.toLowerCase()) {
		    case "small": 
			return smallCupPrice;
	
		    case "medium": 
			return mediumCupPrice;
	
		    case "large": 
			return largeCupPrice;
	
		    case "coffee": 
			return coffeePrice;
	
		    case "milk": 
			return milkPrice;
	
		    case "water": 
			return waterPrice;
	
		    default: 
			return 0;
	        }
	}
}
