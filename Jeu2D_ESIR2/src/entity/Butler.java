package entity;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import entity.Monster;
import entity.Player;
import main.GamePanel;
import resources.FixedValues;
import resources.ImagePath;

public class Butler extends Monster {

	private Rectangle perceptionBox;
	private boolean perceived;
	private int memoryCycle;

	public Butler(int x, int y, GamePanel a_gp) {
		super(x, y, 2, ImagePath.getInstance().BUTLER, a_gp, 5, 2, 60);
		this.perceptionBox = new Rectangle(x, y, FixedValues.TILE, 3 * FixedValues.TILE);
		perceived = false;
		memoryCycle = 0;
	}

	public void perception() {
		perceived = perceptionBox.intersects(m_gp.getM_Player().getM_hitbox());
	}

	@Override
	public void move() {
		perception();
		if (isCollisionWithEnt(m_gp.getM_Player())||perceived || memoryCycle % 120 > 0) {
			memoryCycle++;
			if (!isCollisionWithEnt(m_gp.getM_Player())) {
				int deplacement_x = m_gp.getM_Player().m_x - m_x;
				int deplacement_y = m_gp.getM_Player().m_y - m_y;

				double distance = Math.sqrt(deplacement_x * deplacement_x + deplacement_y * deplacement_y);
				double deplacementNormaliseX = (deplacement_x / distance) * m_speed;
				double deplacementNormaliseY = (deplacement_y / distance) * m_speed;

				m_x += deplacementNormaliseX;
				m_y += deplacementNormaliseY;
				moveHitBox(m_x, m_y);
				perceptionBox.setLocation(m_x, m_y);
			}
		} else
			memoryCycle = 0;

	}
}