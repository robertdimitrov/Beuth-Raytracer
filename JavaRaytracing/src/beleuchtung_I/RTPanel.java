package beleuchtung_I;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.WellKnownNamespace;

import aufgabe01.Camera;
import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.World;

/**
 * Klasse zum Erzeugen eines Raytracer-Panels
 * @author Kosmonaut
 */

public class RTPanel extends JPanel {

    /**
     * Das World-Objekt, das in diesem Raytracer zu benutzen ist
     */
    final public World welt;
    /**
     * Die Kamera für diesen Raytracer
     */
    final public Camera camera;
    /**
     * Die Bildbreite dieses RTPanels
     */
    final private int w;
    /**
     * Die Bildhöhe dieses RTPanels
     */
    final private int h;
    /**
     * Das zu erzeugende Bild
     */
    private BufferedImage image;


    /**
     * Erstellt einen neuen RTPanel
     * @param camera die Kamera für diesen RTPanel
     * @param welt die Welt für diesen RTPanel
     */
    public RTPanel(final Camera camera, final World welt) {
        if(camera==null) throw new IllegalArgumentException("camera darf nicht null sein");
        if(welt==null) throw new IllegalArgumentException("welt darf nicht null sein");
        this.camera = camera;
        this.welt = welt;
        this.w = 640;
        this.h = 480;
        setSize(w, h);
        this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        createImage();
    }

    /**
     * Erstellt das entsprechende Bild fuer diesen Raytracer
     * @return das entstandene Bild
     */
    public BufferedImage createImage(){

        int count=0;
        for(int i=0; i<w;i++){
            for(int j=0;j<h;j++){
                final Set<Ray> rays=camera.rayFor(w, h, i, h-j);
                final Set<Hit> hits = new HashSet<Hit>();
                for(final Ray ray : rays){
                	hits.add(welt.hit(ray));
                }
                if(hits.isEmpty()){// kein einziger Hit
                	image.setRGB(j, j, convertColor(welt.backgroundColor));
                	break;
                }
                
                Color color = Color.BLACK;
                for(final Hit hit : hits){
                    if(hit != null){
                    	color = color.add(hit.geo.material.colorFor(hit, welt,new Tracer(welt, 10)).mul((double) 1 / camera.pattern.points.length));
//                		color = new Color(Math.abs((hit.n.x)/2), Math.abs((hit.n.y)/2), Math.abs((hit.n.z)/2)); //funky
                    }else{
                    	color = color.add(welt.backgroundColor.mul((double) 1 / camera.pattern.points.length));
                    }
                	
                }
                image.setRGB(i, j, convertColor(color));
            }
        }

        return image;
    }

    /**
     * Konvertiert eine aufgabe01.Color-Farbe in eine java.awt.Color-Farbe
     * @param c die aufgabe01-Farbe
     * @return
     */
    public int convertColor(aufgabe01.Color c){
        float red=(float)c.getR();
        float green=(float)(c.getG());
        float blue=(float)(c.getB());
        java.awt.Color color = new java.awt.Color(red,green,blue);
        return color.getRGB();
    }

    @Override
    protected void paintComponent( Graphics g ){
        super.paintComponent(g);
        if ( image != null )
            g.drawImage(image,0, 0, this );
    }



}
