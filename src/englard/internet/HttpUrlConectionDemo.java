package englard.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import sun.net.www.protocol.http.HttpURLConnection;

public class HttpUrlConectionDemo {
	public static void main(String args[]) throws IOException{
		//if string is not a url then u will get IOException
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=11367,us&appid=2de143494c0b295cca9337e1e96b00e0");//know how to exicute request
		HttpURLConnection connection  = (HttpURLConnection) url.openConnection();


		 InputStreamReader isr = new InputStreamReader(connection.getInputStream());
	     BufferedReader br = new BufferedReader(isr);
	     String s;
	     while((s =br.readLine()) != null){
		     System.out.println(s);
	     }
		
	}
}
