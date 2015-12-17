package englard.weather;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShowWeatherGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel tempTitle;
	private JLabel tempFillBox;
	private JLabel descriptionTitle;
	private JLabel descriptionFillBox;
	private JLabel pic;
	private JButton getWeather;
	private JTextField zipFillBox;
	private JLabel zipTitle;

	public ShowWeatherGui() throws IOException {
		setTitle("Weather");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		getWeather = new JButton("Find Weather");
		zipFillBox = new JTextField(5);
		zipTitle = new JLabel("Enter a zip code");
		north.add(zipTitle);
		north.add(zipFillBox);
		north.add(getWeather);
		add(north, BorderLayout.NORTH);

		pic = new JLabel("");
		pic.setSize(100, 100);
		add(pic, BorderLayout.EAST);

		tempTitle = new JLabel("Temprature: ");
		tempFillBox = new JLabel("");
		descriptionTitle = new JLabel("Descrition:  ");
		descriptionFillBox = new JLabel("");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(tempTitle);
		p.add(tempFillBox);
		p.add(descriptionTitle);
		p.add(descriptionFillBox);
		add(p, BorderLayout.CENTER);
		getWeather.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ZipButtonThread zipThread;
				try {
					zipThread = new ZipButtonThread(zipFillBox, tempFillBox, descriptionFillBox, pic);
					zipThread.run();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	public static void main(String args[]) throws IOException {
		ShowWeatherGui weather = new ShowWeatherGui();
		weather.setVisible(true);
	}

}
