package entity.furniture;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Library extends Objet{

	public Library(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().COBWEB,gp);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
