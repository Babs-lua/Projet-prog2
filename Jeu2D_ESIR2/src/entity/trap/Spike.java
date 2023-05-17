package entity.trap;

import java.awt.image.BufferedImage;

import main.GamePanel;

public class Spike extends Trap{
	
	public Spike(int a_x, int a_y, BufferedImage a_idleImage,GamePanel a_gp) {
		super(a_x, a_y, a_idleImage,a_gp);
	}
	
	public void dealDamage() {
		m_gp.getM_Player().setHealth(m_gp.getM_Player().getHealth()-damage);
	}
	
	public void update() {
		dealDamage();
	}
}
