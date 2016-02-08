package zusatz;

import aufgabe01.Camera;
import aufgabe01.Ray;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.PointLight;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robert on 2/8/16.
 */
public class DOFCamera extends Camera {

    final private double lensRadius;
    final private double d;
    final private double f;


    public DOFCamera(Point3 e, Vector3 g, Vector3 t, double lensRadius, double d, double f, SamplingPattern pattern) {
        super(e, g, t, pattern);
        this.lensRadius = lensRadius;
        this.d = d;
        this.f = f;
    }

//    @Override
//    public Set<Ray> rayFor(int w, int h, int x, int y) {
//        Set<Ray> rays = new HashSet<>();
//
//        int i = 0;
//        for(Point2 point : pattern.points){
//            double ppx = x - w / 2.0 + point.x;
//            double ppy = y - h / 2.0 + point.y;
//            Point2 pp = new Point2(ppx, ppy);
//
//            Point2 dp = pattern.asDisc()[i];
//            Point2 lp = new Point2(dp.x * lensRadius, dp.y * lensRadius);
//
//            double nx = pp.x * f / d;
//            double ny = pp.y * f / d;
//            Point2 p = new Point2(nx, ny);
//
//            Vector3 v1 = this.u.mul(p.x - lp.x);
//            Vector3 v2 = this.v.mul(p.y - lp.y);
//            Vector3 v3 = this.w.mul(-f);
//
//            Vector3 dir = v1.add(v2).add(v3);
//
//            Vector3 e1 = this.u.mul(lp.x).add(this.v.mul(lp.y));
//
//            Point3 o = this.e.add(e1);
//
//            rays.add(new Ray(o,dir.normalized()));
//
//        }
//
//
//        return rays;
//    }


//    @Override
//    public Set<Ray> rayFor(int w, int h, int x, int y) {
//        Set<Ray> rays = new HashSet<>();
//        double d1 = h/2/Math.tan(Math.PI/4);
//        double d2 = (w-1)/2;
//        double d3 = (h-1)/2;
//
//
//        for(Point2 point : pattern.points){
//            double px = x - d2 + point.x;
//            double py = y - d3 + point.y;
//
//            double fx = px * f / d1;
//            double fy = py * f / d1;
//
//            Point3 fp = this.e.add(this.w.mul(-f)).add(this.v.mul(fy)).add(this.u.mul(fx));
//
//            for(Point2 lp : pattern.asDisc()){
//                Point3 o = this.e.add(this.u.mul(lp.x*lensRadius)).add(this.v.mul(lp.y*lensRadius));
//                Vector3 dir = fp.sub(o).normalized();
//                rays.add(new Ray(o, dir));
////                break;
//            }
//
//
//        }
//
//        return rays;
//    }

        @Override
    public Set<Ray> rayFor(int w, int h, int x, int y) {
        Set<Ray> rays = new HashSet<>();

        int i = 0;
        for(Point2 point : pattern.points){
            double ppx = x - w / 2.0 + point.x;
            double ppy = y - h / 2.0 + point.y;
            Point2 pp = new Point2(ppx, ppy);

            for(Point2 dp : pattern.asDisc()) {
                Point2 lp = new Point2(dp.x * lensRadius, dp.y * lensRadius);

                double nx = pp.x * f / d;
                double ny = pp.y * f / d;
                Point2 p = new Point2(nx, ny);

                Vector3 v1 = this.u.mul(p.x - lp.x);
                Vector3 v2 = this.v.mul(p.y - lp.y);
                Vector3 v3 = this.w.mul(-f);

                Vector3 dir = v1.add(v2).add(v3);

                Vector3 e1 = this.u.mul(lp.x).add(this.v.mul(lp.y));

                Point3 o = this.e.add(e1);

                rays.add(new Ray(o, dir.normalized()));
            }

        }


        return rays;
    }

}
