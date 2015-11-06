package englard.airline;

public class SeatOutOfBoundsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SeatOutOfBoundsException(){
		super("There is no seat with that number letter combination");
	}
}
