package aufgabe01;

import beleuchtung_I.Material;

/**
 * Diese Klasse ist eine abstrakte Oberklasse fuer Geometrische Gestalten
 * 
 * @author Kosmonaut
 *
 */
public abstract class Geometry {
	/**
	 * Das Material dieser Geometrischen Gestalt
	 */
	public Material material;
	public final static double EPSILON = 0.0001;

	/**
	 * Eine Geometrische Gestalt
	 * 
	 * @param color
	 *            Die Farbe dieser Geometrischen Gestalt
	 */
	protected Geometry(Material material) {
		this.material = material;
	}

	/**
	 * Rechnet einen Schnittpunkt von r und dieser Geometry aus 
	 * @param r
	 *            der Ray, f�r den geprueft wird , ob er diese Geometry
	 *            schneidet
	 * @return einen Hit, falls er diese Geometry schneidet oder null falls
	 *         nicht
	 */
	public abstract Hit hit(Ray r);

	@Override
	public String toString() {
		return " and the Material " + material;
	}

}
