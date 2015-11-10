package englard.connectFour;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MoveCircle extends JComponent implements KeyListener {

	private double x;
	private double y;
	private double columnsDown;

	public MoveCircle(double columnsDown) {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		x = 0;
		y = 0;
		this.columnsDown = columnsDown;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.RED);
		g2.fill(new Ellipse2D.Double(x, y, 50, 50));

	}

	public void down() {
		if (y == 0.0) {// only move down once
			x += 0;
			y += 100 * columnsDown;// times number of columns it can go down
			super.repaint();
		}
	}

	public void right() {
		if (x < getWidth() - 100 && y == 0.0) {// if bigger than size of frame
												// dont
												// move it right
			// and if y is not zero dont move
			x += 100;
			y += 0;
			super.repaint();
		}
	}

	public void left() {
		if (x >= 100 && y == 0.0) { //move left if there is more room, and you did not move down yet
			x += -100;
			y += 0;
			super.repaint();
		}
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_RIGHT) {
			right();
		} else if (keyCode == KeyEvent.VK_DOWN) {
			down();
		} else if (keyCode == KeyEvent.VK_LEFT) {
			left();
		}

	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	/*public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}
	*/

	/*public static void main(String args[]) {
		JFrame frame = new JFrame();
		// Container container = getContentPane();
		// container.setLayout(new GridLayout(7,6));
		frame.add(new MoveCircle(4));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setResizable(false);
	}
	*/

}
