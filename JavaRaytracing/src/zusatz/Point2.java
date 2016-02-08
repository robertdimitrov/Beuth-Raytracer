package zusatz;
/**
 * Diese Klasse stellt einen Punkt (x, y) im 2D-Raum dar.
 * @author Kosmonaut
 *
 */
public class Point2 {
	/**
	 * Der x-Wert des Punktes
	 */
	public final double x;
	/**
	 * Der y-Wert des Punktes
	 */
	public final double y;

	/**
	 * Dieser Konstruktor erzeugt ein neues Point2-Objekt.
	 * @param x Der x-Wert des Punktes
	 * @param y Der y-Wert des Punktes
	 */
	public Point2(final double x, final double y) {
		this.x = x;
		this.y = y;
	}
}
