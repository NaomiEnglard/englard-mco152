package englard.connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class WhiteCircle extends JComponent{

	public void paintComponent (Graphics g)
    { 
    super.paintComponent(g); 
    g.setColor(Color.WHITE); 
    g.fillOval(0,0, 20, 20); 
    
} 
}
