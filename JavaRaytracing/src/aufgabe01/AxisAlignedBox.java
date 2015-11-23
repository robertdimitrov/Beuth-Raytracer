package aufgabe01;

import java.util.ArrayList;

import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

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
	 * alle Seiten dieses Würfels
	 */
	private final Plane[] allSides = new Plane[6];
	/**
	 * Ein am Koordinatensystem ausgerichteter Quader 
	 * 
	 * @param lbf Ecke des Quaders die in im Koordinatensystem am niedrigsten ist
	 * @param run Ecke des Quaders die in im Koordinatensystem am hoechsten ist
	 * @param color Die Farbe des Quaders
	 */
	public AxisAlignedBox(final Point3 lbf, final Point3 run, final Color color) {
		super(color);
		this.lbf = lbf;
		if(lbf.x <= run.x && lbf.y <= run.y && lbf.z <= run.z){
			this.run = run;
		}else{
			throw new IllegalArgumentException("run has to have higher x, y and z values than lbf");
		}

		// Seiten festlegen
		allSides[0] = new Plane(lbf, new Normal3(-1, 0, 0), color);
		allSides[1] = new Plane(lbf, new Normal3(0, -1, 0), color);
		allSides[2] = new Plane(lbf, new Normal3(0, 0, -1), color);
		allSides[3] = new Plane(run, new Normal3(1, 0, 0), color);
		allSides[4] = new Plane(run, new Normal3(0, 1, 0), color);
		allSides[5] = new Plane(run, new Normal3(0, 0, 1), color);
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
		// schau, ob der Schnittpunkt, den furthestHit beschreibt im
		// Quader liegt
		Point3 hitP = r.at(furthestHit.t);
		if (lbf.x <= hitP.x && hitP.x <= run.x && lbf.y <= hitP.y
				&& hitP.y <= run.y && lbf.z <= hitP.z && hitP.z <= run.z) {
			return new Hit(furthestHit.t, r, this);
		}
		return null;
	}

	@Override
	public String toString() {
		return "AxisAlignedBox from "+lbf+" to "+run+super.toString();
	}

}
