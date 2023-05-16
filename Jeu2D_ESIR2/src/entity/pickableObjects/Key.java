package entity.pickableObjects;

import java.awt.image.BufferedImage;

import entity.Entity;
import resources.ImagePath;

public class Key extends Object {

	Door opener;
	
	public Key(int x,int y) {
		super(x,y,0,ImagePath.getInstance().KEY);
		
	}
	
	

}
