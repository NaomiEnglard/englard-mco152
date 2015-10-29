package englard.prodjectile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class ProdjectileArcComponent extends JComponent {
	private double angle;
	private double velocity;
	private int time;

	public ProdjectileArcComponent(double angle, double velocity, int time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// first second
		Prodjectile p = new Prodjectile(angle, velocity, 0);
		double x1 = p.getX();
		double y1 = getHeight() - p.getY();
		p.setTime(1);
		double x2 = p.getX();
		double y2 = getHeight() - p.getY();
		((Graphics2D) g).draw(new Line2D.Double(x1, y1, x2, y2));
		
		for (int i =2 ; i <= time; i++) {
			p.setTime(i);
			x1 = x2;
			y1 = y2;
			x2 = p.getX();
			y2 = getHeight() - p.getY();
			((Graphics2D) g).draw(new Line2D.Double(x1, y1, x2, y2));
		}

	}
}
