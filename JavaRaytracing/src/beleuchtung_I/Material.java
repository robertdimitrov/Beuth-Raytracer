package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

/**

 * @author Clemens
 * 
 * Klasse repräsentiert ein Material
 *
 */
public abstract class Material {
	/**
	 * Liefert die Farbe fuer ein Hit-Objekt zurueck
	 * @param hit das Hit-Objekt
	 * @param world das fuer die Ermittlung der Lichter benoetigte World-Objekt
     * @return die entsprechende Farbe
     */

	public abstract Color colorFor(final Hit hit, final World world);		
}
