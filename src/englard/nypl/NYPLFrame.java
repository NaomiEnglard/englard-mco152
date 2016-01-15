package englard.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.glass.events.KeyEvent;

public class NYPLFrame extends JFrame {
	private JPanel north;
	private JButton search;
	private JTextField searchText;
	private NyplInfo info;
	private JPanel center;
	private JList<Result> list;
	private JLabel image;
	private NyplInfo imageInfo;
	private ArrayList<Capture> captureList;
	private JButton next;
	private JButton previos;
	private JLabel imageUpTo;
	private int counter;

	public NYPLFrame() {
		setTitle("NYPL Search And Dispaly");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		north = new JPanel();
		searchText = new JTextField(40);
		search = new JButton("Search");
		north.add(searchText);
		north.add(search);
		container.add(north, BorderLayout.NORTH);
		DefaultListModel<Result> listModel = new DefaultListModel<Result>();
		list = new JList<Result>(listModel);
		list.setPreferredSize(new Dimension(150, 600));

		center = new JPanel();
		center.setLayout(new BorderLayout());
		image = new JLabel();
		JScrollPane scrollBox = new JScrollPane(image);

		next = new JButton("Next");
		imageUpTo = new JLabel("1/ ");
		previos = new JButton("Previous");
		JPanel nextPanel = new JPanel();
		nextPanel.add(previos);
		nextPanel.add(imageUpTo);
		nextPanel.add(next);

		center.add(nextPanel, BorderLayout.NORTH);
		center.add(scrollBox, BorderLayout.CENTER);
		container.add(center, BorderLayout.CENTER);
		next.setEnabled(false);
		previos.setEnabled(false);
		NYPLFrame parent = this;
		counter = 0;
		search.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// clear the jlist
				listModel.removeAllElements();
				String urlName = "http://api.repo.nypl.org/api/v1/items/search?q=XXX&publicDomainOnly=true";
				urlName = urlName.replace("XXX", searchText.getText());
				URL url;
				try {
					url = new URL(urlName);
					Thread thread = new SearchThead(url, info, listModel, parent);
					thread.start();
					container.add(list, BorderLayout.WEST);
				} catch (MalformedURLException e1) {
					JOptionPane.showMessageDialog(null, "Malformed url");
				}

			}

		});
		/*
		 * search.addKeyListener(new KeyListener() {
		 * 
		 * @Override public void keyPressed(java.awt.event.KeyEvent e) { //
		 * System.out.println("enet"); if (e.getKeyCode() == KeyEvent.VK_ENTER)
		 * { listModel.removeAllElements(); String urlName =
		 * "http://api.repo.nypl.org/api/v1/items/search?q=XXX&publicDomainOnly=true"
		 * ; urlName = urlName.replace("XXX", searchText.getText()); URL url;
		 * try { url = new URL(urlName); Thread thread = new SearchThead(url,
		 * info, listModel, parent); thread.start(); container.add(list,
		 * BorderLayout.WEST); } catch (MalformedURLException e1) {
		 * JOptionPane.showMessageDialog(null, "Malformed url"); } } }
		 * 
		 * @Override public void keyReleased(java.awt.event.KeyEvent arg0) { //
		 * TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * @Override public void keyTyped(java.awt.event.KeyEvent arg0) { //
		 * TODO Auto-generated method stub
		 * 
		 * }
		 * 
		 * });
		 */

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				counter = 0;

				int index = list.getSelectedIndex(); // start at 0
				// start a thread to load the images it should dispaly
				URL url = info.getNyplAPI().getResponse().getResults().get(index).getApiItemURL();
				Thread listThread = new ImageDisplayThread(imageInfo, index, image, url, parent);
				listThread.start();
				next.setEnabled(true);

			}

		});

		next.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				previos.setEnabled(true);
				if (counter == captureList.size() - 1) {
					// make next not work
					next.setEnabled(false);
				}
				++counter;
				imageUpTo.setText(counter + 1 + "/" + captureList.size());
				image.setIcon(new ImageIcon(captureList.get(counter).getImageLinks().getImageThree()));
				if (counter == captureList.size() - 1) {
					// make next not work
					next.setEnabled(false);
				}

			}

		});
		previos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (counter == 0) {
					// make next not work
					next.setEnabled(false);
				}
				--counter;
				imageUpTo.setText(counter + 1 + "/" + captureList.size());
				image.setIcon(new ImageIcon(captureList.get(counter).getImageLinks().getImageThree()));

				if (counter == 0) {
					// make next not work
					previos.setEnabled(false);
				}

			}

		});
	}

	public void setInfo(NyplInfo info) {
		this.info = info;
	}

	public static void main(String args[]) {
		NYPLFrame f = new NYPLFrame();
		f.setVisible(true);
	}

	public void setCaptureList(ArrayList<Capture> captures) {
		this.captureList = captures;

	}
}
