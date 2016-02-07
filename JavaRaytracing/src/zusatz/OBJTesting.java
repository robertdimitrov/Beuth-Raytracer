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
import beleuchtung_I.SingleColorMaterial;

public class OBJTesting {
    public static void main(String[] args) {
        JFrame frame = new JFrame("OBJ und BBox test");
        Container container = frame.getContentPane();

        Color ambient = new Color(0.25, 0.25, 0.25);
        
        // Szene 1
        ArrayList<Geometry> geometries = new ArrayList<Geometry>();

        final ShapeFromFile obj = new ShapeFromFile( new File("./obj-objects/teddy.obj.txt"), new LambertMaterial(new Color(.9, .8, .2)));
        geometries.add(new BoundingBox(obj));
//        geometries.add(obj);
        Transform transform = new Transform();
        Node node = new Node(transform, geometries);

        HashSet<Geometry> geos = new HashSet<Geometry>();
        geos.add(node);
        
        PointLight pointLight = new PointLight(Color.WHITE, new Point3(100,100,100), false);
        ArrayList<Light> lights = new ArrayList<Light>();
        lights.add(pointLight);

        World world = new World(geos, lights, Color.BLACK, ambient);

        PerspectiveCamera camera = new PerspectiveCamera(new Point3(100,100,100), new Vector3(-1, -1, -1), new Vector3(0,1,0), Math.PI/4);
        
        RTPanel panel1 = new RTPanel(camera, world);

        // Szene 2
        ArrayList<Geometry> geometries2 = new ArrayList<Geometry>();

        final ShapeFromFile obj2 = new ShapeFromFile( new File("./obj-objects/Stanford_Bunny.obj"), new LambertMaterial(new Color(.9, .8, .2)));
//TODO
//        geometries2.add(new BoundingBox(obj2));
        geometries2.add(obj2);
        Transform transform2 = new Transform();
        Node node2 = new Node(transform2, geometries2);

        HashSet<Geometry> geos2 = new HashSet<Geometry>();
        geos2.add(node2);
        
        World world2 = new World(geos2, lights, Color.BLACK, ambient);
        
        RTPanel panel2 = new RTPanel(new PerspectiveCamera(new Point3(.5,.5,.5), new Vector3(-1, -1, -1), new Vector3(0,1,0), Math.PI/4), world2);

        JTabbedPane pane = new JTabbedPane();
//        pane.addTab("Szene 1", panel1);
        pane.addTab("Szene 2", panel2);


        container.add(pane);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);


    }

}
