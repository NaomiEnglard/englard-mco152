package englard.connectFour;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinnerFrame extends JFrame {
	
	public WinnerFrame(String winner){
		     setTitle("Winner!");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400,300);
	        setLocation(600, 200);
	        Container container = getContentPane();
	        playSound("clap.wav");
	        if(winner.equalsIgnoreCase("blue")){
	        	  container.setBackground(Color.BLUE);
	        }else{
	        	  container.setBackground(Color.RED);

	        }
	      
	        JLabel text  =  new JLabel(winner +" Won! \n Great Job!!!");
	        text.setFont(new Font("Courier New", Font.BOLD, 22));
	        text.setHorizontalAlignment(JLabel.CENTER);
	        text.setVerticalAlignment(JLabel.CENTER);
	        
	        add(text);
	        setVisible(true);
	    }
	public void playSound(final String file) {
	    new Thread(new Runnable() {

	        
	        public void run() {
				Applet.newAudioClip(getClass().getResource(file)).play();
	        }
	    }).start();
	}
	}


