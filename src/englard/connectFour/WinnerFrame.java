package englard.connectFour;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WinnerFrame(String winner) {
		setTitle("Winner!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocation(600, 200);

		playSound("clap.wav");

		JLabel text = new JLabel(winner + " Won! \n Great Job!!!");
		JLabel playAgain = new JLabel("Do you want to play again?");
		JButton yes = new JButton("yes");
		JButton no = new JButton("no");
		JPanel panel = new JPanel();
		yes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ConnectFourGuiFrame a = new ConnectFourGuiFrame();
				a.setVisible(true);

			}
		});
		no.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		text.setFont(new Font("Courier New", Font.BOLD, 22));
		text.setHorizontalAlignment(JLabel.CENTER);

		if (winner.equalsIgnoreCase("blue")) {
			panel.setBackground(Color.BLUE);
		} else {
			panel.setBackground(Color.RED);

		}
		
		panel.add(text);
		panel.add(playAgain);
		panel.add(yes);
		panel.add(no);
		add(panel);
		setVisible(true);
	}

	public void playSound(final String file) {
		new Thread(new Runnable() {

			public void run() {
				Applet.newAudioClip(getClass().getResource(file)).play();
			}
		}).start();
	}
}
