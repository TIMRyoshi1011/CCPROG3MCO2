import App.*;
import Truck.*;
import Transaction.*;
import StorageBin.*;
import Ingredient.*;
import Espresso.*;
import Cup.*;

/**
 * The main java file. This is the file to run when running the program.
 * No real functions happen, this is mostly just so the AppController, model, and view can be initialized.
 */
public class main{
	/** Controller for the main app. */
	private static AppController appC;

	/**
	 * Main function. Function that is called when program is run.
	 * Initializes the main apps' MVC.
	 */
	public static void main(String args[]){
		AppModel appM = new AppModel();
		AppView appV = new AppView();
		appC = new AppController(appM, appV);

		//appC.mainMenu();
	}
}
