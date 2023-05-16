package entity.pickableObjects;

import resources.ImagePath;

public class Sword extends Object {

	
	private int effect;

	public Sword(int x, int y) {
		super(x,y,ImagePath.getInstance().SWORD);
	}
	
	
}
