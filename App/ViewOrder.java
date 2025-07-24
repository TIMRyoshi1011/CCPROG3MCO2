package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewOrder extends JFrame implements ActionListener{

    private JPanel mainPanel;
    private JPanel headerPanel;

    private JButton bReturn;

    public ViewOrder() {
        super("Order Details");

        setLayout(new BorderLayout());

		setSize(350, 450);

		orderHere();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
    }

    public void orderHere() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Here is a simulation of your order:");
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
            ChooseOrder order = new ChooseOrder();
            dispose(); //close this window
        }
    }
}
