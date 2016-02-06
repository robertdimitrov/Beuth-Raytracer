package zusatz;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.Ray;
import aufgabe01.World;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
import beleuchtung_I.Light;
import beleuchtung_I.Material;
import beleuchtung_I.Tracer;

/**
 * ein perfekt transparentes Material
 * 
 * @author Kosmonaut
 *
 */
public class TransparentMaterial extends Material {

	/**
	 * Der Brechungsindex, auch die Brechzahl, ist eine optische
	 * Materialeigenschaft. Diese dimensionslose physikalische Größe gibt an, um
	 * welchen Faktor die Wellenlänge und die Phasengeschwindigkeit des Lichts
	 * kleiner sind als im Vakuum.An der Grenzfläche zweier Medien
	 * unterschiedlicher Brechungsindizes wird Licht gebrochen und reflektiert.
	 * Dabei nennt man das Medium mit dem höheren Brechungsindex das optisch
	 * dichtere. Dies ist nicht zu verwechseln mit der „optischen Dichte“ als
	 * Maß für die Extinktion. Quelle: Wikipedia
	 */
	public final double indexOfRefraction;

	/**
	 * 
	 * @param indexOfRefraction
	 *            der Brechungsindex
	 */
	public TransparentMaterial(final double indexOfRefraction) {
		this.indexOfRefraction = indexOfRefraction;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
		if (hit == null)
			throw new IllegalArgumentException("hit darf nicht null sein");
		if (world == null)
			throw new IllegalArgumentException("world darf nicht null sein");
		if (tracer == null)
			throw new IllegalArgumentException("tracer darf nicht null sein");

		Color color = Color.BLACK;
		final Point3 p = hit.ray.at(hit.t);

		final double eta1 = 1;
		final double cosPhi1 = Math.abs(hit.ray.d.mul(-1).normalized().dot(hit.n));
		final double cosPhi2 = (Math.sqrt(1 - (eta1 / indexOfRefraction)
				* (eta1 / indexOfRefraction)
				* (1 - cosPhi1 * cosPhi1)));

		final double r0 = Math.pow((eta1 - indexOfRefraction)
				/ (eta1 + indexOfRefraction), 2);
		final double bigR = r0 + (1 - r0) * Math.pow((1 - cosPhi1), 5);
		final double bigT = 1 - bigR;
		
//		System.out.println("traM -d "+hit.ray.d.mul(-1)+" n "+hit.n+" * "+hit.ray.d.mul(-1).dot(hit.n));
		System.out.println("traM R "+bigR+" , T "+bigT+", r0 "+r0+", oo "+  (cosPhi1));

		//Reflektion berechnen
		final Color reflected = tracer.trace(new Ray(p, hit.ray.d
				.add(new Vector3(hit.n.x, hit.n.y, hit.n.z).mul(2 * Math
						.cos(cosPhi1)))));
		if (reflected != null) {
			color = color.add(reflected.mul(bigR));
		}
		
		//Transmission berechnen
		final Color seeThrough = tracer.trace(new Ray(p, hit.ray.d.mul(
				eta1 / indexOfRefraction).sub(
				new Vector3(hit.n.x, hit.n.y, hit.n.z).mul(Math.cos(cosPhi2)
						- (eta1 / indexOfRefraction) * Math.cos(cosPhi1)).normalized().asNormal())));
		if (seeThrough != null) {
			color = color.add(seeThrough.mul(bigT));
		}

		return color;
	}
}
