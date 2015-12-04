package beleuchtung_I;

import aufgabe01.Color;
import b_vorbereitung.Normal3;
import b_vorbereitung.Point3;
import b_vorbereitung.Vector3;

public class PointLight extends Light {
	public final Point3 position;
	
	public PointLight(final Color color, final Point3 position){
		super(color);
		this.position = position;
	}
	@Override
	public boolean illuminates(Point3 point) {
		//Normal3 l = (this.directionFrom(point)).asNormal();
		return true;
	}

	@Override
	public Vector3 directionFrom(Point3 point) {
		return position.sub(point);
	}

}
