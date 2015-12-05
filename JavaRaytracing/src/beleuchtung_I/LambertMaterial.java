package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public class LambertMaterial {

	Color color;
	
	LambertMaterial(Color color){
		
		this.color=color;
	}
	
	public Color colorFor(Hit hit,World world){
		
		Color c=null;
		//Länge des des Licht_Arrays der Welt
		int length=world.lights.size();	
		//Farbe, die sich aus der Multiplikation von Materialfarbe und Lichtfarbe ergibt
		Color dl;
		//Lichtfarbe
		Color cl;
		//Normale des Hit-Objekts
		Normal3 n=hit.n;
		//Richtungsvektor der Lichtquelle
		Vector3 l;
		//Schnittpunkt des strahls mit Geometrie
		Point3 p=hit.ray.at(hit.t);
		//Für jede Lichtquelle wird Berechnung durchgeführt
		 for(int i=0;i<length;i++){
			 
			cl=world.lights.get(i).color;
			dl=color.mul(cl);			
			l=world.lights.get(i).directionFrom(p);
			c=dl.mul(Math.max(0, n.dot(l)));
			 
		 }
		 //Produkt aus color und ambientLight wird zu c addiert
		return c.add(color.mul(world.ambientLight));
	}
}
