package englard.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHTTPRequestDemo {
	public static void main(String args[]) throws UnknownHostException, IOException{
	
			//use port 80, the http port, to connect to goolge
			Socket socket = new Socket("www.google.com", 80);
			//http part or url
			String httpRequest ="GET /index.html\n\n";
			//get output of request ad write it to socket
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.write(httpRequest);
			out.flush();
			
			//read response and output it to screan
			
			
		     InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		     BufferedReader br = new BufferedReader(isr);
		     String s;
		     while((s =br.readLine()) != null){
			     System.out.println(s);
		     }
		     socket.close();

	}
}
