package englard.prodjectile;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;



public class ProdejectileArc extends JFrame {
	public ProdejectileArc(){
		setTitle("Projectile");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new ProdjectileArcComponent(31.0,20.0,20), layout.CENTER);
		
		
		
		
	}
	public static void main(String args[]) {
		ProdejectileArc frame = new ProdejectileArc();
		frame.setVisible(true);
	}
}
