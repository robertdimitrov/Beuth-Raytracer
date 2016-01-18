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
import aufgabe01.Plane;
import aufgabe01.Sphere;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.*;

public class RTDemo3 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Aufgabe 4");
		Container container = frame.getContentPane();

		// Szene 1
		Color reflective = new Color(0.5, 0.5, 0.5);
		Color ambient = new Color(0.25, 0.25, 0.25);
		Set<Geometry> geometries = new HashSet<Geometry>();

		final List<Geometry> geomList1 = new ArrayList<Geometry>();

		final List<Geometry> geomList2 = new ArrayList<Geometry>();
		final Sphere sphere = new Sphere(
				new LambertMaterial(new Color(1, 0, 0)));
		geomList2.add(sphere);
		final List<Geometry> geom3 = new ArrayList<Geometry>();
		geom3.add(sphere);
		final Node n11 = new Node(new Transform().translation(new Vector3(2, 2,
				2)), geom3);
		final Node n12 = new Node(new Transform().translation(new Vector3(2, 2,
				-2)), geom3);
		final Node n13 = new Node(new Transform().translation(new Vector3(2,
				-2, 2)), geom3);
		final Node n14 = new Node(new Transform().translation(new Vector3(2,
				-2, -2)), geom3);
		final Node n15 = new Node(new Transform().translation(new Vector3(-2,
				2, 2)), geom3);
		final Node n16 = new Node(new Transform().translation(new Vector3(-2,
				2, -2)), geom3);
		final Node n17 = new Node(new Transform().translation(new Vector3(-2,
				-2, 2)), geom3);
		final Node n18 = new Node(new Transform().translation(new Vector3(-2,
				-2, -2)), geom3);
		geomList2.add(n11);
		geomList2.add(n12);
		geomList2.add(n13);
		geomList2.add(n14);
		geomList2.add(n15);
		geomList2.add(n16);
		geomList2.add(n17);
		geomList2.add(n18);
		// Transform transformation2 = new Transform().translation(new
		// Vector3(0, 1, 0));
		Transform transformationBig = new Transform().scale(new Vector3(.2, .2,
				.2));
		final Node tests = new Node(transformationBig, geomList2);
		// geometries.add(tests);

		final Sphere sphere2 = new Sphere(new PhongMaterial(Color.RED, reflective, 4));
		geomList1.add(sphere2);

		// final AxisAlignedBox aab = new AxisAlignedBox(
		// new ReflectiveMaterial(Color.YELLOW, Color.BLACK, 64, reflective));
		// geomList1.add(aab);

		// final Plane plane = new Plane(new LambertMaterial(Color.GREEN));
		// geomList1.add(plane);

		// final Triangle tri = new Triangle(new Point3(0, 0, 0), new Point3(.5,
		// 0.2, 0.3), new Point3(1, .4, 3), new Normal3(0, 1, 0),
		// new Normal3(0, 0, 1), new Normal3(1, 0, 0),
		// new SingleColorMaterial(Color.RED));

		Transform transformation1 = new Transform();
//		transformation1 = transformation1.scale(new Vector3(1.0, 1.0, 2.0));
		 transformation1 = transformation1.rotateY(-Math.PI / 4);
		 transformation1 = transformation1.rotateZ(-Math.PI / 4);
			transformation1 = transformation1.scale(new Vector3( 4.0,1.0,4.0 ));
//		 transformation1 = transformation1.rotateZ(-Math.PI / 2);
		// transformation1 = transformation1.translation(new Vector3( -1, -1, 0
		// ));

		// Tests fuer Transformationsreihenfolge
		// transformation1 = transformation1.translation(new Vector3( 0, 2, 0
		// ));
		// transformation1 = transformation1.rotateZ(Math.PI/2);
		// transformation1 = transformation1.translation(new Vector3( 0, 2, 0
		// ));

		final Node rootNode1 = new Node(transformation1, geomList1);
		geometries.add(rootNode1);

		double x = 0;
		double y = 0;
		double z = 20;
		PerspectiveCamera camera = new PerspectiveCamera(new Point3(x, y, z),
				new Vector3(-x, -y, -z), new Vector3(0, 1, 0), Math.PI / 4);

		ArrayList<Light> lights = new ArrayList<Light>();
		PointLight pointLight = new PointLight(Color.WHITE,
				new Point3(0, 0, 20), true);
		lights.add(pointLight);

		World world = new World(geometries, lights, Color.BLACK, ambient);
		RTPanel panel1 = new RTPanel(camera, world);

		// Szene 2
		Set<Geometry> geometries11 = new HashSet<Geometry>();
		final AxisAlignedBox aab = new AxisAlignedBox(new ReflectiveMaterial(
				Color.YELLOW, Color.BLACK, 64, reflective));
		final List<Geometry> geomList11 = new ArrayList<Geometry>(); 
		geomList11.add(aab);
		Transform transformation2 = new Transform();
//		transformation2 = transformation2.scale(new Vector3(4,1,12));
		 transformation2 = transformation2.rotateY(-Math.PI / 4);
		 transformation2 = transformation2.rotateZ(-Math.PI / 4);
			transformation2 = transformation2.scale(new Vector3( 4, 1, 12 ));
		geometries11.add(new Node(transformation2, geomList11));
		ArrayList<Light> lights2 = new ArrayList<Light>();
		PointLight pointLight2 = new PointLight(Color.WHITE,
				new Point3(-6, 1, 16), false);
		lights2.add(pointLight2);
		World welt2 = new World(geometries11, lights2, Color.BLACK, ambient);
		RTPanel panel2 = new RTPanel(camera, welt2);

		JTabbedPane pane = new JTabbedPane();
		pane.addTab("Szene 1", panel1);
		 pane.addTab("Szene 2", panel2);

		container.add(pane);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setResizable(false);
		frame.setVisible(true);

	}
}
