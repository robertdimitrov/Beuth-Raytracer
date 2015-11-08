package b_vorbereitung;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePaint extends JPanel{
	
private BufferedImage image;
				
	public void paintImage(){
		
		int w = this.getWidth();
		int h = this.getHeight();		
		final int black = new Color(0,0,0).getRGB();
		final int red = new Color(255,0,0).getRGB();
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);	
		WritableRaster raster = image.getRaster();
		ColorModel model = image.getColorModel();
		Object r = model.getDataElements(red, null);
		int pixel[]= new int[w*h];
		
		for(int i=0; i<pixel.length;i++){
			pixel[i]=black;
		}
		raster.setDataElements(raster.getMinX(), raster.getMinY(), raster.getWidth(), raster.getHeight(), pixel);
					
		for(int i = 0; i<w; i++){
			
			for(int j=0; j<h; j++){
				
				if(i==j){
					raster.setDataElements(i, j, r);
				}												
			}
		}				
	}
	
	protected void paintComponent( Graphics g ){
		paintImage();
	    if ( image != null )
	      g.drawImage( image, 0, 0, this );
	}
	
	protected BufferedImage getImage(){
		return this.image;
	}
	
	protected void save(){
		
		JFileChooser chooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("Bilder", "png", "jpg");
		chooser.addChoosableFileFilter(filter);
		int returnVal = chooser.showSaveDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			
			final BufferedImage img = getImage();
			File file = null;
			String path = chooser.getSelectedFile().getPath();
			if(!path.toLowerCase().endsWith(".png")|| !path.toLowerCase().endsWith(".jpg") ){
				path=path+".jpg";
			}
			file = new File(path);
			try {				
				ImageIO.write(img, "png", file);
			}
			catch(IOException e){
				System.out.println("Could not write image to");
			}			
		}
		
		
		
	
		
		
		
	}
}
