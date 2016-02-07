package aufgabe01;

import zusatz.SamplingPattern;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese abstrakte Klasse stellt eine Kamera dar.
 * @author Kosmonaut
 *
 */
public abstract class Camera {

	/**
	 * Die Position "e" der Kamera.
	 */
	public final Point3 e;
	/**
	 * Die Blickrichtung (gaze direction) "d" der Kamera.
	 */
	public final Vector3 g;
	/**
	 * Der Up-Vektor "t" der Kamera.
	 */
	public final Vector3 t;
	/**
	 * Die u-Achse der Kamera.
	 */
	public final Vector3 u;
	/**
	 * Die v-Achse der Kamera.
	 */
	public final Vector3 v;
	/**
	 * Die w-Achse der Kamera.
	 */
	public final Vector3 w;
	/**
	 * das SamplingPattern der Kamera
	 */
	public final SamplingPattern pattern;
	
	/**
	 * Dieser Konstruktor erzeugt ein neues Camera-Objekt.
	 * Die u-, v- und w-Achsen der Kamera werden im Konstruktor berechnet und 
	 * als öffentliche Attribute zur Verfügung gestellt.
	 * @param e Die Position der Kamera
	 * @param g Die Blickrichtung der Kamera
	 * @param t Der Up-Vektor der Kamera
	 * @param pattern Das Samplingpattern was die Feinheit der einzelnen Strahlen der Kamera berstimmt 
	 */
	public Camera(final Point3 e, final Vector3 g, final Vector3 t, final SamplingPattern pattern){
		if(e==null) throw new IllegalArgumentException("Der Punkt 'e' darf nicht null sein.");
		if(g==null) throw new IllegalArgumentException("Der Vektor 'g' darf nicht null sein.");
		if(t==null) throw new IllegalArgumentException("Der Vektor 't' darf nicht null sein.");
		
		this.e = e;
		this.g = g;
		this.t = t;
		
		this.w = g.normalized().mul(-1);
		this.u = t.x(w).normalized();
		this.v = w.x(u);
		
		this.pattern = pattern;
	}
	
	/**
	 * Gibt für einen bestimmten Pixel den entsprechenden Strahl zurück.
	 * @param w Breite des Bildes
	 * @param h Höhe des Bildes
	 * @param x x-Koordinate des Pixels
	 * @param y y-Koordinate des Pixels
	 * @return Der entsprechende Strahl
	 */
	public abstract Ray rayFor(final int w, final int h, final int x, final int y);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((g == null) ? 0 : g.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (g == null) {
			if (other.g != null)
				return false;
		} else if (!g.equals(other.g))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if (w == null) {
			if (other.w != null)
				return false;
		} else if (!w.equals(other.w))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Camera [e=" + e + ", g=" + g + ", t=" + t + ", u=" + u + ", v="
				+ v + ", w=" + w + "]";
	}
	
	
}
