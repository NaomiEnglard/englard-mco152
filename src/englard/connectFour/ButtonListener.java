package englard.connectFour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import englard.math.InvalidDataException;

public class ButtonListener implements ActionListener {

	private JButton[] buttons;
	private ConnectFourGame game;
	private JLabel[] board;

	public ButtonListener(JButton[] button, ConnectFourGame game, JLabel[] grid) {
		this.buttons = button;
		this.game = game;
		this.board = grid;
	}

	public void actionPerformed(ActionEvent e) {
		int row = 0;
		Object source = e.getSource();
		for (int i = 0; i < 7; i++) {
			if (source == buttons[i]) {
				row = i;
			}
		}
		try {
			ImageIcon player = game.getPlayerImage();
			row = game.takeTurn(row);
			board[row].setIcon(player);
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
				.showMessageDialog(null,
						"There is no winner and the board is full the game is now over");
		stopGame();
	}

	private void stopGame() {
		// make all buttons stop working if the board is full
		for (int i = 0; i < 7; i++) {
			for (ActionListener a : buttons[i].getActionListeners()) {
				buttons[i].removeActionListener(a);
			}
		}
	}

}
