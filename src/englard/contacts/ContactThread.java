package englard.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;

public class ContactThread extends Thread {

	private DefaultListModel<String> contacts;
	ContactFrame showContactFrame;

	// private ContactInfo[] info;

	public ContactThread(DefaultListModel<String> contacts, ContactFrame contactFrame) throws IOException {
		this.contacts = contacts;
		this.showContactFrame = contactFrame;
		// this.info =info;

	}

	public void run() {
		URL url;
		try {
			url = new URL("http://jsonplaceholder.typicode.com/users");

			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			Gson gson = new Gson();
			InputStreamReader isr = new InputStreamReader(connect.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			ContactInfo[] info = gson.fromJson(br, ContactInfo[].class);
			this.showContactFrame.setContactList(info);

			ArrayList<String> sortedContacts = new ArrayList<String>();
			for (int i = 0; i < info.length; i++) {
				sortedContacts.add(new PersonName(info[i].getName()).toString());
				// System.out.println(sortedContacts.get(i));

			}
			// sort by last name
			Collections.sort(sortedContacts);
			// add components to list
			for (int i = 0; i < info.length; i++) {
				String name = sortedContacts.get(i);
				contacts.addElement(name);

			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "url error");
		}

	}

}
