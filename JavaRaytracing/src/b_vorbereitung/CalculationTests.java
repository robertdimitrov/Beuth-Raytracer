package b_vorbereitung;

import java.io.PrintWriter;

public class CalculationTests {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);

		Normal3 n1 = new Normal3(1, 2, 3);
		Normal3 n2 = new Normal3(3, 2, 1);
		out.println("[0.5, 1.0, 1.5] =? " + n1.mul(0.5));
		out.println("[4.0, 4.0, 4.0] =? " + n1.add(n2));

		out.println("1.0 =? " + new Normal3(1, 0, 0).dot(new Vector3(1, 0, 0)));
		out.println("1.0 =? " + new Vector3(1, 0, 0).dot(new Normal3(1, 0, 0)));
		out.println("1.0 =? " + new Vector3(1, 0, 0).dot(new Vector3(1, 0, 0)));

		out.println("0.0 =? " + new Normal3(1, 0, 0).dot(new Vector3(0, 1, 0)));
		out.println("0.0 =? " + new Vector3(1, 0, 0).dot(new Normal3(0, 1, 0)));
		out.println("0.0 =? " + new Vector3(1, 0, 0).dot(new Vector3(0, 1, 0)));

		out.println("[-1.0, -1.0, 1.0] =?"
				+ new Point3(1, 1, 1).sub(new Point3(2, 2, 0)));
		out.println("[-3.0, -2.0, -1.0] =? "
				+ new Point3(1, 1, 1).sub(new Vector3(4, 3, 2)));
		out.println("[5.0, 4.0, 3.0] =? "
				+ new Point3(1, 1, 1).add(new Vector3(4, 3, 2)));

		out.println(Math.sqrt(3) + " =? " + new Vector3(1, 1, 1).magnitude);

		out.println("[3.0, 1.0, 2.0] =? "
				+ new Vector3(2, 1, 2).add(new Normal3(1, 0, 0)));
		out.println("[4.0, 2.0, 1.0] =? "
				+ new Vector3(0, 0, 1).add(new Vector3(4, 2, 0)));
		out.println("[3.0, 1.0, 3.0] =? "
				+ new Vector3(3, 2, 5).sub(new Normal3(0, 1, 2)));
		out.println("[8.0, -8.0, 8.0] =? " + new Vector3(2, -2, 2).mul(4));

		out.println("[0.707, 0.707, 0.0] =? "
				+ new Vector3(-0.707, 0.707, 0)
						.reflectedOn(new Normal3(0, 1, 0)));
		out.println("[0.707, -0.707, 0.0] =? "
				+ new Vector3(0.707, 0.707, 0)
						.reflectedOn(new Normal3(1, 0, 0)));

		Mat3x3 m1 = new Mat3x3(1, 0, 0, 0, 1, 0, 0, 0, 1);
		out.println("[3.0, 2.0, 1.0] =? " + m1.mul(new Point3(3, 2, 1)));
		out.println("[3.0, 2.0, 1.0] =? " + m1.mul(new Vector3(3, 2, 1)));

		Mat3x3 m2 = new Mat3x3(1, 2, 3, 4, 5, 6, 7, 8, 9);
		out.println("[(1.0, 2.0, 3.0),(4.0, 5.0, 6.0),(7.0,8.0,9.0)] =? "
				+ m2.mul(new Mat3x3(1, 0, 0, 0, 1, 0, 0, 0, 1)));
		out.println("[(3.0, 2.0, 1.0),(6.0, 5.0, 4.0),(9.0, 8.0, 7.0)] =? "
				+ m2.mul(new Mat3x3(0, 0, 1, 0, 1, 0, 1, 0, 0)));

		Vector3 v1 = new Vector3(8, 8, 8);
		out.println(m2.changeCol1(v1));
		out.println(m2.changeCol2(v1));
		out.println(m2.changeCol3(v1));

	}

}
