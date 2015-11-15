/**
 * 
 */
package aufgabe01;

import b_vorbereitung.Point3;

/**
 * @author Kosmonaut
 *
 */
public class Sphere extends Geometry {
	public final Point3 c;
	public final double r;
	
	public Sphere(final Point3 c, final double r, final Color color){
		super(color);
		this.c = c;
		this.r = r;
	}
	
	public Hit hit(Ray r) {
		if(){
			double t;
			return new Hit(t, r, this);
		}
	}
}
