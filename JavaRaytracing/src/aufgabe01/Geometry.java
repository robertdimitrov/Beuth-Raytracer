package aufgabe01;

/**
 * Diese Klasse erstellt Geometrische Gestalten
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
	 *            der Ray, für den geprueft wird , ob er die Geometry schneidet
	 * @return einen Hit, falls er die Geometry schneidet oder null falls nicht
	 */
	public abstract Hit hit(Ray r);
	
}
