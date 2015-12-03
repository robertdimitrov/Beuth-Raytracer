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
	protected final Color color;
	/**
	 * eine Lichtquelle
	 * @param color die Farbe des Lichts
	 */
	Light(final Color color){
		this.color = color;
	}
	/**
	 * prueft ob point beleuchtet wird
	 * @param point ein Point3
	 * @return
	 */
	abstract boolean illuminates(Point3 point);
	/**
	 * 
	 */
	abstract Vector3 directionFrom(final Point3 point );
	
}
