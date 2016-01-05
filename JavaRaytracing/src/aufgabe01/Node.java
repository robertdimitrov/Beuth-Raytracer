package aufgabe01;

import b_vorbereitung.Normal3;
import b_vorbereitung.Vector3;
import beleuchtung_I.Material;
import transformation.Transform;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Kosmonaut
 */
public class Node extends Geometry {

    private final Transform transform;
    private final List<Geometry> geometries;

    public Node(Transform transform, List<Geometry> geometries) {
        super(null);
        this.transform = transform;
        this.geometries = geometries;
    }

    @Override
    public Hit hit(Ray r) {
    	final Ray transformedRay = transform.mul(r);
		Set<Hit> helpSet = new HashSet<Hit>();
		Hit minT = null;
		for(Geometry g : geometries){
			Hit hit = g.hit(transformedRay);
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
		}else{
			return null;
		}
		return new Hit(minT.t, r, transform.mul(minT.n), minT.geo);
    }
}
