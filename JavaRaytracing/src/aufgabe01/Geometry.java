package aufgabe01;

/**
 * Diese Klasse ist eine abstrakte Oberklasse fuer Geometrische Gestalten
 * 
 * @author Kosmonaut
 *
 */
public abstract class Geometry {
	protected final Color color;

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
