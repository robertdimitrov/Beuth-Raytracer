package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt das Material für einen perfekt
 * diffus reflektierenden Körper mit einem Glanzpunkt dar.
 * @author Kosmonaut
 */

/**
 * 
 * Klasse repr�sentiert Phong-Beleuchtung
 * @author Robert
 *
 */
public class PhongMaterial extends Material {

    /**
     * Die Farbe für die diffuse Reflektion
     */
    final public Color diffuse;
    /**
     * Die Farbe für die spekulare Reflektion
     */
    final public Color specular;
    /**
     * Der Phong-Exponent
     */
    final public int exponent;

    /**
     * Erstellt ein neues PhongMaterial-Objekt
     * @param diffuse die Fabre für die diffuse Reflektion
     * @param specular die Farbe für die spekulare Reflektion
     * @param exponent der Phong-Exponent
     */
    public PhongMaterial(final Color diffuse, final Color specular, final int exponent) {
        if(diffuse==null) throw new IllegalArgumentException("diffuse darf nicht null sein");
        if(specular==null) throw new IllegalArgumentException("specular darf nicht null sein");
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(final Hit hit, final World world, Tracer tracer) {

        if(hit==null) throw new IllegalArgumentException("hit darf nicht null sein");
        if(world==null) throw new IllegalArgumentException("world darf nicht null sein");

        Color ambient = world.ambientLight;
        Color cdca = this.diffuse.mul(ambient);
        Color color = cdca;
        Normal3 n = hit.n;
        Point3 p = hit.ray.at(hit.t);

        for(Light light : world.lights){
            if(light.illuminates(p, world)){
                Color cl = light.color;
                Vector3 l = light.directionFrom(p).normalized();
                Vector3 e = hit.ray.d.mul(-1).normalized();
                Vector3 r = l.reflectedOn(n);
                Color c1 = this.diffuse.mul(cl).mul(Math.max(0, n.dot(l)));
                Color c2 = this.specular.mul(cl).mul(Math.pow(Math.max(0, e.dot(r)), exponent));
                color = color.add(c1.add(c2));
            }
        }
        return color;
    }

}
