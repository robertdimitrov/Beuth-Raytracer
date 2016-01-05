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

    public Node(Material material, Transform transform, List<Geometry> geometries) {
        super(material);
        this.transform = transform;
        this.geometries = geometries;
    }

    @Override
    public Hit hit(Ray r) {
    	final Ray transformedRay = new Ray(transform.m.mul(r.o), transform.m.mul(r.d));
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
		}
		final Normal3 n = minT.n;
		return new Hit(minT.t, r, (transform.m.mul(new Vector3(n.x, n.y, n.z))).asNormal(), minT.geo);
    }
}
