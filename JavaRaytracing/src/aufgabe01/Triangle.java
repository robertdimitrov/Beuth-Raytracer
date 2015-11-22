/**
 * 
 */
package aufgabe01;

import b_vorbereitung.Mat3x3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Ein Dreieck
 * 
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
	 * diese Matrix ist zum Sparen von Resourcen
	 */
	private final Mat3x3 hilfsMat3;

	/**
	 * Ein Dreieck
	 * 
	 * @param a
	 *            Ein Eckpunkt des Dreiecks
	 * @param b
	 *            Ein Eckpunkt des Dreiecks
	 * @param c
	 *            Ein Eckpunkt des Dreiecks
	 * @param color
	 *            die Farbe des Dreicks
	 */
	public Triangle(final Point3 a, final Point3 b, final Point3 c,
			final Color color) {
		super(color);
		this.a = a;
		this.b = b;
		this.c = c;
		// wenn man eine unvollkommene Matrix des Dreiecks hier, anstelle von in
		// hit die vollkommene, erstellt, spart man Ressourcen
		Vector3 ab = a.sub(b);
		Vector3 ac = a.sub(c);
		hilfsMat3 = new Mat3x3(ab.x, ac.y, 0, ab.y, ac.y, 0, ab.z, ac.z, 0);

	}

	@Override
	public Hit hit(Ray r) {
		final Mat3x3 matA = hilfsMat3.changeCol3(r.d);
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
	 * prueft ob x grosser-gleich 0 UND kleiner-gleich 1 ist
	 */
	protected boolean groessergleich0UndKleinergleich1(double x) {
		return 0 <= x && x <= 1;
	}

}
