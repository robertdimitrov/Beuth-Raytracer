package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public class Tracer {

    private World world;
    public int rekursion;

    public Tracer(World world, int rekursion) {
        this.world = world;
        this.rekursion = rekursion;
    }

    public Color reflektion(Point3 p, Vector3 v){
        Color fehlerfarbe = world.backgroundColor;

        if(rekursion < 1) return fehlerfarbe;

        rekursion--;
        Color reflected = fehlerfarbe;

        Ray ray = new Ray(p,v);
        Hit hit = world.hit(ray);

        if(!(hit==null)) {
            reflected = hit.geo.material.colorFor(hit, world, this);
        }

        return reflected;
    }
}
