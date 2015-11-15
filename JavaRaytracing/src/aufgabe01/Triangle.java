/**
 * 
 */
package aufgabe01;

import b_vorbereitung.Mat3x3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/** Ein Dreieck
 * @author Kosmonaut
 *
 */
public class Triangle extends Geometry {

	/**
	 * Ein Eckpunkt des Dreiecks
	 */
	public final Point3 a;
	/**
	 * Ein Eckpunkt des Dreiecks
	 */
	public final Point3 b;
	/**
	 * Ein Eckpunkt des Dreiecks
	 */
	public final Point3 c;
	
	/**
	 * Ein Dreieck
	 * @param a Ein Eckpunkt des Dreiecks
	 * @param b Ein Eckpunkt des Dreiecks
	 * @param c Ein Eckpunkt des Dreiecks
	 * @param color die Farbe des Dreicks
	 */
	public Triangle(final Point3 a, final Point3 b, final Point3 c,
			final Color color) {
		super(color);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public Hit hit(Ray r) {
		Vector3 ab = a.sub(b);
		Vector3 ac = a.sub(c);
		final Mat3x3 matA = new Mat3x3(ab.x, ac.y, r.d.x, ab.y, ac.y, r.d.y,
				ab.z, ac.z, r.d.z);
		final Vector3 vecErg = new Vector3(a.x - r.o.x, a.y - r.o.y, a.y
				- r.o.y);
		final Mat3x3 matA1 = matA.changeCol3(vecErg);
		final Mat3x3 matA2 = matA.changeCol3(vecErg);
		final Mat3x3 matA3 = matA.changeCol3(vecErg);
				
		final double beta = matA1.determinant / matA.determinant;
		final double gamma = matA2.determinant / matA.determinant;
		
		if (groessergleich0UndKleinergleich1(beta)
				&& groessergleich0UndKleinergleich1(gamma)
				&& groessergleich0UndKleinergleich1(beta + gamma)) {
			final double t = matA3.determinant / matA.determinant;
			return new Hit(t, r, this);
		}

		return null;
	}

	/**
	 * 
	 */
	protected boolean groessergleich0UndKleinergleich1(double x) {
		return 0 <= x && x <= 1;
	}

}
