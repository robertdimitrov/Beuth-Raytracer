package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

/**
<<<<<<< HEAD
 * @author Clemens
 * 
 * Klasse repr�sentiert ein Material
 *
 */
public abstract class Material {
	
	
	/**
	 * Diese Methode berechnet die Farbe eines Pixels, abh�ngig davon, von welchen Lichtquellen es beleuchtet wird
	 * 
	 * @param hit Schnittpunkt mit einem Objekt
	 * @param world Welt in der Geometrien und Lichtquellen gespeichert werden
	 * @return Farbe des Materials
	 */
=======
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
>>>>>>> refs/remotes/origin/master
	public abstract Color colorFor(final Hit hit, final World world);
	
	

}
