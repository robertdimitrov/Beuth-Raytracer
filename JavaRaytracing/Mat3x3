package b_vorbereitung;

public class Mat3x3 {

	public final double m11;
	public final double m12;
	public final double m13;
	public final double m21;
	public final double m22;
	public final double m23;
	public final double m31;
	public final double m32;
	public final double m33;
	public final double determinant;

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
		determinant = m11 * m22 * m33 + m12 * m23 * m31 + m13 * m22 * m32 - m11
				* m23 * m32 - m12 * m21 * m33 - m13 * m22 * m31;
	}

	public Mat3x3 mul(Mat3x3 m) {
		return new Mat3x3(m11 * m.m11 + m12 * m.m21 + m13 * m.m31, m11 * m.m12
				+ m12 * m.m22 + m13 * m.m32, m11 * m.m13 + m13 * m.m23 + m13
				* m.m33, m21 * m.m11 + m22 * m.m21 + m23 * m.m31, m21 * m.m12
				+ m22 * m.m22 + m33 * m.m32, m21 * m.m13 + m22 * m.m23 + m23
				* m.m33, m31 * m.m11 + m32 * m.m21 + m33 * m.m31, m31 * m.m12
				+ m32 * m.m22 + m33 * m.m32, m31 * m.m13 + m32 * m.m23 + m33
				* m.m33);
	}

	public Vector3 mul(Vector3 v) {
		return new Vector3(m11*v.x + m12*v.y + m13*v.z, m21*v.x + m22*v.y + m23*v.z, m31*v.x + m32*v.y + m33*v.z);
	}

	public Point3 mul(Point3 p) {
		return new Point3(m11*p.x + m12*p.y + m13*p.z, m21*p.x + m22*p.y + m23*p.z, m31*p.x + m32*p.y + m33*p.z);
	}

	public Mat3x3 changeCol1(Vector3 v) {
		return new Mat3x3(v.x, m12, m13, v.y, m22, m23, v.z, m32, m33);
	}

	public Mat3x3 changeCol2(Vector3 v) {
		return new Mat3x3(m11, v.x, m13, m21, v.y, m23, m31, v.z, m33);
	}

	public Mat3x3 changeCol3(Vector3 v) {
		return new Mat3x3(m11, m12, v.x, m21, m22, v.y, m31, m32, v.z);
	}
}
