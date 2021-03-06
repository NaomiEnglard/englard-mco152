package englard.connectFour;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import englard.math.InvalidDataException;

public class ConnectFourGuiFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JButton[] button;
	private JLabel[] grid;
	private ConnectFourGame game;

	public ConnectFourGuiFrame() {
		setTitle("Connect Four");
		setSize(700, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.p = new JPanel();
		p.setLayout(new GridLayout(7, 7));
		p.setOpaque(true);
		p.setBackground(Color.YELLOW);
		p.setBorder(new LineBorder(Color.BLACK, 3));
		try {
			this.grid = new JLabel[42];
			this.game = new ConnectFourGame();
			this.button = new JButton[7];
		} catch (InvalidDataException e1) {
			JOptionPane.showMessageDialog(null, "contanct I.T.");
		}

		// add button per column
		ActionListener listner = new ButtonListener(button, game, grid);
		for (int i = 0; i < button.length; i++) {
			// button[i].addActionListener(some);
			button[i] = new JButton(new ImageIcon(this.getClass().getResource("./downArrow.png")));
			button[i].addActionListener(listner);
			p.add(button[i]);
		}
		ImageIcon blank = new ImageIcon(this.getClass().getResource("./WhitePiece.png"));
		// add 42 cells
		for (int i = 0; i < 42; i++) {
			grid[i] = new JLabel();
			grid[i].setIcon(blank);

			p.add(grid[i]);
		}

		add(p);

	}
}
