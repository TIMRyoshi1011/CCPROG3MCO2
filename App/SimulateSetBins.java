package App;
import StorageBin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimulateSetBins extends JFrame implements ActionListener {

	private StorageBin storageBin;
	private SimulateSetBinAmount setAmount;

	private JPanel mainPanel;
    private JPanel headerPanel;

	private JButton bin1;
	private JButton bin2;
	private JButton bin3;
	private JButton bin4;	
	private JButton bin5;
	private JButton bin6;
	private JButton bin7;
	private JButton bin8;

	private JButton back;

	public SimulateSetBins() {
        super("Set Storage Bins");
		setLayout(new BorderLayout());

		setSize(400, 700);

		setTruckBins();

		setVisible(true);
		setResizable(false);

		setActionListener(this);
    }

    public void setTruckBins() {

		/* Block of code for the Header Text */

		headerPanel = new JPanel();
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	    JLabel label1 = new JLabel("Storage Bin Contents: ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(label1);

		this.add(headerPanel, BorderLayout.NORTH);

		/* ----------------------------------------------------------------------- */

		/* Block of code for the Button Options */

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		mainPanel.add(Box.createVerticalStrut(20));

		bin1 = new JButton("BIN #1");
		bin1.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin1);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin1Cnts = new JLabel("BIN is empty    "); //<------------------ replace value from TruckController -> setBins()
        bin1Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin1Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin1Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin2 = new JButton("BIN #2");
		bin2.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin2);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin2Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin2Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin2Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin2Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin3 = new JButton("BIN #3");
		bin3.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin3);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin3Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin3Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin3Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin3Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin4 = new JButton("BIN #4");
		bin4.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin4);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin4Cnts = new JLabel("BIN is empty"); //<------------------ rreplace value from TruckController -> setBins()
        bin4Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin4Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin4Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin5 = new JButton("BIN #5");
		bin5.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin5);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin5Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin5Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin5Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin5Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin6 = new JButton("BIN #6");
		bin6.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin6);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin6Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin6Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin6Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin6Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin7 = new JButton("BIN #7");
		bin7.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin7);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin7Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin7Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin7Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin7Cnts);

		mainPanel.add(Box.createVerticalStrut(20));

		bin8 = new JButton("BIN #8");
		bin8.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(bin8);

		mainPanel.add(Box.createVerticalStrut(5));

		JLabel bin8Cnts = new JLabel("BIN is empty"); //<------------------ replace value from TruckController -> setBins()
        bin8Cnts.setFont(new Font("Arial", Font.BOLD, 15));
		bin8Cnts.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bin8Cnts);

		mainPanel.add(Box.createVerticalStrut(15));

		back = new JButton("Back");
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(back);

		this.add(mainPanel, BorderLayout.CENTER);

		/* ----------------------------------------------------------------------- */
    }

	public void setActionListener(ActionListener listener) {
        bin1.addActionListener(listener);
		bin2.addActionListener(listener);
		bin3.addActionListener(listener);
		bin4.addActionListener(listener);
		bin5.addActionListener(listener);
		bin6.addActionListener(listener);
		bin7.addActionListener(listener);
		bin8.addActionListener(listener);
		back.addActionListener(listener);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("BIN #1")) {
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #2")) {  
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #3")) {
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #4")) {
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #5")) {
			setAmount = new SimulateSetBinAmount();  
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #6")) { 
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #7")) {
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("BIN #8")) {
			setAmount = new SimulateSetBinAmount(); 
			dispose(); //close this window
        }

		else if (e.getActionCommand().equals("Back")) { 
			SimulateOptions options = new SimulateOptions();
			dispose(); //close this window
        }
    }
}
