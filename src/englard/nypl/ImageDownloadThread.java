package englard.nypl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageDownloadThread extends Thread {

	private JLabel imageLabel;
	private URL url;

	public ImageDownloadThread(JLabel label, URL url) {

		this.url = url;
		this.imageLabel = label;

	}

	public void run() {
		imageLabel.setIcon(new ImageIcon(url));
	}
}
