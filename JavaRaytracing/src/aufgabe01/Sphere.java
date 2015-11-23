/**
 * 
 */
package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

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
	public final Point3 center;
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
		this.center = c;
		this.radius = r;
	}

	public Hit hit(Ray r) {

		final Vector3 oMinusC = r.o.sub(center);
		final double a = r.d.dot(r.d);
		final double b = r.d.dot((oMinusC).mul(2));
		final double c = (oMinusC).dot(oMinusC) - radius * radius;

		final double t1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
		final double t2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
		double smallestPositiveT;
		smallestPositiveT = smallestPositive(t1, t2);
		
		if (smallestPositiveT != -1) {
			return new Hit(smallestPositiveT, r, this);
		} else {
			return null;
		}

	}

	/**Eine Funktion, die die kleinere nicht-negative Zahl aus den Parametern zurückgibt 
	 * @param x
	 *            Die erste zu vergleichende Zahl
	 * @param y
	 *            Die erste zu vergleichende Zahl
	 *
	 * @return kleinere nicht-negative Zahl von t1 und t2 oder '-1', falls t1
	 *         und t2 negative Zahlen sind
	 */
	public double smallestPositive(final double x, final double y) {
		if (x <= y && x >= 0) {
			return x;
		} else {
			if (y >= 0) {
				return y;
			}
		}

		return -1;
	}
	
	@Override
	public String toString() {
		return "Sphere at "+center.toString()+" with the radius "+radius+super.toString();
	}
}
