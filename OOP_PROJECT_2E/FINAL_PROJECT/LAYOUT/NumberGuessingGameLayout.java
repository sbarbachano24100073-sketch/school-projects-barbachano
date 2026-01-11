package LAYOUT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A simple number guessing game using Swing GUI.
 * Created by JFormDesigner on Sun Oct 19 20:52:10 PST 2025
 * @author Admin
 */
public class NumberGuessingGameLayout
{
    // GUI components
    private JFrame frame;
    private JPanel panel;
    private JButton btnGenerate;
    private JButton btnCheck;
    private JTextField txtGuess;
    private JLabel lblPrompt;
    private JLabel lblResult;
    private JLabel lblBackground;

    // Game logic
    private int randomNumber = 0;

    // Constructor
    public NumberGuessingGameLayout() {
        initComponents();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Event: Generate random number
    private void onGenerateClicked(MouseEvent e) {
        randomNumber = (int) (Math.random() * 50) + 1;
        lblResult.setText("Random number generated! Try to guess it.");
        txtGuess.setText("");
    }

    // Event: Check user's guess
    private void onCheckClicked(MouseEvent e) {
        if (randomNumber == 0) {
            lblResult.setText("Please generate a random number first.");
            return;
        }

        String input = txtGuess.getText().trim();
        if (input.isEmpty()) {
            lblResult.setText("Please enter a number.");
            return;
        }

        try {
            int guess = Integer.parseInt(input);
            if (guess < 1 || guess > 50) {
                lblResult.setText("Please enter a number between 1 and 50.");
            } else if (guess == randomNumber) {
                lblResult.setText("🎉 Correct! You guessed the number!");
            } else if (guess < randomNumber) {
                lblResult.setText("Too low! Try a higher number.");
            } else {
                lblResult.setText("Too high! Try a lower number.");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid input! Please enter a number.");
        }
    }

    // Initialize GUI components
    private void initComponents() {
        frame = new JFrame("Guessing Game");
        frame.setSize(515, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);

        // Panel (optional, currently unused)
        panel = new JPanel(null);
        panel.setBounds(148, 148, 0, 0);
        contentPane.add(panel);

        // Generate button
        btnGenerate = new JButton("Generate Random Number");
        btnGenerate.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnGenerate.setBackground(new Color(0x333333));
        btnGenerate.setForeground(Color.WHITE);
        btnGenerate.setFocusable(false);
        btnGenerate.setBounds(50, 65, 395, 45);
        btnGenerate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onGenerateClicked(e);
            }
        });
        contentPane.add(btnGenerate);

        // Prompt label
        lblPrompt = new JLabel("Enter your guess number:");
        lblPrompt.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPrompt.setForeground(Color.WHITE);
        lblPrompt.setBounds(160, 140, 200, 25);
        contentPane.add(lblPrompt);

        // Input field
        txtGuess = new JTextField();
        txtGuess.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtGuess.setBounds(160, 175, 200, 40);
        contentPane.add(txtGuess);

        // Check button
        btnCheck = new JButton("Check");
        btnCheck.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnCheck.setBackground(new Color(0x333333));
        btnCheck.setForeground(Color.WHITE);
        btnCheck.setFocusable(false);
        btnCheck.setBounds(205, 230, 100, 45);
        btnCheck.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onCheckClicked(e);
            }
        });
        contentPane.add(btnCheck);

        // Result label
        lblResult = new JLabel("Result", SwingConstants.CENTER);
        lblResult.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblResult.setForeground(Color.WHITE);
        lblResult.setBounds(50, 305, 395, 45);
        contentPane.add(lblResult);

        // Background label
        lblBackground = new JLabel();
        lblBackground.setOpaque(true);
        lblBackground.setBackground(new Color(0x333333));
        lblBackground.setBounds(0, 0, 515, 390);
        contentPane.add(lblBackground);
    }

    // Main method to run the game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGuessingGameLayout::new);
    }
}
