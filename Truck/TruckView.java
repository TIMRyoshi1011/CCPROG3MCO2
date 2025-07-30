package Truck;

import java.util.ArrayList;
import Transaction.*;
import App.*;
import StorageBin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
/**
 * A coffee truck's view
 */
public class TruckView {
	/** The appview, used to change the frame and switch cards */
	private AppView appView;

	/** Panel for setting storageBins */
	private JPanel setStorageBinsPanel;

	/** Panel for selecting what to do with storageBin */
	private JPanel storageBinActionSelection;

	/** Panel for changing contents of storagebin */
	private JPanel changeBinContentsPanel;

	/** Panel for replenishing the bins */
	private JPanel replenishPanel;

	/**
	 * Constructor for truckview, setting the appview
	 */
	public TruckView(AppView appView){
		this.appView = appView;
	}

	/**
	 * Prints a feedback label
	 */
	public void printFeedback(String feedback){
		System.out.println(feedback);
	}

	/**
	 * Prints the screen when the user is looking at a trucks storage bin inventory,
	 * with the intent of changing its contents. 
	 * @param bins The bins to be printed
	 * @param binselectAction the actionListener for when a bin gets clicked
	 * @param endAction the actionlistener for when 
	 */
	public void showSetStorageBins(ArrayList<StorageBin> bins, ActionListener binSelectAction, ActionListener endAction) {
		setStorageBinsPanel = new JPanel();
		setStorageBinsPanel.setLayout(new BoxLayout(setStorageBinsPanel, BoxLayout.Y_AXIS));
		setStorageBinsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		setStorageBinsPanel.add(new JLabel("Here are the current contents of your storage bins:"));
		setStorageBinsPanel.add(Box.createVerticalStrut(10));

		// Add one button per bin
		int counter = 1;
		for (StorageBin bin : bins) {
			String binInfo = String.format("BIN #%d - %s", counter, bin.getBinInfo());

			JButton binButton = new JButton("Edit Bin #" + counter);
			binButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			binButton.putClientProperty("binIndex", counter - 1); // Store the index (0-based)

			binButton.addActionListener(binSelectAction);

			setStorageBinsPanel.add(new JLabel(binInfo));
			setStorageBinsPanel.add(binButton);
			setStorageBinsPanel.add(Box.createVerticalStrut(10));

			counter++;
		}

		// Exit button at bottom
		JButton endButton = new JButton("Done");
		endButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		endButton.addActionListener(endAction);

		setStorageBinsPanel.add(Box.createVerticalStrut(20));
		setStorageBinsPanel.add(endButton);

		JScrollPane scrollPane = new JScrollPane(setStorageBinsPanel);
		scrollPane.setBorder(null); // Optional: remove border to match aesthetic
		scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smoother scrolling

		// Add the scroll pane instead of the plain panel
		appView.addPanel(scrollPane, "setStorageBins");
		appView.showPanel("setStorageBins");
	}


	/**
	 * Prints the screen when a storage bin is being edited
	 * @param bin The bin being edited.
	 * @param isEmpty Boolean checking if a bin is empty
	 */
	public void showEditBin(StorageBin bin, boolean isEmpty, ActionListener setBinAction, 
                        ActionListener replenishAction, ActionListener emptyAction, 
                        ActionListener exitAction){

		storageBinActionSelection = new JPanel();
		storageBinActionSelection.setLayout(new BoxLayout(storageBinActionSelection, BoxLayout.Y_AXIS));
		storageBinActionSelection.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

	    JButton setBinBtn = new JButton("Set bin contents");
	    setBinBtn.addActionListener(setBinAction);
	    storageBinActionSelection.add(setBinBtn);

	    if (!isEmpty){
		    JButton replenishBinBtn = new JButton("Replenish bin contents");
		    replenishBinBtn.addActionListener(replenishAction);
		    storageBinActionSelection.add(replenishBinBtn);


		    JButton emptyBinBtn = new JButton("Empty bin contents");
		    emptyBinBtn.addActionListener(emptyAction);
		    storageBinActionSelection.add(emptyBinBtn);
	    }

	    JButton exitBtn = new JButton("Exit");
	    exitBtn.addActionListener(exitAction);
	    storageBinActionSelection.add(exitBtn);

	    appView.addPanel(storageBinActionSelection, "storageBinActionSelection");
		appView.showPanel("storageBinActionSelection");
	}

