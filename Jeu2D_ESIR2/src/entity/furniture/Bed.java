package entity.furniture;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Bed extends Objet{

	public Bed(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().TRANSPARENT,gp);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
