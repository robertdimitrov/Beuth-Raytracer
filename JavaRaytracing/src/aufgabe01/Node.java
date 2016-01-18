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
		Hit minT = null;
		for(Geometry g : geometries){
			Hit hit = g.hit(transformedRay);
			if(minT == null){
				minT = hit;
			}
			if(hit!=null && hit.t < minT.t && hit.t > 0){				
				helpSet.add(hit);
			}
		}
		if(minT == null){
			return null;
		}
		return new Hit(minT.t, r, transform.mul(minT.n), minT.geo);
    }
    
 
}
