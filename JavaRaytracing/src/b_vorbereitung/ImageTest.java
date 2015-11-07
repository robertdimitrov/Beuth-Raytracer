package b_vorbereitung;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ImageTest {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Imageviewer");		
		frame.setLayout( new BorderLayout() );	
		JMenuBar menu = new JMenuBar();
		JMenu save = new JMenu("save");
		menu.add(save);
		frame.setJMenuBar(menu);
		ImagePaint imagePainter = new ImagePaint();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.setSize( 640, 480 );
	    frame.setVisible( true );
	    frame.add(imagePainter);
	}
}
