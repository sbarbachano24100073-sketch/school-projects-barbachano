import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Created by JFormDesigner on Sun Oct 19 20:52:10 PST 2025
 */

/**
 * @author Admin
 */
public class GuessingGame {

	private int randomNumber = 0; // store the generated number

	private void btnGenrateRandomMouseClicked(MouseEvent e) {
		// Generate random number between 1 and 50
		randomNumber = (int) (Math.random() * 50) + 1;
		lblResult.setText("Random number generated! Try to guess it.");
		txtEnterNum.setText("");
	}

	private void btnCheckMouseClicked(MouseEvent e) {
		// Check if random number has been generated
		if (randomNumber == 0) {
			lblResult.setText("Please generate a random number first.");
			return;
		}

		// Get the user's input
		String userInput = txtEnterNum.getText().trim();

		// Validate input
		if (userInput.isEmpty()) {
			lblResult.setText("Please enter a number.");
			return;
		}

		try {
			int guess = Integer.parseInt(userInput);

			// Check if guess is in valid range
			if (guess < 1 || guess > 50) {
				lblResult.setText("Please enter a number between 1 and 50.");
				return;
			}

			// Compare the guess with the random number
			if (guess == randomNumber) {
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

	public GuessingGame() {
		initComponents();
		this2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this2.setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Educational license - Charlie Marzan (Charlie S Marzan)
		this2 = new JFrame();
		panel1 = new JPanel();
		btnGenrateRandom = new JButton();
		lblGenRadmNum = new JLabel();
		txtEnterNum = new JTextField();
		btnCheck = new JButton();
		lblResult = new JLabel();
		lblBG = new JLabel();

		//======== this2 ========
		{
			this2.setTitle("Guessing Game");
			this2.setResizable(false);
			Container this2ContentPane = this2.getContentPane();
			this2ContentPane.setLayout(null);

			//======== panel1 ========
			{
				panel1.setLayout(null);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			this2ContentPane.add(panel1);
			panel1.setBounds(new Rectangle(new Point(148, 148), panel1.getPreferredSize()));

			//---- btnGenrateRandom ----
			btnGenrateRandom.setText("Generate Random Number");
			btnGenrateRandom.setFont(new Font("Segoe UI", Font.BOLD, 20));
			btnGenrateRandom.setBackground(new Color(0x333333));
			btnGenrateRandom.setForeground(Color.white);
			btnGenrateRandom.setFocusable(false);
			btnGenrateRandom.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnGenrateRandomMouseClicked(e);
				}
			});
			this2ContentPane.add(btnGenrateRandom);
			btnGenrateRandom.setBounds(50, 65, 395, 45);

			//---- lblGenRadmNum ----
			lblGenRadmNum.setText("Enter your guess number:");
			lblGenRadmNum.setForeground(Color.white);
			lblGenRadmNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			this2ContentPane.add(lblGenRadmNum);
			lblGenRadmNum.setBounds(new Rectangle(new Point(160, 140), lblGenRadmNum.getPreferredSize()));

			//---- txtEnterNum ----
			txtEnterNum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			this2ContentPane.add(txtEnterNum);
			txtEnterNum.setBounds(160, 175, 200, 40);

			//---- btnCheck ----
			btnCheck.setText("Check");
			btnCheck.setBackground(new Color(0x333333));
			btnCheck.setForeground(Color.white);
			btnCheck.setOpaque(true);
			btnCheck.setFont(new Font("Segoe UI", Font.BOLD, 20));
			btnCheck.setFocusable(false);
			btnCheck.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnCheckMouseClicked(e);
				}
			});
			this2ContentPane.add(btnCheck);
			btnCheck.setBounds(205, 230, 100, 45);

			//---- lblResult ----
			lblResult.setText("Result");
			lblResult.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			lblResult.setForeground(Color.white);
			lblResult.setHorizontalAlignment(SwingConstants.CENTER);
			this2ContentPane.add(lblResult);
			lblResult.setBounds(50, 305, 395, 45);

			//---- lblBG ----
			lblBG.setBackground(new Color(0x333333));
			lblBG.setOpaque(true);
			this2ContentPane.add(lblBG);
			lblBG.setBounds(0, 0, 515, 390);

			this2ContentPane.setPreferredSize(new Dimension(515, 420));
			this2.setSize(515, 420);
			this2.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Educational license - Charlie Marzan (Charlie S Marzan)
	private JFrame this2;
	private JPanel panel1;
	private JButton btnGenrateRandom;
	private JLabel lblGenRadmNum;
	private JTextField txtEnterNum;
	private JButton btnCheck;
	private JLabel lblResult;
	private JLabel lblBG;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
