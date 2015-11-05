package englard.connectFour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RedBlueButton extends JButton implements ActionListener {
	private ImageIcon RED, BLUE;
	private int turn;

	public RedBlueButton() {
		BLUE = new ImageIcon(this.getClass().getResource("./BluePiece.png"));
		RED = new ImageIcon(this.getClass().getResource("./RedPiece.png"));
		this.addActionListener(this);
		this.turn = 0;
	}

	public void actionPerformed(ActionEvent event) {
		//turn++;
		turn %= 3;
		switch(turn){
		case 0:
			setIcon(null);
			break;
		case 1:
			setIcon(RED);
			break;
		case 2:
			setIcon(BLUE);
			break;
		}
	}
	
	public void setWhoseTurn(int whoseTurn){
		turn = whoseTurn;
		this.addActionListener(this);
	}
}