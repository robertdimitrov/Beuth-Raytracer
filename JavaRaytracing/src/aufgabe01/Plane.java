/**
 * 
 */
package aufgabe01;

import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Eine Ebene
 * @author Kosmaonaut
 *
 */
public class Plane extends Geometry {
	private final Point3 a;
	private final Normal3 n;
	
	public Plane(final Point3 a, final Normal3 n, final Color color){
		super(color);
		this.a = a;
		this.n = n;
	}

	@Override
	public Hit hit(Ray r) {
		if(n.dot(r.getD() != 0)){
			final double t = a.sub(r.getO()).dot(n) / r.getD().dot(n);
			return new Hit(t, r, this);
		}else{
			return null;
		}
	}
}
