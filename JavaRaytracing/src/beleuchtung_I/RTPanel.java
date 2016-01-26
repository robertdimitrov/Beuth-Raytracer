package beleuchtung_I;

import aufgabe01.*;
import aufgabe01.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

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
                Ray r=camera.rayFor(w, h, i, h-j);
                Hit hit=welt.hit(r);
                if(hit!=null){
                    int color=convertColor(hit.geo.material.colorFor(hit, welt,new Tracer(welt, 5)));
                	//funky
//                	int color = convertColor(new Color(hit.n.x/2+.5, hit.n.y/2+.5, hit.n.z/2+.5));
                    image.setRGB(i, j,color);
                }
                else{int color = convertColor(welt.backgroundColor);
                    image.setRGB(i, j, color);
                }
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
