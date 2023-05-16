package entity;

import java.util.HashSet;
import java.util.Set;

import controls.Controls;
import main.GamePanel;
import main.KeyHandler;
import resources.FixedValues;
import resources.ImagePath;

/**
 * Défintition du comportement d'un joueur
 *
 */
public class Player extends Entity {

	private int health;
	private int attack;
	private Set<Object> inventory;
	private KeyHandler m_keyH;

	/**
	 * Constructeur de Player
	 * 
	 * @param a_gp   GamePanel, pannel principal du jeu
	 * @param a_keyH KeyHandler, gestionnaire des touches
	 */
	public Player(GamePanel a_gp, KeyHandler a_keyH) {
		super(500, 350, 4, ImagePath.getInstance().PLAYER, a_gp);
		this.m_gp = a_gp;
		this.m_keyH = a_keyH;
		inventory = new HashSet<>();
		int health = FixedValues.MAXHEALTH;
		int attack = FixedValues.ATTACK;
	}

	public void attack(Monster m) {
		m.setLife_point(m.getLife_point() - attack);
	}

	/**
	 * Mise à jour des données du joueur
	 */
	public void update() {
		for (Entity e : m_gp.getM_listEntity()) {
			if (e instanceof Door && this.isCollisionWithEnt(e)) {
				Door d = (Door)e;
				d.interact();
				setPosition(d.getX_sortie(), d.getY_sortie());
			}
		}

		move();
	}

	public void move() {
		HashSet<Integer> tabKey = (HashSet<Integer>) m_keyH.getKey();
		if (tabKey.size() > 0) {
			for (Integer i : tabKey) {
				int keyCode = (int) i;
				int new_x = m_x;
				int new_y = m_y;
				if (keyCode == Controls.goRight) {
					new_x = Math.min(new_x + m_speed, m_gp.SCREEN_WIDTH - m_gp.TILE_SIZE) - 1;
				} else if (keyCode == Controls.goLeft) {
					new_x = Math.max(new_x - m_speed, 0) + 1;
				} else if (keyCode == Controls.goUp) {
					new_y = Math.max(new_y - m_speed, 0) + 1;
				} else if (keyCode == Controls.goDown) {
					new_y = Math.min(new_y + m_speed, m_gp.SCREEN_HEIGHT - m_gp.TILE_SIZE) - 1;
				}

				boolean findCollision = false;
				for (Entity e : m_gp.getM_listEntity()) {
					if (e instanceof Objet && ((Objet)e).solid && isCollisionWithEnt(e)) {
						findCollision = true;
						break;
					}
				}
				
				if (!isCollision(new_x, new_y) && !findCollision) {
					setPosition(new_x, new_y);
				}
			}
		}
	}
	
	public void setPosition(int x, int y) {
		m_x = x;
		m_y = y;
		moveHitBox(m_x, m_y);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public Set<Object> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Object> inventory) {
		this.inventory = inventory;
	}

	public KeyHandler getM_keyH() {
		return m_keyH;
	}

	public void setM_keyH(KeyHandler m_keyH) {
		this.m_keyH = m_keyH;
	}
}
