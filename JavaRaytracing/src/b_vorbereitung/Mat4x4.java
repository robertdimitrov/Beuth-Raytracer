package b_vorbereitung;

/**
 * Diese Klasse stellt eine Matrix mit vier Zeilen und vier Spalten dar.
 * @author Kosmonaut
 */
public class Mat4x4 {

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
     * Das Element in Zeile 1, Spalte 4
     */
    public final double m14;
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
     * Das Element in Zeile 2, Spalte 4
     */
    public final double m24;
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
     * Das Element in Zeile 3, Spalte 4
     */
    public final double m34;
    /**
     * Das Element in Zeile 4, Spalte 1
     */
    public final double m41;
    /**
     * Das Element in Zeile 4, Spalte 2
     */
    public final double m42;
    /**
     * Das Element in Zeile 4, Spalte 3
     */
    public final double m43;
    /**
     * Das Element in Zeile 4, Spalte 4
     */
    public final double m44;

    /**
     * Die Einheitsmatrix
     */
    public final static Mat4x4 EINHEITSMATRIX =
            new Mat4x4( 1.0,0,0,0,
                        0,1.0,0,0,
                        0,0,1.0,0,
                        0,0,0,1.0);

    /**
     * Erzeugt ein neues Mat4x4-Objekt
     * @param m11 das Element in Zeile 1, Spalte 1
     * @param m12 das Element in Zeile 1, Spalte 2
     * @param m13 das Element in Zeile 1, Spalte 3
     * @param m14 das Element in Zeile 1, Spalte 4
     * @param m21 das Element in Zeile 2, Spalte 1
     * @param m22 das Element in Zeile 2, Spalte 2
     * @param m23 das Element in Zeile 2, Spalte 3
     * @param m24 das Element in Zeile 2, Spalte 4
     * @param m31 das Element in Zeile 3, Spalte 1
     * @param m32 das Element in Zeile 3, Spalte 2
     * @param m33 das Element in Zeile 3, Spalte 3
     * @param m34 das Element in Zeile 3, Spalte 4
     * @param m41 das Element in Zeile 4, Spalte 1
     * @param m42 das Element in Zeile 4, Spalte 2
     * @param m43 das Element in Zeile 4, Spalte 3
     * @param m44 das Element in Zeile 4, Spalte 4
     */
    public Mat4x4(final double m11, final double m12, final double m13, final double m14,
                  final double m21, final double m22, final double m23, final double m24,
                  final double m31, final double m32, final double m33, final double m34,
                  final double m41, final double m42, final double m43, final double m44) {
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m21 = m21;
        this.m22 = m22;
        this.m23 = m23;
        this.m24 = m24;
        this.m31 = m31;
        this.m32 = m32;
        this.m33 = m33;
        this.m34 = m34;
        this.m41 = m41;
        this.m42 = m42;
        this.m43 = m43;
        this.m44 = m44;
    }

    /**
     * Multipliziert diese Mat4x4 mit einem Vector3 (mit w = 0)
     * @param v der Vektor
     * @return das Produkt der Matrix und des Vektors
     */
    public Vector3 mul(final Vector3 v){
        if(v==null) throw new IllegalArgumentException("v darf nicht null sein");
        return new Vector3(m11*v.x + m12*v.y + m13*v.z,
                m21*v.x + m22*v.y + m23*v.z,
                m31*v.x + m32*v.y + m33*v.z);
    }

    /**
     * Multipliziert diese Mat4x4 mit einem Point3 (mit w = 1)
     * @param p der Punkt
     * @return das Produkt der Matrix und des Punktes
     */
    public Point3 mul(final Point3 p){
        if(p==null) throw new IllegalArgumentException("p darf nicht null sein");
        return new Point3(m11*p.x + m12*p.y + m13*p.z + m14*1,
                m21*p.x + m22*p.y + m23*p.z + m24*1,
                m31*p.x + m32*p.y + m33*p.z + m34*1);
    }

    /**
     * Multipliziert diese Mat4x4 mit einer Normale (mit w = 0)
     * @param n die Normale
     * @return das Produkt der Matrix und der Normalen
     */
    public Normal3 mul(final Normal3 n){
        if(n==null) throw new IllegalArgumentException("n darf nicht null sein");
        return new Normal3(m11*n.x + m12*n.y + m13*n.z,
                m21*n.x + m22*n.y + m23*n.z,
                m31*n.x + m32*n.y + m33*n.z);
    }

