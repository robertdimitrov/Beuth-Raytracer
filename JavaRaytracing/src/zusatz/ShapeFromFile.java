package zusatz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sun.misc.Regexp;
import aufgabe01.Color;
import aufgabe01.Geometry;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.Triangle;
import b_vorbereitung.Point3;
import beleuchtung_I.SingleColorMaterial;

public class ShapeFromFile extends Geometry{
	private final List<Triangle> triangles = new ArrayList<Triangle>();
	public ShapeFromFile(final File file){
		super(new SingleColorMaterial(Color.WHITE));
		final Scanner in;
		final List<Point3> vertices = new ArrayList<Point3>();
		try{
			in = new Scanner(new BufferedReader(new FileReader(file)));
			while(in.hasNext()){
				final String line = in.nextLine();
				final Scanner lineScanner = new Scanner(line);
				switch (lineScanner.next()) {
				case "v":
					vertices.add(new Point3(lineScanner.nextDouble(), lineScanner.nextDouble(), lineScanner.nextDouble()));
					break;

				case "f":
//					faces.add(new Point3(lineScanner.nextDouble(), lineScanner.nextDouble(), lineScanner.nextDouble()));
					break;

				default:
					break;
				}
			}
		}catch(FileNotFoundException fnfe){
			System.err.println("in Raytracer: "+fnfe.toString());
		}catch(IOException ioe){
			System.err.println("in Raytracer: "+ioe.toString());
		}
	}

	@Override
	public Hit hit(Ray r) {
		Hit hit = null;
		for(Triangle triangle : triangles){
			final Hit possibleHit = triangle.hit(r);
			if(hit == null && possibleHit != null){
				hit = possibleHit;
			}
			if(hit != null && possibleHit != null){
				if(possibleHit.t < hit.t){
					hit = possibleHit;
				}
			}
		}
		return hit;
	}
}