package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SimulateOrder extends JFrame implements ActionListener, DocumentListener{
    private AppModel model;

    private JPanel mainPanel;

    private JTextField drink;

    private JButton small;
    private JButton medium;
    private JButton large;

    public SimulateOrder() {
        super("Order Up");

        setLayout(new BorderLayout());

		setSize(250, 350);

		order();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
        setDocumentListener(this);
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

        drink = new JTextField(20);
        mainPanel.add(drink);

        JLabel wSize = new JLabel("What size would you like? ");
        wSize.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(wSize);

        small = new JButton("Small");
        mainPanel.add(small);

        medium = new JButton("Medium");
        mainPanel.add(medium);

        large = new JButton("Large");
        mainPanel.add(large);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        small.addActionListener(listener);
        medium.addActionListener(listener);
        large.addActionListener(listener);
	}

    public void setDocumentListener(DocumentListener listener) {
	    drink.getDocument().addDocumentListener(listener);
	}

    public String getDrink() { //For Amount via Text Field
		return drink.getText(); 
	}

	public void setDrink(String tDrink) { //For Amount via Text Field
		drink.setText(tDrink);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Small")) {
            if (drink.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a drink.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(getDrink());  // Pass getDrink() to the model - placeholder for test/ to delete
                removeUpdate(null);
                ViewOrder view = new ViewOrder();
                dispose(); //close this window
            }
        }

        else if (e.getActionCommand().equals("Medium")) {
            if (drink.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a drink.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(getDrink());  // Pass getDrink() to the model - placeholder for test/ to delete
                removeUpdate(null);
                ViewOrder view = new ViewOrder();
                dispose(); //close this window
            }
        }

        else if (e.getActionCommand().equals("Large")) {
            if (drink.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a drink.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(getDrink());  // Pass getDrink() to the model - placeholder for test/ to delete
                removeUpdate(null);
                ViewOrder view = new ViewOrder();
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
        drink.setText(""); // Clear the text field when text is removed
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change
    }
}
