package englard.nypl;

import java.util.ArrayList;

public class Response {

	private String numResults;
	private ArrayList<Result> result;
	private ArrayList<Capture> capture;

	public ArrayList<Capture> getCapture() {
		return capture;
	}

	public String getNumResults() {
		return numResults;
	}

	public ArrayList<Result> getResults() {
		return result;
	}

}
