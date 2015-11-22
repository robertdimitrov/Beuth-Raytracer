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
		
<<<<<<< HEAD
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
=======
//		Set<Hit> helpSet = new HashSet<Hit>();
//		Hit hit = null;
//		Hit minT = null;
//		Iterator<Geometry> it = welt.iterator();
//		while(it.hasNext()){
//			Geometry geo = it.next();		
//			hit=geo.hit(r);
//			if(hit!=null){
//				helpSet.add(hit);
//				System.out.println(helpSet.size()); // Test, um zu sehen, ob es einen hit gab
//			}
//		}
//		
//		if(helpSet.size()!=0){
//			Iterator<Hit> iterator = helpSet.iterator();
//			minT=iterator.next();
//			while(iterator.hasNext()){
//				Hit h=iterator.next();
//				if(h.t<minT.t){
//					minT=h;
//				}
//			}	
//			return minT;
//			
//		}
//		else return null;
		
		Hit hit = null;
		double minT = 1000000;
		
		for(Geometry g : welt){
			Hit h = g.hit(r);
			if(h==null) continue;
			if(h.t > 0 && h.t < minT){
				minT = h.t;
				hit = h;
			}
		}
		return hit;

	}
	

		
>>>>>>> 74b6b47e5d62fa0130d8e1ec57d4d9bc54d34193
}

