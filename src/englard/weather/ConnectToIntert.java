package englard.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import englard.ufo.UFOSightingLIst;
import sun.net.www.protocol.http.HttpURLConnection;

public class ConnectToIntert {
	
	public static void main(String args[]) throws IOException{
		String zip ="11415";
		String homeWeather = "http://api.openweathermap.org/data/2.5/weather?zip=11367,us&appid=2de143494c0b295cca9337e1e96b00e0";
		homeWeather.replaceAll("11367", zip);
		URL url = new URL(homeWeather);//know how to exicute request
		HttpURLConnection connection  = (HttpURLConnection) url.openConnection();
		 
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
	     BufferedReader br = new BufferedReader(isr);
	     
	     Gson gson = new Gson();
	     gson.fromJson(br, );
	     
	     String s;
	     while((s =br.readLine()) != null){
		     System.out.println(s);
	     }
	}

}
