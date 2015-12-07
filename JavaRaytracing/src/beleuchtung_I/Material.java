package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

public abstract class Material {
	
	
	public abstract Color colorFor(final Hit hit, final World world);

}
