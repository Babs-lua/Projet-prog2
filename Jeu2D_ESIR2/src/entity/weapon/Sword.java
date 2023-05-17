package entity.weapon;

import java.awt.Rectangle;

import entity.Player;
import main.GamePanel;
import resources.FixedValues;
import resources.ImagePath;

public class Sword extends Weapon {


	public Sword(int x, int y, GamePanel gp) {
		super(x,y,ImagePath.getInstance().SWORD,gp);
		this.m_hitbox = new Rectangle(m_x, m_y, FixedValues.sword_width, FixedValues.sword_length);
	}

	public Sword() {
		super(ImagePath.getInstance().SWORD);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
