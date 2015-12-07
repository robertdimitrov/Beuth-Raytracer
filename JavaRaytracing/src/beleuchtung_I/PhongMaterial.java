package beleuchtung_I;

import aufgabe01.Color;
import aufgabe01.Hit;
import aufgabe01.World;
<<<<<<< HEAD
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
=======
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;
>>>>>>> ff864bacb019247ff6f35e54a3799ab9a5328156

/**
 * @author Kosmonaut
 */

public class PhongMaterial extends Material {

    public Color diffuse;
    public Color specular;
    public int exponent;

    public PhongMaterial(Color diffuse, Color specular, int exponent) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.exponent = exponent;
    }

    @Override
    public Color colorFor(Hit hit, World world) {
        Color ambient = world.ambientLight;
        Color cdca = this.diffuse.mul(ambient);
        Color color = cdca;
        Normal3 n = hit.n;
        Point3 p = hit.ray.at(hit.t);

        for(Light light : world.lights){
            if(light.illuminates(p)){
            Color cl = light.color;
            Vector3 l = light.directionFrom(p).normalized();
            Vector3 e = hit.ray.d.mul(-1).normalized();
            Vector3 r = l.reflectedOn(n);
                Color c1 = this.diffuse.mul(cl).mul(Math.max(0, n.dot(l)));
                Color c2 = this.specular.mul(cl).mul(Math.pow(Math.max(0, e.dot(r)), exponent));
                color = color.add(c1.add(c2));
            }
        }
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhongMaterial that = (PhongMaterial) o;

        if (exponent != that.exponent) return false;
        if (diffuse != null ? !diffuse.equals(that.diffuse) : that.diffuse != null) return false;
        return !(specular != null ? !specular.equals(that.specular) : that.specular != null);

    }

    @Override
    public int hashCode() {
        int result = diffuse != null ? diffuse.hashCode() : 0;
        result = 31 * result + (specular != null ? specular.hashCode() : 0);
        result = 31 * result + exponent;
        return result;
    }

    @Override
    public String toString() {
        return "PhongMaterial{" +
                "diffuse=" + diffuse +
                ", specular=" + specular +
                ", exponent=" + exponent +
                '}';
    }
}
