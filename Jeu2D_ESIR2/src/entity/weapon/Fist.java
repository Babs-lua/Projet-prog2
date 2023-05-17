package entity.weapon;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import entity.Player;
import main.GamePanel;
import resources.FixedValues;

public class Fist extends Weapon {

	public Fist(int a_x, int a_y, GamePanel g_p) {
		super(a_x, a_y, null, g_p);
		this.m_hitbox = new Rectangle(m_x, m_y, FixedValues.fist_size, FixedValues.fist_size);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
