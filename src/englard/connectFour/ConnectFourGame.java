package englard.connectFour;

import javax.swing.ImageIcon;

import englard.math.InvalidDataException;


public class ConnectFourGame {

	private Board game;
	private Player a;
	private Player b;
	private Player whoseTurn;
	

	public ConnectFourGame() throws InvalidDataException {
		game = new Board();
		a = new Player(1, new ImageIcon(this.getClass().getResource(
				"./RedPiece.png")), "Red");
		b = new Player(2, new ImageIcon(this.getClass().getResource(
				"./BluePiece.png")), "Blue");
		whoseTurn = a; // start with red
		
		

	}

	/*
	 * switch players turn
	 */
	private void changeTurn() {
		if (whoseTurn == a) {
			whoseTurn = b;
		} else {
			whoseTurn = a;
		}
	}

	/*
	 * drop a piece into a slot, reuturn the row it was put in
	 */
	public int takeTurn(int slot) throws InvalidDataException, FilledException {
		int numInSlot = 0;
		if (slot <0 || slot > 7) {
			throw new InvalidDataException();
		} else {
			if (!game.isFull()) {
				numInSlot = this.game.addPieceToColumn(slot,
						whoseTurn.getPlayerNum());
				this.changeTurn();
			}
		}
		//return the number coresponding to the 
		//JLabel [] index, from 0-41 that the piece should go into
		return (slot) + 7* (5 - numInSlot);
	}

	

	/*
	 * return player image
	 */
	public ImageIcon getPlayerImage() {
		return whoseTurn.getPiecePicture();
	}

	/*
	 * get winner
	 */
	public Integer winner() {
		return game.winner();
	}
	
	public boolean isFull(){
		return game.isFull();
	}
}
