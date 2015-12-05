package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;

public class SingleColorMaterial extends Material{
	
	Color color;
	
	SingleColorMaterial(Color color){
		
		this.color=color;
	}
	
	public Color colorFor(Hit hit, World world){
		
		return this.color;
	}

}
