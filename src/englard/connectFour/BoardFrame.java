package englard.connectFour;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import englard.math.InvalidDataException;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JButton[] button;
	private JLabel[] grid;
	private ConnectFour game;

	public BoardFrame() {
		setTitle("Connect Four");
		setSize(700, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p = new JPanel();
		p.setLayout(new GridLayout(7, 7));
		p.setOpaque(true);
		p.setBackground(Color.YELLOW);
		p.setBorder(new LineBorder(Color.BLACK, 3));

		try {
			game = new ConnectFour();
		} catch (InvalidDataException e1) {
			JOptionPane.showMessageDialog(null, "contanct I.T.");
		}

		this.button = new JButton[7];
		for (int i = 0; i < 7; i++) {
			p.add(button[i] = new JButton(new ImageIcon(this.getClass().getResource("./downArrow.png"))));
		}

		this.grid = new JLabel[42];
		for (int i = 0; i < 42; i++) {
			grid[i] = new JLabel();
			grid[i].setIcon(new ImageIcon(this.getClass().getResource("./WhitePiece.png")));

			p.add(grid[i]);
		}

		add(p);

		for (int i = 0; i < this.button.length; i++) {
			button[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					int row = 0;
					Object source = e.getSource();
					for (int i = 0; i < 7; i++) {
						if (source == button[i]) {
							row = i;
						}
					}
					try {
						ImageIcon player = game.getPlayerImage();
						row = game.takeTurn(row);
						grid[row].setIcon(player);
						if (game.winner() != null) {
							String won = null;
							if (game.winner() == 1) {
								won = "RED";
							} else {
								won = "BLUE";
							}
							new WinnerFrame(won);
							stopGame();

						} else if (game.isFull()) {
							full();
						}

					} catch (FilledException e1) {
						JOptionPane.showMessageDialog(null, "That column is full already");
					} catch (InvalidDataException e1) {
						JOptionPane.showMessageDialog(null, "Get it help");
					}

				}

				private void full() {
					JOptionPane
							.showMessageDialog(null, "There is no winner and the board is full the game is now over");
					stopGame();
				}

				private void stopGame() {
					// make all buttons stop working if the board is full
					for (int i = 0; i < 7; i++) {
						for (ActionListener a : button[i].getActionListeners()) {
							button[i].removeActionListener(a);
						}
					}
				}

			});
		}

	}

}
