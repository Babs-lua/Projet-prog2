package entity.pickableObjects;

import java.awt.image.BufferedImage;

import entity.Objet;
import main.GamePanel;

public abstract class Buff extends Objet {

	int effect;
	
	public Buff(int x, int y,BufferedImage img, GamePanel gp) {
		super(x,y,img, gp);
	}
}
