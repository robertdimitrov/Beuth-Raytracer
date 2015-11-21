package b_vorbereitung;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Clemens
 *
 */
	class ImagePaint extends JPanel{
	
/** BufferedImage, wird in der Methode paintImage initialisiert */
	
	protected BufferedImage image;

	public ImagePaint(){
		super();
		this.setSize(640, 480);
		paintImage();
	}
					
	/**
	 * Methode zum Zeichnen eines BufferedImage mit schwarzem Hintergrund und einer roten Diagonale
	 */
	public void paintImage(){
		
		final int w = this.getWidth();
		final int h = this.getHeight();		
		final int black = new Color(0,0,0).getRGB();
		final int red = new Color(255,0,0).getRGB();
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);	
		final WritableRaster raster = image.getRaster();
		final ColorModel model = image.getColorModel();
		final Object r = model.getDataElements(red, null);
		final int pixel[]= new int[w*h];		
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
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * 
	 */
	protected void paintComponent( Graphics g ){
		super.paintComponent(g);
		paintImage();		
	    if ( image != null )
	      g.drawImage( image, 0, 0, this );	  
	}
	
	/**
	 * @return Ein BufferedImage
	 */
	protected BufferedImage getImage(){
		return this.image;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagePaint other = (ImagePaint) obj;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		return true;
	}

	/**
	 * Methode zum Speichern eines Bildes
	 * 
	 */
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
				ImageIO.write(img, "jpg", file);
			}
			catch(IOException e){				
			}			
		}													
	}

	@Override
	public String toString() {
		return "ImagePaint [image=" + image + "]";
	}			
}
