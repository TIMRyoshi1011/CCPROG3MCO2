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

/**
 * View for the main app interface
 */
public class AppView extends JFrame { 
	protected JPanel mainPanel;			//panels must be protected to be accessed by the controller
	protected JPanel headerPanel;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;

	private JButton createBtn = new JButton("Create Truck");
	private JButton simulateBtn = new JButton("Simulate Truck");
	private JButton dashboardBtn = new JButton("Dashboard");

	private JButton javaJeepS = new JButton("JavaJeep+");
    private JButton javaJeepR = new JButton("JavaJeep");

    protected JTextField location = new JTextField(20);
	private JButton proceed = new JButton("Proceed");

	private JButton bin1 = new JButton("BIN #1");
	private JButton bin2 = new JButton("BIN #2");;
	private JButton bin3 = new JButton("BIN #3");;
	private JButton bin4 = new JButton("BIN #4");;	
	private JButton bin5 = new JButton("BIN #5");;
	private JButton bin6 = new JButton("BIN #6");;
	private JButton bin7 = new JButton("BIN #7");;
	private JButton bin8 = new JButton("BIN #8");;
	private JButton nxt = new JButton(">");

	protected JTextField amount = new JTextField(20);
	private JButton enter = new JButton("Enter");

	private JButton sCup = new JButton("Small Cup");
    private JButton mCup = new JButton("Medium Cup");
    private JButton lCup = new JButton("Large Cup");
    private JButton cBns = new JButton("Coffee Beans");
    private JButton dMlk = new JButton("Milk");
    private JButton dWtr = new JButton("Water");

    protected JTextField price = new JTextField(15);

    private JButton save = new JButton("Save");;
	private JButton confirm = new JButton("Confirm");

	private JButton mainMenu = new JButton("Main Menu");

	protected JTextField toSimulate = new JTextField(10);
	private JButton next = new JButton("Next");

	private JButton choice1 = new JButton("Simulate Sale");;
    private JButton choice2 = new JButton("View Truck Information");
    private JButton choice3 = new JButton("Manage Bins");
    private JButton choice4 = new JButton("Maintenance");
	private JButton choice5 = new JButton("Back to Main Menu");
	private JButton bReturn = new JButton("Return");

	private JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");

	protected JTextField drink = new JTextField(20);;

    private JButton small = new JButton("Small");
    private JButton medium = new JButton("Medium");
    private JButton large = new JButton("Large");

	private JButton bBack = new JButton("Back");

	protected JTextField mLocation = new JTextField(20);

    private JButton mContinue = new JButton("Continue");

	private JButton sconfirm = new JButton("confirm");

	private JButton back = new JButton("<");

	private JButton sbin1 = new JButton("BIN 1");
	private JButton sbin2 = new JButton("BIN 2");
	private JButton sbin3 = new JButton("BIN 3");
	private JButton sbin4 = new JButton("BIN 4");
	private JButton sbin5 = new JButton("BIN 5");
	private JButton sbin6 = new JButton("BIN 6");
	private JButton sbin7 = new JButton("BIN 7");
	private JButton sbin8 = new JButton("BIN 8");

	private JButton prev = new JButton("Previous");

	private JButton home = new JButton("Home");

	//insert attributes for textfield
	//private JTextField textField;

	/* SUGGESTION: since lots of the programs parts concerns choosing an option from a set of lists, 
				   there could be a general option that prints a list of choices given the number
				   of choices and the labels of each choice. Unsure how to work around this with 
				   button inputs though, but will think about it when we reach the GUI implementation
				   stage. */

	public AppView() {
		super("JavaJeep");
		setLayout(new FlowLayout());

		setSize(800, 400);

		homeScreen();

		setVisible(true);
		//setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void homeScreen() {

		/* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Welcome to JavaJeeps!");
        label1.setFont(new Font("Arial", Font.BOLD, 30));
        headerPanel.add(label1);

		// JLabel label2 = new JLabel("Select an Option:");
        // label2.setFont(new Font("Arial", Font.BOLD, 15));
        // headerPanel.add(label2);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

		/* Block of code for the Button Options */

	    mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		mainPanel.add(createBtn);
		mainPanel.add(simulateBtn);
		mainPanel.add(dashboardBtn);

		this.add(mainPanel, BorderLayout.CENTER);

		/* ----------------------------------------------------------------------- */
	}

