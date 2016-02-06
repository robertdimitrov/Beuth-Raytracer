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
	 * Maß für die Extinktion.
	 * Quelle: Wikipedia
	 */
	public final double indexOfRefraction;
	/**
	 * 
	 * @param indexOfRefraction der Brechungsindex
	 */
	public TransparentMaterial(final double indexOfRefraction) {
		this.indexOfRefraction = indexOfRefraction;
	}

	@Override
	public Color colorFor(Hit hit, World world, Tracer tracer) {
    	if(hit==null) throw new IllegalArgumentException("hit darf nicht null sein");
        if(world==null) throw new IllegalArgumentException("world darf nicht null sein");
        if(tracer==null) throw new IllegalArgumentException("tracer darf nicht null sein");

        Color color = Color.BLACK;
        final Point3 p = hit.ray.at(hit.t);

        final Color reflected = tracer.reflektion(new Ray(p, hit.ray.d.mul( -1 ).reflectedOn(hit.n)));
        if(reflected != null){
        	color = color.add(reflected.mul(reflected));
        }
        final Color seeThrough = tracer.reflektion(new Ray(p, hit.ray.d.mul( -1 ).reflectedOn(hit.n)));
        if(seeThrough != null){
        	color = color.add(seeThrough.mul(seeThrough));
        }
        
		return color;
	}

}
