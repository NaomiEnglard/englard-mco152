package englard.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {

	private HashMap<String, Character> seatMap;
	private int rows;
	private int columns;
	

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		seatMap = new HashMap<String, Character>();
		createSeatsInMap();
	}

	private void createSeatsInMap() {
		// create hashmap with all the seats, each seat starts as empty
		StringBuilder builder = new StringBuilder();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {

				// convert row number to letter
				char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
				String letter = Character.toString(alphabet[c]);
				builder.append(letter);
				builder.append(r + 1);// there is not a seat zero, so position 0
										// is seat 1
				// all seats start empty
				seatMap.put(builder.toString(), 'o');
				builder.setLength(0);
			}

		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {
		if (!seatMap.containsKey(seatName)) {
			throw new SeatOutOfBoundsException();
		}
		if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		} else {
			seatMap.replace(seatName, '#');
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return (seatMap.get(seatName).equals('#'));
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		build.append("  ");
		for (int i = 0; i < this.columns; i++) {
			build.append(Character.toString(alphabet[i]));// append letter for
															// each column in
															// the plane

		}

		int counter = 0;

		StringBuilder makeString = new StringBuilder();
		for (int c = 0; c < this.columns; c++) { // go through each column
			build.append("\n");
			build.append(++counter);
			build.append(" ");
			for (int r = 0; r < this.rows; r++) {
				String letter = Character.toString(alphabet[c]);
				makeString.append(letter);
				makeString.append(r + 1);// there is not a seat zero, so
											// position 0
				// is seat 1
				// all seats start empty

				build.append(seatMap.get(makeString.toString()));
				makeString.setLength(0);
			}

		}
		/*
		 * char row; char previousRow = '1'; for (Map.Entry<String, Character>
		 * mapValue : seatMap.entrySet()) { // if the second character in the
		 * value returned is a number that is // the same as the one before
		 * print on same line String seat = mapValue.getKey(); row =
		 * seat.charAt(1); if (row == previousRow) {
		 * build.append(mapValue.getValue()); previousRow = row; }else{ //add
		 * the row number as long as if(counter + 1 < rows){ build.append("\n");
		 * build.append(++counter); build.append(" ");
		 * 
		 * } }
		 * 
		 * }
		 */
		return build.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		if (numberOfSeatsTogether > this.rows) {
			throw new NotEnoughSeatsException();
		}
		ArrayList<Character> rowSpots = new ArrayList<Character>();
		ArrayList<String> groupSeatList = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int c = 0; c < columns; c++) {
			for (int r = 0; r < rows; r++) {
				// convert row number to letter
				char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
				String letter = Character.toString(alphabet[c]);
				builder.append(letter);
				builder.append(r + 1);// there is not a seat zero, so position 0
										// is seat 1
				// all seats start empty
				rowSpots.add(seatMap.get(builder.toString()));

				builder.setLength(0);
			}
			// after each row check if that row has the amount of seats u want
			// in a row
			int counter = 0;
			for (int i = 0; i < rowSpots.size(); i++) {
				if (rowSpots.get(i) == 'o') {
					counter++;
					// add the seat that is not empty
					// groupSeatList.add();
				} else {
					counter = 0;
					groupSeatList = null;
				}

			}
			if (counter == numberOfSeatsTogether) {
				return groupSeatList;
			}
			rowSpots = null;

		}

		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (Map.Entry<String, Character> mapValue : seatMap.entrySet()) {
			if (mapValue.getValue() == 'o') {
				return false;
			}
		}

		return true;
	}

}
