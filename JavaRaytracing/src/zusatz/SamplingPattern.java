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
					r = x;
					a = y / x;
				} else {
					r = y;
					a = 2.0 - x / y;
				}
			} else {
				if (x < y) {
					r = -x;
					a = 4 + y / x;
				} else {
					r = -y;
					a = y != 0 ? 6 - x / y : 0;
				}
			}
			double phi = Math.PI * a / 4.0;
			discPoints[i] = new Point2(r * Math.cos(phi), r * Math.sin(phi));
			i++;
		}
		return discPoints;
//		Point2[] discPoints = new Point2[points.length];
//		for (int i = 0; i < points.length; i++) {
//			final double x = points[i].x;
//			final double y = points[i].y;
//			
//			if(x == 0 && y == 0){// would divide by 0
//				discPoints[i] = points[i]; 
//			}
//			
//			final double angle;
//			final double quadrant;// 0 : West, 1: North, 2: East, 3 : South
//			if (x > -y) {
//				if (x > y) {
//					quadrant = 0;
//					angle = y / x;
//				} else {
//					quadrant = 1;
//					angle = x / y;
//				}
//			} else {
//				if (x < y) {
//					quadrant = 2;
//					angle = y / x;
//				} else {
//					quadrant = 3;
//					angle = x / y ;
//				}
//			}
//
//			final double alpha = Math.PI / 2.0 * quadrant  + Math.atan(angle);
//			discPoints[i] = new Point2( Math.cos(alpha), Math.sin(alpha));
//		}
//		return discPoints;
	}


}