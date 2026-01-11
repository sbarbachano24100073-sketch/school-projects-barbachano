import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*; // Import the Random class

/*
 * Created by JFormDesigner on Wed Oct 15 22:36:44 PST 2025
 */

/**
 * @author Admin
 */
public class RPS extends JFrame {
    // Scores for player and computer
    private int playerScore = 0;
    private int compScore = 0;

    public RPS() {
        initComponents();
    }

    private void btnRockMouseClicked(MouseEvent e) {
        playGame("Rock");
    }

    private void btnPaperMouseClicked(MouseEvent e) {
        playGame("Paper");
    }

    private void btnScissorMouseClicked(MouseEvent e) {
        playGame("Scissor");
    }

    /**
     * Main game logic is handled here.
     * @param playerChoice The choice made by the player ("Rock", "Paper", or "Scissor")
     */
    private void playGame(String playerChoice) {
        // --- Computer's Turn ---
        String[] choices = {"Rock", "Paper", "Scissor"};
        String computerChoice = choices[new Random().nextInt(choices.length)];

        // --- Determine the Winner ---
        if (playerChoice.equals(computerChoice)) {
            lblResultholder.setText("It's a tie! Computer also chose " + computerChoice + ".");
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissor")) ||
                   (playerChoice.equals("Scissor") && computerChoice.equals("Paper")) ||
                   (playerChoice.equals("Paper") && computerChoice.equals("Rock"))) {
            // Player wins
            playerScore++;
            lblResultholder.setText("You have won! Computer chose " + computerChoice + ".");
            lblPlayerScore.setText(String.valueOf(playerScore));
        } else {
            // Computer wins
            compScore++;
            lblResultholder.setText(" The computer wins! Computer chose " + computerChoice + ".");
            lblCompScore.setText(String.valueOf(compScore));
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Educational license - Charlie Marzan (Charlie S Marzan)
		panel1 = new JPanel();
		lblcomputer = new JLabel();
		lblCompScore = new JLabel();
		lblplayer = new JLabel();
		lblPlayerScore = new JLabel();
		btnRock = new JButton();
		btnPaper = new JButton();
		btnScissor = new JButton();
		lblResult = new JLabel();
		lblResultholder = new JLabel();
		lblBG = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== panel1 ========
		{
			panel1.setLayout(null);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panel1.getComponentCount(); i++) {
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
		contentPane.add(panel1);
		panel1.setBounds(new Rectangle(new Point(148, 148), panel1.getPreferredSize()));

		//---- lblcomputer ----
		lblcomputer.setText("Computer:");
		lblcomputer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblcomputer.setForeground(Color.white);
		contentPane.add(lblcomputer);
		lblcomputer.setBounds(new Rectangle(new Point(315, 60), lblcomputer.getPreferredSize()));

		//---- lblCompScore ----
		lblCompScore.setText("0");
		lblCompScore.setForeground(Color.white);
		lblCompScore.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblCompScore);
		lblCompScore.setBounds(415, 60, 55, lblCompScore.getPreferredSize().height);

		//---- lblplayer ----
		lblplayer.setText("Player:");
		lblplayer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblplayer.setForeground(Color.white);
		contentPane.add(lblplayer);
		lblplayer.setBounds(350, 90, 60, 27);

		//---- lblPlayerScore ----
		lblPlayerScore.setText("0");
		lblPlayerScore.setForeground(Color.white);
		lblPlayerScore.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		contentPane.add(lblPlayerScore);
		lblPlayerScore.setBounds(415, 90, 55, 27);

		//---- btnRock ----
		btnRock.setText("Rock");
		btnRock.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnRock.setForeground(Color.white);
		btnRock.setBackground(new Color(0x333333));
		btnRock.setOpaque(true);
		btnRock.setFocusable(false);
		btnRock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRockMouseClicked(e);
			}
		});
		contentPane.add(btnRock);
		btnRock.setBounds(50, 205, 125, 44);

		//---- btnPaper ----
		btnPaper.setText("Paper");
		btnPaper.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnPaper.setForeground(Color.white);
		btnPaper.setBackground(new Color(0x333333));
		btnPaper.setOpaque(true);
		btnPaper.setFocusable(false);
		btnPaper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPaperMouseClicked(e);
			}
		});
		contentPane.add(btnPaper);
		btnPaper.setBounds(195, 205, 125, 44);

		//---- btnScissor ----
		btnScissor.setText("Scissor");
		btnScissor.setFont(new Font("Segoe UI", Font.PLAIN, 26));
		btnScissor.setForeground(Color.white);
		btnScissor.setBackground(new Color(0x333333));
		btnScissor.setOpaque(true);
		btnScissor.setFocusable(false);
		btnScissor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnScissorMouseClicked(e);
			}
		});
		contentPane.add(btnScissor);
		btnScissor.setBounds(340, 205, 125, 44);

		//---- lblResult ----
		lblResult.setText("Result:");
		lblResult.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblResult.setForeground(Color.white);
		contentPane.add(lblResult);
		lblResult.setBounds(40, 310, 60, 30);

		//---- lblResultholder ----
		lblResultholder.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblResultholder.setBackground(new Color(0xcccccc));
		lblResultholder.setOpaque(true);
		lblResultholder.setFocusable(false);
		contentPane.add(lblResultholder);
		lblResultholder.setBounds(105, 310, 325, 30);

		//---- lblBG ----
		lblBG.setBackground(new Color(0x333333));
		lblBG.setOpaque(true);
		contentPane.add(lblBG);
		lblBG.setBounds(0, 0, 515, 390);

		contentPane.setPreferredSize(new Dimension(515, 420));
		setSize(515, 420);
		setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Educational license - Charlie Marzan (Charlie S Marzan)
	private JPanel panel1;
	private JLabel lblcomputer;
	private JLabel lblCompScore;
	private JLabel lblplayer;
	private JLabel lblPlayerScore;
	private JButton btnRock;
	private JButton btnPaper;
	private JButton btnScissor;
	private JLabel lblResult;
	private JLabel lblResultholder;
	private JLabel lblBG;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}