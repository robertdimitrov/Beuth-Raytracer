package b_vorbereitung;

/**
 * Diese Klasse stellt einen Punkt (x,y,z) im 3D-Raum dar.
 * @author Kosmonaut
 *
 */
public class Point3 {
	
	/**
	 * Der x-Wert des Punktes.
	 */
	public final double x;
	
	/**
	 * Der y-Wert des Punktes.
	 */
	public final double y;
	
	/**
	 * Der z-Wert des Punktes.
	 */
	public final double z;
	
	
	/**
	 * Dieser Konstruktor erzeugt ein neues Point3-Objekt.
	 * @param x Der x-Wert des Punktes.
	 * @param y Der y-Wert des Punktes.
	 * @param z Der z-Wert des Punktes.
	 */
	public Point3(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Subtrahiert einen Point3 von diesem Point3.
	 * @param p der Subtrahend
	 * @return die Differenz zwischen den beiden Punkten
	 */
	public Vector3 sub(Point3 p){
		return new Vector3(x - p.x, y - p.y, z - p.z);
	}
	
	/**
	 * Subtrahiert einen Vector3 von diesem Point3.
	 * @param v der Subtrahend
	 * @return die Differenz zwischen dem Punkt und dem Vektor
	 */
	public Point3 sub(Vector3 v){
		return new Point3(x - v.x, y - v.y, z - v.z);
	}
	
	/**
	 * Addiert diesen Point3 mit einem Vector3.
	 * @param v der Vektor
	 * @return die Summe des Punktes und des Vektors
	 */
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

