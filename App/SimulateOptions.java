package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimulateOptions extends JFrame implements ActionListener{
    private AppModel model;

    private JPanel mainPanel;
    private JPanel headerPanel;

    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;

    public SimulateOptions() {
        super("Simulate Options");

        setLayout(new BorderLayout());

		setSize(400, 450);

		optionList();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
    }

    public void optionList() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("What would you like to do?");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(Box.createVerticalStrut(15));

        choice1 = new JButton("Simulate Sale");
        choice1.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(choice1);
        mainPanel.add(Box.createVerticalStrut(5));

        choice2 = new JButton("View Truck Information");
        choice2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(choice2);
        mainPanel.add(Box.createVerticalStrut(5));

        choice3 = new JButton("Manage Bins");
        choice3.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(choice3);
        mainPanel.add(Box.createVerticalStrut(5));

        choice4 = new JButton("Maintenance");
        choice4.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(choice4);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        choice1.addActionListener(listener);
        choice2.addActionListener(listener);
        choice3.addActionListener(listener);
        choice4.addActionListener(listener);
	}

        @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Simulate Sale")) {
            ChooseOrder order = new ChooseOrder();
            dispose(); //close this window
        }

        else if (e.getActionCommand().equals("View Truck Information")) {
            ViewTruckInfo truck = new ViewTruckInfo();
            dispose(); //close this window
        }

        else if (e.getActionCommand().equals("Manage Bins")) {
            SimulateSetBins setBins = new SimulateSetBins();
            dispose(); //close this window
        }

        else if (e.getActionCommand().equals("Maintenance")) {
            Maintenance maintenance = new Maintenance();
            dispose(); //close this window
        }
    }
}
