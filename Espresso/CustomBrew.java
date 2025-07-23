package Espresso;

/**
 * Class for a custom brew (1/? ratio of coffee and water)
 */
public class CustomBrew extends Espresso{
	/**
	 * Constructor for custom brew
	 */
	public CustomBrew(int waterRatio){
		super(waterRatio, "Custom Brew");
	}
}