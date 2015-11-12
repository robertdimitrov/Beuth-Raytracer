package aufgabe01;

import java.util.ArrayList;

import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * ein am Koordinatensystem ausgerichteter Wuerfel
 * 
 * @author Kosmonaut
 *
 */
public class AxisAlignedBox extends Geometry {
	/**
	 * Ecke des Wuerfels die in im Koordinatensystem am niedrigsten ist
	 */
	public final Point3 lbf;
	/**
	 * Ecke des Wuerfels die in im Koordinatensystem am hoechsten ist
	 */
	public final Point3 run;
	/**
	 * alle Seiten dieses Würfels
	 */
	private final Plane[] allSides = new Plane[6];

	/**
	 * 
	 * @param lbf
	 * @param run
	 * @param color
	 */
	public AxisAlignedBox(final Point3 lbf, final Point3 run, final Color color) {
		super(color);
		this.lbf = lbf;
		this.run = run;

		// Seiten festlegen
		allSides[0] = new Plane(lbf, new Normal3(-1, 0, 0), color);
		allSides[1] = new Plane(lbf, new Normal3(0, -1, 0), color);
		allSides[2] = new Plane(lbf, new Normal3(0, 0, -1), color);
		allSides[3] = new Plane(lbf, new Normal3(1, 0, 0), color);
		allSides[4] = new Plane(lbf, new Normal3(0, 1, 0), color);
		allSides[5] = new Plane(lbf, new Normal3(0, 0, 1), color);
	}

	@Override
	public Hit hit(Ray r) {
		// schreibe in facingSides alle Planes, die man vom Ursprung des Rays
		// sieht
		final ArrayList<Plane> facingSides = new ArrayList<Plane>();
		Vector3 oSubA = r.o.sub(lbf);
		for (int i = 0; i < allSides.length; i++) {
			if (allSides[i].n.dot(oSubA) > 0) {
				facingSides.add(allSides[i]);
			}
		}

		// lasse furthestHit auf den am weitesten entfernten Hit aller Planes in
		// facingSides zeigen
		Hit furthestHit = null;
		for (int j = 0; j < facingSides.size(); j++) {
			Hit newHit = facingSides.get(j).hit(r);
			if (furthestHit == null) {
				furthestHit = newHit;
				continue;
			}
			if (newHit.t > furthestHit.t) {
				furthestHit = newHit;
			}
		}
		// schau, ob der Schnittpunkt, den furthestHit beschreibt ueberhaupt im
		// Wuerfel liegt
		Point3 hitP = r.at(furthestHit.t);
		if (lbf.x < hitP.x && hitP.x < run.x && lbf.y < hitP.y
				&& hitP.y < run.y && lbf.z < hitP.z && hitP.z < run.z) {
			return furthestHit;
		}
		return null;
	}

}
