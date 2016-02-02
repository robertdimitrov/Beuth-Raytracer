package aufgabe01;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import transformation.Transform;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.Light;
import beleuchtung_I.PointLight;
import beleuchtung_I.RTPanel;
import beleuchtung_I.SingleColorMaterial;;

public class Aufgabe01Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Aufgabe 4");
		Container container = frame.getContentPane();

		// Szene 1
		Set<Geometry> geometries = new HashSet<Geometry>();

		final List<Geometry> geomList1 = new ArrayList<Geometry>();

		final Sphere sphere = new Sphere(new SingleColorMaterial(Color.RED));
		geomList1.add(sphere);
		
		Transform transformationL = new Transform().translation(new Vector3(-1.5, 0, -2));
		Transform transformationR = new Transform().translation(new Vector3(1.5, 0, 2));
		final Node l = new Node(transformationL, geomList1);
		final Node r = new Node(transformationR, geomList1);
		geometries.add(l);
		geometries.add(r);

		double x = 0;
		double y = 0;
		double z = 10;
		PerspectiveCamera camera = new PerspectiveCamera(new Point3(x, y, z),
				new Vector3(-x, -y, -z), new Vector3(0, 1, 0), Math.PI / 4);

		ArrayList<Light> lights = new ArrayList<Light>();
		PointLight pointLight = new PointLight(Color.WHITE,
				new Point3(0, 0, 10), false);
		lights.add(pointLight);

		World world = new World(geometries, lights, Color.BLACK, new Color(.3, .3, .3));
		RTPanel panel1 = new RTPanel(camera, world);

		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Szene 1", panel1);

		container.add(pane);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
