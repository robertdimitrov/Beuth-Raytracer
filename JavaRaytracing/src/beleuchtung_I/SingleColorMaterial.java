package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

/**
 * 
 * Klasse repr�sentiert einfarbiges Material ohne Reflektion
 * @author Clemens
 *

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


	
	

	
	/* (non-Javadoc)
	 * @see beleuchtung_I.Material#colorFor(aufgabe01.Hit, aufgabe01.World)
	 */
	public Color colorFor(Hit hit, World world, Tracer tracer){

		if(hit==null) throw new IllegalArgumentException("hit darf nicht null sein");
		if(world==null) throw new IllegalArgumentException("world darf nicht null sein");
		return this.color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleColorMaterial other = (SingleColorMaterial) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SingleColorMaterial [color=" + color + "]";
	}
	
	

}
