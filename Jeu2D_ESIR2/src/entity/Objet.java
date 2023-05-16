package entity;

import java.awt.image.BufferedImage;

import main.GamePanel;

public abstract class  Objet extends Entity {

	boolean solid;
	int damage;
	
	public Objet(int x, int y,BufferedImage img, GamePanel a_gp) {
		super(x,y,0,img,a_gp);
	}
	
}
