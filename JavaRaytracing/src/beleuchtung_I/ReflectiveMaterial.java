package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

/**
 * Created by Robert on 12/8/15.
 */
public class ReflectiveMaterial extends Material {

    public Color diffuse;
    public Color specular;
    public Color reflection;
    public int exponent;

    public ReflectiveMaterial(Color diffuse, Color specular, int exponent, Color reflection) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.reflection = reflection;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(Hit hit, World world) {
        return Color.GREEN;
    }
}
