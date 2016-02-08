package beleuchtung_I;

import aufgabe01.*;
import aufgabe01.Color;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import transformation.Transform;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kosmonaut
 */
public class RTDemo_2 {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Aufgabe 4");
        Container container = frame.getContentPane();


        // Szene 1
        Color reflective = new Color(0.5, 0.5, 0.5);
        Color ambient = new Color(0.25, 0.25, 0.25);
        int exponent = 64;
        ArrayList<Geometry> geometries = new ArrayList<Geometry>();

        Plane plane = new Plane(
                new ReflectiveMaterial(new Color(0.1, 0.1, 0.1), Color.BLACK, exponent, reflective));
        geometries.add(plane);
        Plane plane2 = new Plane(
                new ReflectiveMaterial(new Color(0.1, 0.1, 0.1), Color.BLACK, exponent, reflective));
        geometries.add(plane2);
        Sphere sphere = new Sphere(new Point3(-3, 1, 0), 1,
                new ReflectiveMaterial(Color.RED, Color.WHITE, exponent, reflective));
        geometries.add(sphere);
        Sphere sphere2 = new Sphere(new Point3(0,1,0), 1,
                new ReflectiveMaterial(Color.GREEN, Color.WHITE, exponent, reflective));
        geometries.add(sphere2);
        Sphere sphere3 = new Sphere(new Point3(3,1,0), 1,
                new ReflectiveMaterial(Color.BLUE, Color.WHITE, exponent, reflective));
        geometries.add(sphere3);

        Transform transform = new Transform();
//        transform = transform.scale(new Vector3(4,4,4));
        Node node = new Node(transform, geometries);

        HashSet<Geometry> geos = new HashSet<Geometry>();
        geos.add(node);
        
        PointLight pointLight = new PointLight(Color.WHITE, new Point3(8,8,8), true);
        ArrayList<Light> lights = new ArrayList<Light>();
        lights.add(pointLight);

        World world = new World(geos, lights, Color.BLACK, ambient);

        PerspectiveCamera camera = new PerspectiveCamera(new Point3(8,8,8), new Vector3(-1, -1, -1), new Vector3(0,1,0), Math.PI/4);
        
        RTPanel panel1 = new RTPanel(camera, world);

        // Szene 2
//        Plane plane2 = new Plane(new Point3(0,0,0), new Normal3(0,1,0), new LambertMaterial(new Color(0.8, 0.8, 0.8)));
//        AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5, 0, -0.5), new Point3(0.5, 1, 0.5), new LambertMaterial(Color.RED));
//        Set<Geometry> geometries2 = new HashSet<Geometry>();
//        geometries2.add(box);
//        geometries2.add(plane2);
//        PointLight plight = new PointLight(Color.WHITE, new Point3(8,8,0), true);
//        ArrayList<Light> lights2 = new ArrayList<>();
//        lights2.add(plight);
//        World welt2 = new World(geometries2, lights2, Color.BLACK, ambient);
//        RTPanel panel2 = new RTPanel(camera, welt2);


        JTabbedPane pane = new JTabbedPane();
        pane.addTab("Szene 1", panel1);
//        pane.addTab("Szene 2", panel2);


        container.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);


    }
}
