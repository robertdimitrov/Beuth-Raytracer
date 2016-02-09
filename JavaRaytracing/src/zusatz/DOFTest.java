package zusatz;

import aufgabe01.*;
import aufgabe01.Color;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.*;
import transformation.Transform;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Kosmonaut
 */
public class DOFTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Depth of Field");
        Container container = frame.getContentPane();

        Plane plane = new Plane(new LambertMaterial(Color.WHITE));
        Sphere sphere1 = new Sphere(new PhongMaterial(Color.RED, Color.WHITE, 64));
        Sphere sphere2 = new Sphere(new PhongMaterial(Color.GREEN, Color.WHITE, 64));
        Sphere sphere3 = new Sphere(new PhongMaterial(Color.BLUE, Color.WHITE, 64));

        double s = 3;

        Transform transform1 = new Transform();
        transform1 = transform1.translation(new Vector3(-3,0,12)).scale(new Vector3(s,s,s));
        Node node1 = new Node(transform1, new ArrayList<Geometry>(){{
            this.add(sphere1);}
        });

        Transform transform2 = new Transform();
        transform2 = transform2.scale(new Vector3(s,s,s));
        Node node2 = new Node(transform2, new ArrayList<Geometry>(){{
            this.add(sphere2);}
        });

        Transform transform3 = new Transform();
        transform3 = transform3.translation(new Vector3(15,0,-60)).scale(new Vector3(s,s,s));
        Node node3 = new Node(transform3, new ArrayList<Geometry>(){{
            this.add(sphere3);}
        });



        HashSet<Geometry> geometries = new HashSet<Geometry>(){{
//            add(plane);
            add(node1);
            add(node2);
            add(node3);
        }
        };



        double x = 0;
        double y = 0;
        double z = 20;
        Camera camera = new PerspectiveCamera(new Point3(x, y, z),
                new Vector3(-x, -y, -z), new Vector3(0, 1, 0), Math.PI / 4);

        camera = new DOFCamera(new Point3(x, y, z),
                new Vector3(-x, -y, -z), new Vector3(0, 1, 0), 0.5, 50, 5, new DiagonalSamplingPattern(10));

        ArrayList<Light> lights = new ArrayList<Light>();
        PointLight pointLight = new PointLight(Color.WHITE,
                new Point3(0, 0, 20), true);
        lights.add(pointLight);

        World world = new World(geometries, lights, Color.BLACK, new Color(0.6, 0.6, 0.6));
        RTPanel panel1 = new RTPanel(camera, world);


        container.add(panel1);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
