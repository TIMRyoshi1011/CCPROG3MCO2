package App;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame{

    private JPanel mainPanel;

    public Dashboard() {
        super("Dashboard");

        setLayout(new BorderLayout());

		setSize(450, 200);

		dashboard();

		setVisible(true);
		setResizable(false);
    }

    public void dashboard() {
		/* Block of code for the options */

        mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel details1 = new JLabel("Dashboard Text");
        details1.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(details1);

        this.add(mainPanel, BorderLayout.CENTER);

        /* ----------------------------------------------------------------------- */
    }
}
