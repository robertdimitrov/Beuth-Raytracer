package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
import b_vorbereitung.Vector3;

public class PhongMaterial extends Material{
	
	final Color diffuse;
	final Color specular;
	final int exponent;
	
	public PhongMaterial(Color diffuse, Color specular, int exponent){
		
		this.diffuse=diffuse;
		this.specular=specular;
		this.exponent=exponent;
	}
	
	public Color colorFor(Hit hit,World world{
		
		Color c;
		Color ca=world.ambientLight;
		int length=world.lightArray.size;
		Vector3 r;
		Vector3 l;
		Color cl;
		
		for(int i=0; i<length;i++){
			
			cl=world.lightArray.get(i).color;
			l=world.lightArray.get(i).directionFrom();
			r=
		}
	}

}
