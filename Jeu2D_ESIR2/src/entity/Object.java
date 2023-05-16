package entity;

import java.awt.image.BufferedImage;

public abstract class  Object extends Entity {

	boolean solid;
	int damage;
	
	public Object(int x, int y,BufferedImage img) {
		super(x,y,0,img);
	}
	
}
