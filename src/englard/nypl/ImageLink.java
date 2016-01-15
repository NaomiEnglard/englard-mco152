package englard.nypl;

import java.net.URL;
import java.util.ArrayList;

public class ImageLink {

	private ArrayList<URL> imageLink;

	public ArrayList<URL> getImageLink() {
		return imageLink;
	}

	public URL getImageThree() {
		return imageLink.get(3);
	}

}