    /**
     * Multipliziert diese Mat4x4 mit einer anderen Mat4x4
     * @param mat die zweite 4x4-Matrix
     * @return das Produkt beider Matrizen
     */
    public Mat4x4 mul(final Mat4x4 mat){
        if(mat==null) throw new IllegalArgumentException("mat darf nicht null sein");
        return new Mat4x4(m11*mat.m11 + m12*mat.m21 + m13*mat.m31 + m14*mat.m41,
                m11*mat.m12 + m12*mat.m22 + m13*mat.m32 + m14*mat.m42,
                m11*mat.m13 + m12*mat.m23 + m13*mat.m33 + m14*mat.m43,
                m11*mat.m14 + m12*mat.m24 + m13*mat.m34 + m14*mat.m44,
                m21*mat.m11 + m22*mat.m21 + m23*mat.m31 + m24*mat.m41,
                m21*mat.m12 + m22*mat.m22 + m23*mat.m32 + m24*mat.m42,
                m21*mat.m13 + m22*mat.m23 + m23*mat.m33 + m24*mat.m43,
                m21*mat.m14 + m22*mat.m24 + m23*mat.m34 + m24*mat.m44,
                m31*mat.m11 + m32*mat.m21 + m33*mat.m31 + m34*mat.m41,
                m31*mat.m12 + m32*mat.m22 + m33*mat.m32 + m34*mat.m42,
                m31*mat.m13 + m32*mat.m23 + m33*mat.m33 + m34*mat.m43,
                m31*mat.m14 + m32*mat.m24 + m33*mat.m34 + m34*mat.m44,
                m41*mat.m11 + m42*mat.m21 + m43*mat.m31 + m44*mat.m41,
                m41*mat.m12 + m42*mat.m22 + m43*mat.m32 + m44*mat.m42,
                m41*mat.m13 + m42*mat.m23 + m43*mat.m33 + m44*mat.m43,
                m41*mat.m14 + m42*mat.m24 + m43*mat.m34 + m44*mat.m44);
    }

    /**
     * Transponiert diese Mat4x4
     * @return die transponierte Matrix
     */
    public Mat4x4 transpose(){
        return new Mat4x4(m11, m21, m31, m41,
                m12, m22, m32, m42,
                m13, m23, m33, m43,
                m14, m24, m34, m44);
    }

    @Override
    public String toString() {
        return String.format("Mat4x4: %n %4.2f %4.2f %4.2f %4.2f %n %4.2f %4.2f %4.2f %4.2f %n" +
                "%4.2f %4.2f %4.2f %4.2f %n %4.2f %4.2f %4.2f %4.2f %n",
                m11, m12, m13, m14, m21, m22, m23, m24, m31, m32, m33, m34, m41, m42, m43, m44);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mat4x4 mat4x4 = (Mat4x4) o;

        if (Double.compare(mat4x4.m11, m11) != 0) return false;
        if (Double.compare(mat4x4.m12, m12) != 0) return false;
        if (Double.compare(mat4x4.m13, m13) != 0) return false;
        if (Double.compare(mat4x4.m14, m14) != 0) return false;
        if (Double.compare(mat4x4.m21, m21) != 0) return false;
        if (Double.compare(mat4x4.m22, m22) != 0) return false;
        if (Double.compare(mat4x4.m23, m23) != 0) return false;
        if (Double.compare(mat4x4.m24, m24) != 0) return false;
        if (Double.compare(mat4x4.m31, m31) != 0) return false;
        if (Double.compare(mat4x4.m32, m32) != 0) return false;
        if (Double.compare(mat4x4.m33, m33) != 0) return false;
        if (Double.compare(mat4x4.m34, m34) != 0) return false;
        if (Double.compare(mat4x4.m41, m41) != 0) return false;
        if (Double.compare(mat4x4.m42, m42) != 0) return false;
        if (Double.compare(mat4x4.m43, m43) != 0) return false;
        return Double.compare(mat4x4.m44, m44) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(m11);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m12);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m13);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m14);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m21);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m22);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m23);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m24);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m31);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m32);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m33);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m34);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m41);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m42);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m43);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(m44);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
