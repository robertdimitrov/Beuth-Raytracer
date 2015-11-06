package b_vorbereitung;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ImageTest {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Imageviewer");
		frame.setLayout( new BorderLayout() );	
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.setSize( 640, 480 );
	    frame.setVisible( true );
	    ImagePaint imagePainter = new ImagePaint();
	    frame.add(imagePainter);
	}
}
