package entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import main.GamePanel;

public abstract class Weapon extends Objet{
	
	private List<Objet> inventaire;

	public Weapon(int a_x, int a_y, BufferedImage a_idleImage, GamePanel a_gp) {
		super(a_x, a_y, a_idleImage,a_gp);
	}
}
