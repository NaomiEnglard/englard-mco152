package englard.contacts;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailedContactInfoFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DetailedContactInfoFrame(ContactInfo[] contactList, String name) {
		setTitle("Detailed Info");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel p = new JPanel(new GridLayout(10, 1));

		for (int i = 0; i < contactList.length; i++) {
			String contactName = new PersonName(contactList[i].getName()).toString();
			if (contactName.equals(name)) {
				p.add(new JLabel("email: "));
				p.add(new JLabel(contactList[i].getEmail()));
				p.add(new JLabel("address"));
				p.add(new JLabel(contactList[i].getAddress()));

			}
		}
		add(p);

	}

}
