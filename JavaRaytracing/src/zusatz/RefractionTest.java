package zusatz;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import transformation.Transform;
import aufgabe01.AxisAlignedBox;
import aufgabe01.Color;
import aufgabe01.Geometry;
import aufgabe01.Node;
import aufgabe01.PerspectiveCamera;
import aufgabe01.Plane;
import aufgabe01.Sphere;
import aufgabe01.Triangle;
import aufgabe01.World;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.DirectionalLight;
import beleuchtung_I.Light;
import beleuchtung_I.PhongMaterial;
import beleuchtung_I.PointLight;
import beleuchtung_I.RTPanel;
import beleuchtung_I.ReflectiveMaterial;
import beleuchtung_I.SpotLight;

public class RefractionTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Refraction");
		Container container = frame.getContentPane();

		// Szene 1
		final List<Geometry> geometries = new ArrayList<Geometry>();

		geometries.add(new Plane(new ReflectiveMaterial(Color.WHITE,
				Color.WHITE, 10, Color.WHITE)));

		final Sphere sphere1 = new Sphere(new ReflectiveMaterial(new Color(1,
				0, 0), Color.WHITE, 10, new Color(1, .5, .5)));
		final List<Geometry> geom1 = new ArrayList<Geometry>();
		geom1.add(sphere1);
		Transform transform1 = new Transform();
		transform1 = transform1.translation(new Vector3(0, 1, 0)).scale(
				new Vector3(.5, .5, .5));
		Node node1 = new Node(transform1, geom1);
		// geometries.add(node1);
		final Sphere sphere2 = new Sphere(new ReflectiveMaterial(new Color(0,
				1, 0), Color.WHITE, 10, new Color(1, .5, .5)));
		final List<Geometry> geom2 = new ArrayList<Geometry>();
		geom2.add(sphere2);
		Transform transform2 = new Transform();
		transform2 = transform2.translation(new Vector3(-1.5, 1, 0)).scale(
				new Vector3(.5, .5, .5));
		Node node2 = new Node(transform2, geom2);
		// geometries.add(node2);
		final Sphere sphere3 = new Sphere(new ReflectiveMaterial(new Color(0,
				0, 1), Color.WHITE, 10, new Color(1, .5, .5)));
		final List<Geometry> geom3 = new ArrayList<Geometry>();
		geom3.add(sphere3);
		Transform transform3 = new Transform();
		transform3 = transform3.translation(new Vector3(1.5, 1, 0)).scale(
				new Vector3(.5, .5, .5));
		Node node3 = new Node(transform3, geom3);
		// geometries.add(node3);
		final Sphere sphere4 = new Sphere(new ReflectiveMaterial(new Color(0,
				1, 1), Color.WHITE, 10, new Color(1, .5, .5)));
		final List<Geometry> geom4 = new ArrayList<Geometry>();
		geom4.add(sphere4);
		Transform transform4 = new Transform();
		transform4 = transform4.translation(new Vector3(0, 1, -1.5)).scale(
				new Vector3(.5, .5, .5));
		Node node4 = new Node(transform4, geom4);
		// geometries.add(node4);
		final Sphere sphere5 = new Sphere(new ReflectiveMaterial(new Color(1,
				0, 1), Color.WHITE, 10, new Color(1, .5, .5)));
		final List<Geometry> geom5 = new ArrayList<Geometry>();
		geom5.add(sphere5);
		Transform transform5 = new Transform();
		transform5 = transform5.translation(new Vector3(-1.5, 1, -1.5)).scale(
				new Vector3(.5, .5, .5));
		Node node5 = new Node(transform5, geom5);
		// geometries.add(node5);
		final Sphere sphere6 = new Sphere(new ReflectiveMaterial(new Color(1,
				1, 0), Color.WHITE, 10, new Color(1, .5, .5)));
		final List<Geometry> geom6 = new ArrayList<Geometry>();
		geom6.add(sphere6);
		Transform transform6 = new Transform();
		transform6 = transform6.translation(new Vector3(1.5, 1, -1.5)).scale(
				new Vector3(.5, .5, .5));
		Node node6 = new Node(transform6, geom6);
		// geometries.add(node6);
		final Sphere sphere7 = new Sphere(new TransparentMaterial(1.33));
		final List<Geometry> geom7 = new ArrayList<Geometry>();
		geom7.add(sphere7);
		Transform transform7 = new Transform();
		transform7 = transform7.translation(new Vector3(0, 2, 1.5)).scale(
				new Vector3(.5, .5, .5));
		Node node7 = new Node(transform7, geom7);
		// geometries.add(node7);
		final Sphere sphere8 = new Sphere(new TransparentMaterial(1.33));
		final List<Geometry> geom8 = new ArrayList<Geometry>();
		geom8.add(sphere8);
		Transform transform8 = new Transform();
		transform8 = transform8.translation(new Vector3(-1.5, 2, 1.5)).scale(
				new Vector3(.5, .5, .5));
		Node node8 = new Node(transform8, geom8);
		// geometries.add(node8);
		final Sphere sphere9 = new Sphere(new TransparentMaterial(1.33));
		final List<Geometry> geom9 = new ArrayList<Geometry>();
		geom9.add(sphere9);
		Transform transform9 = new Transform();
		transform9 = transform9.translation(new Vector3(1.5, 2, 1.5)).scale(
				new Vector3(.5, .5, .5));
		Node node9 = new Node(transform9, geom9);
		// geometries.add(node9);
		final AxisAlignedBox aab = new AxisAlignedBox(new TransparentMaterial(
				1.33));
		final List<Geometry> geom10 = new ArrayList<Geometry>();
		geom10.add(aab);
		Transform transform10 = new Transform();
		transform10 = transform10.translation(new Vector3(0, .5, 3.5));
		Node node10 = new Node(transform10, geom10);
		geometries.add(node10);
		final Triangle tri = new Triangle(new Point3(.7, .5, 3), new Point3(
				1.3, .5, 3), new Point3(.7, .5, 4), new PhongMaterial(
				new Color(0, 1, 0), new Color(0, 1, 0), 20));
		final List<Geometry> geom11 = new ArrayList<Geometry>();
		geom11.add(tri);
		Transform transform11 = new Transform();
		transform11 = transform11.translation(new Vector3(0, 0, 0));
		Node node11 = new Node(transform11, geom11);
		geometries.add(node11);

		final List<Geometry> shrinkList = new ArrayList<Geometry>();
		shrinkList.add(node1);
		shrinkList.add(node2);
		shrinkList.add(node3);
		shrinkList.add(node4);
		shrinkList.add(node5);
		shrinkList.add(node6);
		shrinkList.add(node7);
		shrinkList.add(node8);
		shrinkList.add(node9);
		geometries.add(new Node(new Transform()// .scale(new Vector3(.5, .5,
												// .5))
				, shrinkList));

		final HashSet<Geometry> geos = new HashSet<Geometry>(geometries);

		ArrayList<Light> lights = new ArrayList<Light>();

		final Color o3 = new Color(.3, .3, .3);

		Light spotLight = new SpotLight(o3, new Point3(0, 5, -10), new Vector3(
				0, -1, 0), Math.PI / 8, true);
		lights.add(spotLight);

		Light pointLight = new PointLight(o3, new Point3(5, 5, -10), true);
		lights.add(pointLight);

		Light directionalLight = new DirectionalLight(o3,
				new Vector3(1, -1, 0), true);
		lights.add(directionalLight);

		Color ambient = new Color(0.1, 0.1, 0.1);
		World world = new World(geos, lights, Color.BLACK, ambient);

		PerspectiveCamera camera = new PerspectiveCamera(new Point3(8, 8, 8),
				new Vector3(-1, -1, -1), new Vector3(0, 1, 0), Math.PI / 4, new DiagonalSamplingPattern(10));

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
