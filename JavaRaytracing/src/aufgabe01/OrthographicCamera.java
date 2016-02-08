package aufgabe01;

import java.util.HashSet;
import java.util.Set;

import zusatz.DiagonalSamplingPattern;
import zusatz.Point2;
import zusatz.SamplingPattern;
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
	public OrthographicCamera(final Point3 e, final Vector3 g, final Vector3 t, final double s) {
		this(e, g, t, s, new DiagonalSamplingPattern(1));
	}
	/**
	 * Dieser Konstruktor erzeugt ein neues OrhographicCamera-Objekt
	 * @param e Die Position der Kamera
	 * @param g Die Blickrichtung der Kamera
	 * @param t Der Up-Vektor der Kamera
	 * @param s Der Skalierungsfaktor der Bildebene
	 * @param pattern Das Pattern der Kamera
	 */
	public OrthographicCamera(final Point3 e, final Vector3 g, final Vector3 t, final double s, final SamplingPattern pattern) {
		super(e, g, t, pattern);
		this.s = s;
	}

	@Override
	public Set<Ray> rayFor(final int w,final int h,final int x,final int y) {
		double a = (double) w/h;
		Vector3 d = this.w.mul(-1);
		
		final Set<Ray> rays = new HashSet<Ray>();
		
		for(final Point2 patternPoint : pattern.points){
			final Vector3 vectorX = u.mul(((x + patternPoint.x - (double)((w - 1)/2))/(w-1))).mul(s).mul(a);
			final Vector3 vectorY = v.mul(((y + patternPoint.y - (double)((h - 1)/2))/(h-1))).mul(s);
			rays.add(new Ray(e.add(vectorX.add(vectorY)), d));
		}
		return rays;
	}

	@Override
	public String toString() {
		return "OrthographicCamera [s=" + s + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(s);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrthographicCamera other = (OrthographicCamera) obj;
		if (Double.doubleToLongBits(s) != Double.doubleToLongBits(other.s))
			return false;
		return true;
	}

	
	
}
