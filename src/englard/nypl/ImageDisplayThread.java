package englard.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.google.gson.Gson;

public class ImageDisplayThread extends Thread {

	private int listIndex;
	private JLabel imageLabel;
	private URL url;
	private NyplInfo imageInfo;
private NYPLFrame frame;
	public ImageDisplayThread(NyplInfo imageInfo, int index, JLabel image, URL url, NYPLFrame frame) {

		this.listIndex = index;
		this.imageLabel = image;
		this.url = url;
		this.imageInfo = imageInfo;
		this.frame = frame;
		

	}

	public void run() {
		try {
			HttpURLConnection connect;
			connect = (HttpURLConnection) url.openConnection();
			connect.setRequestProperty("Authorization", "Token token=\"jvwwhwt86dt9fept\"");
			InputStreamReader isr;
			isr = new InputStreamReader(connect.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			Gson gson = new Gson();
			imageInfo = gson.fromJson(br, NyplInfo.class);
			// need to set an array of capture and then have it in then in main
			// you can use it
			ArrayList<Capture> captures = imageInfo.getNyplAPI().getResponse().getCapture();
			frame.setCaptureList(captures);
			URL imageUrl = imageInfo.getNyplAPI().getResponse().getCapture().get(0).getImageLinks().getImageThree();

			// dowload the image with another thread
			Thread thread = new ImageDownloadThread(imageLabel, imageUrl);
			thread.run();

			br.close();
			isr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
