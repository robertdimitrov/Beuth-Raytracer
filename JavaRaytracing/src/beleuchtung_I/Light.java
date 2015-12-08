/**
 * 
 */
package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.World;
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
	 * ob das Licht einen Schatten auf eine Geometry wirft
	 */
	public boolean castsShadow ;

	/**
	 * eine Lichtquelle
	 * 
	 * @param color
	 *            die Farbe des Lichts
	 */
	protected Light(final Color color, final boolean castsShadow) {
		this.color = color;
		this.castsShadow = castsShadow;
	}

	/**
	 * prueft ob point beleuchtet wird
	 * 
	 * @param point
	 *            ein Point3
	 * @return
	 */
	public abstract boolean illuminates(Point3 point, final World world);

	/**
	 * gibt den Vektor der von point aus auf die Lichtquelle zeigt (oft Vektor l
	 * genannt)
	 * 
	 * @param point
	 *            ein Point3
	 * @return
	 */
	public abstract Vector3 directionFrom(final Point3 point);

}
