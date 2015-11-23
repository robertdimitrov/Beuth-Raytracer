package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt eine orthographische Kamera dar
 * @author Kosmonaut
 *
 */
public class OrthographicCamera extends Camera {

	/**
	 * Der Skalierungsfaktor der Bildebene
	 */
	public final double s;
	
	/**
	 * Dieser Konstruktor erzeugt ein neues OrhographicCamera-Objekt
	 * @param e Die Position der Kamera
	 * @param g Die Blickrichtung der Kamera
	 * @param t Der Up-Vektor der Kamera
	 * @param s Der Skalierungsfaktor der Bildebene
	 */
	public OrthographicCamera(final Point3 e,final Vector3 g,final Vector3 t,final double s) {
		super(e, g, t);
		this.s = s;
	}

	@Override
	public Ray rayFor(final int w,final int h,final int x,final int y) {
		double a = (double) w/h;
		Vector3 d = this.w.mul(-1);
		
		Vector3 vectorX = u.mul(((x - (double)((w - 1)/2))/(w-1))).mul(s).mul(a);
		Vector3 vectorY = v.mul(((y - (double)((h - 1)/2))/(h-1))).mul(s);
		
		return new Ray(e.add(vectorX.add(vectorY)), d);
	}

	@Override
	public String toString() {
		return "OrthographicCamera [s=" + s + "]";
	}

	
	
}