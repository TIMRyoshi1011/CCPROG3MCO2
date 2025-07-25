package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class SimulateScreen extends JFrame implements ActionListener, DocumentListener{
    private AppModel model;

    private JPanel mainPanel;
    private JPanel headerPanel;

    private JTextField toSimulate;
    private JButton proceed;

    public SimulateScreen() {
        super("Simulate Truck");

        setLayout(new BorderLayout());

		setSize(420, 450);

		truckSimulate();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
        setDocumentListener(this);
    }

    public void truckSimulate() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Choose a truck to simulate:");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel label2 = new JLabel("#1 || Type: _ || Location: ______           /* To add more */"); //<------------replace with values from CreateTruck
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        JLabel choice = new JLabel("Enter Number: ");
        choice.setFont(new Font("Arial", Font.BOLD, 12));
        mainPanel.add(choice);

        toSimulate = new JTextField(10);
        mainPanel.add(toSimulate);

		proceed = new JButton("Proceed");
        mainPanel.add(proceed);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        proceed.addActionListener(listener);
	}

    public void setDocumentListener(DocumentListener listener) {
	    toSimulate.getDocument().addDocumentListener(listener);
	}

    public String getSimulation() { 
		return toSimulate.getText(); 
	}

	public void setSimulation(String simulate) {
		toSimulate.setText(simulate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Proceed")) {
            if (toSimulate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a Truck No.");
                return; // Do not proceed if the text field is empty
            }
            else {
                System.out.println(getSimulation()); // Pass getSimulation() to the model - placeholder for test/ to delete
                removeUpdate(null); // Clear the text field after proceeding
                SimulateOptions options = new SimulateOptions();
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
        toSimulate.setText(""); // Clear the text field when text is removed
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change
    }
}
