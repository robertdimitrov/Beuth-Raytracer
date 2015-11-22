package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public class Ray {

	public final Point3 o;
	public final Vector3 d;
	
	public Ray(Point3 o, Vector3 d){
		this.o = o;
		this.d = d;
	}
	
	public Point3 at(double t){
		return o.add(d.mul(t));
	}
	
	public double tOf(Point3 p){
		return (p.x - o.x) / d.x;
	}
}
