package entity.weapon;

import java.awt.image.BufferedImage;

import entity.Entity;
import main.GamePanel;
import main.Room;
import resources.ImagePath;

public class SpecialDoor extends Entity {
	
	public SpecialDoor(int x,int y,GamePanel gp) {
		super(x,y,0, ImagePath.getInstance().SPECIAL_DOOR,gp);
		
	}
	
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
