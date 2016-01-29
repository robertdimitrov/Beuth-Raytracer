package aufgabe01;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Set;

import javax.swing.JPanel;


/**
 * Klasse zum erzeugen eines Raytracers
 * 
 * @author Clemens
 *
 */

public class Raytracer extends JPanel{
	
	public final World welt;
	public final Camera kamera;
	final int w;
	final int h;
	public BufferedImage image;
	
	/**
	 * @param w H�he des Bildes
	 * @param h Breite des Bildes
	 * @param backgroundColor Hintergrundfarbe
	 * @param kamera Kamera, die einen Strahl f�r jedes Pixel erzeugt
	 * @param set Menge mit Geometry-objekten
	 */
	public Raytracer(int w, int h,Color backgroundColor, Camera kamera,Set<Geometry> set){
		//neue Welt
		welt=new World(set, null, backgroundColor, backgroundColor);
		this.kamera=kamera;	
		this.w=w;
		this.h=h;		
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);		
		this.setSize(w, h);		
//		createImage();
	}
	
	/**
	 * Jedes Pixel wird in einer geschachtelten Schleife durchlaufen und ein neuer Strahl erzeugt mit der �bergebenen kamera
	 * @return image
	 */
//	public BufferedImage createImage(){
//
//		int count=0;
//		for(int i=0; i<w;i++){
//			for(int j=0;j<h;j++){
//				Ray r=kamera.rayFor(w, h, i, j);
//				Hit hit=welt.hit(r);
//				if(hit!=null){
//					// Aus dem zur�ckgegeben Hit-Objekt wird die Farbe ausgelesen und konvertiert, da die Methode setRGB() von BufferedImage
//					// einen int-Wert ben�tigt, um die Farbe zu setzen
//					int color=convertColor(hit.geo.material.colorFor(hit, welt));
//					image.setRGB(i, j,color);
//				}
//				else{int color = convertColor(welt.backgroundColor);
//					image.setRGB(i, j, color);
//				}
//			}
//		}
//
//		return image;
//	}
	
	/**
	 * 
	 *Werte werden nach Float gecastet, da Java.awt.Color float-Werte ben�tigt um ein Color-Objekt zu erzeugen
	 *und die setRGB()-Methode einen int-Wert ben�tigt f�r die Farbinformation
	 * 
	 * @param c color-Objekt
	 * @return int 
	 */
	public int convertColor(aufgabe01.Color c){
		
		
		float red=(float)c.getR();
		float green=(float)(c.getG());
		float blue=(float)(c.getB());
		java.awt.Color color = new java.awt.Color(red,green,blue);
		// Farbinformationen von color werden in einem int gespeichert
		int col = color.getRGB();
		return col;
	}
	
	@Override	
	protected void paintComponent( Graphics g ){
		super.paintComponent(g);				
	    if ( image != null )
	      g.drawImage(image,0, 0, this );	  
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + h;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((kamera == null) ? 0 : kamera.hashCode());
		result = prime * result + w;
		result = prime * result + ((welt == null) ? 0 : welt.hashCode());
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
		Raytracer other = (Raytracer) obj;
		if (h != other.h)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (kamera == null) {
			if (other.kamera != null)
				return false;
		} else if (!kamera.equals(other.kamera))
			return false;
		if (w != other.w)
			return false;
		if (welt == null) {
			if (other.welt != null)
				return false;
		} else if (!welt.equals(other.welt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Raytracer [welt=" + welt + ", kamera=" + kamera + ", w=" + w + ", h=" + h + ", image=" + image + "]";
	}		
}
