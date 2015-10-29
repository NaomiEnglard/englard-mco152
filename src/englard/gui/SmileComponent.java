package englard.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	private int y;
	private int x;
	public Point mousePostion;

	public SmileComponent() {
		// this.y = 50;
	}

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

		/*
		 * if (y <= 50 && y > 0) { g.fillOval(90, 135, 50, y--); } if (y <= 0) {
		 * y = 50; } try { Thread.sleep(16); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 * super.repaint();
		 */

		mousePostion = MouseInfo.getPointerInfo().getLocation();
		x = mousePostion.x;
		y = mousePostion.y;

		g.fillOval(210, 135, 60, 60);
		g.fillOval(90, 135, 60, 60);
		g.setColor(Color.WHITE);

		g.fillOval(x / 30 + 90, y / 30 + 150, 12, 12);
		g.fillOval(x / 30 + 210, y / 30 + 150, 12, 12);

		super.repaint();

		g.setColor(Color.RED);
		g.drawArc(110, 175, 150, 120, 180, 180);

	}

}
