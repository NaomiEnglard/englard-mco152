package englard.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.server.Container;

import englard.math.InvalidInputException;
import englard.math.QuadraticEquation;

public class JFrameDemo extends JFrame{
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JButton button;
	
	
	public JFrameDemo(){
		setTitle("Quadratic");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new FlowLayout());
		
		java.awt.Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS)); //dispaly vertically
		
		label = new JLabel("A");
		add(label); 
		
		textField = new JTextField("             ");
		add(textField);
		
		label2 = new JLabel("B");
		add(label2);
		
		textField2 = new JTextField();
		add(textField2);
		
		label3 = new JLabel("C");
		add(label3);
		
		textField3 = new JTextField();
		add(textField3);
		
		button = new JButton("Compute");
		add(button);
		
		label4 = new JLabel();
		add(label4);
		
	
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				double a = Double.parseDouble(textField.getText());
				double b = Double.parseDouble(textField2.getText());
				double c  = Double.parseDouble(textField3.getText());
				QuadraticEquation q;
				try {
					q = new QuadraticEquation(a,b,c);
					Double answer = q.getNegativeX();
					Double answer2= q.getPositiveX();
					label4.setText(answer.toString()+ " " + answer2.toString());
				} catch (InvalidInputException e) {
					System.exit(1);
				}
				
				
				
			}
		});
		
		
		
		
	}
	 

}
