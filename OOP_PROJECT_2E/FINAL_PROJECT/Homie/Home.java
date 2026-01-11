import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Oct 15 21:34:30 PST 2025
 */



/**
 * @author Admin
 */
public class Home extends JFrame {
		Clip s1;

	public Home() {
		
		initComponents();
		try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                new java.io.File("RPS Game/music/_X-Men Theme song (No Sound FX).wav").getAbsoluteFile());

        s1 = AudioSystem.getClip();
        s1.open(audioInputStream);
        s1.loop(Clip.LOOP_CONTINUOUSLY);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
	}


	private void btnPlayMouseClicked(MouseEvent e) {
		// TODO add your code here

		 new RPS().setVisible(true);

		 setVisible(false);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Educational license - Charlie Marzan (Charlie S Marzan)
		panel1 = new JPanel();
		btnPlay = new JButton();
		lblbghome = new JLabel();

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

		//---- btnPlay ----
		btnPlay.setText("PLAY");
		btnPlay.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnPlay.setBackground(new Color(0x333333));
		btnPlay.setForeground(Color.white);
		btnPlay.setBorder(new BevelBorder(BevelBorder.LOWERED));
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnPlayMouseClicked(e);
			}
		});
		contentPane.add(btnPlay);
		btnPlay.setBounds(new Rectangle(new Point(200, 330), btnPlay.getPreferredSize()));

		//---- lblbghome ----
		lblbghome.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\OOP_2E\\Final_Project\\RPS GAME\\Images\\RPS.jpg"));
		contentPane.add(lblbghome);
		lblbghome.setBounds(new Rectangle(new Point(0, 0), lblbghome.getPreferredSize()));

		contentPane.setPreferredSize(new Dimension(515, 420));
		setSize(515, 420);
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Educational license - Charlie Marzan (Charlie S Marzan)
	private JPanel panel1;
	private JButton btnPlay;
	private JLabel lblbghome;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
