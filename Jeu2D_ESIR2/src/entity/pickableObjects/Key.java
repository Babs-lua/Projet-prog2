package entity.pickableObjects;

import java.awt.image.BufferedImage;

import entity.Entity;
import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Key extends Objet {

	
	public Key(int x,int y, GamePanel a_gp) {
		super(x,y,ImagePath.getInstance().KEY,a_gp);
		
	}
	
	public Key(GamePanel a_gp) {
		super(-8,-8,ImagePath.getInstance().KEY,a_gp);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	

}