	/**
	 * Prints the max quantity of each ingredient. 
	 * @param actions The actionlisteners for the buttons
	 */
	public void showSetStorageBin(ArrayList<ActionListener> actions){
		changeBinContentsPanel = new JPanel();
		changeBinContentsPanel.setLayout(new BoxLayout(changeBinContentsPanel, BoxLayout.Y_AXIS));
		changeBinContentsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		changeBinContentsPanel.add(new JLabel("Max. capacity of each ingredient:"));

		String[] ingredients = {
			"Small Cup - 80pcs",
			"Medium Cup - 64pcs",
			"Large Cup - 40pcs",
			"Coffee Beans - 1008grams",
			"Milk - 640fl",
			"Water - 640fl",
			"Syrups - 500fl"
		};

		String[] keys = {"Small Cup", "Medium Cup", "Large Cup", "Coffee", "Milk", "Water", "Syrup"};

		for (int i = 0; i < ingredients.length; i++) {
			JPanel row = new JPanel();
			row.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel label = new JLabel(ingredients[i]);
			JTextField amtField = new JTextField(5);
			JButton button = new JButton("Set");

			button.setActionCommand(keys[i]);
			button.putClientProperty("inputField", amtField);
			button.addActionListener(actions.get(i));

			row.add(label);
			row.add(new JLabel("Amount:"));
			row.add(amtField);
			row.add(button);
			changeBinContentsPanel.add(row);
			changeBinContentsPanel.add(Box.createVerticalStrut(5));

			appView.addPanel(changeBinContentsPanel, "setBin");
		}

		appView.showPanel("setBin");
	}



















	

	/**
	 * Prints the base info (location, type) of a truck.
	 * @param type The type of the truck to be printed
	 * @param location The location of the truck to be printed
	 */
	public void printTruckBaseInfo(char type, String location){
		System.out.printf("Type: %c || Location: %s\n", type, location);
	}

	/**
	 * Prints the bin info of a truck
	 * @param truck The truck whos bin info is gonna be printed.
	 */
	public void printTruckBinInfo(ArrayList<StorageBin> bins){
		int counter = 1;
		System.out.println("Storage bins contain...");

		for (StorageBin bin : bins) {
			System.out.printf("Storage bin #%d - ", (counter));
			bin.getBinInfo();
			System.out.println();
			counter++;

			
		}
	}

	/**
	 * Shows the screen when the user is replenishing the contents of the bin
	 * @param onSubmit runs upon the user submitting their input, tells controllers to use input
	 * @param onCancel runs when the user cancels from replenishing
	 @*/
	public void showReplenishBinForm(ActionListener onSubmit, Runnable onCancel) {
		JPanel replenishPanel = new JPanel();
		replenishPanel.setLayout(new BoxLayout(replenishPanel, BoxLayout.Y_AXIS));
		replenishPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		replenishPanel.add(new JLabel("What is the new quantity of the item?"));

		JPanel inputRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField inputField = new JTextField(10);
		JButton submitBtn = new JButton("Replenish");

		submitBtn.putClientProperty("inputField", inputField);
		submitBtn.addActionListener(onSubmit);

		inputRow.add(new JLabel("Amount:"));
		inputRow.add(inputField);
		inputRow.add(submitBtn);
		replenishPanel.add(inputRow);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(e -> onCancel.run());
		replenishPanel.add(Box.createVerticalStrut(10));
		replenishPanel.add(cancelBtn);

		appView.addPanel(replenishPanel, "replenishBin");
		appView.showPanel("replenishBin");
	}

	/**
	 * Prints the full info of a truck. Transaction, type, location, menu, and bins
	 * @param type The type of the truck
	 * @param location the location of the truck
	 * @param bins the storage bins of the truck
	 * @param transacs The transactions of the truck
	 * @param menu The menu of the truck
	 */
	public void printTruckFullInfo(char type, String location, ArrayList<StorageBin> bins,
		ArrayList<TransactionController> transacs, ArrayList<String> menu){
		
		printTruckBaseInfo(type, location);
		printTruckBinInfo(bins);

		System.out.println("\nMenu: ");
		printMenu(menu);
		
		System.out.println("\nTransactions: ");
		for (TransactionController transaction : transacs){
			transaction.printTransaction();
		}
	}

	/**
	 * Prints the contents of the menu
	 * @param menu The menu to be printed
	 */
	public void printMenu(ArrayList<String> menu) {
		System.out.println("AVAILABLE ITEMS:");

		for (String item : menu) {
			System.out.println(item);
		}
		System.out.println();
	}
}