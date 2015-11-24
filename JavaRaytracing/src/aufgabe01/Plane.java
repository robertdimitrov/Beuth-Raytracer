package aufgabe01;

import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Eine Ebene
 * 
 * @author Kosmaonaut
 *
 */
public class Plane extends Geometry {
	/**
	 * Ursprung a dieser Ebene
	 */
	public final Point3 a;
	/**
	 * Stuetzvektor n dieser Ebene
	 */
	public final Normal3 n;

	/**
	 * Erzeugt eine Ebene
	 * 
	 * @param a
	 *            der Ursprung dieser Ebene als Point3
	 * @param n
	 *            der Stuetzvektor dieser Ebene
	 * @param color
	 *            die Farbe dieser Ebene
	 */
	public Plane(final Point3 a, final Normal3 n, final Material material) {
		super(material);
		this.a = a;
		this.n = n;
	}

	@Override
	public Hit hit(Ray r) {
		if (n.dot(r.d) != 0) {
			final double t = a.sub(r.o).dot(n) / r.d.dot(n);
			return new Hit(t, r, n, this);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Plane at " + a + " with a perpendicular Vektor3 " + n
				+ super.toString();
	}

}
