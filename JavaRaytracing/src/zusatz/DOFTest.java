package zusatz;

import aufgabe01.*;
import aufgabe01.Color;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.LambertMaterial;
import beleuchtung_I.Light;
import beleuchtung_I.PointLight;
import beleuchtung_I.RTPanel;
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
        Sphere sphere1 = new Sphere(new LambertMaterial(Color.RED));
        Sphere sphere2 = new Sphere(new LambertMaterial(Color.GREEN));
        Sphere sphere3 = new Sphere(new LambertMaterial(Color.BLUE));


        Transform transform1 = new Transform();
        transform1 = transform1.translation(new Vector3(-2,0,4));
        Node node1 = new Node(transform1, new ArrayList<Geometry>(){{
            this.add(sphere1);}
        });

        Transform transform3 = new Transform();
        transform3 = transform3.translation(new Vector3(2.5,0,-4));
        Node node3 = new Node(transform3, new ArrayList<Geometry>(){{
            this.add(sphere3);}
        });



        HashSet<Geometry> geometries = new HashSet<Geometry>(){{
//            add(plane);
            add(node1);
            add(sphere2);
            add(node3);
        }
        };



        double x = 0;
        double y = 0;
        double z = 20;
        Camera camera = new PerspectiveCamera(new Point3(x, y, z),
                new Vector3(-x, -y, -z), new Vector3(0, 1, 0), Math.PI / 4);

        camera = new DOFCamera(new Point3(x, y, z),
                new Vector3(-x, -y, -z), new Vector3(0, 1, 0), new DiagonalSamplingPattern(10), 1.0, 3, 4);

        ArrayList<Light> lights = new ArrayList<Light>();
        PointLight pointLight = new PointLight(Color.WHITE,
                new Point3(0, 0, 10), false);
        lights.add(pointLight);

        World world = new World(geometries, lights, Color.BLACK, Color.WHITE);
        RTPanel panel1 = new RTPanel(camera, world);


        container.add(panel1);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
