package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public class OrthographicCamera extends Camera {

	public final double s;
	
	public OrthographicCamera(Point3 e, Vector3 g, Vector3 t, double s) {
		super(e, g, t);
		this.s = s;
	}

	@Override
	public Ray rayFor(int w, int h, int x, int y) {
		double a = (double) w/h;
		Vector3 d = this.w.mul(-1);
		
		Vector3 vectorX = u.mul(((x - (double)((w - 1)/2))/(w-1))).mul(s).mul(a);
		Vector3 vectorY = v.mul(((y - (double)((h - 1)/2))/(h-1))).mul(s);
		
		return new Ray(e.add(vectorX.add(vectorY)), d);
	}

	@Override
	public String toString() {
		return "OrthographicCamera [s=" + s + "]";
	}

}
