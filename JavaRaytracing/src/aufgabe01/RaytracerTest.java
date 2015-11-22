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
		// Werte für die Kamera
		Point3 e = new Point3(0,0,0);
		Vector3 g = new Vector3(0,0,1);
		Vector3 t = new Vector3(0,1,0);
		double angle = Math.PI/4;
		// Werte für die Fläche
		Point3 a = new Point3(0,-1,0);
		Normal3 n = new Normal3(0,1,0);
		Color color = new Color(0,1,0);
		// Farbe für den Hintergrund, wenn es keinen Hit gab
		Color backgroundColor = new Color(0,0,0);
		// Fläche wird dem Set hinzugefügt
		Set<Geometry> set = new HashSet<Geometry>();
		Geometry plane = new Plane(a,n,color);
		set.add(plane);	
		
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


