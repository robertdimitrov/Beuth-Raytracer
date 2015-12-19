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
	 * Diese Methode berechnet die Farbe eines Pixels, abhängig davon, von welchen Lichtquellen es beleuchtet wird
	 * 
	 * @param hit Schnittpunkt mit einem Objekt
	 * @param world Welt in der Geometrien und Lichtquellen gespeichert werden
	 * @return Farbe des Materials
	 */
	public abstract Color colorFor(final Hit hit, final World world);
}
