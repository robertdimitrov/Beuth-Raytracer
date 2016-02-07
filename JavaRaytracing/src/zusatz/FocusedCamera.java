package zusatz;

import java.util.HashSet;
import java.util.Set;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import aufgabe01.Camera;
import aufgabe01.Ray;

/**
 * Eine Kamera mit einer Fokusentfernung
 * 
 * @author anwender
 *
 */
public class FocusedCamera extends Camera {

	/**
	 * Der Öffnungswinkel der Kamera
	 */
	public final double angle;
	/**
	 * Die Schaerfentiefe dieser Kamera
	 */
	public final double sharpAt;
	
	/**
	 * Dieser Konstruktor erzeugt ein neues FocusedCamera-Objekt
	 * @param e Position der Kamera
	 * @param g Blickrichtung der Kamera
	 * @param t Up-Vektor der Kamera
	 * @param angle Oeffnungswinkel der Kamera	 
	 * @param sharpAt Die Schaerfentiefe dieser Kamera
	 * @param pattern Das {@link SamplingPattern} dieser Kamera
	 */
	public FocusedCamera(final Point3 e, final Vector3 g, final Vector3 t, final double angle, final double sharpAt, final SamplingPattern pattern) {
		super(e, g, t, pattern);
		this.angle = angle;
		this.sharpAt = sharpAt;
	}

	@Override
	public Set<Ray> rayFor(final int w, final int h, final int x, final int y) {
		final Set<Ray> rays = new HashSet<Ray>();
		
		for(final Point2 patternPoint : pattern.points){
			final Vector3 vectorX = this.u.mul(x + patternPoint.x - (((double)w-1)/2));
			final Vector3 vectorY = this.v.mul(y + patternPoint.y - (((double)h-1)/2));
			double tanA = Math.tan(angle/2);
			if(tanA == 0) throw new IllegalArgumentException();
			final Vector3 r = this.w.mul(((double)h/2)/tanA).mul(-1).add(vectorX).add(vectorY);
			rays.add(new Ray(e, r.normalized()));
		}
		return rays;
	}
}
