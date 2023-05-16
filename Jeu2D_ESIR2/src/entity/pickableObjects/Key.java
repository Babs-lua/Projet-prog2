package entity.pickableObjects;

import java.awt.image.BufferedImage;

import entity.Entity;
import entity.Objet;
import resources.ImagePath;

public class Key extends Objet {

	
	public Key(int x,int y) {
		super(x,y,ImagePath.getInstance().KEY);
		
	}
	
	

}
