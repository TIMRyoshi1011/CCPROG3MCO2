package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayTruckInfo extends JFrame implements ActionListener {
    private AppModel model;
	
    private JPanel mainPanel;
    private JPanel headerPanel;

    private JButton bReturn;

    public DisplayTruckInfo() {
        super("Truck Info");

        setLayout(new BorderLayout());

		setSize(510, 450);

		truckInfo();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
    }

    public void truckInfo() {

        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Congratulations! Your truck has successfully been created.");
        label1.setFont(new Font("Arial", Font.BOLD, 17));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the Text */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(35));

        JLabel label2 = new JLabel("Type: _ || Location: ______"); //<------------replace with values from CreateTruck
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(label2);

        mainPanel.add(Box.createVerticalStrut(35));

        JLabel label3 = new JLabel("Storage Bins Contain...");
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

        bReturn = new JButton("Confirm");
        mainPanel.add(bReturn);

		this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        bReturn.addActionListener(listener);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Confirm")) {
            dispose(); //close this window
        }
    }
}
