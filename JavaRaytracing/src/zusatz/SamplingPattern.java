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
	 * @param points Die Anzahl der Punkte, die Weite und Hoehe das Pattern beschreiben
	 */
	public SamplingPattern(final int points) {
		this.points = new Point2[points];
	}
}
