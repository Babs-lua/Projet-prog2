package entity.furniture;

import java.awt.image.BufferedImage;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Bath extends Objet {

	public Bath(int x, int y, GamePanel a_gp) {
		super(x, y, ImagePath.getInstance().BATH, a_gp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {		
	}
	
}
