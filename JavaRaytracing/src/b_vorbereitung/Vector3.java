package b_vorbereitung;

/**
 * Diese Klasse stellt einen Vektor (x,y,z) im 3D-Raum dar.
 * @author Kosmonaut
 *
 */
public class Vector3 {

	/**
	 * Der x-Wert des Vektors
	 */
	public final double x;
	/**
	 * Der y-Wert des Vektors
	 */
	public final double y;
	/**
	 * Der z-Wert des Vektors
	 */
	public final double z;
	/**
	 * Die Länge des Vektors
	 */
	public final double magnitude;
	
	/**
	 * Dieser Konstruktor erzeugt ein neues Vector3-Objekt.
	 * @param x Der x-Wert des Vektors
	 * @param y	Der y-Wert des Vektors
	 * @param z	Der z-Wert des Vektors
	 */
	public Vector3(final double x, final double y, final double z){
		this.x = x;
		this.y = y;
		this.z = z;
		magnitude=Math.sqrt(x*x + y*y + z*z);
	}
	
	/**
	 * Addiert diesen Vector3 mit einem anderen Vector3.
	 * @param v der zu addierende Vector3
	 * @return die Summe beider Vektoren
	 */
	public Vector3 add(final Vector3 v){
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
		return new Vector3(x+v.x, y+v.y, z+v.z);
	}
	
	/**
	 * Addiert diesen Vector3 mit einer Normal3.
	 * @param n die zu addierende Normale
	 * @return die Summe des Vektors und der Normalen
	 */
	public Vector3 add(final Normal3 n){
		if(n==null){
			throw new IllegalArgumentException("n darf nicht null sein");
		}
		return new Vector3(x+n.x, y+n.y, z+n.z);
	}
	
	/**
	 * Subtrahiert eine Normal3 von diesem Vector3.
	 * @param n der Subtrahend
	 * @return die Differenz zwischen dem Vektor und der Normalen
	 */
	public Vector3 sub(final Normal3 n){
		if(n==null){
			throw new IllegalArgumentException("n darf nicht null sein");
		}
		return new Vector3(x-n.x, y-n.y, z-n.z);
	}
	
	/**
	 * Multipliziert diesen Vector3 mit einer reellen Zahl.
	 * @param c der Multiplikator
	 * @return das Produkt des Vektors und der Zahl
	 */
	public Vector3 mul(final double c){
		return new Vector3(x*c, y*c, z*c);
	}
	
	/**
	 * Berechnet das Skalarprodukt dieses Vector3 mit einem anderen Vector3.
	 * @param v der zweite Vector3
	 * @return das Skalarprodukt beider Vektoren
	 */
	public double dot(final Vector3 v){
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
		return x*v.x + y*v.y + z*v.z;
	}
	
	/**
	 * Berechnet das Skalarprodukt dieses Vector3 mit einer Normal3.
	 * @param n die Normale
	 * @return das Skalarprodukt des Vektors und der Normalen
	 */
	public double dot(final Normal3 n){
		if(n==null){
			throw new IllegalArgumentException("n darf nicht null sein");
		}
		return x*n.x + y*n.y + z*n.z;
	}
	
	/** 
	 * Normiert diesen Vector3.
	 * @return der normierte Vector3
	 */
	public Vector3 normalized(){
		if(magnitude==0){
			throw new IllegalArgumentException("Die Länge des Vektors darf bei dieser Operation nicht 0 sein.");
		}
		return new Vector3(x/magnitude, y/magnitude, z/magnitude);
	}
	
	/**
	 * Konvertiert diesen Vector3 in eine Normale.
	 * @return den konvertierten Vektor
	 */
	public Normal3 asNormal(){
		if(magnitude==0){
			throw new IllegalArgumentException("Die Länge des Vektors darf bei dieser Operation nicht 0 sein.");
		}
		return new Normal3(x/magnitude, y/magnitude, z/magnitude);
	}
	
	/**
	 * Reflektiert diesen Vector3 an einer Normalen.
	 * @param n die Normale
	 * @return der reflektierte Vektor
	 */
	public Vector3 reflectedOn(final Normal3 n){
		if(n==null){
			throw new IllegalArgumentException("n darf nicht null sein");
		}
		Normal3 m = n.mul(this.dot(n)*2);
		Vector3 v = new Vector3(-x, -y, -z);
		return v.add(m);
	}
	
	/**
	 * Berechnet das Kreuzprodukt dieses Vektor3 und eines anderen Vector3.
	 * @param v der zweite Vektor
	 * @return das Kreuzprodukt beider Vektoren
	 */
	public Vector3 x(final Vector3 v){
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
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
		return "Vector3: " + String.format("(%5.2f, %5.2f, %5.2f )", x, y, z);
	}
	
}
