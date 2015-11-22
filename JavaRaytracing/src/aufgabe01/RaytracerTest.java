package aufgabe01;

import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;



public class RaytracerTest {

	public static void main(String[] args) {
		
		Point3 e = new Point3(0,0,0);
		e = new Point3(3,3,3);
		Vector3 g = new Vector3(0,0,-1);
		g = new Vector3(-3,-3,-3);
		Vector3 t = new Vector3(0,1,0);
		double angle = Math.PI/4;
	
		Point3 a = new Point3(0,-1,0);
		Normal3 n = new Normal3(0,1,0);
		Color color = new Color(0,1,0);
		
		Color backgroundColor = new Color(0,0,0);
	
		Set<Geometry> set = new HashSet<Geometry>();
		
		Geometry plane = new Plane(a,n,color);
		Sphere sphere = new Sphere(new Point3(0,0,-3), angle, new Color(1,0,0));
		AxisAlignedBox box = new AxisAlignedBox(new Point3(-0.5, 0, -0.5), new Point3(0.5,1,0.5), new Color(0,0,1));
		
//		set.add(plane);
//		set.add(sphere);
		set.add(box);
		
		
		Camera kamera = new PerspectiveCamera(e,g,t,angle);
		
		JFrame frame = new JFrame("WindowedRayTracer");
		frame.setSize(640,480);
		frame.setLayout( new BorderLayout() );							
		Raytracer raytracer= new Raytracer(640,480,backgroundColor,kamera,set);		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	   	   	  
	    frame.add(raytracer);	 
	    frame.setVisible( true );	   
	}
}

