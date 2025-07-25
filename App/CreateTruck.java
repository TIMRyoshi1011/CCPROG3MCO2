package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class CreateTruck extends JFrame implements ActionListener, DocumentListener {
    private AppModel model;
	
    private JButton javaJeepS;
    private JButton javaJeepR;

    private JPanel mainPanel;
    private JPanel headerPanel;

    private JTextField location;
    private JButton proceed;

    public CreateTruck() {
        super("Create Truck");

        setLayout(new BorderLayout());

		setSize(300, 200);

		createNewTruck();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
        setDocumentListener(this);
    }

    public void createNewTruck() {

        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Create a brand new coffee truck!");
        label1.setFont(new Font("Arial", Font.BOLD, 15));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the Button Options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		javaJeepS = new JButton("JavaJeep+");
		mainPanel.add(javaJeepS);

		javaJeepR = new JButton("JavaJeep");
		mainPanel.add(javaJeepR);

        JLabel label2 = new JLabel("Enter Location: ");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(label2);

        location = new JTextField(20);
        mainPanel.add(location);

        proceed = new JButton("Proceed");
		mainPanel.add(proceed);

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        javaJeepR.addActionListener(listener);
        javaJeepS.addActionListener(listener);
        proceed.addActionListener(listener);
	}

    public void setDocumentListener(DocumentListener listener) {
	    location.getDocument().addDocumentListener(listener);
	}

	public String getLoc() { //For Location via Text Field
		return location.getText(); 
	}

	public void setLoc(String loc) { //For Location via Text Field
		location.setText(loc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("JavaJeep")) {
            System.out.println("R");  //placeholder for test/ to delete
            // Pass R to the model
        }

        else if (e.getActionCommand().equals("JavaJeep+")) {
            System.out.println("P"); //placeholder for test/ to delete
            // Pass S to the model
        }

        
        else if (e.getActionCommand().equals("Proceed")) {
            if (location.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a location.");
                return; // Do not proceed if the text field is empty
            }
           
            else {
                System.out.println(getLoc());  // Send getLoc() to the model - placeholder for test/ to delete
                removeUpdate(null); 
                SettingStorageBins setBins = new SettingStorageBins();
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
