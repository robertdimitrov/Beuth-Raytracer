/**
 * 
 */
package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.World;
import aufgabe01.Hit;

/**
 * eine abstarkte Oberklsse von der Lichter erben
 * 
 * @author Kosmonaut
 *
 */
public abstract class Light {
	/**
	 * Diese Methode gibt die Farbe der Geometrie aus deren Schnitt hit entstand
	 * 
	 * @param hit
	 *            Der Hit der die Geometryy enthält die beleuchtete wird
	 * @param world
	 *            Die Welt die die Beleuchtungen enthält
	 * @return Die Farbedie errechnet wurde
	 * 
	 */
	public abstract Color colorFor(final Hit hit, final World world);
}
