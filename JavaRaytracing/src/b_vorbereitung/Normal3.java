package b_vorbereitung;

/**
 * Diese Klasse stellt eine Normale (x,y,z) auf einer Oberfläche dar.
 * @author Kosmonaut
 *
 */
public class Normal3 {
	
	/**
	 * Der x-Wert der Normalen
	 */
	public final double x;
	
	/**
	 * Der y-Wert der Normalen
	 */
	public final double y;
	
	/**
	 * Der z-Wert der Normalen
	 */
	public final double z;
	
	/**
	 * Dieser Konstruktor erzeugt ein neues Normal3-Objekt.
	 * @param x Der x-Wert der Normalen
	 * @param y Der y-Wert der Normalen
	 * @param z Der z-Wert der Normalen
	 */
	public Normal3(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Multipliziert diese Normal3 mit einer reellen Zahl.
	 * @param n der Multiplikator
	 * @return das Produkt der Normalen und der Zahl
	 */
	public Normal3 mul(final double n){
		return new Normal3(n*x, n*y, n*z);
	}
	
	/**
	 * Addiert diese Normal3 mit einer anderen Normal3.
	 * @param n die zweite Normale
	 * @return die Summe beider Normalen
	 */
	public Normal3 add(final Normal3 n){
		if(n==null){
			throw new IllegalArgumentException("n darf nicht null sein");
		}
		return new Normal3(x + n.x, y + n.y, z + n.z);
	}
	
	/**
	 * Berechnet das Skalarprodukt dieser Normal3 und einem Vector3.
	 * @param v der Vektor
	 * @return das Skalarprodukt der Normalen und des Vektors
	 */
	public double dot(final Vector3 v){
		if(v==null){
			throw new IllegalArgumentException("n darf nicht null sein");
		}
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
		return "Normal3: " + String.format("(%5.2f, %5.2f, %5.2f )", x, y, z);
	}
	
	
}
