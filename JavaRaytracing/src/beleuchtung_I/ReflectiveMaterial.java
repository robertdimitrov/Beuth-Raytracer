package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * @author Kosmonaut
 */
public class ReflectiveMaterial extends Material {

    public Color diffuse;
    public Color specular;
    public Color reflection;
    public int exponent;

    public ReflectiveMaterial(Color diffuse, Color specular, int exponent, Color reflection) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.reflection = reflection;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(Hit hit, World world, Tracer tracer) {
    	
    	if(hit==null) throw new IllegalArgumentException("hit darf nicht null sein");
        if(world==null) throw new IllegalArgumentException("world darf nicht null sein");
        if(tracer==null) throw new IllegalArgumentException("tracer darf nicht null sein");

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
                Color c1 = this.diffuse.mul(cl).mul(Math.max(0, l.dot(n)));
                Color c2 = this.specular.mul(cl).mul(Math.pow(Math.max(0, e.dot(r)), exponent));

                Color c3 = reflection.mul(tracer.reflektion(p, hit.ray.d.reflectedOn(hit.n).mul(-1)));
                color = color.add(c1.add(c2).add(c3));
            }
        }
        return color;
    }
}
