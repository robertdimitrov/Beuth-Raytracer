/**
 * 
 */
package beleuchtung_I;

import aufgabe01.Color;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * eine abstrakte Oberklasse, von der Lichtquellen erben
 * 
 * @author Kosmonaut
 *
 */
public abstract class Light {
	/**
	 * die Farbe des Lichts
	 */
	public final Color color;

	/**
	 * eine Lichtquelle
	 * 
	 * @param color
	 *            die Farbe des Lichts
	 */
	protected Light(final Color color) {
		this.color = color;
	}

	/**
	 * prueft ob point beleuchtet wird
	 * 
	 * @param point
	 *            ein Point3
	 * @return
	 */
	public abstract boolean illuminates(Point3 point);

	/**
	 * gibt de normaliesierten Vektor der von point aus auf die Lichtquelle
	 * zeigt
	 * 
	 * @param point
	 *            ein Point3
	 * @return
	 */
	public abstract Vector3 directionFrom(final Point3 point);

}
