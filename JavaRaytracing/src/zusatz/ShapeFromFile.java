package zusatz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import aufgabe01.Color;
import aufgabe01.Geometry;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.Triangle;
import b_vorbereitung.Point3;
import beleuchtung_I.Material;
import beleuchtung_I.SingleColorMaterial;

/**
 * Eine Geometrische Figur die aus einer ".obj"-Datei gelesen wird
 * @author Kosmonaut
 *
 */
public class ShapeFromFile extends Geometry{
	
	/**
	 * Das Triangle mesh das die Figur beschreibt
	 */
	private final List<Triangle> triangles = new ArrayList<Triangle>();
	
	/**
	 * Eine 3D Figur aus Dreiecken
	 * @param file Die ".obj"-Datei in der sich die Figur befindet
	 * @param material Das Material der Datei
	 */
	public ShapeFromFile(final File file, final Material material){
		super(material);
		final Scanner in;
		final List<Point3> vertices = new ArrayList<Point3>();
		final List<int[]> faces = new ArrayList<int[]>();
		try{
			in = new Scanner(new BufferedReader(new FileReader(file))).useLocale(Locale.US);
			while(in.hasNextLine()){
				final Scanner lineScanner = new Scanner(in.nextLine());
				lineScanner.useLocale(Locale.US);
				switch (lineScanner.next()) {
				case "v":
					vertices.add(new Point3(lineScanner.nextDouble(), lineScanner.nextDouble(), lineScanner.nextDouble()));
					break;

				case "f":
					faces.add(new int[]{lineScanner.nextInt(), lineScanner.nextInt(), lineScanner.nextInt()});
					break;
					
				default:
					break;
				}
				lineScanner.close();
			}
			in.close();
		}catch(FileNotFoundException fnfe){
			System.err.println("in Raytracer: "+fnfe.toString());
		}catch(IOException ioe){
			System.err.println("in Raytracer: "+ioe.toString());
		}
		for(int[] face: faces){
			triangles.add(new Triangle(vertices.get(face[0]-1), vertices.get(face[1]-1), vertices.get(face[2]-1), material));
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