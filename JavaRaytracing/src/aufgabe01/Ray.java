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
		this.o = o;
		this.d = d;
	}
	
	/**
	 * Berechnet den Punkt auf dem Strahl, der einen bestimmten Abstand vom Ursprung hat 
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
		return (p.x - o.x) / d.x;
	}
}
