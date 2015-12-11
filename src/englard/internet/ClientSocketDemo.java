package englard.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {
	public static void main(String args[]) throws UnknownHostException, IOException {
		String serverIP = "192.168.117.73";
		Socket socket = new Socket(serverIP, 52746);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("HI CHAVA!\n"); // need \n
		out.flush();
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String response = br.readLine();
		System.out.println("RESPONSE: ");
		System.out.println(response);
		socket.close();
	}
}
