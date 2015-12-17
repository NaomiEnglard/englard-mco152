package englard.weather;

import java.text.DecimalFormat;

public class OpenWeatherMapData {
	private Weather[] weather;
	private Main main;

	public OpenWeatherMapData() {
		weather = new Weather[1];
		main = new Main();
	}

	public String description() {
		return weather[0].getDescription();
	}

	public String generalDescription() {
		return weather[0].getMain();

	}

	/*
	 * change temp from kelvin to farenhier, and return oF rounded to the second
	 * decimal place
	 */
	public double temp() {
		double kelvin = Double.parseDouble(main.getTemp());
		// double farenheit = kelvin * 9 / 5 - 459.67;
		// farenheit = Double.parseDouble(new DecimalFormat("##.##")
		// .format(farenheit));
		return kelvin;
	}

	public String icon() {
		return weather[0].getIcon();
	}

}
