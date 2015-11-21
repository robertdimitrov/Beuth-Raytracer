/**
 * 
 */
package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

//TODO kommentare und was ist die nicht-hit-bedingung
/**
 * Diese Klasse erstellt einen Kreis
 * 
 * @author Kosmonaut
 *
 */
public class Sphere extends Geometry {
	/**
	 * Der Mittelpunkt des Kreis
	 */
	public final Point3 c;
	/**
	 * Der Radius des Kreis
	 */
	public final double radius;

	/**
	 * Ein Kreis
	 * 
	 * @param c
	 *            Der Mittelpunkt des Kreis
	 * @param r
	 *            Der Radius des Kreis
	 * @param color
	 *            Die Farbe des Kreises
	 */
	public Sphere(final Point3 c, final double r, final Color color) {
		super(color);
		this.c = c;
		this.radius = r;
	}

	public Hit hit(Ray r) {

		final Vector3 oMinusC = r.o.sub(c);
		final double a = r.d.dot(r.d);
		final double b = r.d.dot((oMinusC).mul(2));
		final double c = (oMinusC).dot(oMinusC) - r * r;

		final double t1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
		final double t2 = (-b - Math.sqrt(b*b -4*a*c))/ 2*a;
		final double smallestPositiveT ;
		if(t1 <= t2 && t1 >= 0){
			smallestPositiveT = t1 ;
		}else{
			if(t2<=0){
				smallestPositiveT = t2;
			}
		}
		
		return new Hit(smallestPositiveT, r, this);

	}
}
