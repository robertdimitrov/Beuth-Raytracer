package aufgabe01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class World {
	
	public final Color backgroundColor; 
	
//	In diesem Set werden die Geometrien gespeichert, die abgebildet werden sollen
	
	public final Set<Geometry> welt;
	
	public World(Set<Geometry> set, Color color){
		
		welt = set;	
		backgroundColor=color;
	}
	
/*
 * Diese Methode nimmt einen Strahl entgegen, der von einer Kamera erzeugt wurde.
 * Es wird ein Hiflsset (helpSet)erzeugt, in dem alle Hits gespeichert werden, die nicht null sind.
 * Ein Iterator iteriert über das Set "welt". Dabei wird ein Geometry-Objekt erzeugt ud die Methode hit() des Objektes aufgerufen.
 * Wenn hit nicht null ist, wird er in helpSet gespeichert.
 * Wenn helpSet hits enthält, wird derjenige ausgewählt, der das kleinste t hat. Dazu wird wieder mit einem Iterator über das Set iteriert.
 * 
 * 
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
}
