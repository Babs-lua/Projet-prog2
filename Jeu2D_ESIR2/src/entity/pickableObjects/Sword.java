package entity.pickableObjects;

import java.awt.Rectangle;

import entity.Weapon;
import main.GamePanel;
import resources.FixedValues;
import resources.ImagePath;

public class Sword extends Weapon {

	
	private Rectangle hitboxSword;

	public Sword(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().SWORD, gp);
		this.hitboxSword = new Rectangle(m_x, m_y, FixedValues.sword_width, FixedValues.sword_length);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
