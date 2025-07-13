import javax.swing.*;
import java.awt.*;

public class JavaJeepGUI extends JFrame {
    public JavaJeepGUI() {
        super("JavaJeep");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //display();

        setVisible(true);
        setResizable(false);
    }

    // private void display() {
        // insert panels if necessary (south, north, east, west, center)

    // sample
    //     // Create the main panel
    //     JPanel mainPanel = new JPanel();
    
    //     mainPanel.setLayout(new BorderLayout()); //FlowLayout() for north, south/ GridBagLayout() for east, west
    //     mainPanel.setBackground(Color.LIGHT_GRAY);
    
    //     JLabel label = new JLabel("Welcome to JavaJeep!");
    //     setFont(new Font("Arial", Font.BOLD, 16));
    //     setForeground(Color.BLUE);
    //     mainPanel.add(label);

    //     JButton button = new JButton("Click Me");
    //     mainPanel.add(button);

    //     JTextField textField = new JTextField(20);
    //     mainPanel.add(textField);
    
    //     this.add(mainPanel, BorderLayout.CENTER);
    // }
}