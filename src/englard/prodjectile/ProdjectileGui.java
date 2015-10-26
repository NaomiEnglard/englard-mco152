package englard.prodjectile;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProdjectileGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3068476851518602433L;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JButton enter;
	private JLabel output;

	// private ProdjectileArcComponent movement;

	public ProdjectileGui() {
		setTitle("Prodjectile Calculator");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("Angle");
		label2 = new JLabel("velocity");
		label3 = new JLabel("time");
		Font type = new Font("Courier New", Font.ITALIC, 20);
		label1.setFont(type);
		label1.setForeground(Color.MAGENTA);
		label2.setFont(type);
		label2.setForeground(Color.MAGENTA);
		label3.setFont(type);
		label3.setForeground(Color.MAGENTA);
		textField1 = new JTextField();
		Dimension size = new Dimension(400, 200);
		textField1.setMaximumSize(size);
		textField2 = new JTextField();
		textField2.setMaximumSize(size);
		textField3 = new JTextField();
		textField3.setMaximumSize(size);

		enter = new JButton("Calculate");
		output = new JLabel();

		add(label1);
		add(textField1);
		add(label2);
		add(textField2);
		add(label3);
		add(textField3);
		add(enter);
		add(output);

		// on click of enter button
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// create a new prodjectile withe 3 given inputs, convert the
				// inputed strings to double
				Prodjectile p = new Prodjectile(Double.parseDouble(textField1
						.getText()), Double.parseDouble(textField2.getText()),
						Double.parseDouble(textField3.getText()));
				StringBuilder answer = new StringBuilder();
				answer.append("x =");
				answer.append(Double.toString(p.getX()));
				answer.append("      y= ");
				answer.append(Double.toString(p.getY()));
				output.setText(answer.toString()); // convert double answer to
													// string

			}
		});

	}

}
