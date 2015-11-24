package b_vorbereitung;

/**
 * Diese Klasse stellt eine Matrix mit drei Zeilen und drei Spalten dar.
 * 
 * @author Kosmonaut
 * 
 */
public class Mat3x3 {

	/**
	 * Das Element in Zeile 1, Spalte 1
	 */
	public final double m11;

	/**
	 * Das Element in Zeile 1, Spalte 2
	 */
	public final double m12;

	/**
	 * Das Element in Zeile 1, Spalte 3
	 */
	public final double m13;

	/**
	 * Das Element in Zeile 2, Spalte 1
	 */
	public final double m21;

	/**
	 * Das Element in Zeile 2, Spalte 2
	 */
	public final double m22;

	/**
	 * Das Element in Zeile 2, Spalte 3
	 */
	public final double m23;

	/**
	 * Das Element in Zeile 3, Spalte 1
	 */
	public final double m31;

	/**
	 * Das Element in Zeile 3, Spalte 2
	 */
	public final double m32;

	/**
	 * Das Element in Zeile 3, Spalte 3
	 */
	public final double m33;

	/**
	 * Die Determinante der Matrix
	 */
	public final double determinant;

	/**
	 * Dieser Konstruktor erzeugt ein neues Mat3x3-Objekt.
	 * 
	 * @param m11 das Element in Zeile 1, Spalte 1
	 * @param m12 das Element in Zeile 1, Spalte 2
	 * @param m13 das Element in Zeile 1, Spalte 3
	 * @param m21 das Element in Zeile 2, Spalte 1
	 * @param m22 das Element in Zeile 2, Spalte 2
	 * @param m23 das Element in Zeile 2, Spalte 3
	 * @param m31 das Element in Zeile 3, Spalte 1
	 * @param m32 das Element in Zeile 3, Spalte 2
	 * @param m33 das Element in Zeile 3, Spalte 3
	 */
	public Mat3x3(final double m11, final double m12, final double m13,
			final double m21, final double m22, final double m23,
			final double m31, final double m32, final double m33) {
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
		// determinant = m11 * m22 * m33 + m12 * m23 * m31 + m13 * m22 * m32 - m11
		//		* m23 * m32 - m12 * m21 * m33 - m13 * m22 * m31;
		determinant = m11*(m22*m33 - m23*m32) - m12*(m21*m33 - m23*m31) + m13*(m21*m32 - m22*m31);
	}

	/**
	 * Multipliziert diese Mat3x3 mit einer anderen Mat3x3.
	 * @param m die zweite Matrix
	 * @return das Produkt der beiden Matrizen
	 */
	public Mat3x3 mul(final Mat3x3 m) {
		if(m==null){
			throw new IllegalArgumentException("m darf nicht null sein");
		}
		return new Mat3x3(m11 * m.m11 + m12 * m.m21 + m13 * m.m31, m11 * m.m12
				+ m12 * m.m22 + m13 * m.m32, m11 * m.m13 + m13 * m.m23 + m13
				* m.m33, m21 * m.m11 + m22 * m.m21 + m23 * m.m31, m21 * m.m12
				+ m22 * m.m22 + m33 * m.m32, m21 * m.m13 + m22 * m.m23 + m23
				* m.m33, m31 * m.m11 + m32 * m.m21 + m33 * m.m31, m31 * m.m12
				+ m32 * m.m22 + m33 * m.m32, m31 * m.m13 + m32 * m.m23 + m33
				* m.m33);
	}

	/**
	 * Multipliziert diese Mat3x3 mit einem Vector3.
	 * @param v der Vektor
	 * @return das Produkt der Matrix und des Vektors
	 */
	public Vector3 mul(final Vector3 v) {
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
		return new Vector3(m11 * v.x + m12 * v.y + m13 * v.z, m21 * v.x + m22
				* v.y + m23 * v.z, m31 * v.x + m32 * v.y + m33 * v.z);
	}

	/**
	 * Multipliziert diese Mat3x3 mit einem Point3.
	 * @param p der Punkt
	 * @return das Produkt der Matrix und des Punktes
	 */
	public Point3 mul(final Point3 p) {
		if(p==null){
			throw new IllegalArgumentException("p darf nicht null sein");
		}
		return new Point3(m11 * p.x + m12 * p.y + m13 * p.z, m21 * p.x + m22
				* p.y + m23 * p.z, m31 * p.x + m32 * p.y + m33 * p.z);
	}

	/**
	 * Tauscht die erste Spalte dieser Mat3x3 mit einem Vector3.
	 * @param v der Vektor
	 * @return die veränderte Matrix
	 */
	public Mat3x3 changeCol1(final Vector3 v) {
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
		return new Mat3x3(v.x, m12, m13, v.y, m22, m23, v.z, m32, m33);
	}

	/**
	 * Tauscht die zweite Spalte dieser Mat3x3 mit einem Vector3.
	 * @param v der Vektor
	 * @return die veränderte Matrix
	 */
	public Mat3x3 changeCol2(final Vector3 v) {
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
		return new Mat3x3(m11, v.x, m13, m21, v.y, m23, m31, v.z, m33);
	}

	/**
	 * Tauscht die dritte Spalte dieser Mat3x3 mit einem Vector3.
	 * @param v der Vektor
	 * @return die veränderte Matrix
	 */
	public Mat3x3 changeCol3(final Vector3 v) {
		if(v==null){
			throw new IllegalArgumentException("v darf nicht null sein");
		}
		return new Mat3x3(m11, m12, v.x, m21, m22, v.y, m31, m32, v.z);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(determinant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m11);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m12);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m13);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m21);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m22);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m23);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m31);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m32);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(m33);
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
		Mat3x3 other = (Mat3x3) obj;
		if (Double.doubleToLongBits(determinant) != Double
				.doubleToLongBits(other.determinant))
			return false;
		if (Double.doubleToLongBits(m11) != Double.doubleToLongBits(other.m11))
			return false;
		if (Double.doubleToLongBits(m12) != Double.doubleToLongBits(other.m12))
			return false;
		if (Double.doubleToLongBits(m13) != Double.doubleToLongBits(other.m13))
			return false;
		if (Double.doubleToLongBits(m21) != Double.doubleToLongBits(other.m21))
			return false;
		if (Double.doubleToLongBits(m22) != Double.doubleToLongBits(other.m22))
			return false;
		if (Double.doubleToLongBits(m23) != Double.doubleToLongBits(other.m23))
			return false;
		if (Double.doubleToLongBits(m31) != Double.doubleToLongBits(other.m31))
			return false;
		if (Double.doubleToLongBits(m32) != Double.doubleToLongBits(other.m32))
			return false;
		if (Double.doubleToLongBits(m33) != Double.doubleToLongBits(other.m33))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mat3x3: \n"
				+ String.format(
						"|%6.2f %6.2f %6.2f  |\n|%6.2f %6.2f %6.2f  |\n|%6.2f %6.2f %6.2f  |",
						m11, m12, m13, m21, m22, m23, m31, m32, m33);
	}

}