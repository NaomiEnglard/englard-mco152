package englard.SixteenDayWeatherForcast;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import com.sun.javafx.binding.StringFormatter;

public class SixteenDayForcastInfo {

	// private City city;
	private List[] list;

	public SixteenDayForcastInfo() {
		// city = new City();
		list = new List[16];
	}

	public double maxTemp(int day) {
		// day 1 of 16 days is spot 0
		return list[day].getMaxTemp();
	}

	public double minTemp(int day) {
		return list[day].getMinTemp();
	}

	public URL imageURL(int day) throws MalformedURLException {

		String defaultIcon = "http://openweathermap.org/img/w/XXX.png";
		URL iconUrl = new URL(defaultIcon.replace("XXX", list[day].getIcon()));
		return iconUrl;
	}

	public String mainDescriptioin(int day) {
		return list[day].getMain();
	}

}
