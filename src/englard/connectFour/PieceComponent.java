package englard.connectFour;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class PieceComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;

	public PieceComponent(Color color) { 
		this.color = color;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(color);
		g.fillOval(0, 10, 30, 30);

		// mousePosition = MouseInfo.getPointerInfo().getLocation();
		// g.fillOval(mousePosition.x, mousePosition.y, 15, 15);
		super.repaint();

	}
}
