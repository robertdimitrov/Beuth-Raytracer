package aufgabe01;

import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import zusatz.Point2;
import zusatz.SamplingPattern;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kosmonaut
 */
public class FisheyeCamera extends Camera {

    final private double s;
    final private double psi_max;

    /**
     * Dieser Konstruktor erzeugt ein neues Camera-Objekt.
     * Die u-, v- und w-Achsen der Kamera werden im Konstruktor berechnet und
     * als öffentliche Attribute zur Verfügung gestellt.
     *
     * @param e       Die Position der Kamera
     * @param g       Die Blickrichtung der Kamera
     * @param t       Der Up-Vektor der Kamera
     * @param pattern Das Samplingpattern was die Feinheit der einzelnen Strahlen der Kamera berstimmt
     * @param s       Der Skalierungsfaktor der Bildebene
     * @param psi_max Der maximale Winkel der Kamera
     */
    public FisheyeCamera(final Point3 e, final Vector3 g, final Vector3 t, final double s, final double psi_max, final SamplingPattern pattern) {
        super(e, g, t, pattern);
        this.s = s;
        this.psi_max = psi_max;
    }

    @Override
    public Set<Ray> rayFor(final int w, final int h, final int x, final int y) {
        final HashSet<Ray> rays = new HashSet<>();


        for (final Point2 point : pattern.points) {
            final double ppx = s * (x - 0.5 * w + point.x);
            final double ppy = s * (y - 0.5 * h + point.y);

            final double aspect = w / h;
            final double xn = aspect / (s * h) * ppx;
            final double yn = aspect / (s * w) * ppy;


            final double r_squared = xn*xn + yn*yn;

            if (r_squared < 1.00001) {
                final double r = Math.sqrt(r_squared);

                double psi = Math.asin(yn/r);
                if(xn < 0) psi = Math.PI - psi;

                final double alpha = r * psi_max / 2.0;


                final double sin_psi = Math.sin(psi);
                final double cos_psi = Math.cos(psi);
                final double sin_a = Math.sin(alpha);
                final double cos_a = Math.cos(alpha);

                final Vector3 v1 = this.u.mul(sin_a * cos_psi);
                final Vector3 v2 = this.v.mul(sin_a * sin_psi);
                final Vector3 v3 = this.w.mul(-cos_a);

                final Vector3 d = v1.add(v2).add(v3);

                rays.add(new Ray(this.e, d.normalized()));
            }


        }
        return rays;
    }

}
