package englard.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class EmptyBoardComponent extends JComponent{
	
	public EmptyBoardComponent(){
		setOpaque(false);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0, 100, 200, 200);
	}
	
}
