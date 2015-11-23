package aufgabe01;

/**
 * Diese Klasse ist eine abstrakte Oberklasse fuer Geometrische Gestalten
 * 
 * @author Kosmonaut
 *
 */
public abstract class Geometry {
	/**
	 * Die Farbe dieser Geometrischen Gestalt
	 */
	protected final Color color;
	
	/**
	 * Eine Geometrische Gestalt
	 * @param color Die Farbe dieser Geometrischen Gestalt
	 */
	protected Geometry(final Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @param r
	 *            der Ray, für den geprueft wird , ob er diese Geometry schneidet
	 * @return einen Hit, falls er diese Geometry schneidet oder null falls nicht
	 */
	public abstract Hit hit(Ray r);
	
}
