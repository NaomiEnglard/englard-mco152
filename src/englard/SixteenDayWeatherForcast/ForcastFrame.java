package englard.SixteenDayWeatherForcast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForcastFrame extends JFrame {

	private JPanel north;
	private JPanel center;
	private JTextField cityName;
	private JButton findWeather;
	private JLabel[] labelList;

	public ForcastFrame() {
		setTitle("16 day forecast");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		north = new JPanel();
		north.add(new JLabel("Enter a city:"));
		cityName = new JTextField(20); // longest city name is 20 char
		north.add(cityName);
		findWeather = new JButton("Find Weather Forcast");
		north.add(findWeather);
		add(north, BorderLayout.NORTH);

		center = new JPanel();
		center.setLayout(new GridLayout(16, 5));
		center.setBackground(new Color(240, 255, 255));
		labelList = new JLabel[80];
		for (int i = 0; i < labelList.length; i++) {
			labelList[i] = new JLabel("");
			center.add(labelList[i]);
		}
		add(center, BorderLayout.CENTER);

		findWeather.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String defaultUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?q=XXX&mode=json&units=Imperial&cnt=16&appid=ca1d966caacad3ba9ed500104b1b3c75";
				String city = cityName.getText().trim();
				// remove all spaces and replace with %20, which is what the web
				// url does
				for (int i = 1; i < city.length(); i++) {
					if (city.charAt(i) == ' ') {
						city = city.replace(" ", "%20");
					}
				}
				String url = defaultUrl.replace("XXX", city);
				// System.out.println(url);
				URL forcastURL;
				try {
					forcastURL = new URL(url);
					ForcastThread thread = new ForcastThread(labelList,
							forcastURL);
					thread.start();
					center.revalidate();

				} catch (MalformedURLException e1) {

				}
			}
		});

	}

	public static void main(String args[]) {
		ForcastFrame frame = new ForcastFrame();
		frame.setVisible(true);
	}

}
