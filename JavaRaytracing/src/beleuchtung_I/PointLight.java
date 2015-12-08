package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Geometry;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Alles Licht dieser Lichtquelle geht von einem einzigen Punkt aus
 * 
 * @author Kosmonaut
 *
 */
public class PointLight extends Light {
	/**
	 * Die Position des Punkts, von dem das Licht ausgeht
	 */
	public final Point3 position;

	/**
	 * Eine Lichtquelle, bei der alles Licht von einem einzigen Punkt ausgeht
	 * 
	 * @param color
	 *            Die Farbe des Lichts
	 * @param position
	 *            Die Position des Punkts, von dem das Licht ausgeht
	 */
	public PointLight(final Color color, final Point3 position, final boolean castsShadow) {
		super(color, castsShadow);
		this.position = position;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point).normalized();
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		if(!castsShadow){
			Ray lRay = new Ray(point, directionFrom(point));
			double distance = position.sub(point).magnitude; 
			for(Geometry g : world.welt){
				Hit hit = g.hit(lRay);
				if(hit!=null && hit.t < distance){
					return false;
				}
			}
		}
		return true;
	}

}
