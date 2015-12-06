package aufgabe01;

import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;



/**
 * Klasse zum Testen eines Raytracers
 * 
 * @author Clemens
 *
 */
public class RaytracerTest {

	/**
	 * @param args �bergabeparameter
	 */
	public static void main(String[] args) {
		
		Point3 e = new Point3(0,0,0);

		Vector3 g = new Vector3(0,0,-1);
		
		Vector3 t = new Vector3(0,1,0);
		
		double angle = Math.PI/4;
		
		Color backgroundColor = new Color(0,0,0);
	
		Set<Geometry> set = new HashSet<Geometry>();
		
		
//		Camera kamera_Plane_Sphere_Triangle = new PerspectiveCamera(e,g,t,angle);
//		Camera kamera_Box = new PerspectiveCamera(new Point3(3,3,3),new Vector3(-3,-3,-3),new Vector3(0,1,0),angle);
//		Camera kamera_Kugeln_gross = new OrthographicCamera(new Point3(0, 0, 0), new Vector3(0, 0, -1), new Vector3(0, 1, 0), 3);
//
//		Geometry plane = new Plane(new Point3(0,-1,0),new Normal3(0,1,0),new Color(0,1,0));
//		Sphere sphere = new Sphere(new Point3(0,0,-3),0.5, new Color(1,0,0));
//		AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5, 0, -0.5), new Point3(0.5,1,0.5), new Color(0,0,1));
//		Triangle tri = new Triangle(new Point3(-0.5,0.5,-3), new Point3(0.5,0.5,-3),new Point3(0.5,-0.5,-3), new Color(1,0,1));
//		Sphere sphere_klein = new Sphere(new Point3(1,0,-6),0.5, new Color(1,0,0));
//		Sphere sphere_gro� = new Sphere(new Point3(-1,0,-3),0.5, new Color(1,0,0));
//
//		Sphere sphere_Paarlinks = new Sphere(new Point3(-1,0,-3),0.5, new Color(1,0,0));
//		Sphere sphere_Paarrechts = new Sphere(new Point3(1,0,-6),0.5, new Color(1,0,0));
//
//		set.add(plane);
//		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera_Plane_Sphere_Triangle,set);		
		
//		set.add(sphere);
//		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera_Plane_Sphere_Triangle,set);	
		
//		set.add(box);
//		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera_Box,set);	
		
//		set.add(tri);
//		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera_Plane_Sphere_Triangle,set);
		
//		set.add(sphere_klein);	
//		set.add(sphere_gro�);
//		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera_Plane_Sphere_Triangle,set);
//		
//		set.add(sphere_Paarlinks);
//		set.add(sphere_Paarrechts);
//		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera_Kugeln_gro�,set);
		


		
	
		
//		JFrame frame = new JFrame("WindowedRayTracer");
//		frame.setSize(640,480);
//		frame.setLayout( new BorderLayout() );
//		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//	    frame.add(raytracer);
//	    frame.setVisible( true );
	}
	
}

