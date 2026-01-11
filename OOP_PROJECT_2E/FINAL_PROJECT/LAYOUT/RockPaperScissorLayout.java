package LAYOUT;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * Rock-Paper-Scissors Game
 * Created by JFormDesigner on Wed Oct 15 22:36:44 PST 2025
 * @author Admin
 */
public class RockPaperScissorLayout extends JFrame 
{

    // Game scores
    private int playerScore = 0;
    private int computerScore = 0;

    // GUI components
    private JLabel lblComputer;
    private JLabel lblPlayer;
    private JLabel lblComputerScore;
    private JLabel lblPlayerScore;
    private JLabel lblResult;
    private JLabel lblResultHolder;
    private JLabel lblBackground;
    private JButton btnRock;
    private JButton btnPaper;
    private JButton btnScissor;

    // Constructor
    public RockPaperScissorLayout() 
    {
        initComponents();
    }

    // Game logic
    private void playGame(String playerChoice) 
    {
        String[] choices = {"Rock", "Paper", "Scissor"};
        String computerChoice = choices[new Random().nextInt(choices.length)];

        if (playerChoice.equals(computerChoice)) 
        {
            lblResultHolder.setText("It's a tie! Computer also chose " + computerChoice + ".");
        } else if (
            (playerChoice.equals("Rock") && computerChoice.equals("Scissor")) ||
            (playerChoice.equals("Scissor") && computerChoice.equals("Paper")) ||
            (playerChoice.equals("Paper") && computerChoice.equals("Rock"))
        ) {
            playerScore++;
            lblResultHolder.setText("You won! Computer chose " + computerChoice + ".");
            lblPlayerScore.setText(String.valueOf(playerScore));
        } else {
            computerScore++;
            lblResultHolder.setText("Computer wins! Computer chose " + computerChoice + ".");
            lblComputerScore.setText(String.valueOf(computerScore));
        }
    }

    // GUI setup
    private void initComponents() 
    {
        setTitle("Rock-Paper-Scissors Game");
        setSize(515, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Labels
        lblComputer = new JLabel("Computer:");
        lblComputer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblComputer.setForeground(Color.WHITE);
        lblComputer.setBounds(315, 60, 100, 30);
        add(lblComputer);

        lblComputerScore = new JLabel("0");
        lblComputerScore.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblComputerScore.setForeground(Color.WHITE);
        lblComputerScore.setBounds(415, 60, 55, 30);
        add(lblComputerScore);

        lblPlayer = new JLabel("Player:");
        lblPlayer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblPlayer.setForeground(Color.WHITE);
        lblPlayer.setBounds(350, 90, 100, 30);
        add(lblPlayer);

        lblPlayerScore = new JLabel("0");
        lblPlayerScore.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblPlayerScore.setForeground(Color.WHITE);
        lblPlayerScore.setBounds(415, 90, 55, 30);
        add(lblPlayerScore);

        lblResult = new JLabel("Result:");
        lblResult.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblResult.setForeground(Color.WHITE);
        lblResult.setBounds(40, 310, 60, 30);
        add(lblResult);

        lblResultHolder = new JLabel();
        lblResultHolder.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblResultHolder.setOpaque(true);
        lblResultHolder.setBackground(new Color(0xCCCCCC));
        lblResultHolder.setBounds(105, 310, 325, 30);
        add(lblResultHolder);

        // Buttons
        btnRock = createButton("Rock", 50, 205);
        btnRock.addActionListener(e -> playGame("Rock"));
        add(btnRock);

        btnPaper = createButton("Paper", 195, 205);
        btnPaper.addActionListener(e -> playGame("Paper"));
        add(btnPaper);

        btnScissor = createButton("Scissor", 340, 205);
        btnScissor.addActionListener(e -> playGame("Scissor"));
        add(btnScissor);

        // Background
        lblBackground = new JLabel();
        lblBackground.setOpaque(true);
        lblBackground.setBackground(new Color(0x333333));
        lblBackground.setBounds(0, 0, 515, 390);
        add(lblBackground);
    }

    // Helper method to create styled buttons
    private JButton createButton(String text, int x, int y) 
    {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 26));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0x333333));
        button.setOpaque(true);
        button.setFocusable(false);
        button.setBounds(x, y, 125, 44);
        return button;
    }

    // Main method
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new RockPaperScissorLayout().setVisible(true));
    }
}
