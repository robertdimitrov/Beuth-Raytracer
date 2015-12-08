package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt ein Licht dar, das von einem Punkt aus in eine Richtung
 * unter einem Winkel Licht austrahlt
 * 
 * @author Kosmonaut
 *
 */
public class SpotLight extends Light {
	/**
	 * Die Position des Punkts, von dem das Licht ausgeht
	 */
	public final Point3 position;
	/**
	 * Die Richtung, aus der das Licht kommt
	 */
	public final Vector3 direction;
	/**
	 * Eine Haelfte des Oeffnungswinkels des Lichts
	 */
	public final double halfAngle;

	/**
	 * Ein Licht, das von einem Punkt aus in eine Richtung unter einem Winkel
	 * Licht austrahlt
	 *
	 * @param color
	 *            Die Farbe des Lichts
	 * @param position
	 *            Die Position des Punkts, von dem das Licht ausgeht
	 * @param direction
	 *            Die Richtung, aus der das Licht kommt
	 * @param halfAngle
	 *            Eine Haelfte des Oeffnungswinkels des Lichts
	 */
	public SpotLight(final Color color, final Point3 position,
			final Vector3 direction, final double halfAngle, final boolean castsShadow) {
		super(color, castsShadow);
		this.position = position;
		this.direction = direction;
		this.halfAngle = halfAngle;
	}

	@Override
	public boolean illuminates(Point3 point, World world) {
		if(!castsShadow){
			return point.sub(position).angleTo(direction) <= halfAngle;
		}
		return point.sub(position).angleTo(direction) <= halfAngle;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point).normalized();
	}

}
