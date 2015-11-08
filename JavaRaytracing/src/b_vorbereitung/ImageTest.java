package b_vorbereitung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class ImageTest {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Imageviewer");		
		frame.setLayout( new BorderLayout() );	
		JMenuBar menu = new JMenuBar();				
		frame.setJMenuBar(menu);
		ImagePaint imagePainter = new ImagePaint();
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("hallo");
				 imagePainter.save();
			}
		};
		JMenuItem save = new JMenuItem("save");
		save.addActionListener(listener);
		menu.add(save);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.setSize( 640, 480 );
	    frame.setVisible( true );
	    frame.add(imagePainter);
	   
	}
}
