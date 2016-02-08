package zusatz;
/**
 * Ein Sampling pattern streut auf einer 2D-Ebene,  zum Zweck des Anti-Aliasing
 * @author Kosmonaut
 *
 */
public abstract class SamplingPattern {

	/**
	 * Alle Punkte, die sich in einem SamplingPattern befinden
	 */
	public final Point2[] points;

	/**
	 * Ein SamplingPattern streut auf einer 2D-Ebene,  zum Zweck des Anti-Aliasing
	 *
	 * @param points Die Anzahl der Punkte, die Weite und Hoehe das Pattern beschreiben
	 */
	public SamplingPattern(final int points) {
		this.points = new Point2[points];
	}

	public Point2[] asDisc() {
		Point2[] discPoints = new Point2[points.length];
		int i = 0;

		for (Point2 point : points) {
			double x = point.x * 2;
			double y = point.y * 2;

			double a, r;
			if (x > -y) {
				if (x > y) {
					a = x;
					r = y / x;
				} else {
					a = y;
					r = 2.0 - x / y;
				}
			} else {
				if (x < y) {
					a = -x;
					r = 4 + y / x;
				} else {
					a = -y;
					r = y != 0 ? 6 - x / y : 0;
				}
			}
			double phi = Math.PI * a / 4.0;
			discPoints[i] = new Point2(r * Math.cos(phi), r * Math.sin(phi));
			i++;
		}
		return discPoints;
	}


}