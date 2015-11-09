package b_vorbereitung;

public class Normal3 {
	
	public final double x;
	public final double y;
	public final double z;

	public Normal3(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Normal3 mul(double n){
		return new Normal3(n*x, n*y, n*z);
	}
	
	public Normal3 add(Normal3 n){
		return new Normal3(x + n.x, y + n.y, z + n.z);
	}
	
	public double dot(Vector3 v){
		return x*v.x + y*v.y + z*v.z;
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
		Normal3 other = (Normal3) obj;
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
		return "Normal3 [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
