package b_vorbereitung;

public class Vector3 {

	public final double x;
	public final double y;
	public final double z;
	public final double magnitude;
	
	public Vector3(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
		magnitude=Math.sqrt(x*x + y*y + z*z);
	}
	
	public Vector3 add(Vector3 v){
		return new Vector3(x+v.x, y+v.y, z+v.z);
	}
	
	public Vector3 add(Normal3 n){
		return new Vector3(x+n.x, y+n.y, z+n.z);
	}
	
	public Vector3 sub(Normal3 n){
		return new Vector3(x-n.x, y-n.y, z-n.z);
	}
	
	public Vector3 mul(double c){
		return new Vector3(x*c, y*c, z*c);
	}
	
	public double dot(Vector3 v){
		return x*v.x + y*v.y + z*v.z;
	}
	
	public double dot(Normal3 n){
		return x*n.x + y*n.y + z*n.z;
	}
	
	public Vector3 normalized(){
		if(magnitude==0){
			throw new IllegalArgumentException("The magnitude of the Vector can not be 0");
		}
		return new Vector3(x/magnitude, y/magnitude, z/magnitude);
	}
	
	public Normal3 asNormal(){
		if(magnitude==0){
			throw new IllegalArgumentException("The magnitude of the Vector can not be 0");
		}
		return new Normal3(x/magnitude, y/magnitude, z/magnitude);
	}
	
	public Vector3 reflectedOn(Normal3 n){
		Normal3 m = n.mul(this.dot(n)*2);
		Vector3 v = new Vector3(-x, -y, -z);
		return v.add(m);
	}
	
	public Vector3 x(Vector3 v){
		return new Vector3(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(magnitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Vector3 other = (Vector3) obj;
		if (Double.doubleToLongBits(magnitude) != Double
				.doubleToLongBits(other.magnitude))
			return false;
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
		return "Vector3 [x=" + x + ", y=" + y + ", z=" + z + ", magnitude="
				+ magnitude + "]";
	}

	
}
