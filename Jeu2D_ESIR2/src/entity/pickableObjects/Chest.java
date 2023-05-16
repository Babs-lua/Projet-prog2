package entity.pickableObjects;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Chest extends Objet{

	public Chest(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().CLOSECHEST,gp);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
