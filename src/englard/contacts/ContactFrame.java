package englard.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class ContactFrame extends JFrame {

	private ContactInfo[] contactList;
	private JList<String> contacts;
	private DefaultListModel<String> model;

	public ContactFrame() {
		setTitle("Practice");
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = new DefaultListModel<String>();

		contacts = new JList<String>(model);
		add(contacts);
		try {
			ContactThread thread = new ContactThread(model, this);
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		contacts.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList<String> list = (JList<String>) evt.getSource();
				if (evt.getClickCount() == 2) {
					// Double-click
					int index = list.locationToIndex(evt.getPoint());
					// System.out.println("you double clicked" + index);

					DetailedContactInfoFrame detail = new DetailedContactInfoFrame(contactList, model.get(index));
					detail.setVisible(true);

				}
			}
		});

	}

	public DefaultListModel<String> getModel() {
		return model;
	}

	public void setModel(DefaultListModel<String> model) {
		this.model = model;
	}

	public void setContactList(ContactInfo[] contactList) {
		this.contactList = contactList;
	}

	public static void main(String args[]) {
		ContactFrame f = new ContactFrame();
		f.setVisible(true);
	}
}
