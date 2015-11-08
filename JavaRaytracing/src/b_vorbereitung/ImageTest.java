package b_vorbereitung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;

public class ImageTest {

	public static void main(String[] args) {
		
		ImagePaint imagePainter = new ImagePaint();
		ActionListener saveAL = new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
			    // retrieve image		
				final BufferedImage img = imagePainter.getImage();
				try {
				    File outputfile = new File("images/saved.png");
				    ImageIO.write(img, "png", outputfile);
				}	
				catch (IOException ioe) {
				    System.out.println("Could not write image to");
				}
			}
		};
		JFrame frame = new JFrame("Imageviewer");		
		frame.setLayout( new BorderLayout() );	
		JMenuBar menu = new JMenuBar();
		JMenuItem save = new JMenuItem("save");
		save.addActionListener(saveAL);
		menu.add(save);
		frame.setJMenuBar(menu);
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.setSize( 640, 480 );
	    frame.setVisible( true );
	    frame.add(imagePainter);
	}
}
