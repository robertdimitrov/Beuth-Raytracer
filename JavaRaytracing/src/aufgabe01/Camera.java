package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public abstract class Camera {

	public final Point3 e;
	public final Vector3 g;
	public final Vector3 t;
	public final Vector3 u;
	public final Vector3 v;
	public final Vector3 w;
	
	public Camera(final Point3 e, final Vector3 g, final Vector3 t){
		this.e = e;
		this.g = g;
		this.t = t;
		
		w = g.normalized().mul(-1);
		u = t.x(g).normalized();
		v = w.x(u);
	}
	
	public abstract Ray rayFor(final int w, final int h, final int x, final int y);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((g == null) ? 0 : g.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (g == null) {
			if (other.g != null)
				return false;
		} else if (!g.equals(other.g))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if (w == null) {
			if (other.w != null)
				return false;
		} else if (!w.equals(other.w))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Camera [e=" + e + ", g=" + g + ", t=" + t + ", u=" + u + ", v="
				+ v + ", w=" + w + "]";
	}
	
	
}