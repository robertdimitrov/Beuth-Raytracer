package b_vorbereitung;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class ImageOpen {
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final JDialog dialog = new JDialog();
				dialog.setTitle("ooga");
				final Container container = dialog.getContentPane();
				final JFileChooser fChooser = new JFileChooser();
				fChooser.setFileFilter(new FileFilter() {

					@Override
					public String getDescription() {
						return "images( jpg, bmp, gif, png, jpeg, wbmp)";
					}

					@Override
					public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						}
						for (String s : ImageIO.getReaderFileSuffixes()) {
							if (f.toString().endsWith("." + s)) {
								return true;
							}
						}
						return false;
					}
				});

				int returnVal = fChooser.showOpenDialog(container);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					final JFrame imgframe = new JFrame();
					final BufferedImage img;
					File file = fChooser.getSelectedFile();
					try {
						img = ImageIO.read(file);
						imgframe.getContentPane().add(new JPanel() {
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
							public void paintComponent(Graphics g) {
								BufferedImage image = img;
								Graphics2D graphics2d = (Graphics2D) g;
								graphics2d.drawImage(image, 0, 0, null);
								super.paintComponents(g);
							}	
						});
						imgframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						imgframe.setSize(img.getWidth(), img.getHeight());
						imgframe.setVisible(true);
					} catch (IOException e) {
						System.err.println(file + " could not be opened");
					}
				}
				System.out.println("done");
			}
		});
	}

}
