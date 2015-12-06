package englard.weather;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.sun.net.ssl.HttpsURLConnection;

public class WeatherListner implements ActionListener {

	private JTextField zip;
	private JLabel temp;
	private JLabel description;
	private JLabel pic;

	public WeatherListner(JTextField zipFillBox, JLabel tempFillBox,
			JLabel descriptionFillBox, JLabel pic) throws IOException {
		this.zip = zipFillBox;
		this.temp = tempFillBox;
		this.description = descriptionFillBox;
		this.pic =pic;

	}

	public void actionPerformed(ActionEvent e) {
		String zip = this.zip.getText().trim();
		String defaultURL = "http://api.openweathermap.org/data/2.5/weather?zip=XXXXX,us&appid=2de143494c0b295cca9337e1e96b00e0";
		String weatherURL = defaultURL.replace("XXXXX", zip);
		URL url = null;
		try {
			url = new URL(weatherURL);
			HttpURLConnection connect = (HttpURLConnection) url
					.openConnection();
			Gson gson = new Gson();
			InputStreamReader isr = new InputStreamReader(connect.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			OpenWeatherMapData weatherData = gson.fromJson(br , OpenWeatherMapData.class);
			StringBuilder tempBuilder = new StringBuilder();
			tempBuilder.append(weatherData.temp());
			tempBuilder.append(" F");
			temp.setText(tempBuilder.toString());
			description.setText(weatherData.description());
			String defaultIcon = "http://openweathermap.org/img/w/XXX.png";
			URL iconUrl = new URL(defaultIcon.replace("XXX", weatherData.icon()));
			connect = (HttpURLConnection) iconUrl.openConnection();
			BufferedImage image = ImageIO.read(iconUrl);
			pic.setIcon(new ImageIcon(image));
			isr.close();
			br.close();
		} catch (IOException e1) {
		} catch(NullPointerException e1){
			JOptionPane.showMessageDialog(null, "Not a valid zip");
		}
		

	}

}
