package englard.airline;

public class AlreadyReservedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AlreadyReservedException(){
		super("This seat is already reserved");
	}

}
