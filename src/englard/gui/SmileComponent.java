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
		g.drawArc(90, 100, 55, 100, 45, 100);
		g.drawArc(210, 100, 55, 100, 45, 100);
		// g.drawArc(x, y, width, height, startAngle, arcAngle);
		g.setColor(Color.GREEN);
		g.fillOval(90, 135, 50, 50);
		g.fillOval(210, 135, 50, 50);

		g.setColor(Color.RED);
		g.drawArc(110, 175, 150, 120, 180, 180);
	}

}