	public void createNewTruck() {

        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Create a brand new coffee truck!");
        label1.setFont(new Font("Arial", Font.BOLD, 25));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the Button Options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		mainPanel.add(javaJeepS);
		mainPanel.add(javaJeepR);

        label2 = new JLabel("            Enter Location: ");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        mainPanel.add(location);

		mainPanel.add(proceed);

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void setTruckBins() {
		binList();

		mainPanel.add(nxt);

		this.add(mainPanel, BorderLayout.CENTER);

		/* ----------------------------------------------------------------------- */
    }

	public void binList() {
		/* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Storage Bin Contents: ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

		/* Block of code for the Button Options */

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		mainPanel.add(bin1);

		JLabel bin1Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin1Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin1Cnts);

		mainPanel.add(bin2);

		JLabel bin2Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin2Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin2Cnts);

		mainPanel.add(bin3);

		JLabel bin3Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin3Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin3Cnts);

		mainPanel.add(bin4);

		JLabel bin4Cnts = new JLabel("- BIN is empty       "); //<------------------ rreplace value from TruckController -> setBins()
        bin4Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin4Cnts);

		mainPanel.add(bin5);

		JLabel bin5Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin5Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin5Cnts);

		mainPanel.add(bin6);

		JLabel bin6Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin6Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin6Cnts);

		mainPanel.add(bin7);

		JLabel bin7Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin7Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin7Cnts);

		mainPanel.add(bin8);

		JLabel bin8Cnts = new JLabel("- BIN is empty       "); //<------------------ replace value from TruckController -> setBins()
        bin8Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin8Cnts);
	}

	public void setAmounts() {

       	amountList();
		mainPanel.add(enter);

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void amountList() {
		 /* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Max quanitity for all items: ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

        /* Block of code for the Button Options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel sml = new JLabel("Small Cup - 80pcs");
        sml.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(sml);

        JLabel med = new JLabel("Medium Cup - 64pcs");
        med.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(med);

        JLabel lrg = new JLabel("Large Cup - 40pcs");
        lrg.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(lrg);

        JLabel cfe = new JLabel("Coffee Beans - 1008grams");
        cfe.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(cfe);

        JLabel mlk = new JLabel("Milk - 640fl");
        mlk.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(mlk);

        JLabel wtr = new JLabel("Water - 640fl");
        wtr.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(wtr);

		mainPanel.add(sCup);
		mainPanel.add(mCup);
		mainPanel.add(lCup);
		mainPanel.add(cBns);
		mainPanel.add(dMlk);
		mainPanel.add(dWtr);

        label2 = new JLabel("                Amount: ");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        mainPanel.add(amount);
	}

	public void setPrices(){
        priceList();

		mainPanel.add(confirm);
        mainPanel.add(Box.createVerticalStrut(20));

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void priceList() {
		/* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Below are the current prices for each ingredient: ");
        label1.setFont(new Font("Arial", Font.BOLD, 25));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

        /* Block of code for the Button Options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(20));

        JLabel pCBns = new JLabel("1 gram coffee bean - 1.00");  //<------------------- change value from AppController -> editPrices()
        pCBns.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(pCBns);

        JLabel pMlk = new JLabel("1fl of milk - 2.50");     //<------------------- change value from AppController -> editPrices()
        pMlk.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(pMlk);

        JLabel pWtr = new JLabel("1fl of water - 0.50");    //<------------------- change value from AppController -> editPrices()
        pWtr.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(pWtr);

        JLabel pScup = new JLabel("Small cup  base price - 50.00");     //<------------------- change value from AppController -> editPrices()
        pScup.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(pScup);

        JLabel pMcup = new JLabel("Medium cup base price - 60.00");     //<------------------- change value from AppController -> editPrices()
        pMcup.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(pMcup);

        JLabel pLcup = new JLabel("Large cup base price - 70.00");      //<------------------- change value from AppController -> editPrices()
        pLcup.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(pLcup);

        mainPanel.add(Box.createVerticalStrut(15));

		mainPanel.add(sCup);
        mainPanel.add(Box.createVerticalStrut(5));

		mainPanel.add(mCup);
        mainPanel.add(Box.createVerticalStrut(5));

		mainPanel.add(lCup);
        mainPanel.add(Box.createVerticalStrut(5));

		mainPanel.add(cBns);
        mainPanel.add(Box.createVerticalStrut(5));

		mainPanel.add(dMlk);
        mainPanel.add(Box.createVerticalStrut(5));

		mainPanel.add(dWtr);
        mainPanel.add(Box.createVerticalStrut(20));

        label2 = new JLabel("If you wish to change, select a buttton, enter price and click save ");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        mainPanel.add(Box.createVerticalStrut(5));

        label3 = new JLabel("Price: ");
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label3);

        mainPanel.add(price);
		mainPanel.add(save);
        mainPanel.add(Box.createVerticalStrut(10));

		label4 = new JLabel("If you wish to continue, click confirm");
        label4.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label4);
	}
 
	public void truckInfo() {

        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Congratulations! Your truck has successfully been created.");
        label1.setFont(new Font("Arial", Font.BOLD, 17));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the Text */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(35));

        label2 = new JLabel("Type: _ || Location: ______"); //<------------replace with values from CreateTruck
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(label2);

        mainPanel.add(Box.createVerticalStrut(35));

        label3 = new JLabel("Storage Bins Contain...");
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(label3);

        JLabel bin1Cnts = new JLabel("Storage Bin #1 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin1Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin1Cnts);

		JLabel bin2Cnts = new JLabel("Storage Bin #2 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin2Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin2Cnts);

		JLabel bin3Cnts = new JLabel("Storage Bin #3 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin3Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin3Cnts);


		JLabel bin4Cnts = new JLabel("Storage Bin #4 - Bin is empty"); //<------------------ rreplace value from TruckController -> setBins()
        bin4Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin4Cnts);

		JLabel bin5Cnts = new JLabel("Storage Bin #5 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin5Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin5Cnts);


		JLabel bin6Cnts = new JLabel("Storage Bin #6 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin6Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin6Cnts);


		JLabel bin7Cnts = new JLabel("Storage Bin #7 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin7Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin7Cnts);

		JLabel bin8Cnts = new JLabel("Storage Bin #8 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin8Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin8Cnts);

        mainPanel.add(Box.createVerticalStrut(35));

        mainPanel.add(mainMenu);

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void truckSimulate() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Choose a truck to simulate:");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        label2 = new JLabel("#1 || Type: _ || Location: ______           /* To add more */"); //<------------replace with values from CreateTruck
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        JLabel choice = new JLabel("Enter Number: ");
        choice.setFont(new Font("Arial", Font.BOLD, 12));
        mainPanel.add(choice);

        mainPanel.add(toSimulate);
        mainPanel.add(next);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void optionList() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("What would you like to do?");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(choice1);
        mainPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(choice2);
        mainPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(choice3);
        mainPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(choice4);
		mainPanel.add(Box.createVerticalStrut(5));

		mainPanel.add(choice5);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void simulateTruckInfo() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Type: _ | Truck at: ______ | Earned: __"); //<------ To change values
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(20));

        label3 = new JLabel("Storage Bins Contain...");
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(label3);

        JLabel bin1Cnts = new JLabel("Storage Bin #1 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin1Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin1Cnts);

		JLabel bin2Cnts = new JLabel("Storage Bin #2 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin2Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin2Cnts);

		JLabel bin3Cnts = new JLabel("Storage Bin #3 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin3Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin3Cnts);


		JLabel bin4Cnts = new JLabel("Storage Bin #4 - Bin is empty"); //<------------------ rreplace value from TruckController -> setBins()
        bin4Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin4Cnts);

		JLabel bin5Cnts = new JLabel("Storage Bin #5 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin5Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin5Cnts);


		JLabel bin6Cnts = new JLabel("Storage Bin #6 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin6Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin6Cnts);

		JLabel bin7Cnts = new JLabel("Storage Bin #7 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin7Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin7Cnts);

		JLabel bin8Cnts = new JLabel("Storage Bin #8 - Bin is empty"); //<------------------ replace value from TruckController -> setBins()
        bin8Cnts.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(bin8Cnts);

        mainPanel.add(Box.createVerticalStrut(15));

        label2 = new JLabel("AVAILABLE ITEMS:");
        label2.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(label2);

        JLabel americano = new JLabel("Cafe Americano [ S M L ]");
        americano.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(americano);

        JLabel latte = new JLabel("Latte [ S M L ]");
        latte.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(latte);

        JLabel cappucino = new JLabel("Cappucino [ S M L ]");
        cappucino.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(cappucino);
        mainPanel.add(Box.createVerticalStrut(20));

        JLabel drink = new JLabel("Drink: _________");
        drink.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(drink);

        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(bReturn);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void choose() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("AVAILABLE ITEMS:");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel americano = new JLabel("Cafe Americano [ S M L ]");
        americano.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(americano);
        mainPanel.add(Box.createVerticalStrut(5));

        JLabel latte = new JLabel("Latte [ S M L ]");
        latte.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(latte);
        mainPanel.add(Box.createVerticalStrut(5));

        JLabel cappucino = new JLabel("Cappucino [ S M L ]");
        cappucino.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(cappucino);
        mainPanel.add(Box.createVerticalStrut(20));

        JLabel choose = new JLabel("Would you like to make an order?");
        choose.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(choose);
        mainPanel.add(Box.createVerticalStrut(5));


        yes.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(yes);
        mainPanel.add(Box.createVerticalStrut(5));

        no.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(no);
        mainPanel.add(Box.createVerticalStrut(5));

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void order() {

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel wDrink = new JLabel("What drink would you like? ");
        wDrink.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(wDrink);

        JLabel americano = new JLabel("Cafe Americano [ S M L ]");
        americano.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(americano);

        JLabel latte = new JLabel("Latte [ S M L ]");
        latte.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(latte);

        JLabel cappucino = new JLabel("Cappucino [ S M L ]");
        cappucino.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(cappucino);

        mainPanel.add(drink);

        JLabel wSize = new JLabel("What size would you like? ");
        wSize.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(wSize);

        mainPanel.add(small);
        mainPanel.add(medium);
        mainPanel.add(large);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void orderHere() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Here is a simulation of your order:");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(25));

        JLabel details1 = new JLabel("Brewing ___ fl espresso...");  //<------------------ to change value
        details1.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details1);

        JLabel details2 = new JLabel("      ___ grams of coffee...");  //<------------------ to change value
        details2.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details2);

        JLabel details3 = new JLabel("      ___ fl of water...");  //<------------------ to change value
        details3.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details3);

        JLabel details4 = new JLabel("Adding ___ of milk...");  //<------------------ to change value
        details4.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details4);

        mainPanel.add(Box.createVerticalStrut(15));

        JLabel details5 = new JLabel("________ successfully brewed!");  //<------------------ to change value
        details5.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details5);

        mainPanel.add(Box.createVerticalStrut(5));

        JLabel details6 = new JLabel("Drink: ______, Size: ____, Cost ______");  //<------------------ to change value
        details6.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details6);

        mainPanel.add(Box.createVerticalStrut(30));

        mainPanel.add(bBack);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void simulateTruckBins() {
		/* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    label1 = new JLabel("Storage Bin Contents: ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

		/* Block of code for the Button Options */

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		mainPanel.add(Box.createVerticalStrut(20));

		sbin1.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin1);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin1Cnts = new JLabel("BIN is empty    "); //<------------------ replace value from TruckController -> setBins()
        bin1Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin1Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin1Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin2.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin2);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin2Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin2Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin2Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin2Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin3.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin3);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin3Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin3Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin3Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin3Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin4.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin4);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin4Cnts = new JLabel("BIN is empty"); //<------------------ rreplace value from TruckController -> setBins()
        bin4Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin4Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin4Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin5.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin5);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin5Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin5Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin5Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin5Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin6.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin6);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin6Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin6Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin6Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin6Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin7.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin7);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin7Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin7Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin7Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin7Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		sbin8.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(sbin8);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin8Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin8Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin8Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin8Cnts);

		mainPanel.add(Box.createVerticalStrut(15));

		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(back);

		this.add(mainPanel, BorderLayout.CENTER);

		/* ----------------------------------------------------------------------- */

    }

	public void simulateAmounts() {
		amountList();

		mainPanel.add(Box.createVerticalStrut(15));

		prev.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(prev);

		this.add(mainPanel, BorderLayout.CENTER);

		/* ----------------------------------------------------------------------- */
    }
	
	public void maintainance() {
		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        label1 = new JLabel("What location do you want your truck to stay in?");
        label1.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(label1);

        mainPanel.add(mLocation);
        mainPanel.add(mContinue);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	 public void mSetPrices(){
		priceList();

		mainPanel.add(sconfirm);

        mainPanel.add(Box.createVerticalStrut(20));

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

	public void dashboard() { 
		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel details1 = new JLabel("Dashboard Text");
        details1.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(details1);

		mainPanel.add(home);

        this.add(mainPanel, BorderLayout.CENTER);

		// NOTE: Add Button for return later

        /* ----------------------------------------------------------------------- */
    }

	public String getLoc() { //For Location via Text Field
		return location.getText(); 
	}

	public void setLoc(String loc) { //For Location via Text Field
		location.setText(loc);
    }

	public String getAmount() { //For Amount via Text Field
		return amount.getText(); 
	}

	public void setAmount(String qty) { //For Amount via Text Field
		amount.setText(qty);
    }

	public String getPrice() { //For Price via Text Field
		return price.getText(); 
	}

	public void setPrice(String tPrice) { //For Price via Text Field
		price.setText(tPrice);
    }

	public String getSimulation() { //For choosing a truck
		return toSimulate.getText(); 
	}

	public void setSimulation(String simulate) {//For choosing a truck
		toSimulate.setText(simulate);
    }

	public String getDrink() { //For Amount via Text Field
		return drink.getText(); 
	}

	public void setDrink(String tDrink) { //For Amount via Text Field
		drink.setText(tDrink);
    }

	public String getMLoc() {
		return mLocation.getText(); 
	}

	public void setMLoc(String locate) {
		mLocation.setText(locate);
    }

	public void setActionListener(ActionListener listener) {
		createBtn.addActionListener(listener);
		simulateBtn.addActionListener(listener);
		dashboardBtn.addActionListener(listener);
		javaJeepR.addActionListener(listener);
        javaJeepS.addActionListener(listener);
        proceed.addActionListener(listener);
		bin1.addActionListener(listener);
		bin2.addActionListener(listener);
		bin3.addActionListener(listener);
		bin4.addActionListener(listener);
		bin5.addActionListener(listener);
		bin6.addActionListener(listener);
		bin7.addActionListener(listener);
		bin8.addActionListener(listener);
		nxt.addActionListener(listener);
		sCup.addActionListener(listener);
        mCup.addActionListener(listener);
        lCup.addActionListener(listener);
        cBns.addActionListener(listener);
        dMlk.addActionListener(listener);
        dWtr.addActionListener(listener);
        save.addActionListener(listener);
        confirm.addActionListener(listener);
		enter.addActionListener(listener);
		mainMenu.addActionListener(listener);
		next.addActionListener(listener);
		choice1.addActionListener(listener);
        choice2.addActionListener(listener);
        choice3.addActionListener(listener);
        choice4.addActionListener(listener);
		choice5.addActionListener(listener);
		bReturn.addActionListener(listener);
		yes.addActionListener(listener);
        no.addActionListener(listener);
		small.addActionListener(listener);
        medium.addActionListener(listener);
        large.addActionListener(listener);
		bBack.addActionListener(listener);
		mContinue.addActionListener(listener);
        sconfirm.addActionListener(listener);
		back.addActionListener(listener);
		sbin1.addActionListener(listener);
		sbin2.addActionListener(listener);
		sbin3.addActionListener(listener);
		sbin4.addActionListener(listener);
		sbin5.addActionListener(listener);
		sbin6.addActionListener(listener);
		sbin7.addActionListener(listener);
		sbin8.addActionListener(listener);
		prev.addActionListener(listener);
		home.addActionListener(listener);
	}

	public void setDocumentListener(DocumentListener listener) {
	    location.getDocument().addDocumentListener(listener);
		amount.getDocument().addDocumentListener(listener);
		price.getDocument().addDocumentListener(listener);
		toSimulate.getDocument().addDocumentListener(listener);
		drink.getDocument().addDocumentListener(listener);
		mLocation.getDocument().addDocumentListener(listener);
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

	/**
	 * Halts the program for .5 seconds.
	 * Used in printing statements.
	 */
	public static void pause(){		
			try {
			Thread.sleep(500); // Delay for 0.5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the main menu of the app.
	 */
	public void printMain(){
		clear();
		System.out.println("Welcome to JavaJeeps!\n");
		System.out.println("Select an Option:");
		System.out.println("1 - Create a coffee truck");
		System.out.println("2 - Simulate a coffee truck");
		System.out.println("3 - Dashboard");
		System.out.println("4 - Exit");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints a feedback label
	 */
	public void printFeedback(String feedback){
		System.out.println(feedback);
	}

	/**
	 * Prints the screen when the truck's type is being set.
	 */
	public void printSetType(){
		AppView.clear();
		System.out.println("Create a brand new coffee truck!");
		System.out.println("What kind of coffee truck would you like to make?");
		System.out.println("");
		System.out.println("P - JavaJeep+ (Not available yet!!!!)");
		System.out.println("R - JavaJeep Regular");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints the screen when the type's location is being set.
	 */
	public void printSetLocation(){
		AppView.clear();
		System.out.println("What location do you want your truck to stay in?");
		System.out.println("To keep business efficient, we're limiting it to one truck per city!");
		System.out.println("");
		System.out.print(">> ");
	}

	/**
	 * Prints the screen when the user is setting the prices.
	 */
	public void printSetPrice(){
		clear();
		System.out.println("The prices of drinks for all coffee trucks are equal, and is determined by the amount of an ingredient and it's base price, as well as the cup size.\n");
		System.out.println("Below are the current prices for each ingredient:");
		System.out.printf("1 shot espresso: %.2f\n", Espresso.getPrice());
		System.out.printf("1fl of milk: %.2f\n", Milk.getPrice());
		System.out.printf("1fl of water: %.2f\n", Water.getPrice());
		System.out.printf("Small cup base price: %.2f\n", SmallCup.getPrice());
		System.out.printf("Medium cup base price: %.2f\n", MediumCup.getPrice());
		System.out.printf("Large cup base price: %.2f\n", LargeCup.getPrice());
		System.out.printf("Additional syrups or toppings: %.2f\n", ExtraIngr.getPrice());
		System.out.println();

		System.out.println("Enter an ingredient who's price you'd like to change ['water','milk','espresso','scup','mcup','lcup','extra']. If you'd like to exit, enter END.");
		System.out.print(">> ");
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
			truck.truckBaseInfo();
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
		for (TruckController truck : trucks) truck.truckBaseInfo();

		/* Prints aggregate amount of ingredients all trucks have. 
		 * 0 = scup, 1 = mcup, 2 = lcup, 3 = milk, 4 = water, 5 = coffee */
		System.out.println();
		System.out.println();
		System.out.println("Total amount of ingredients in all trucks:");

		pause();
		System.out.printf("\tSmall Cups: %.0f pcs", totalIngr[0]);
		pause();
		System.out.printf("\tMedium Cups: %.0f pcs", totalIngr[1]);
		pause();
		System.out.printf("\tLarge Cups: %.0f pcs", totalIngr[2]);
		pause();
		System.out.printf("\tCoffee: %.2f grams", totalIngr[3]);
		pause();
		System.out.printf("\tWater: %.2f fl", totalIngr[4]);
		pause();
		System.out.printf("\tMilk: %.2f fl\n", totalIngr[5]);

		System.out.println();

		/* Aggregate total. */
		System.out.printf("\nTotal amount of earnings: %.2f", combinedSales);
		System.out.println();


		/* Amount of orders for specific types of drinks as well as sizes.
		 * 0 = small, 1 = medium, 2 = large, 3 = cafe americano, 4 = latte, 5 = cappucino */
		System.out.printf("Total amount of sales: %f\n", combinedSales);
		System.out.println("\nOrder types:");

		pause();
		System.out.printf("\tCafe Americano: %d", transacType[3]);
		pause();
		System.out.printf("\tLatte: %d", transacType[4]);
		pause();
		System.out.printf("\tCappucino: %d", transacType[5]);

		System.out.println();
		System.out.println("Order sizes:");

		pause();
		System.out.printf("\tSmall: %d", transacType[0]);
		pause();
		System.out.printf("\tMedium: %d", transacType[1]);
		pause();
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
}