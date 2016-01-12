package transformation;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import aufgabe01.AxisAlignedBox;
import aufgabe01.Color;
import aufgabe01.Geometry;
import aufgabe01.Node;
import aufgabe01.PerspectiveCamera;
import aufgabe01.Sphere;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.LambertMaterial;
import beleuchtung_I.Light;
import beleuchtung_I.PointLight;
import beleuchtung_I.RTPanel;

public class RTDemo3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aufgabe 4");
        Container container = frame.getContentPane();


        // Szene 1
        Color reflective = new Color(0.5, 0.5, 0.5);
        Color ambient = new Color(0.5, 0.5, 0.5);
        
        final List<Geometry> geomList1 = new ArrayList<Geometry>();
//        final Sphere diskSphere = new Sphere(new LambertMaterial(new Color(1, 0, 0)));
//        geomList1.add(diskSphere);
        
        final AxisAlignedBox aab = new AxisAlignedBox(new LambertMaterial(Color.YELLOW));
        geomList1.add(aab);
        
        
        final Transform transformation1 = new Transform();
//        transformation1.rotateZ(-Math.PI/4);
//        transformation1.rotateY(-Math.PI/4);
//        transformation1.scale(new Vector3(4, 1/8, 4));
        
        final Node rootNode1 = new Node(transformation1 ,geomList1);
        Set<Geometry> geometries = new HashSet<Geometry>();
        geometries.add(rootNode1);
        
        PerspectiveCamera camera = new PerspectiveCamera(new Point3(0,10,5), new Vector3(0, 0-1, -1), new Vector3(0,1,0), Math.PI/4);
        ArrayList<Light> lights = new ArrayList<Light>();
        PointLight pointLight = new PointLight(Color.WHITE, new Point3(8,8,0), true);
        lights.add(pointLight);
        World world = new World(geometries, lights, Color.BLACK, ambient);
        RTPanel panel1 = new RTPanel(camera, world);

        // Szene 2
//        AxisAlignedBox box = new AxisAlignedBox(new LambertMaterial(new Color(0, 1, 1)));
//        Set<Geometry> geometries2 = new HashSet<Geometry>();
//        geometries2.add(rootNode2);
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
