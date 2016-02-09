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

/**
 * Created by Robert on 2/8/16.
 */
public class FisheyeTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fisheye Projection");
        Container container = frame.getContentPane();

        HashSet<Geometry> geometries = new HashSet<>();
        AxisAlignedBox box = new AxisAlignedBox(new LambertMaterial(Color.GREEN));
        Sphere sphere = new Sphere(new PhongMaterial(Color.RED, Color.WHITE, 16));
        Transform transform = new Transform();


        Plane plane = new Plane(new LambertMaterial(Color.YELLOW));

        geometries.add(box);
//        geometries.add(sphere);
//        geometries.add(plane);

        PointLight pointLight = new PointLight(Color.WHITE, new Point3(0,0,5), true);
        ArrayList<Light> lights = new ArrayList<Light>();
        lights.add(pointLight);

        World world = new World(geometries, lights, Color.BLACK, new Color(0.5,0.5,0.5));

        Camera camera = new FisheyeCamera(new Point3(1.5,1.5,1.5), new Vector3(-1, -1, -1), new Vector3(0,1,0), 3, Math.PI, new DiagonalSamplingPattern(10));
        RTPanel panel = new RTPanel(camera, world);

        Camera camera2 = new PerspectiveCamera(new Point3(1.5,1.5,1.5), new Vector3(-1, -1, -1), new Vector3(0,1,0), Math.PI/4, new DiagonalSamplingPattern(10));
        RTPanel panel2 = new RTPanel(camera2, world);
		
        JTabbedPane pane = new JTabbedPane();
		pane.addTab("Fish", panel);
		pane.addTab("Persp", panel2);

        container.add(pane);
        


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setResizable(false);
        frame.setVisible(true);

    }


}
