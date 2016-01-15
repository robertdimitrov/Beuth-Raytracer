package aufgabe01;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.utils.SuballocatedByteVector;

import transformation.Transform;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.LambertMaterial;
import beleuchtung_I.Material;

/**
 * Ein am Koordinatensystem ausgerichteter Quader
 *
 * @author Kosmonaut
 *
 */
public class AxisAlignedBox extends Geometry {
	/**
	 * Ecke des Quaders die in im Koordinatensystem am niedrigsten ist
	 */
	public final Point3 lbf;
	/**
	 * Ecke des Quaders die in im Koordinatensystem am hoechsten ist
	 */
	public final Point3 run;
	/**
	 * alle Seiten dieses W�rfels
	 */
	private final Node[] allSides = new Node[6];

	/**
	 * Ein am Koordinatensystem ausgerichteter Quader
	 *
	 * @param lbf
	 *            Ecke des Quaders die in im Koordinatensystem am niedrigsten
	 *            ist
	 * @param run
	 *            Ecke des Quaders die in im Koordinatensystem am hoechsten ist
	 * @param color
	 *            Die Farbe des Quaders
	 */
	public AxisAlignedBox(final Material material) {
		super(material);
		lbf = new Point3(-0.5, -0.5, -0.5);
		run = new Point3(0.5, 0.5, 0.5);

		// Seiten festlegen
		final List<Geometry> planeList = new ArrayList<Geometry>();
		planeList.add(new Plane(material));
		final List<Geometry> planeList1 = new ArrayList<Geometry>();
		planeList1.add(new Plane(new LambertMaterial(Color.BLUE)));
		final List<Geometry> planeList2 = new ArrayList<Geometry>();
		planeList2.add(new Plane(new LambertMaterial(Color.RED)));
		final List<Geometry> planeList3 = new ArrayList<Geometry>();
		planeList3.add(new Plane(new LambertMaterial(Color.GREEN)));
		final List<Geometry> planeList4 = new ArrayList<Geometry>();
		planeList4.add(new Plane(new LambertMaterial(Color.WHITE)));
		final List<Geometry> planeList5 = new ArrayList<Geometry>();
		planeList5.add(new Plane(new LambertMaterial(new Color(.5, .5, .5))));

		// von positiv z aus
		// links
		final Vector3 lbfV = lbf.sub(new Point3(0, 0, 0));
		final Vector3 runV = run.sub(new Point3(0, 0, 0));
		allSides[0] = new Node(new Transform().translation(
				lbfV).rotateZ(Math.PI / 2), planeList);
		// unten
		allSides[1] = new Node(new Transform().translation(
				lbfV).rotateX(Math.PI), planeList1);
		// hinten
		allSides[2] = new Node(new Transform().translation(
				lbfV).rotateX(-Math.PI / 2), planeList2);
		//rechts
		allSides[3] = new Node(new Transform().translation(
				runV).rotateZ(-Math.PI / 2), planeList3);
		//oben
		allSides[4] = new Node(
				new Transform().translation(runV), planeList4);
		//vorne
		allSides[5] = new Node(new Transform().translation(
				runV).rotateX(Math.PI / 2), planeList5);
		
	}

	@Override
	public Hit hit(Ray r) {
//		// lasse closestPositiveHit auf den am naehesten Hit aller Planes in
//		// facingSides zeigen
//		Hit closestPositiveHit = null;
//		for (int j = 0; j < 3; j++) {
//			Hit newlbfHit = allSides[j].hit(r);
//			Hit newrunHit = allSides[j +3].hit(r);
//			if (newlbfHit != null && closestPositiveHit == null) {
//				closestPositiveHit = newlbfHit;
//				if (newrunHit != null && closestPositiveHit == null) {
//					closestPositiveHit = newrunHit;
//				}
//			}
//			if (newlbfHit != null && newlbfHit.t < closestPositiveHit.t) {
//				closestPositiveHit = newlbfHit;
//			}
//			if (newrunHit != null && newrunHit.t < closestPositiveHit.t) {
//				closestPositiveHit = newrunHit;
//			}
//		}
//		if (closestPositiveHit == null) {
//			return null;
//		}
		
		final List<Hit> facingSides = new ArrayList<Hit>();
		 		for (int i = 0; i < allSides.length; i++) {
		 			final Hit hit = allSides[i].hit(r);
		 			if (hit != null && hit.n.dot(r.o.sub(i<3?lbf:run)) > 0) {
		 				facingSides.add(hit);
		 			}
		 		}
		
 		// lasse furthestHit auf den am weitesten entfernten Hit aller Planes in
 		// allSides zeigen
 		Hit furthestHit = null;
 		for (int j = 0; j < facingSides.size(); j++) {
 			final Hit hit = facingSides.get(j);
 			if (furthestHit == null) {
 				furthestHit = hit;
 				continue;
 			}
 			if (hit.t > furthestHit.t) {
 				furthestHit = hit;
 			}
 		}
 		if (furthestHit == null) {
 			return null;

 		}
 
		// schau, ob der Schnittpunkt, den closestPositiveHit beschreibt im
		// Quader liegt
		Point3 hitP = r.at(furthestHit.t);

		// mithilfe von diesen kann ich unnoetige hitP-tests weglassen
		if (Math.abs(furthestHit.n.x) == 1) {
			if (lbf.y <= hitP.y && hitP.y <= run.y && lbf.z <= hitP.z
					&& hitP.z <= run.z) {
				return new Hit(furthestHit.t, r, furthestHit.n,
						this
						);
			}
		}
		
		if (Math.abs(furthestHit.n.y) == 1) {
			if (lbf.x <= hitP.x && hitP.x <= run.x && lbf.z <= hitP.z
					&& hitP.z <= run.z) {
				return new Hit(furthestHit.t, r, furthestHit.n,
						this
						);
			}
		}
		if (Math.abs(furthestHit.n.z) == 1) {
			if (lbf.x <= hitP.x && hitP.x <= run.x && lbf.y <= hitP.y
					&& hitP.y <= run.y) {
				return new Hit(furthestHit.t, r, furthestHit.n,
						this
						);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "AxisAlignedBox";
	}

}
