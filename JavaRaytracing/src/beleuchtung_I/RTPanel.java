package beleuchtung_I;

import aufgabe01.*;
import aufgabe01.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

/**
 * Klasse zum Erzeugen eines Raytracer-Panels
 *
 * @author Kosmonaut
 */

public class RTPanel extends JPanel {

    final public World welt;
    final public Camera camera;
    final private int w;
    final private int h;
    private BufferedImage image;

    public RTPanel(Camera camera, World welt) {
        this.camera = camera;
        this.welt = welt;
        this.w = 640;
        this.h = 480;
        setSize(w, h);
        this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        createImage();
    }

    public BufferedImage createImage(){

        int count=0;
        for(int i=0; i<w;i++){
            for(int j=0;j<h;j++){
                Ray r=camera.rayFor(w, h, i, j);
                Hit hit=welt.hit(r);
                if(hit!=null){
                    int color=convertColor(hit.geo.material.colorFor(hit, welt));
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
