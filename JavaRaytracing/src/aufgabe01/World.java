package aufgabe01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Clemens
 *
 *Diese Klasse stellt eine Welt dar. In dieser Welt k�nnen Geometry-Objekte dargestellt werden. 
 */
public class World {
	
	/**
	 * Hintergrundfarbe der Welt 
	 */
	public final Color backgroundColor; 
		
	/**
	 * In diesem Set werden die Geometrien gespeichert, die abgebildet werden sollen 
	 */
	public final Set<Geometry> welt;
	
	/**
	 * @param set Eine Sammlung von Geometry-Objekten
	 * @param color Farbe f�r die backgroundColor
	 */
	public World(Set<Geometry> set, Color color){
		
		welt = set;	
		backgroundColor=color;
	}
	

  
  
 
 
	
	/**
	 * Diese Methode nimmt einen Strahl entgegen, der von einer Kamera erzeugt wurde.
  	 * Es wird ein Hiflsset (helpSet)erzeugt, in dem alle Hits gespeichert werden, die nicht null sind.
  	 * Ein Iterator iteriert über das Set "welt". Dabei wird ein Geometry-Objekt erzeugt ud die Methode hit() des Objektes aufgerufen.
     * Wenn hit nicht null ist, wird er in helpSet gespeichert.
     * Wenn helpSet hits enthält, wird derjenige ausgewählt, der das kleinste t hat. Dazu wird wieder mit einem Iterator über das Set iteriert.
	 * @param r Ein Strahl, der von einer Kamera erzeugt wurde
	 * @return ein Hit-Objekt, wenn es einen Schnittpunkt gibt oder null
	 */
	public Hit hit(Ray r){
		

		Set<Hit> helpSet = new HashSet<Hit>();
	
		Hit minT = null;

		for(Geometry g : welt){
			Hit hit = g.hit(r);
			if(hit!=null && hit.t > 0){				
				helpSet.add(hit);
			}
		}
		if(helpSet.size()!=0){
			Iterator<Hit> it = helpSet.iterator();
			minT=it.next();
			while(it.hasNext()){
				Hit help = it.next();
				if(minT.t>help.t){
					minT=help;
				}
			}	
		}
		return minT;						
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backgroundColor == null) ? 0 : backgroundColor.hashCode());
		result = prime * result + ((welt == null) ? 0 : welt.hashCode());
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
		World other = (World) obj;
		if (backgroundColor == null) {
			if (other.backgroundColor != null)
				return false;
		} else if (!backgroundColor.equals(other.backgroundColor))
			return false;
		if (welt == null) {
			if (other.welt != null)
				return false;
		} else if (!welt.equals(other.welt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "World [backgroundColor=" + backgroundColor + ", welt=" + welt + "]";
	}
				
}

