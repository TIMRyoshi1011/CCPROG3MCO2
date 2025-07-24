package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTruckInfo extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel headerPanel;

    private JButton bReturn;

    public ViewTruckInfo() {
        super("Truck Information");

        setLayout(new BorderLayout());

		setSize(450, 500);

		truckInfo();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
    }

    public void truckInfo() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Type: _ | Truck at: ______ | Earned: __"); //<------ To change values
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

         mainPanel.add(Box.createVerticalStrut(20));

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

        mainPanel.add(Box.createVerticalStrut(15));

        JLabel label2 = new JLabel("AVAILABLE ITEMS:");
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

        bReturn = new JButton("Return");
        mainPanel.add(bReturn);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        bReturn.addActionListener(listener);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Return")) {
            SimulateOptions options = new SimulateOptions();
            dispose(); //close this window
        }
    }
}
