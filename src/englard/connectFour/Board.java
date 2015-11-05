package englard.connectFour;

import java.util.ArrayList;
import java.util.Stack;

public class Board {
	private Integer[][] board;

	private Board() {
		board = new Integer[7][6];
	}

	/*
	 * Add piece to a opening at the top
	 * 
	 * @param slotNo - the slot you want to put a piece in, slot numbers start
	 * at 1 and go from left to right
	 */
	private void addPieceToColumn(int slotNO, int whoseTurn)
			throws FilledException {
		if (this.isFull()) { // if board is not full
			throw new FilledException();
		}
		slotNO--;// user starts slot at 1, array starts at 0
		if (slotNO > 0 && slotNO < board.length) { // slot is a slot btw 1-7
			int piecesInSlot = this.board[slotNO].length;
			if (piecesInSlot < board[0].length) { // if the slot is not full
													// -all leght are same
				// add a piece to the next position in the slot
				this.board[slotNO][++piecesInSlot] = whoseTurn;
			} else {
				throw new FilledException();
			}
		}

	}

	/*
	 * @return if the board is full
	 */
	public boolean isFull() {
		int howManyFull = 0;
		for (int slot = 0; slot < board.length; slot++) {
			if (this.board[slot][5] != null) {
				howManyFull++;
			}
		}
		return (howManyFull == 7);
	}

	/*
	 * @return return the winner if someone won other wise return null
	 */
	public Integer winner() {
		// check the board for a winner
		Integer winner = null;
		// horizontal test
		winner = horizontalWinner();
		if (winner != null) {
			return winner;
		}

		// vertical test
		winner = verticalWinner();
		if (winner != null) {
			return winner;
		}
		// negative slop diagnal test
		winner = negativeDiagnalWinner();
		if (winner != null) {
			return winner;
		}
		// positive slop diagnal test
		winner = positiveDiagnalWinner();
		if (winner != null) {
			return winner;
		}
		return winner;
	}

	private Integer horizontalWinner() {
		for (int height = 0; height < board[0].length; height++) {
			for (int slot = 3; slot < board.length; slot++) {

				// start at slot 3 to compare that value with the three behind
				// it
				Integer player = board[slot][height];
				if (player == board[slot - 1][height]
						&& player == board[slot - 2][height]
						&& player == board[slot - 3][height]) {
					return player;
				}
			}

		}
		return null;
	}

	private Integer verticalWinner() {
		for (int slot = 0; slot < board.length; slot++) {
			for (int height = 3; height < board[slot].length; height++) {
				// to have 4 in a row need 4 pieces =third height spot
				if (board[slot][height] == board[slot][height - 1]
						&& board[slot][height] == board[slot][height - 2]
						&& board[slot][height] == board[slot][height - 3]) {
					// return the winner that has 4 in a row
					return board[slot][height];
				}

			}
		}
		return null; // if did not find a winner return null
	}

	private Integer positiveDiagnalWinner() {

		for (int slot = 0; slot < board.length - 3; slot++) {
			for (int height = 0; height < board[slot].length; height++) {
				// start at slot o height 3 since there is not enough room to
				// have four in a row daignaly before slot 3
				Integer player = board[slot][height];
				if (player == board[slot + 1][height + 1]
						&& player == board[slot + 2][height + 2]
						&& player == board[slot + 3][height + 3]) {
					return player;
				}

			}
		}
		return null;
	}

	private Integer negativeDiagnalWinner() {
		for (int slot = 0; slot < board.length - 3; slot++) {
			for (int height = 3; height < board[slot].length; height++) {
				// start at slot o height 3 since there is not enough room to
				// have four in a row diagnally before slot 3
				Integer player = board[slot][height];
				if (player == board[slot + 1][height - 1]
						&& player == board[slot + 2][height - 2]
						&& player == board[slot + 3][height - 3]) {
					return player;
				}

			}
		}
		return null;
	}

	public static void main(String args[]) throws FilledException {
		Board connectBoard = new Board();
		connectBoard.addPieceToColumn(1, 1);
		System.out.println(connectBoard.winner());
		connectBoard.addPieceToColumn(1, 1);
		System.out.println(connectBoard.winner());
		connectBoard.addPieceToColumn(1, 1);
		System.out.println(connectBoard.winner());
		connectBoard.addPieceToColumn(1, 1);
		System.out.println(connectBoard.winner());

	}
}
