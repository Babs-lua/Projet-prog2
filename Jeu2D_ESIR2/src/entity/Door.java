package entity;

import java.awt.image.BufferedImage;

import entity.Objet;
import main.GamePanel;
import main.Room;

public class Door extends Objet {

	Room m_sortie;
	
	public Door(int x, int y,BufferedImage img, GamePanel a_gp, Room room_sortie) {
		super(x, y, img, a_gp);
		
		m_sortie = room_sortie;
	}

	@Override
	public void update() {
		
		
	}
	public void interact() {
		System.out.println("test");
		m_sortie.updateGamePanel();
	}

}
