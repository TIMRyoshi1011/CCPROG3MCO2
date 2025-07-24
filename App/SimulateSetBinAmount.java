package App;

import StorageBin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SimulateSetBinAmount extends JFrame implements ActionListener, DocumentListener{
    private AppModel model;

    private JPanel mainPanel;
    private JPanel headerPanel;

	private JButton sCup;
    private JButton mCup;
    private JButton lCup;
    private JButton cBns;
    private JButton dMlk;
    private JButton dWtr;

    private JTextField amount;

	private JButton confirm;

    private SimulateSetBins setBins;

    public SimulateSetBinAmount() {
        super("Set Amount");

        setLayout(new BorderLayout());

		setSize(280, 450);

		setAmounts();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
        setDocumentListener(this);
    }

    public void setAmounts() {

        /* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Max quanitity for all items: ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

        /* Block of code for the Button Options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

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

		sCup = new JButton("Small Cup");
		mainPanel.add(sCup);

		mCup = new JButton("Medium Cup");
		mainPanel.add(mCup);

        lCup = new JButton("Large Cup");
		mainPanel.add(lCup);

        cBns = new JButton("Coffee Beans");
		mainPanel.add(cBns);

        dMlk = new JButton("Milk");
		mainPanel.add(dMlk);

        dWtr = new JButton("Water");
		mainPanel.add(dWtr);

        JLabel label2 = new JLabel("                Amount: ");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        amount = new JTextField(20);
        mainPanel.add(amount);

        confirm = new JButton("Confirm");
		mainPanel.add(confirm);

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
        confirm.addActionListener(listener);
	}

    public void setDocumentListener(DocumentListener listener) {
	    amount.getDocument().addDocumentListener(listener);
	}

    public String getAmount() { //For Amount via Text Field
		return amount.getText(); 
	}

	public void setAmount(String qty) { //For Amount via Text Field
		amount.setText(qty);
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

        else if (e.getActionCommand().equals("Confirm")) {
            if (amount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter an amount.");
                return; 
            }

            else {
                System.out.println(getAmount());  // Send getAmount() to the model
                removeUpdate(null); 
                setBins = new SimulateSetBins();
                dispose(); //close this window
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        // Handle text insertion
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Handle text removal
        amount.setText(""); // Clear the text field when text is removed
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change
    }
}
