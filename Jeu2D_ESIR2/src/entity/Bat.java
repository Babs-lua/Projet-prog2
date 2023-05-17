package entity;

import java.awt.Point;
import java.util.HashMap;

import main.GamePanel;
import resources.ImagePath;

public class Bat extends Monster {

	private enum Parameters {
		distance, XDirection, YDirection
	}

	private final int slideValue = 96;
	private int b_gameCycle;
	private HashMap<Parameters, Double> attackParameters;

	public Bat(int x, int y, GamePanel a_gp) {
		super(x, y, 3, ImagePath.getInstance().BAT, a_gp, 3, 1, 30);
		b_gameCycle = 0;
		attackParameters = new HashMap<>();
	}

	public void aim(Player p) {
		int deplacement_x = p.m_x - m_x;
		int deplacement_y = p.m_y - m_y;
		double distance = Math.sqrt(deplacement_x * deplacement_x + deplacement_y * deplacement_y);
		attackParameters.put(Parameters.distance, distance);
		attackParameters.put(Parameters.XDirection, (deplacement_x / distance) * m_speed);
		attackParameters.put(Parameters.YDirection, (deplacement_y / distance) * m_speed);
	}

	public void go() {
		Point newPosition = new Point();
		newPosition.x = (int) (m_x + attackParameters.get(Parameters.XDirection) +  (slideValue * attackParameters.get(Parameters.XDirection) < 0 ? -1 : 1));
		newPosition.y = (int) (m_y + attackParameters.get(Parameters.YDirection) + (slideValue * attackParameters.get(Parameters.YDirection) < 0 ? -1 : 1));

		if (!isCollision(newPosition.x, newPosition.y)) {
			if (newPosition.x != m_gp.getM_Player().m_x || newPosition.y != m_gp.getM_Player().m_y) {
				m_x += attackParameters.get(Parameters.XDirection)
						+ (slideValue * attackParameters.get(Parameters.XDirection) < 0 ? -1 : 1);
				m_y += attackParameters.get(Parameters.YDirection)
						+ (slideValue * attackParameters.get(Parameters.YDirection) < 0 ? -1 : 1);
			} else  {
				m_x += attackParameters.get(Parameters.XDirection);
				m_y += attackParameters.get(Parameters.YDirection);
			}
		}
	}

	@Override
	public void move() {
		if (!isCollisionWithEnt(m_gp.getM_Player())) {
			if (b_gameCycle % 120 < 30) {
				aim(m_gp.getM_Player());
				go();
			} else if (b_gameCycle % 180 < 100) {
				go();
			} else {

			}
			b_gameCycle++;
		}

	moveHitBox(m_x, m_y);}
}