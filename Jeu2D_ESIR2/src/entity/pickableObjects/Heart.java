package entity.pickableObjects;

import entity.Objet;
import entity.Player;
import main.GamePanel;
import resources.ImagePath;

public class Heart extends Objet implements Buff {

	private int effect;

	public Heart(int x, int y, GamePanel gp) {
		super(x, y, ImagePath.getInstance().SWORD, gp);
		this.effect = 1;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void effect(Player p) {
		p.setHealth(p.getHealth()-effect);
	}

}
