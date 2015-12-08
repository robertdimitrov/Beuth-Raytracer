package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt eine unendlich weit entfernte Lichtquelle dar
 * 
 * @author Kosmonaut
 *
 */
public class DirectionalLight extends Light {

	/**
	 * Die Richtung, aus der das Licht kommt
	 */
	public final Vector3 direction;

	/**
	 * Eine unendlich weit entfernte Lichtquelle dar
	 * 
	 * @param color
	 *            Die Farbe des Lichts
	 * @param direction
	 *            Die Richtung, aus der das Licht kommt
	 */
	public DirectionalLight(final Color color, final Vector3 direction, final boolean castsShadow) {
		super(color, castsShadow);
		this.direction = direction;
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		if(castsShadow){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return direction.mul(-1).normalized();
	}

}
