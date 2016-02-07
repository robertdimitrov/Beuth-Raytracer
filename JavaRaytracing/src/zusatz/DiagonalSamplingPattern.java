/**
 * 
 */
package zusatz;


/**
 * Ein Samplinpattern, bei welchem alle Punkte des Pattern diagonal von (-x, -y) nach (+x, +y) gehen
 * @author Kosmonaut
 *
 */
public class DiagonalSamplingPattern extends SamplingPattern {

	/**
	 * Ein Samplinpattern, bei welchem alle Punkte des Pattern diagonal von (-x, -y) nach (+x, +y) gehen
	 * @param points wieviele Punkte es gibt
	 */
	public DiagonalSamplingPattern(int points) {
		super(points);
		final double distanceFromFellows = (double) 1 / points;
		for(int i = 0; i < points; i++){
			final double xAndY = -0.5 + i * distanceFromFellows + distanceFromFellows / 2;
			super.points[i] = new Point2(xAndY, xAndY);
		}
	}

}
