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
        return null;
    }

    public Transform scale(Vector3 s){
        return null;
    }

    public Transform rotateX(double a){
        return null;
    }

    public Transform rotateY(double a){
        return null;
    }

    public Transform rotateZ(double a){
        return null;
    }

    public Ray mul(Ray ray){
        return null;
    }

    public Normal3 mul(Normal3 n){
        return null;
    }
}