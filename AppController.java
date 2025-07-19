import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller for the main app interface.
 */
public class AppController {
	/** Model for main app interface. */
	private AppModel model;
	/** View for main app interface. */
	private AppView view;

	/**
	 * Constructor for the AppController.
	 * @param model The model of the controller.
	 * @param view the view of the controller.
	 */
	public AppController (AppModel model, AppView view){
		this.model = model;
		this.view = view;
	}

	/**
	 * The main menu of the whole app. It lets the user pick between the different app functions.
	 */
	public void mainMenu(){
		String input;
		int choice = 0;
		Scanner scan = new Scanner(System.in);

		while (choice != 4){
			view.printMain();

			input = scan.nextLine();
			choice = model.toInt(input);

			switch(choice){
			case 1:
				// create truck
				break;
			case 2:
				// simulate truck
				break;
			case 3:
				// dashboard
				break;
			case 4:
				// exit
				view.printFeedback("Thank you for using JavaJeeps!");
				break;
			default:
				// invalid input
				view.printFeedback("Invalid option, please try again: ");
				break;
			}
		}

		scan.close();
		System.exit(0); // Terminates the program
	}
}