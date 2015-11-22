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
		Hit hit = null;
		Hit minT = null;
		Iterator<Geometry> it = welt.iterator();
		while(it.hasNext()){
			Geometry geo = it.next();		
			hit=geo.hit(r);
			if(hit!=null){
				helpSet.add(hit);
				System.out.println(helpSet.size()); // Test, um zu sehen, ob es einen hit gab
			}
		}
		
		if(helpSet.size()!=0){
			Iterator<Hit> iterator = helpSet.iterator();
			minT=iterator.next();
			while(iterator.hasNext()){
				Hit h=iterator.next();
				if(h.t<minT.t){
					minT=h;
				}
			}
			
		}else {return null;}
		
		
		
		
		
		return minT;
	}

}
