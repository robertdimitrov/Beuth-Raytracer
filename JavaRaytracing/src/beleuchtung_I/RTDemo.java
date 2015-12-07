package beleuchtung_I;

import aufgabe01.*;
import aufgabe01.Color;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kosmonaut
 */
public class RTDemo {

    public static void main(String[] args) {

        // Geometrien
        Plane plane = new Plane(new Point3(0,0,0), new Normal3(0,1,0), new SingleColorMaterial(new Color(1,0,0)));
        Sphere sphere = new Sphere(new Point3(1,1,1), 0.5, new SingleColorMaterial(new Color(0,1,0)));
        AxisAlignedBox box = new AxisAlignedBox(new Point3(-1.5, 0.5, 0.5), new Point3(-0.5, 1.5, 1.5),
                new SingleColorMaterial(new Color(0,0,1)));
        Triangle triangle = new Triangle(new Point3(0,0,-1), new Point3(1,0,-1), new Point3(1,1,-1),
                new Normal3(1,0,0), new Normal3(0,1,0), new Normal3(0,0,1), new SingleColorMaterial(new Color(1,1,0)));
        PerspectiveCamera camera = new PerspectiveCamera(new Point3(4,4,4), new Vector3(-1,-1,-1), new Vector3(0,1,0), 45);

        Set<Geometry> geometries = new HashSet<>();
        geometries.add(plane);
        geometries.add(sphere);
        geometries.add(box);
        geometries.add(triangle);

        ArrayList<Light> lights = new ArrayList<Light>();


        // Panel 1
        World world = new World(geometries, lights, new Color(1,1,1), new Color(0,0,0));
        RTPanel panel1 = new RTPanel(camera, world);

        // Panel 2
        geometries.forEach(RTDemo::changeMaterialToLambert);
        PointLight pointLight = new PointLight(new Color(1,1,1), new Point3(4,4,4));
        lights.add(pointLight);
        RTPanel panel2 = new RTPanel(camera, new World(geometries, lights, new Color(1,1,1), new Color(0,0,0)));

        // Panel 3
        geometries.forEach(RTDemo::changeMaterialToPhong);
        RTPanel panel3 = new RTPanel(camera, new World(geometries, lights, new Color(1,1,1), new Color(0,0,0)));

        // Panel 4
        DirectionalLight directionalLight = new DirectionalLight(new Color(1,1,1), new Vector3(-1, -1, -1).normalized());
        lights.remove(pointLight);
        lights.add(directionalLight);
        RTPanel panel4 = new RTPanel(camera, new World(geometries, lights, new Color(1,1,1), new Color(0, 0, 0)));

        // Panel 5
        SpotLight spotLight = new SpotLight(new Color(1,1,1), new Point3(4,4,4), new Vector3(-1,-1,-1), Math.PI/14);
        lights.remove(directionalLight);
        lights.add(spotLight);
        RTPanel panel5 = new RTPanel(camera, new World(geometries, lights, new Color(1,1,1), new Color(0, 0, 0)));

        // Panel 6
        RTPanel panel6 = new RTPanel(camera, new World(geometries, lights, new Color(1,1,1), new Color(0.25, 0.25, 0.25)));

        // Panel 7 (eigene Szene)
        Sphere sphere2 = new Sphere(new Point3(-4,1,1), 0.5, new PhongMaterial(new Color(0.4,0.8,0.72), new Color(1,1,1), 16));
        Plane plane2 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), new LambertMaterial(new Color(0,0.35,0.25)));
        Triangle triangle2 = new Triangle(new Point3(-1,0,-1), new Point3(3,0,-1), new Point3(1,4,-1),
                new Normal3(1,0,0), new Normal3(0,1,0), new Normal3(0,0,1), new PhongMaterial(new Color(0.5,0.2,0.3), new Color(1,1,1), 16));
        AxisAlignedBox box2 = new AxisAlignedBox(new Point3(-1.0, 0.5, 0.5), new Point3(0, 1.5, 1.5),
                new PhongMaterial(new Color(0.15,0.4,0.61), new Color(0,0,0), 16));
        Set<Geometry> geometries2 = new HashSet<Geometry>();
        geometries2.add(sphere2);
        geometries2.add(plane2);
        geometries2.add(triangle2);
        geometries2.add(box2);
        ArrayList<Light> lights2 = new ArrayList<Light>();
        lights2.add(directionalLight);
        lights2.add(spotLight);
        World welt = new World(geometries2, lights2, new Color(1,1,1), new Color(0.2, 0.2, 0.2));
        RTPanel panel7 = new RTPanel(camera, welt);

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("Abb.3", panel1);
        pane.addTab("Abb.4", panel2);
        pane.addTab("Abb.5", panel3);
        pane.addTab("Abb.6", panel4);
        pane.addTab("Abb.7", panel5);
        pane.addTab("Abb.8", panel6);
        pane.addTab("Eig. Szene", panel7);

        JFrame frame = new JFrame("Aufgabe 3");
        Container container = frame.getContentPane();
        container.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void changeMaterialToLambert(Geometry g){
        SingleColorMaterial m = (SingleColorMaterial) g.material;
        Color c = m.color;
        g.material = new LambertMaterial(c);
    }

    public static void changeMaterialToPhong(Geometry g){
        LambertMaterial m = (LambertMaterial) g.material;
        Color c = m.color;
        g.material = new PhongMaterial(c, new Color(1,1,1), 64);
    }
}
