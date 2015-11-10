package aufgabe01;

/**
 * Diese Klasse erzeugt Farben in der RGB-Darstellung
 * 
 * @author Kosmonaut
 *
 */
public class Color {
	private final double r;
	private final double g;
	private final double b;

	/**
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
		}
		if(akzeptierbar(g)){
			this.g = g;
		}
		if(akzeptierbar(b)){
			this.b = b;
		}
	}

	private boolean akzeptierbar(double x) {
		return 0 <= x && x >= 1;
	}
}
