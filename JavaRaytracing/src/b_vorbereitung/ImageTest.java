package b_vorbereitung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



/**
 * @author Clemens
 * 
 * Klasse zum Test der Klasse ImagePainter
 *
 */
public class ImageTest {

	/**
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Imageviewer");
		frame.setSize(640,480);
		frame.setLayout( new BorderLayout() );	
		JMenuBar menu = new JMenuBar();				
		frame.setJMenuBar(menu);
		ImagePaint imagePainter = new ImagePaint();	
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){			
				 imagePainter.save();
			}
		};
		JMenuItem save = new JMenuItem("save");
		save.addActionListener(listener);
		menu.add(save);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	   	   	  
	    frame.add(imagePainter);	 
	    frame.setVisible( true );	   
	}
}
