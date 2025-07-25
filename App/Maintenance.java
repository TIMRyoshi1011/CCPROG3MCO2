package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class Maintenance extends JFrame implements ActionListener, DocumentListener{
    private AppModel model;

    private JPanel mainPanel;

    private JTextField location;

    private JButton next;

    public Maintenance() {
        super("Maintenance");

        setLayout(new BorderLayout());

		setSize(450, 200);

		maintain();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
        setDocumentListener(this);
    }

    public void maintain() {
		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel details1 = new JLabel("What location do you want your truck to stay in?");
        details1.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(details1);

        location = new JTextField(20);
        mainPanel.add(location);

        next = new JButton("Next");
        mainPanel.add(next);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        next.addActionListener(listener);
	}

    public void setDocumentListener(DocumentListener listener) {
	    location.getDocument().addDocumentListener(listener);
	}

    public String getTextField() {
		return location.getText(); 
	}

	public void setTextField(String loc) {
		location.setText(loc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next")) {
            if (location.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a location.");
                return; // Do not proceed if the text field is empty
            }

            else {
                System.out.println(getTextField()); // Pass getTextField() to the model - placeholder for test/ to delete
                removeUpdate(null); // Clear the text field after proceeding
                MaintainBinPrices prices = new MaintainBinPrices();
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
        location.setText(""); // Clear the text field when text is removed
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Handle text change
    }
}
