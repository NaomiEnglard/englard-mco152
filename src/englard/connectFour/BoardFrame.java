package englard.connectFour;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import englard.gui.SmileComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

public class BoardFrame extends JFrame{
	private JPanel p;
	private RedBlueButton[] listButtons;
		
	public BoardFrame(){
		setTitle("Connect Four");
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container container = getContentPane();
		p = new JPanel();
		p.setLayout(new GridLayout(7,6));
		listButtons = new RedBlueButton[42];
		for(int i = 0; i<42; i++){
			listButtons[i] = new RedBlueButton();
			p.add(listButtons[i]);
		}
		add(p);
		//container.setBackground(Color.GRAY);
		
		
		
		
		
	}
public static void main(String args[]){
	BoardFrame frame = new BoardFrame();
	frame.setVisible(true);
}
}
