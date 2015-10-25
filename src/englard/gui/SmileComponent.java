package englard.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.YELLOW);
		g.fillOval(25, 50, 310, 310);
		
		g.setColor(Color.BLACK);
		g.drawLine(160, 120,90,90);
		g.drawLine(210, 120, 300, 100);
		
		g.setColor(Color.GREEN);
		g.fillOval(90, 120, 75, 75);
		g.fillOval(215, 120, 75, 75);
		
		g.setColor(Color.RED);
		g.drawArc(100, 250, 150, 120, 0, 180);
	}

}
