package program.MainProgram;

import program.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Subpage extends JPanel {
    protected JButton backButton;
    protected JPanel mainPanel;

    public Subpage() {
        this.setBackground(new Color(230, 126, 34));
        this.setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94), 3));
        this.setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon backArrowIcon = new ImageIcon("src/main/resources/back-arrow.png");
        Image backArrowImage = backArrowIcon.getImage();
        Image newBackArrowImage = backArrowImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon backArrow = new ImageIcon(newBackArrowImage);
        backButton = new JButton(backArrow);
        topPanel.add(backButton);
        this.add(topPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 100 , 100, 100));
        this.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new GridBagLayout());
        
        this.setVisible(true);
    }
    /*
    JLabel sleepLabel = new JLabel("Sleep");
        sleepLabel.setFont(new Font("Arial", Font.BOLD, 25));
        sleepLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        
     */
}
