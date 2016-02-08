/**
 *
 */
package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.Material;

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
	 r	 * @param c
	 *            Der Mittelpunkt des Kreis
	 * @param r
	 *            Der Radius des Kreis
	 * @param color
	 *            Die Farbe des Kreises
	 */
	public Sphere(final Material material) {
		super(material);
		this.center = new Point3(0, 0, 0);
		this.radius = 1;
	}

	public Hit hit(Ray r) {

		final Vector3 oMinusC = r.o.sub(center);
		final double a = r.d.dot(r.d);
		final double b = r.d.dot((oMinusC).mul(2));
		final double c = (oMinusC).dot(oMinusC) - radius * radius;

		final double t1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		final double t2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

		if( t2 > 0.0000001 ) {
			return new Hit( t2, r, r.at( t2 ).sub( this.center ).normalized().asNormal(), this );
		} else if( t1 > 0.0000001 ) {
			return new Hit( t1, r, r.at( t1 ).sub( this.center ).normalized().asNormal(), this );
		}

//		if( t2 > 0.0000001 ) {
////			return new Hit( t2, r, r.at( t2 ).sub( this.center ).normalized().asNormal(), this );
//			return new Hit( t2, r, r.at( t2 ).sub( this.center ).mul(-1).normalized().asNormal(), this );
//		} else if( t1 > 0.0000001 ) {
//			return new Hit( t1, r, r.at( t1 ).sub( this.center ).mul(-1).normalized().asNormal(), this );
//		}

		return null;

//		double smallestPositiveT = Math.min(t1, t2);
//		if(smallestPositiveT < 0) smallestPositiveT = -1;
//
//		if (smallestPositiveT != -1) {
//			return new Hit(smallestPositiveT, r, r.at(smallestPositiveT).sub(center).asNormal(), this);
//		} else {
//			return null;
//		}

	}

	@Override
	public String toString() {
		return "Sphere at " + center.toString() + " with the radius " + radius
				+ super.toString();
	}
}
