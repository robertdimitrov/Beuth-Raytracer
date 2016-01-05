package aufgabe01;

import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.Material;

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
	public Plane(final Material material) {
		super(material);
		this.a = new Point3(0, 0, 0);
		this.n = new Normal3(0, 1, 0);
	}

	@Override
	public Hit hit(Ray r) {
		final double teiler = r.d.dot(n);
		if (teiler != 0) {
			final double t = a.sub(r.o).dot(n) / teiler;
			if(t < 0.00001){
				return null;
			}
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
