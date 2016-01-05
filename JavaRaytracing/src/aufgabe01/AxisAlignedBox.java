package aufgabe01;

import java.util.ArrayList;
import java.util.List;

import transformation.Transform;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
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
		allSides[0] = new Node(new Transform().rotateX(Math.PI/2).translation(new Vector3(-.5, 0, 0)), planeList);
		allSides[1] = new Node(new Transform().rotateY(Math.PI/2).translation(new Vector3(0, -.5, 0)), planeList);
		allSides[2] = new Node(new Transform().rotateZ(Math.PI/2).translation(new Vector3(0, 0, -.5)), planeList);
		allSides[3] = new Node(new Transform().rotateX(Math.PI/2).translation(new Vector3(.5, 0, 0)), planeList);
		allSides[4] = new Node(new Transform().rotateY(Math.PI/2).translation(new Vector3(0, .5, 0)), planeList);
		allSides[5] = new Node(new Transform().rotateZ(Math.PI/2).translation(new Vector3(0, 0, .5)), planeList);
	}

	@Override
	public Hit hit(Ray r) {
		// lasse closestPositiveHit auf den am naehesten Hit aller Planes in
		// facingSides zeigen
		Hit closestPositiveHit = null;
		for (int j = 0; j < allSides.length; j++) {
			Hit newHit = allSides[j].hit(r);
			if (newHit != null && closestPositiveHit == null) {
				closestPositiveHit = newHit;
				continue;
			}
			if (newHit != null && newHit.t < closestPositiveHit.t) {
				closestPositiveHit = newHit;
			}
		}
		if (closestPositiveHit == null) {
			return null;
		}

		// schau, ob der Schnittpunkt, den closestPositiveHit beschreibt im
		// Quader liegt
		Point3 hitP = r.at(closestPositiveHit.t);
		
		
//		 mithilfe von diesen kann ich unnoetige hitP-tests weglassen
		if (Math.abs(((Plane) closestPositiveHit.geo).n.x) == 1) {
			if (lbf.y <= hitP.y && hitP.y <= run.y && lbf.z <= hitP.z
					&& hitP.z <= run.z) {
				return new Hit(closestPositiveHit.t, r, closestPositiveHit.n, this);
			}
		}
		if (Math.abs(((Plane) closestPositiveHit.geo).n.y) == 1) {
			if (lbf.x <= hitP.x && hitP.x <= run.x && lbf.z <= hitP.z
					&& hitP.z <= run.z) {
				return new Hit(closestPositiveHit.t, r, closestPositiveHit.n, this);
			}
		}
		if (Math.abs(((Plane) closestPositiveHit.geo).n.z) == 1) {
			if (lbf.x <= hitP.x && hitP.x <= run.x && lbf.y <= hitP.y
					&& hitP.y <= run.y) {
				return new Hit(closestPositiveHit.t, r, closestPositiveHit.n, this);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "AxisAlignedBox";
	}

}
