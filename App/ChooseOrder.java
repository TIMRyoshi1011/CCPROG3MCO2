package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChooseOrder extends JFrame implements ActionListener{

    private AppModel model;

    private JPanel mainPanel;
    private JPanel headerPanel;

    private JButton yes;
    private JButton no;

    public ChooseOrder() {
        super("Choose");

        setLayout(new BorderLayout());

		setSize(400, 350);

		choose();

		setVisible(true);
		setResizable(false);

        setActionListener(this);
    }

    public void choose() {
        /* Block of code for the Header Text */

        headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("AVAILABLE ITEMS:");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

        /* ----------------------------------------------------------------------- */

		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel americano = new JLabel("Cafe Americano [ S M L ]");
        americano.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(americano);
        mainPanel.add(Box.createVerticalStrut(5));

        JLabel latte = new JLabel("Latte [ S M L ]");
        latte.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(latte);
        mainPanel.add(Box.createVerticalStrut(5));

        JLabel cappucino = new JLabel("Cappucino [ S M L ]");
        cappucino.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(cappucino);
        mainPanel.add(Box.createVerticalStrut(20));

        JLabel choose = new JLabel("Would you like to make an order?");
        choose.setFont(new Font("Arial", Font.BOLD, 17));
        mainPanel.add(choose);
        mainPanel.add(Box.createVerticalStrut(5));


        yes = new JButton("Yes");
        yes.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(yes);
        mainPanel.add(Box.createVerticalStrut(5));

        no = new JButton("No");
        no.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(no);
        mainPanel.add(Box.createVerticalStrut(5));

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }

    public void setActionListener(ActionListener listener) {
        yes.addActionListener(listener);
        no.addActionListener(listener);
	}

        @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Yes")) {
            SimulateOrder orderup = new SimulateOrder();
            dispose(); //close this window
        }

        else if (e.getActionCommand().equals("No")) {
            SimulateOptions options = new SimulateOptions();
            dispose(); //close this window
        }
    }
}
