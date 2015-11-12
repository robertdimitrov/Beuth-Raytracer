/**
 * 
 */
package aufgabe01;

import java.io.File;

/**
 * ein Hit ist ein Schnittpunkt eines Ray's und einer Geometry
 * 
 * @author Kosmonaut
 *
 */
class Hit {
	public final double t;
	public final Ray ray;
	public final Geometry geo;
	
	/**
	 * Der Schnittpunkt zwischen dem Ray und der Geometry
	 * @param t
	 *            der Skalar mit dem ray multipliziert wurde um geo zu schneiden
	 * @param ray
	 *            der Ray, der die Geometry geo schneidet
	 * @param geo
	 *            die Geometrie die vom Ray ray geschnitten wurde
	 */
	Hit(final double t, final Ray ray, final Geometry geo) {
		this.t = t;
		this.ray = ray;
		this.geo = geo;
	}
	
}
