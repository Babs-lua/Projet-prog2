package entity.pickableObjects;

import java.awt.Rectangle;

import entity.Player;
import entity.Weapon;
import main.GamePanel;
import resources.FixedValues;
import resources.ImagePath;

public class Sword extends Weapon {


	public Sword(int x, int y, Player p) {
		super(x,y,ImagePath.getInstance().SWORD,p);
		this.m_hitbox = new Rectangle(m_x, m_y, FixedValues.sword_width, FixedValues.sword_length);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
