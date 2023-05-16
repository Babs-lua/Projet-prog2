package entity;

import java.awt.image.BufferedImage;

import entity.Objet;
import main.GamePanel;
import main.Room;

public class Door extends Objet {

	Room m_entree;
	Room m_sortie;
	
	public Door(int x, int y,BufferedImage img, GamePanel a_gp, Room room_entree, Room room_sortie) {
		super(x, y, img, a_gp);
		m_entree = room_entree;
		m_sortie = room_sortie;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
