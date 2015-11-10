package englard.connectFour;
/*
 * Use with a main
 */

import englard.math.InvalidDataException;

public class ConnectFourGame {
	private Person player1;
	private Person player2;
	private int whoseTurn;
	private Board connectFourBoard;

	public ConnectFourGame() {
		// get both players names and color they want to be

		this.connectFourBoard = new Board();
		this.whoseTurn = 1; // red,1 goes first
	}

	/*
	 * allow player to take a turn and return the winner
	 * 
	 * @return return winner or if there is no winner return null
	 */
	public Integer takeTurn(int column) throws FilledException,
			InvalidDataException {
		if (!this.connectFourBoard.isFull()) {
			this.connectFourBoard.addPieceToColumn(column, whoseTurn);
			changeWhoseTurn();
		}
		return this.connectFourBoard.winner();


	}

	private void changeWhoseTurn() {
		if (this.whoseTurn == 1) {
			whoseTurn = 2;
		} else {
			this.whoseTurn = 1;
		}
	}
	 public int getWhoseTurn(){
		 return whoseTurn;
	 }

}
