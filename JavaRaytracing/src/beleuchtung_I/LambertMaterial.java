package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt das Material für einen perfekt diffus reflektierenden Körper dar.
 * @author Kosmonaut
 */
public class LambertMaterial extends Material {

	/**
	 * Die Farbe des Körpers
	 */
	final public Color color;

	/**
	 * Erstellt ein neues LambertMaterial-Objekt
	 * @param color die Farbe des geometrischen Körpers
     */
	LambertMaterial(final Color color){
		if(color==null) throw new IllegalArgumentException("color darf nicht null sein");
		this.color=color;
	}

	@Override
	public Color colorFor(final Hit hit, final World world){
		if(hit==null) throw new IllegalArgumentException("hit darf nicht null sein");
		if(world==null) throw new IllegalArgumentException("world darf nicht null sein");
		Color ca = world.ambientLight;
		Color cd = this.color.mul(ca);
		Normal3 n = hit.n;
		Point3 p = hit.ray.at(hit.t);

		for(Light light : world.lights){
			if(light.illuminates(p)) {
				Color cl = light.color;
				Vector3 l = light.directionFrom(p).normalized();
				cd = cd.add(color.mul(cl).mul(Math.max(0, n.dot(l))));
			}
		}

		return cd;
	}


}
