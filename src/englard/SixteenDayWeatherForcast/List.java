package englard.SixteenDayWeatherForcast;

public class List {

	private Temp temp;
	private String humidity;
	private weather[] weather;

	public String getHumidity() {
		return humidity;
	}

	public double getMaxTemp() {
		return temp.getMax();
	}

	public double getMinTemp() {
		return temp.getMin();

	}

	public String getIcon() {
		return weather[0].getIcon();
	}

	public String getMain() {
		return weather[0].getMain();
	}
	
	

}
