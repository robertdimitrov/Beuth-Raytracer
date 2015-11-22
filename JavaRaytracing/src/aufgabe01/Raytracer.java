package aufgabe01;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Set;

import javax.swing.JPanel;


public class Raytracer extends JPanel{
	
	public final World welt;
	public final Camera kamera;
	final int w;
	final int h;
	public BufferedImage image;
	
	public Raytracer(int w, int h,Color backgroundColor, Camera kamera,Set<Geometry> set){
		//neue Welt
		welt=new World(set,backgroundColor);
		//neue Kamera
		this.kamera=kamera;
		//Breite und Höhe des Bildes
		this.w=w;
		this.h=h;
		//Die Fläche wird erzeugt
		this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);	
		//Größe des Panels setzen
		this.setSize(w, h);
		//Fläche wird gezeichnet je nachdem, welche Geometrien im Set sind.
		createImage();
	}
	
	public BufferedImage createImage(){
		/*
		 * Jedes Pixel wird in einer geschachtelten Schleife durchlaufen und ein neuer Strahl erzeugt mit der übergebenen kamera
		 */
		for(int i=0; i<w;i++){			
			for(int j=0;j<h;j++){				
				Ray r=kamera.rayFor(w, h, i, j);				
				Hit hit=welt.hit(r);
				if(hit!=null){
					// Aus dem zurückgegeben Hit-Objekt wird die Farbe ausgelesen und konvertiert, da die Methode setRGB() von BufferedImage 
					// einen int-Wert benötigt, um die Farbe zu setzen
					int color=convertColor(hit.geo.color);
					image.setRGB(i, j,color);
				}
				else{int color = convertColor(welt.backgroundColor);
					image.setRGB(i, j, color);
				}
			}
		}
		
		return image;
	}
	
	public int convertColor(aufgabe01.Color c){
		
		// Werte werden nach Float gecastet, da Java.awt.Color float-Werte benötigt um ein Color-Objekt zu erzeugen
		// und die setRGB()-Methode einen int-Wert benötigt für die farbinformation
		
		float red=(float)c.getR();
		float green=(float)(c.getG());
		float blue=(float)(c.getB());
		java.awt.Color color = new java.awt.Color(red,green,blue);
		// Farbinformationen von color werden in einem int gespeichert
		int col = color.getRGB();
		return col;
	}
	
	protected void paintComponent( Graphics g ){
		super.paintComponent(g);				
	    if ( image != null )
	      g.drawImage(image,0, 0, this );	  
	}
}
