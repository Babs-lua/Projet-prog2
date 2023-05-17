

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import entity.Objet;
import main.GamePanel;

public abstract class Monster extends Entity {

	private List<Objet> inventaire;
	protected int life_point;
	protected int damages;
	protected int frequence;
	private int gameCycle;

	public Monster(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp, int life_point,
			int damages, int frequence) {
		super(a_x, a_y, a_speed, a_idleImage, a_gp);
		inventaire = new ArrayList<Objet>();
		this.life_point = life_point;
		this.setDamages(damages);
		this.frequence = frequence;

	}

	public abstract void move();

	public void dealDamage() {
		m_gp.getM_Player().setHealth(m_gp.getM_Player().getHealth() - damages);
	}

	public void dropObjet() {
		m_gp.getM_listEntity().addAll(inventaire);
		m_gp.getM_listEntity().remove(this);
	}

	public void update() {
		move();
		if (life_point <= 0) {
			dropObjet();
		}
		else if (isCollisionWithEnt(m_gp.getM_Player())) {
			if (gameCycle % frequence == 0)
				dealDamage();
			gameCycle++;
		}
		else gameCycle=0;

	}

	public List<Objet> getObject() {
		return inventaire;
	}

	public void setObject(List<Objet> object) {
		this.inventaire = object;
	}

	public int getLife_point() {
		return life_point;
	}

	public void setLife_point(int life_point) {
		this.life_point = life_point;
	}

	public int getDamages() {
		return damages;
	}

	public void setDamages(int damages) {
		this.damages = damages;
	}

}