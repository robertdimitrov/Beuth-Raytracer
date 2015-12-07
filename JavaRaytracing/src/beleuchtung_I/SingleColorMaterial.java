package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

/**
 * Diese Klasse stellt das Material für einen Körper dar,
 * der unabhängig von der Lichtquelle in einer Farbe gezeigt wird.
 * @author Kosmonaut
 */
public class SingleColorMaterial extends Material{

	/**
	 * Die Farbe des Körpers
	 */
	final Color color;

	/**
	 * Erstellt ein neues SingleColorMaterial-Objekt
	 * @param color die Farbe des geometrischen Körpers
     */
	SingleColorMaterial(final Color color){
		
		this.color=color;
	}

	@Override
	public Color colorFor(final Hit hit, final World world){
		if(hit==null) throw new IllegalArgumentException("hit darf nicht null sein");
		if(world==null) throw new IllegalArgumentException("world darf nicht null sein");
		return this.color;
	}

}
