package aufgabe01;

/**
 * Diese Klasse repraensentiert eine Farben im RGB-Farbraum
 * 
 * @author Kosmonaut
 *
 */
public class Color {
	private final double r;
	private final double g;
	private final double b;

	/**
	 * erzeugt eine Farbe im RGB-Farbraum
	 * 
	 * @param r
	 *            Rot-Anteil der Farbe zwischen 0 und 1
	 * @param g
	 *            Gruen-Anteil der Farbe zwischen 0 und 1
	 * @param b
	 *            Blau-Anteil der Farbe zwischen 0 und 1
	 */
	public Color(final double r, final double g, final double b) {
		if (akzeptierbar(r)) {
			this.r = r;
		} else {
			throw new IllegalArgumentException("r ist groesser als 1 oder kleiner als 0");
		}
		if (akzeptierbar(g)) {
			this.g = g;
		} else {
			throw new IllegalArgumentException("g ist groesser als 1 oder kleiner als 0");
		}
		if (akzeptierbar(b)) {
			this.b = b;
		} else {
			throw new IllegalArgumentException("b ist groesser als 1 oder kleiner als 0");
		}
	}

	/**
	 * prueft ob die Zahl einen Wert zwischen 0 und 1 hat
	 * 
	 * @param x
	 *            zu prüfende Zahl
	 * @return Ergebnis
	 */
	private boolean akzeptierbar(double x) {
		return 0 <= x && x <= 1;
	}

	/**
	 * die Farbe c wird zum Methodenaufrufer addiert
	 * 
	 * @param c
	 *            die Farbe die wird
	 * @return die berechnete Farbe
	 */
	public Color add(Color c) {
		final double nR = this.r + c.getR();
		final double nG = this.g + c.getG();
		final double nB = this.b + c.getB();
		return new Color(nR, nG, nB);
	}

	/**
	 * die Farbe c wird vom Methodenaufrufer subtrahiert
	 * 
	 * @param c
	 *            die Farbe die subtrahiert wird wird
	 * @return die berechnete Farbe
	 */
	public Color sub(Color c) {
		final double nR = this.r - c.getR();
		final double nG = this.g - c.getG();
		final double nB = this.b - c.getB();
		return new Color(nR, nG, nB);
	}

	/**
	 * die Farbe c wird mit dem Methodenaufrufer multipliziert
	 * 
	 * @param c
	 *            die Farbe mit der multipliziert wird
	 * @return die berechnete Farbe
	 */
	public Color mul(Color c) {
		final double nR = this.r * c.getR();
		final double nG = this.g * c.getG();
		final double nB = this.b * c.getB();
		return new Color(nR, nG, nB);
	}

	/**
	 * der Methodenaufrufer wird mit dem Faktor v mulipliziert
	 * 
	 * @param v
	 *            der Faktor mit dem multipliziert wird
	 * @return die berechnete Farbe
	 */
	public Color mul(double v) {
		final double nR = this.r * v;
		final double nG = this.g * v;
		final double nB = this.b * v;
		return new Color(nR, nG, nB);
	}

	public double getR() {
		return r;
	}

	public double getG() {
		return g;
	}

	public double getB() {
		return b;
	}
}
