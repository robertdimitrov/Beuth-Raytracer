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

	/**
	 * Transform-Objekt
	 */
    public final Transform transform;
	/**
	 * Liste von Geometrien
	 */
    public final List<Geometry> geometries;

	/**
	 * Erstellt ein neues Node-Objekt
	 * @param transform das entsprechende Transform-Objekt
	 * @param geometries Liste der Geometrien
     */
    public Node(Transform transform, List<Geometry> geometries) {
		super(null);
		if(transform==null) throw new IllegalArgumentException("transform darf nicht null sein");
		if(geometries==null) throw new IllegalArgumentException("geometries darf nicht null sein");
		this.transform = transform;
        this.geometries = geometries;
    }

    @Override
    public Hit hit(Ray r) {
    	if(r==null) throw new IllegalArgumentException("r darf nicht null sein");
		final Ray transformedRay = transform.mul(r);
		Set<Hit> helpSet = new HashSet<Hit>();
		Hit trueHit = null;
		for(Geometry g : geometries){
			Hit newHit = g.hit(transformedRay);
			if(trueHit == null){
				trueHit = newHit;
			}
			if(newHit!=null && newHit.t < trueHit.t && newHit.t > 0){				
				helpSet.add(newHit);
			}
		}
		if(trueHit == null){
			return null;
		}
		final Normal3 normal = trueHit.n;
		return new Hit(trueHit.t, r, transform.i.transpose().mul(new Vector3(normal.x, normal.y, normal.z)).normalized().asNormal(), trueHit.geo);
    }
    
 
}
