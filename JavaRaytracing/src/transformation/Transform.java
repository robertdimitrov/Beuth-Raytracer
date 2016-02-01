package transformation;

import aufgabe01.Ray;
import b_vorbereitung.Mat4x4;
import b_vorbereitung.Normal3;
import b_vorbereitung.Vector3;

/**
 *
 * @author Kosmonaut
 */
public class Transform {

    /**
     * Transformationsmatrix
     */
    public final Mat4x4 m;
    /**
     * Inverse der Transformationsmatrix
     */
    public final Mat4x4 i;

    /**
     * Erstellt ein neues Transform-Objekt mit Einheitsmatrizen für m und i
     */
    public Transform() {
        m = Mat4x4.EINHEITSMATRIX;
        i = Mat4x4.EINHEITSMATRIX;
    }

    /**
     * Erstellt ein neues Transform-Objekt
     * @param m die Transformationsmatrix
     * @param i die Inverse der Transformationsmatrix
     */
    private Transform(Mat4x4 m, Mat4x4 i) {
        if(m==null) throw new IllegalArgumentException("m darf nicht null sein");
        if(i==null) throw new IllegalArgumentException("i darf nicht null sein");
        this.m = m;
        this.i = i;
    }

    /**
     * Translation um einen Vektor
     * @param t der Vektor
     * @return das entsprechende Transform-Objekt
     */
    public Transform translation(Vector3 t){
        if(t==null) throw new IllegalArgumentException("t darf nicht null sein");
        Mat4x4 translation = new Mat4x4
                (1.0,0,0,t.x,
                 0,1.0,0,t.y,
                 0,0,1.0,t.z,
                 0,0,0,1.0);
        Mat4x4 inverse = new Mat4x4
                (1.0,0,0,-t.x,
                 0,1.0,0,-t.y,
                 0,0,1.0,-t.z,
                 0,0,0,1.0);
//        return new Transform(m.mul(translation), i.mul(inverse));
        return new Transform(m.mul(translation), inverse.mul(i));
    }

    /**
     * Skalierung um einen Vektor
     * @param s der Vektor
     * @return das entsprechende Transform-Objekt
     */
    public Transform scale(Vector3 s){
        if(s==null) throw new IllegalArgumentException("s darf nicht null sein");
        if(s.x==0 || s.y==0 || s.z==0) throw new IllegalArgumentException("Es darf nicht um 0 skaliert werden");
        Mat4x4 scale = new Mat4x4
                (s.x,0,   0,   0,
                 0,  s.y, 0,   0,
                 0,  0,   s.z, 0,
                 0,  0,   0,   1.0);
        Mat4x4 inverse = new Mat4x4
                (1.0/s.x, 0,      0,     0,
                 0,     1.0/s.y,  0,     0,
                 0,     0,      1.0/s.z, 0,
                 0,     0,      0,     1.0);
//        return new Transform(m.mul(scale), i.mul(inverse));
        return new Transform(m.mul(scale), inverse.mul(i));
    }

    /**
     * Rotation um die x-Achse
     * @param a der Winkel
     * @return das entsprechende Transform-Objekt
     */
    public Transform rotateX(double a){
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);

        Mat4x4 rotateX = new Mat4x4(1.0,0,0,0,0,cosA,-sinA,0,0,sinA,cosA,0,0,0,0,1.0);
        Mat4x4 inverse = new Mat4x4(1.0,0,0,0,0,cosA,sinA,0,0,-sinA,cosA,0,0,0,0,1.0);

//        return new Transform(m.mul(rotateX), i.mul(inverse));
        return new Transform(m.mul(rotateX), inverse.mul(i));
    }

    /**
     * Rotation um die y-Achse
     * @param a der Winkel
     * @return das entsprechende Transform-Objekt
     */
    public Transform rotateY(double a){
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);

        Mat4x4 rotateY = new Mat4x4(cosA,0,sinA,0,0,1.0,0,0,-sinA,0,cosA,0,0,0,0,1.0);
        Mat4x4 inverse = new Mat4x4(cosA,0,-sinA,0,0,1.0,0,0,sinA,0,cosA,0,0,0,0,1.0);

//        return new Transform(m.mul(rotateY), i.mul(inverse));
        return new Transform(m.mul(rotateY), inverse.mul(i));
    }

    /**
     * Rotation um die z-Achse
     * @param a der Winkel
     * @return das entsprechende Transform-Objekt
     */
    public Transform rotateZ(double a){
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);

        Mat4x4 rotateZ = new Mat4x4(cosA,-sinA,0,0,sinA,cosA,0,0,0,0,1.0,0,0,0,0,1.0);
        Mat4x4 inverse = new Mat4x4(cosA,sinA,0,0,-sinA,cosA,0,0,0,0,1.0,0,0,0,0,1.0);

//        return new Transform(m.mul(rotateZ), i.mul(inverse));
        return new Transform(m.mul(rotateZ), inverse.mul(i));
    }

    /**
     * Multipliziert die Inverse der Transformationsmatrix mit einem Strahl
     * @param ray der Strahl
     * @return der neue Strahl
     */
    public Ray mul(Ray ray){
        if(ray==null) throw new IllegalArgumentException("ray darf nicht null sein");
        return new Ray(i.mul(ray.o), i.mul(ray.d));
    }

    /**
     * Multipliziert die Inverse der Transformationsmatrix mit einer Normale
     * @param normal
     * @return
     */
    public Normal3 mul(final Normal3 normal) {
        return (i.transpose().mul(new Vector3(normal.x, normal.y, normal.z))).normalized().asNormal();
    }
}

