package entity.trap;

import java.awt.image.BufferedImage;
import entity.Objet;
import main.GamePanel;

public abstract class Trap extends Objet {

	protected int damage;

	public Trap(int a_x, int a_y, BufferedImage a_idleImage, GamePanel a_gp) {
		super(a_x, a_y, a_idleImage, a_gp);
	}
	
	public abstract void dealDamage();
}
