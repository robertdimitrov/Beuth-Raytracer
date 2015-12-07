package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

/**
 * Diese Klasse ist die abstrakte Superklasse für alle Material-Klassen
 * @author Kosmonaut
 */
public abstract class Material {

	/**
	 * Liefert die Farbe für ein Hit-Objekt zurück
	 * @param hit das Hit-Objekt
	 * @param world das für die Ermittlung der Lichter benötigte World-Objekt
     * @return die entsprechende Farbe
     */
	public abstract Color colorFor(final Hit hit, final World world);

}
