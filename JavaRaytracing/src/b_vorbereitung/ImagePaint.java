package b_vorbereitung;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePaint extends JPanel{
	
private BufferedImage image;
				
	public void paintImage(){
		int w = this.getWidth();
		int h = this.getHeight();
		
		final int black = new Color(0,0,0).getRGB();
		final int red = new Color(255,0,0).getRGB();
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);	
	
		for(int i = 0; i<w; i++){
			
			for(int j=0; j<h; j++){
				
				if(i==j){
					image.setRGB(i, j, red);
				}
				else { 
					image.setRGB(i, j, black);
				}
			}
		}				
	}
	
	protected void paintComponent( Graphics g ){
		paintImage();
	    if ( image != null )
	      g.drawImage( image, 0, 0, this );
	  }
	
	public BufferedImage getImage(){
		return image;
	}
}
