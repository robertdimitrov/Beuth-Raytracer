package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse represäntiert einen Strahl
 * @author Kosmonaut
 *
 */
public class Ray {

	/**
	 * Der Ursprung "o" des Strahls
	 */
	public final Point3 o;
	/**
	 * Die Richtung "d" des Strahls
	 */
	public final Vector3 d;
	
	/**
	 * Erzeugt ein neues Strahl-Objekt
	 * @param o Der Ursprung des Strahls
	 * @param d Die Richtung des Strahls
	 */
	public Ray(final Point3 o, final Vector3 d){
		if(o==null) throw new IllegalArgumentException("Der Punkt 'o' darf nicht null sein.");
		if(d==null) throw new IllegalArgumentException("Der Vektor 'd' darf nicht null sein.");
		
		this.o = o;
		this.d = d;
	}
	
	/**
	 * Berechnet den Punkt auf dem Strahl der einen bestimmten Abstand vom Ursprung hat 
	 * @param t Der Abstand
	 * @return Der entsprechende Punkt
	 */
	public Point3 at(final double t){
		return o.add(d.mul(t));
	}
	
	/**
	 * Berechnet den Abstand eines Punktes vom Ursprung des Strahls
	 * @param p Der Punkt
	 * @return Der entsprechende Abstand
	 */
	public double tOf(final Point3 p){
		if(p==null) throw new IllegalArgumentException("Der Punkt 'p' darf nicht null sein.");
		return (p.x - o.x) / d.x;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((o == null) ? 0 : o.hashCode());
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
		Ray other = (Ray) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (o == null) {
			if (other.o != null)
				return false;
		} else if (!o.equals(other.o))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ray [o=" + o + ", d=" + d + "]";
	}
	
	
}
