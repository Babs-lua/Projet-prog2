package entity;

import java.awt.image.BufferedImage;

import entity.Objet;
import main.GamePanel;
import main.Room;
import resources.ImagePath;

public class Door extends Objet {

	Room m_sortie;
	int m_x_sortie;
	int m_y_sortie;
	
	public Room getM_sortie() {
		return m_sortie;
	}

	public void setM_sortie(Room m_sortie) {
		this.m_sortie = m_sortie;
	}

	public Door(int x, int y, GamePanel a_gp, Room room_sortie, int x_sortie, int y_sortie) {
		super(x, y, ImagePath.getInstance().TRANSPARENT,a_gp);
		
		m_sortie = room_sortie;
		m_x_sortie = x_sortie;
		m_y_sortie = y_sortie;
	}
	
	public int getX_sortie() {
		return m_x_sortie;
	}
	
	public int getY_sortie() {
		return m_y_sortie;
	}

	@Override
	public void update() {
		
		
	}
	public void interact() {
		System.out.println("test");
		m_sortie.updateGamePanel();
	}

}
