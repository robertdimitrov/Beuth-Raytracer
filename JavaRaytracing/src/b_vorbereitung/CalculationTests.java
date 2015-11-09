package b_vorbereitung;

import java.io.PrintWriter;

public class CalculationTests {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);

		Normal3 n1 = new Normal3(1, 2, 3);
		out.println("--- Normale * Zahl ---");
		out.println(n1.mul(0.5));
		out.println("\n--- Normale + Normale ---");
		out.println(n1.add(new Normal3(3,2,1)));
		
		Normal3 n2 = new Normal3(1,0,0);
		Normal3 n3 = new Normal3(0,1,0);
		Vector3 v2 = new Vector3(1,0,0);
		Vector3 v3 = new Vector3(0,1,0);
		out.println("\n--- Skalarprodukt Normale und Vektor ---");
		out.println("Skalarprodukt: " + n2.dot(v2));
		out.println("Skalarprodukt: " + n2.dot(v3));
		out.println("\n--- Skalarprodukt Vektor und Normale ---");
		out.println("Skalarprodukt: " + v2.dot(n2));
		out.println("Skalarprodukt: " + v2.dot(n3));
		out.println("\n--- Skalarprodukt Vektor und Vektor ---");
		out.println("Skalarprodukt: " + v2.dot(v2));
		out.println("Skalarprodukt: " + v2.dot(v3));
		
		Point3 p1 = new Point3(1,1,1);
		out.println("\n--- Punkt - Punkt ---");
		out.println(p1.sub(new Point3(2,2,0)));
		
		out.println("\n--- Punkt - Vektor ---");
		out.println(p1.sub(new Vector3(4,3,2)));
		
		out.println("\n--- Punkt + Vektor ---");
		out.println(p1.add(new Vector3(4,3,2)));
		
		out.println("\n--- Länge eines Vektors ---");
		out.println(new Vector3(1,1,1).magnitude);
		
		out.println("\n--- Vektor + Vektor ---");
		out.println(new Vector3(2,1,4).add(new Vector3(5,-2,-2)));
		out.println("\n--- Vektor + Normale ---");
		out.println(new Vector3(-2,0,3).add(new Normal3(1,1,0)));
		out.println("\n--- Vektor - Normale ---");
		out.println(new Vector3(4,3,2).sub(new Normal3(-1,0,0)));
		out.println("\n--- Vektor * Zahl ---");
		out.println(new Vector3(2,2,2).mul(0.5));
		
		out.println("\n--- Reflektierter Vektor ---");
		out.println(new Vector3(-0.707,0.707,0).reflectedOn(new Normal3(0,1,0)));
		out.println("\n--- Reflektierter Vektor ---");
		out.println(new Vector3(0.707,0.707,0).reflectedOn(new Normal3(1,0,0)));
		
		Mat3x3 m1 = new Mat3x3(1,0,0,0,1,0,0,0,1);
		out.println("\n--- Matrix * Punkt ---");
		out.println(m1.mul(new Point3(3,2,1)));
		out.println("\n--- Matrix * Vektor ---");
		out.println(m1.mul(new Vector3(3,2,1)));
		
		Mat3x3 m2 = new Mat3x3(1,2,3,4,5,6,7,8,9);
		out.println("\n--- Matrix * Matrix ---");
		out.println(m2.mul(new Mat3x3(1,0,0,0,1,0,0,0,1)));
		out.println("\n--- Matrix * Matrix ---");
		out.println(m2.mul(new Mat3x3(0,0,1,0,1,0,1,0,0)));
		
		Vector3 v1 = new Vector3(8,8,8);
		out.println("\n--- Austauschen Spalte 1 ---");
		out.println(m2.changeCol1(v1));
		out.println("\n--- Austauschen Spalte 2 ---");
		out.println(m2.changeCol2(v1));
		out.println("\n--- Austauschen Spalte 3 ---");
		out.println(m2.changeCol3(v1));
	}

}
