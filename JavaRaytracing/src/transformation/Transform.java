package transformation;

import aufgabe01.Ray;
import b_vorbereitung.Mat4x4;
import b_vorbereitung.Normal3;
import b_vorbereitung.Vector3;

/**
 * @author Kosmonaut
 */
public class Transform {

    public final Mat4x4 m;
    public final Mat4x4 i;

    public Transform() {
        m = Mat4x4.EINHEITSMATRIX;
        i = Mat4x4.EINHEITSMATRIX;
    }

    private Transform(Mat4x4 m, Mat4x4 i) {
        this.m = m;
        this.i = i;
    }

    public Transform translation(Vector3 t){
        Mat4x4 translation = new Mat4x4
                (1,0,0,t.x,
                 0,1,0,t.y,
                 0,0,1,t.z,
                 0,0,0,1);
        Mat4x4 inverse = new Mat4x4
                (1,0,0,-t.x,
                 0,1,0,-t.y,
                 0,0,1,-t.z,
                 0,0,0,1);
        return new Transform(m.mul(translation), inverse.mul(i));
    }

    public Transform scale(Vector3 s){
        Mat4x4 scale = new Mat4x4
                (s.x,0,   0,   0,
                 0,  s.y, 0,   0,
                 0,  0,   s.z, 0,
                 0,  0,   0,   1);
        Mat4x4 inverse = new Mat4x4
                (1/s.x, 0,      0,     0,
                 0,     1/s.y,  0,     0,
                 0,     0,      1/s.z, 0,
                 0,     0,      0,     1);
        return new Transform(m.mul(scale), inverse.mul(i));
    }

    public Transform rotateX(double a){
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);

        Mat4x4 rotateX = new Mat4x4(1,0,0,0,0,cosA,-sinA,0,0,sinA,cosA,0,0,0,0,1);
        Mat4x4 inverse = new Mat4x4(1,0,0,0,0,cosA,sinA,0,0,-sinA,cosA,0,0,0,0,1);

        return new Transform(m.mul(rotateX), inverse.mul(i));
    }

    public Transform rotateY(double a){
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);

        Mat4x4 rotateY = new Mat4x4(cosA,0,sinA,0,0,1,0,0,-sinA,0,cosA,0,0,0,0,1);
        Mat4x4 inverse = new Mat4x4(cosA,0,-sinA,0,0,1,0,0,sinA,0,cosA,0,0,0,0,1);

        return new Transform(m.mul(rotateY), inverse.mul(i));
    }

    public Transform rotateZ(double a){
        double cosA = Math.cos(a);
        double sinA = Math.sin(a);

        Mat4x4 rotateZ = new Mat4x4(cosA,-sinA,0,0,sinA,cosA,0,0,0,0,1,0,0,0,0,1);
        Mat4x4 inverse = new Mat4x4(cosA,sinA,0,0,-sinA,cosA,0,0,0,0,1,0,0,0,0,1);

        return new Transform(m.mul(rotateZ), inverse.mul(i));
    }

    public Ray mul(Ray ray){
        return new Ray(i.mul(ray.o), i.mul(ray.d));
    }

    public Normal3 mul(Normal3 n){
        return i.transpose().mul(new Vector3(n.x, n.y, n.z)).normalized().asNormal();
    }
}