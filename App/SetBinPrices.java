package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SetBinPrices extends JFrame implements ActionListener, DocumentListener {

    private AppModel model;

    private JPanel mainPanel;
    private JPanel headerPanel;

	private JButton sCup;
    private JButton mCup;
    private JButton lCup;
    private JButton cBns;
    private JButton dMlk;
    private JButton dWtr;

    private JTextField price;

    private JButton save;
	private JButton confirm;

    public SetBinPrices() {
        super("Set Prices");

        setLayout(new BorderLayout());

		setSize(600, 620);

		setPrices();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
        setDocumentListener(this);
    }
    
    public void setPrices(){
        /* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Below are the current prices for each ingredient: ");
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

		sCup = new JButton("Small Cup");
		mainPanel.add(sCup);

        mainPanel.add(Box.createVerticalStrut(5));

		mCup = new JButton("Medium Cup");
		mainPanel.add(mCup);

        mainPanel.add(Box.createVerticalStrut(5));

        lCup = new JButton("Large Cup");
		mainPanel.add(lCup);

        mainPanel.add(Box.createVerticalStrut(5));

        cBns = new JButton("Coffee Beans");
		mainPanel.add(cBns);

        mainPanel.add(Box.createVerticalStrut(5));

        dMlk = new JButton("Milk");
		mainPanel.add(dMlk);

        mainPanel.add(Box.createVerticalStrut(5));

        dWtr = new JButton("Water");
		mainPanel.add(dWtr);

        mainPanel.add(Box.createVerticalStrut(20));

        JLabel label2 = new JLabel("If you wish to change, select a buttton, enter price and click save ");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        mainPanel.add(Box.createVerticalStrut(5));

        JLabel label3 = new JLabel("Price: ");
        label3.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label3);

        price = new JTextField(15);
        mainPanel.add(price);

        save = new JButton("Save");
		mainPanel.add(save);

        mainPanel.add(Box.createVerticalStrut(10));

        JLabel label5 = new JLabel("If you wish to continue, click confirm");
        label5.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label5);

        confirm = new JButton("Confirm");
		mainPanel.add(confirm);

        mainPanel.add(Box.createVerticalStrut(20));

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        sCup.addActionListener(listener);
        mCup.addActionListener(listener);
        lCup.addActionListener(listener);
        cBns.addActionListener(listener);
        dMlk.addActionListener(listener);
        dWtr.addActionListener(listener);
        save.addActionListener(listener);
        confirm.addActionListener(listener);
	}

    public void setDocumentListener(DocumentListener listener) {
	    price.getDocument().addDocumentListener(listener);
	}

    public String getPrice() { //For Price via Text Field
		return price.getText(); 
	}

	public void setTextField(String tPrice) { //For Price via Text Field
		price.setText(tPrice);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Small Cup")) {
            System.out.println("Small Cup");  //placeholder, to remove
        }

        else if (e.getActionCommand().equals("Medium Cup")) {
            System.out.println("Medium Cup");  //placeholder, to remove
        }

        else if (e.getActionCommand().equals("Large Cup")) {
            System.out.println("Large Cup");  //placeholder, to remove
        }

        else if (e.getActionCommand().equals("Coffee Beans")) {
            System.out.println("Coffee Beans");  //placeholder, to remove
        }

        else if (e.getActionCommand().equals("Milk")) {
            System.out.println("Milk");  //placeholder, to remove
        }

        else if (e.getActionCommand().equals("Water")) {
            System.out.println("Water");  //placeholder, to remove
        }

        else if (e.getActionCommand().equals("Save")) {
            if (price.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a price.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(getPrice());  // Send getPrice() to the model
                removeUpdate(null);
                System.out.println("Saved");  //placeholder, to remove
            }
        }

        else if (e.getActionCommand().equals("Confirm")) {
            DisplayTruckInfo finalDisplay = new DisplayTruckInfo();
            dispose(); //close this window
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        // Handle text insertion
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Handle text removal
        price.setText(""); // Clear the text field when text is removed
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change
    }
}
