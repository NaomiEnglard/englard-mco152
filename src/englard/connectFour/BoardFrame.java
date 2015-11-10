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

		try {
			game = new ConnectFour();
		} catch (InvalidDataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.button = new JButton[7];
		for (int i = 0; i < 7; i++) {
			//button[i].addActionListener(arg0);
			p.add(button[i] = new JButton(new ImageIcon(this.getClass()
					.getResource("./downArrow.png"))));
		}

		this.grid = new JLabel[42];
		for (int i = 0; i < 42; i++) {
			grid[i] = new JLabel(String.valueOf(i));
			grid[i].setBorder(new LineBorder(Color.BLACK));
			p.add(grid[i]);
		}

		add(p);

		button[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int row = 0;
				try {
					row = game.takeTurn(1);
				} catch (InvalidDataException | FilledException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(row);

				switch (row) {
				case 0:
					row = 35;
					break;
				case 1:
					row = 28;
					break;
				case 2:
					row = 21;
					break;
				case 3:
					row = 14;
					break;
				case 4:
					row = 7;
					break;
				case 5:
					row = 0;
					break;

				}
				grid[row].setIcon(game.getPlayerImage());
				// grid[counter].setIcon(new
				// ImageIcon(this.getClass().getResource(game.getPlayerImage())));

			}

			private void winner(int winner) {
				JOptionPane.showMessageDialog(null, "Great Job player "
						+ winner + "winns");

			}

			private void full() {
				JOptionPane
						.showMessageDialog(null,
								"There is no winner and the board is full the game is now over");
				// make all buttons stop working if the board is full
				for (int i = 0; i < 7; i++) {
					for (ActionListener a : button[i].getActionListeners()) {
						button[i].removeActionListener(a);
					}
				}
			}

		});

	}

	public static void main(String args[]) {
		BoardFrame frame = new BoardFrame();
		frame.setVisible(true);
	}
}
