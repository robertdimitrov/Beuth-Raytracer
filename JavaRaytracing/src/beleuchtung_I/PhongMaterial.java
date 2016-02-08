package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

/**
 * Diese Klasse stellt das Material für einen perfekt
 * diffus reflektierenden Körper mit einem Glanzpunkt dar.
 * @author Kosmonaut
 */
public class PhongMaterial extends Material {

    public final Color difuse;
    public final Color spectacular;
    public final int exponent;

    public PhongMaterial(final Color difuse, final Color spectacular,final int exponent) {
        if (difuse == null) {
            throw new IllegalArgumentException("Die dem PhongMaterial übergebene Color difuse darf nicht null sein");
        }
        if (spectacular == null) {
            throw new IllegalArgumentException("Die dem PhongMaterial übergebene Color spectacular darf nicht null sein");
        }
        this.difuse = difuse;
        this.spectacular = spectacular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(Hit hit, World world, Tracer tracer) {

        Color withLightsColor = difuse.mul(world.ambientLight);
        final Point3 point = hit.ray.at(hit.t);
        final Normal3 n = hit.n;
        final Vector3 e = hit.ray.d.mul(-1).normalized();

        for (Light light : world.lights) {
            if (light.illuminates(point,world)) {
                final Vector3 l = light.directionFrom(point);
                final Vector3 rl = l.reflectedOn(n);
                final double alpha = l.dot(n);
                final double betha = e.dot(rl);
                withLightsColor = withLightsColor.add(difuse.mul(light.color).mul(Double.max(0.0, alpha)));
                withLightsColor = withLightsColor.add(spectacular.mul(light.color).mul(Math.pow(Double.max(0.0, betha), exponent)));
            }
        }
        return withLightsColor;
    }

}
