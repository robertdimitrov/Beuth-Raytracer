/**
 * 
 */
package aufgabe01;

import java.io.File;

import b_vorbereitung.Normal3;

/**
 * ein Hit ist ein Schnittpunkt eines Ray's und einer Geometry
 * 
 * @author Kosmonaut
 *
 */
public class Hit {
	/**
	 * Faktor, um den ray multipliziert werden muss, um geo zu schneiden
	 */
	public final double t;
	/**
	 * Ein Strahl, der auf eine Ebene trifft
	 */
	public final Ray ray;
	/**
	 * Die Geometrische Form, auf die ray trifft
	 */
	public final Geometry geo;
	/**
	 * Die Normale des Schnittpunkts
	 */
	public final Normal3 n;

	/**
	 * Der Schnittpunkt zwischen dem Ray und der Geometry
	 * 
	 * @param t
	 *            der Skalar mit dem ray multipliziert wurde um geo zu schneiden
	 * @param ray
	 *            der Ray, der die Geometry geo schneidet
	 * @param n
	 *            Die Normale des Schnittpunkts
	 * @param geo
	 *            die Geometrie die vom Ray ray geschnitten wurde
	 */
	public Hit(final double t, final Ray ray, final Normal3 n, final Geometry geo) {
		this.t = t;
		this.ray = ray;
		this.n = n;
		this.geo = geo;
	}

}
