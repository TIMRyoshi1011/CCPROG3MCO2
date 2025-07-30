package App;

import java.util.ArrayList;
import Truck.*;
import Ingredient.*;
import Cup.*;
import Espresso.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import java.util.HashMap;

/**
 * View for the main interface
 */
public class AppView extends JFrame {
    /** Holds the cardlayout */
    private JPanel cardPanel;
    /** Cardlayout to be used to switch between screens */
    private CardLayout cardLayout;
    /** Reusable textarea */
    private JTextArea outputArea;

    /** JPanel for main menu */
    private JPanel mainMenuPanel;
    /** Buttons for main menu */
    private JButton createButton, simulateButton, dashboardButton, exitButton;

    /** JPanel for setting truck type */
    private JPanel setTypePanel;
    /** Buttons for setting type */
    private JButton plusButton, regularButton;

    /** JPanel for setting truck location */
    private JPanel setLocationPanel;

    /**
     * Constructor for AppView. Sets all GUI components.
     */
    public AppView(){
        super("JavaJeeps!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        add(cardPanel, BorderLayout.CENTER);

        outputArea = new JTextArea(6, 50);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Outputs a feedback message
     * @param msg Message to be shown
     */
    public void setOutput(String msg) {
        outputArea.setText(msg); // already there, shows messages
    }

    /**
     * Adds a Panel to the cardlayout. Used mostly by other View files.
     * @param panel the Panel to be added
     * @param name The label to be given to the panel
     */
    public void addPanel(JComponent panel, String name){
    	cardPanel.add(panel, name);
    }

    /**
     * Shows a panel on the cardlayout. Used mostly by other View files.
     * @param name The label of the panel to be shown
     */
    public void showPanel(String name){
    	cardLayout.show(cardPanel, name);
    }

    /**
     * For the main menu that the user sees upon opening the program
     * @param actions ActionListener for each respective button controlled by the controller.
     */
    public void showMainMenu(ActionListener[] actions) {
        if (mainMenuPanel == null) {
            mainMenuPanel = new JPanel(new GridLayout(5, 1));
	        mainMenuPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

            mainMenuPanel.add(new JLabel("Welcome to JavaJeeps! Select an Option:"));

            createButton = new JButton("Create a coffee truck");
            simulateButton = new JButton("Simulate a coffee truck");
            dashboardButton = new JButton("Dashboard");
            exitButton = new JButton("Exit");

            createButton.addActionListener(actions[0]);
            simulateButton.addActionListener(actions[1]);
            dashboardButton.addActionListener(actions[2]);
            exitButton.addActionListener(actions[3]);

            mainMenuPanel.add(createButton);
            mainMenuPanel.add(simulateButton);
            mainMenuPanel.add(dashboardButton);
            mainMenuPanel.add(exitButton);

            cardPanel.add(mainMenuPanel, "main");
        }

        cardLayout.show(cardPanel, "main");
    }

    /**
     * Shows the panel that is for setting the type of the truck.
     * @param actions ActionListener for each respective button controlled by the controller
     */
    public void showSetType(ActionListener[] actions){
        if (setTypePanel == null){
            setTypePanel = new JPanel(new GridLayout(5, 1));
	        setTypePanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

            setTypePanel.add(new JLabel("Select the truck type:"), BorderLayout.NORTH);

            plusButton = new JButton("Plus Truck");
            regularButton = new JButton("Regular Truck");

            plusButton.addActionListener(actions[0]);
            regularButton.addActionListener(actions[1]);

            setTypePanel.add(plusButton);
            setTypePanel.add(regularButton);

            cardPanel.add(setTypePanel, "setType");
        }

        cardLayout.show(cardPanel, "setType");
    }

    /**
     * Shows the screen when the type's location is being set.
     */
    public void showSetLocation(ActionListener confirmAction){
        if (setLocationPanel == null){
        	setLocationPanel = new JPanel();
			setLocationPanel.setLayout(new BoxLayout(setLocationPanel, BoxLayout.Y_AXIS));
	        setLocationPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

            setLocationPanel.add(new JLabel("What location do you want your truck to stay in?"), BorderLayout.NORTH);
            setLocationPanel.add(new JLabel("To keep business efficient, we're limiting it to one truck per city!"));


            JTextField locationField = new JTextField();
            locationField.setMaximumSize(new Dimension(200, 25));
            JButton confirmButton = new JButton("Confirm");

            confirmButton.setActionCommand("confirmLocation");
            confirmButton.addActionListener(e -> {
                confirmButton.putClientProperty("location", locationField.getText());
                confirmAction.actionPerformed(e);
            });

            setLocationPanel.add(locationField);
            setLocationPanel.add(confirmButton);

            cardPanel.add(setLocationPanel, "setLocation");
        }

        cardLayout.show(cardPanel, "setLocation");
    }

    /**
     * Panel for when the price is being edited 
     * @param prices HashMap of the current ingredients and their prices
     * @param updateListener Actionlistener for when a price is edited
     * @param doneListener ActionListener when the user is done with the showEditPricesPanel
     */
	public void showEditPricesPanel(
	    HashMap<String, Float> prices,
	    ArrayList<ActionListener> setPriceActions,
	    ActionListener doneListener
	) {
	    JPanel editPricesPanel = new JPanel();
	    editPricesPanel.setLayout(new BoxLayout(editPricesPanel, BoxLayout.Y_AXIS));
	    editPricesPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

	    editPricesPanel.add(new JLabel("Set Ingredient Prices (Applies to ALL trucks):"));
	    editPricesPanel.add(Box.createVerticalStrut(10));

	    int index = 0;
	    for (HashMap.Entry<String, Float> entry : prices.entrySet()) {
	        String ingredient = entry.getKey();
	        Float currentPrice = entry.getValue();

	        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel label = new JLabel(ingredient + " (Current: " + String.format("%.2f", currentPrice) + ")");
	        JTextField priceField = new JTextField(5);
	        JButton setButton = new JButton("Set");

	        setButton.setActionCommand(ingredient);
	        setButton.putClientProperty("priceField", priceField);
	        setButton.addActionListener(setPriceActions.get(index++));

	        row.add(label);
	        row.add(new JLabel("New Price:"));
	        row.add(priceField);
	        row.add(setButton);

	        editPricesPanel.add(row);
	        editPricesPanel.add(Box.createVerticalStrut(5));
	    }

	    // Done button at the bottom
	    JButton doneButton = new JButton("Done");
	    doneButton.addActionListener(doneListener);
	    JPanel donePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    donePanel.add(doneButton);

	    editPricesPanel.add(Box.createVerticalStrut(10));
	    editPricesPanel.add(donePanel);

	    cardPanel.add(editPricesPanel, "editPrices");
	    cardLayout.show(cardPanel, "editPrices");
	}




















    /**
     * Prints the screen allowing the user to pick a truck
     * @param trucks Arraylist of trucks to print
     */
    public void printTruckOptions(ArrayList<TruckController> trucks){
        int count = 1;

        clear();

        System.out.println("Choose a truck!"); 
        for (TruckController truck : trucks){
            System.out.printf("#%d || ", count);
            //truck.truckBaseInfo();
            count++;
        }
        System.out.println("Enter \"END\" to exit.");
    }

    /**
     * Prints the options the user can pick from when simulating a truck.
     */
    public void printSimulateOptions(){
        clear();

        System.out.println("What would you like to do?");
        System.out.println("1 - Simulate sale");
        System.out.println("2 - View truck information");
        System.out.println("3 - Manage bins");
        System.out.println("4 - Maintenance");
        System.out.println("5 - Exit");
        System.out.println();
    }

    /**
     * Prints the dashboard
     * @param trucks The arraylist of trucks
     * @param totalIngr Array containing amount of all ingredients
     * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee
     * @param combinedSales Total earnings of all trucks
     * @param transacType Total amount of all types of drinks made
     */
    public void printDashboard(ArrayList<TruckController> trucks, float[] totalIngr, float combinedSales, int[] transacType){
        clear();
        System.out.println("ALL TRUCKS:");

        /* Prints all trucks' base info */
        //for (TruckController truck : trucks) truck.truckBaseInfo();

        /* Prints aggregate amount of ingredients all trucks have. 
         * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee */
        System.out.println();
        System.out.println();
        System.out.println("Total amount of ingredients in all trucks:");

        System.out.printf("\tSmall Cups: %.0f pcs", totalIngr[0]);
        System.out.printf("\tMedium Cups: %.0f pcs", totalIngr[1]);
        System.out.printf("\tLarge Cups: %.0f pcs", totalIngr[2]);
        System.out.printf("\tCoffee: %.2f grams", totalIngr[3]);
        System.out.printf("\tWater: %.2f fl", totalIngr[4]);
        System.out.printf("\tMilk: %.2f fl\n", totalIngr[5]);

        System.out.println();

        /* Aggregate total. */
        System.out.printf("\nTotal amount of earnings: %.2f", combinedSales);
        System.out.println();


        /* Amount of orders for specific types of drinks as well as sizes.
         * 0 = small, 1 = medium, 2 = large, 3 = cafe americano, 4 = latte, 5 = cappucino */
        System.out.printf("Total amount of sales: %f\n", combinedSales);
        System.out.println("\nOrder types:");

        System.out.printf("\tCafe Americano: %d", transacType[3]);
        System.out.printf("\tLatte: %d", transacType[4]);
        System.out.printf("\tCappucino: %d", transacType[5]);

        System.out.println();
        System.out.println("Order sizes:");

        System.out.printf("\tSmall: %d", transacType[0]);
        System.out.printf("\tMedium: %d", transacType[1]);
        System.out.printf("\tLarge: %d", transacType[2]);

        System.out.println();
    }

    /**
     * Prints the screen when the user decides on what to do during maintenance
     */
    public void printMaintenanceSelect(){
        AppView.clear();
        System.out.println("What would you like to do?");
        System.out.println("1 - Change location");
        System.out.println("2 - Set prices");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.print(">> ");
    }

    /**
     * Clears the console, for clarity purposes.
     */
    public static void clear(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }



    public void printFeedback(String msg){
        System.out.println(msg);
    }
}