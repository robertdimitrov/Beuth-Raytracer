package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt einen Tracer dar, der
 * für das rekursive RayTracing verwendet wird.
 * @author Kosmonaut
 */
public class Tracer {

    /**
     * Die Welt für den Tracer
     */
    private World world;
    /**
     * Der Zähler der Rekursion
     */
    public int rekursion;

    /**
     * Erstellt ein neues Tracer-Objekt
     * @param world die Welt für den Tracer
     * @param rekursion der Zähler der Rekursion
     */
    public Tracer(World world, int rekursion) {
        this.world = world;
        this.rekursion = rekursion;
    }

    /**
     * Ermittelt die Farbe für einen Strahl
     * @param ray der gegebene Strahl
     * @return die Farbe
     */
    public Color trace(Ray ray){
        Color fehlerfarbe = Color.GREEN;

        if(rekursion < 1) return fehlerfarbe;

        Hit hit = world.hit(ray);

        if(!(hit==null)) {
            return hit.geo.material.colorFor(hit, world, this);
        }

        return null;
    }
}
