package englard.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SmileFrame() {
		setTitle("Sad Face");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new SmileComponent(), layout.CENTER);
	}

	public static void main(String args[]) {
		SmileFrame frame = new SmileFrame();
		frame.setVisible(true);
	}
}
