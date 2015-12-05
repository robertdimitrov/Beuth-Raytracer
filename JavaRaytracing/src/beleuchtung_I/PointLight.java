package beleuchtung_I;

import aufgabe01.Color;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Alles Licht dieser Lichtquelle geht von einem einzigen Punkt aus
 * 
 * @author Kosmonaut
 *
 */
public class PointLight extends Light {
	/**
	 * Die Position des Punkts, von dem das Licht ausgeht
	 */
	public final Point3 position;

	/**
	 * Eine Lichtquelle, bei der alles Licht von einem einzigen Punkt ausgeht
	 * 
	 * @param color
	 *            Die Farbe des Lichts
	 * @param position
	 *            Die Position des Punkts, von dem das Licht ausgeht
	 */
	public PointLight(final Color color, final Point3 position) {
		super(color);
		this.position = position;
	}

	@Override
	public boolean illuminates(Point3 point) {
		return true;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point);
	}

}
