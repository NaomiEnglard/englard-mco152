package englard.SixteenDayWeatherForcast;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class ForcastThread extends Thread {

	private JLabel[] info;
	private URL forecastURL;

	public ForcastThread(JLabel[] labelList, URL forcastURL) {

		this.info = labelList;
		this.forecastURL = forcastURL;
	}

	public void run() {
		try {
			HttpURLConnection connect = (HttpURLConnection) this.forecastURL
					.openConnection();
			Gson gson = new Gson();
			InputStreamReader isr = new InputStreamReader(
					connect.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			SixteenDayForcastInfo sixteenDay = gson.fromJson(br,
					SixteenDayForcastInfo.class);

			// for each day add another info
			int counter = 0;
			for (int i = 0; i < 16; i++) {
				BufferedImage image = ImageIO.read(sixteenDay.imageURL(i));
				if (i == 0) {
					info[counter++].setText("Today");
				} else {
					info[counter++].setText("In " + i + " days");
				}

				info[counter++].setIcon(new ImageIcon(image));
				info[counter++].setText(sixteenDay.mainDescriptioin(i));
				info[counter++].setText("Min: "
						+ String.valueOf(sixteenDay.minTemp(i)) + "\u00b0 F");
				info[counter++].setText("Max: "
						+ String.valueOf(sixteenDay.maxTemp(i)) + "\u00b0 F");

			}
			isr.close();
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Connection Not Working");
		}

	}

}
