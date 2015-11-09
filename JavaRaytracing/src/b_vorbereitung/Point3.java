package b_vorbereitung;

public class Point3 {
	
	public final double x;
	public final double y;
	public final double z;
	
	public Point3(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3 sub(Point3 p){
		return new Vector3(x - p.x, y - p.y, z - p.z);
	}
	
	public Point3 sub(Vector3 v){
		return new Point3(x - v.x, y - v.y, z - v.z);
	}
	
	public Point3 add(Vector3 v){
		return new Point3(x + v.x, y + v.y, z + v.z);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Point3 other = (Point3) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
	

}

