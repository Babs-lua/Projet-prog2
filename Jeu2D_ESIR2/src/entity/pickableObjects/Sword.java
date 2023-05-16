package entity.pickableObjects;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Sword extends Objet {

	
	private int effect;

	public Sword(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().SWORD, gp);
	}
	
	
}
