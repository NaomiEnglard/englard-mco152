package englard.gui;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List extends JFrame  {
	private JList<String> list;

	
	public List(){
		setTitle("Use JList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		String[] data = {"one", "two", "three", "four", "five"};
		list = new JList<String>(data);
		list.setVisibleRowCount(3);
		JScrollPane scrollBar = new JScrollPane(list);
		scrollBar.setPreferredSize(new Dimension(200, 80));
		JPanel p = new JPanel();
		p.add(scrollBar);
		add(p);
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				JOptionPane.showMessageDialog(null,"yipee  you chose arrayList posstion" + index);
				data[index] = "clicked";
			}
			
		});
		//add(scrollBar);
	}
	public static void main(String args[]){
		List frame = new List();
		frame.setVisible(true);
	}
}
