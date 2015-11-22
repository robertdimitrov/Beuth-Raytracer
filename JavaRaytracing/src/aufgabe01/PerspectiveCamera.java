package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public class PerspectiveCamera extends Camera {

	public final double angle;
	
	public PerspectiveCamera(Point3 e, Vector3 g, Vector3 t, double angle) {
		super(e, g, t);
		this.angle = angle;
	}

	@Override
	public Ray rayFor(final int w, final int h, final int x, final int y) {
		final Vector3 vectorX = u.mul(x - ((double)(w-1)/2));
		final Vector3 vectorY = v.mul(y - ((double)(h-1)/2));
		final Vector3 r = this.w.mul(((double)h/2)/Math.tan(angle)).mul(-1).add(vectorX).add(vectorY);
		
		return new Ray(e, r.normalized());
	}

}