package aufgabe01;

import beleuchtung_I.Material;
import transformation.Transform;

import java.util.List;

/**
 * @author Kosmonaut
 */
public class Node extends Geometry {

    private final Transform transform;
    private final List<Geometry> geometries;

    public Node(Material material, Transform transform, List<Geometry> geometries) {
        super(material);
        this.transform = transform;
        this.geometries = geometries;
    }

    @Override
    public Hit hit(Ray r) {
        return null;
    }
}
