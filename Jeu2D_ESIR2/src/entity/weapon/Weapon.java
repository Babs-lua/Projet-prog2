package entity.weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import entity.Objet;
import entity.Player;
import main.GamePanel;

public abstract class Weapon extends Objet{
	

	public Weapon(int a_x, int a_y, BufferedImage a_idleImage,Player p) {
		super(a_x, a_y, a_idleImage,p.getM_gp());
	}
}
