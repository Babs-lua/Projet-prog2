package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import javax.imageio.ImageIO;
import controls.Controls;
import entity.Monster;
import entity.Player;
import main.GamePanel;
import resources.ImagePath;

public class Bat extends Monster {

	public Bat(GamePanel a_gp) {
		super(50, 50, 3, ImagePath.getInstance().BAT, a_gp, 3, 1,30);
	}

	@Override
	public void move() {
		int p_x = m_gp.getM_Player().m_x;
		int p_y = m_gp.getM_Player().m_y;

		int deplacement_x = m_gp.getM_Player().m_x - m_x;
		int deplacement_y = m_gp.getM_Player().m_y - m_y;

		double distance = Math.sqrt(deplacement_x * deplacement_x + deplacement_y * deplacement_y);
		double deplacementNormaliseX = (deplacement_x / distance) * m_speed;
		double deplacementNormaliseY = (deplacement_y / distance) * m_speed;

		m_x += deplacementNormaliseX;
		m_y += deplacementNormaliseY;
	}
}