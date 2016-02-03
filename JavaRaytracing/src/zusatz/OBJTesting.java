package zusatz;

import java.awt.Container;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import transformation.Transform;
import aufgabe01.Color;
import aufgabe01.Geometry;
import aufgabe01.Node;
import aufgabe01.PerspectiveCamera;
import aufgabe01.Plane;
import aufgabe01.Sphere;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.LambertMaterial;
import beleuchtung_I.Light;
import beleuchtung_I.PointLight;
import beleuchtung_I.RTPanel;
import beleuchtung_I.ReflectiveMaterial;

public class OBJTesting {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aufgabe 4");
        Container container = frame.getContentPane();


        // Szene 1
        Color ambient = new Color(0.25, 0.25, 0.25);
        ArrayList<Geometry> geometries = new ArrayList<Geometry>();

        final Geometry obj = new ShapeFromFile( new File("./obj-objects/teddy.obj.txt"), new LambertMaterial(new Color(.9, .8, .2)));
        geometries.add(obj);
        Transform transform = new Transform();
        Node node = new Node(transform, geometries);

        HashSet<Geometry> geos = new HashSet<Geometry>();
        geos.add(node);
        
        PointLight pointLight = new PointLight(Color.WHITE, new Point3(8,8,8), false);
        ArrayList<Light> lights = new ArrayList<Light>();
        lights.add(pointLight);

        World world = new World(geos, lights, Color.BLACK, ambient);

        PerspectiveCamera camera = new PerspectiveCamera(new Point3(0,0,50), new Vector3(0, 0, -1), new Vector3(0,1,0), Math.PI/4);
        
        RTPanel panel1 = new RTPanel(camera, world);

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("Szene 1", panel1);


        container.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);


    }

}
