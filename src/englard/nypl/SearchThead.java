package englard.nypl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class SearchThead extends Thread {

	private URL url;
	private NyplInfo info;
	private DefaultListModel<Result> model;
	private NYPLFrame frame;

	public SearchThead(URL url, NyplInfo info, DefaultListModel<Result> listModel, NYPLFrame frame) {
		this.url = url;
		this.info = info;
		this.model = listModel;
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
			NyplInfo content = gson.fromJson(br, NyplInfo.class);
			frame.setInfo(content);
			
			ArrayList<Result> results = content.getNyplAPI().getResponse().getResults();
			for (int i = 0; i < results.size(); i++) {
				model.addElement(results.get(i));
			}
			

			br.close();
			isr.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "IO Exception");
		}

	}
}
