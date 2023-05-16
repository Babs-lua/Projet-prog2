package entity;

import java.awt.image.BufferedImage;

public abstract class  Objet extends Entity {

	boolean solid;
	int damage;
	
	public Objet(int x, int y,BufferedImage img) {
		super(x,y,0,img);
	}
	
}
