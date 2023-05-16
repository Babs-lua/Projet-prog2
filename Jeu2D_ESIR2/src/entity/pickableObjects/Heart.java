package entity.pickableObjects;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Heart extends Objet{

	
	private int effect;

	public Heart(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().SWORD, gp);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
