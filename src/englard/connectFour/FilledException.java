package englard.connectFour;

public class FilledException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilledException(){
		super("The slot is full already, you may not add more pieces");
	}
}
