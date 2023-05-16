package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import resources.FixedValues;

/**
 * Entité de base du jeu
 *
 */
public abstract class Entity {
	protected int m_x, m_y; // position sur la map
	protected int m_speed; // Déplacement de l'entité
	protected GamePanel m_gp;
	protected BufferedImage m_idleImage; // Une image de l'entité
	protected Rectangle m_hitbox;

	Entity(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp) {
		this.m_x = a_x;
		this.m_y = a_y;
		m_hitbox = new Rectangle(a_x, a_y, FixedValues.TILE, FixedValues.TILE);
		this.m_speed = a_speed;
		this.m_idleImage = a_idleImage;
		this.m_gp = a_gp;
	}
	
	public void moveHitBox(int x,int y) {
		m_hitbox.setLocation(x, y);
	}

	public abstract void update();

	/**
	 * Affichage du l'image du joueur dans la fenêtre du jeu
	 * 
	 * @param a_g2 Graphics2D
	 */
	public void draw(Graphics2D a_g2) {
		// récupère l'image du joueur
		BufferedImage l_image = m_idleImage;
		// affiche le personnage avec l'image "image", avec les coordonnées x et y, et
		// de taille tileSize (16x16) sans échelle, et 48x48 avec échelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}

	public int[][] getHitbox(int x, int y) {
		int[][] tmp = new int[FixedValues.box_width][FixedValues.box_length];
		// haut gauche
		tmp[0][0] = (x + FixedValues.OVERLAP) / m_gp.TILE_SIZE;
		tmp[1][0] = (y + FixedValues.OVERLAP) / m_gp.TILE_SIZE;
		// haut droite
		tmp[0][1] = (x - FixedValues.OVERLAP + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		tmp[1][1] = (y + FixedValues.OVERLAP) / m_gp.TILE_SIZE;
		// bas gauche
		tmp[0][2] = (x + FixedValues.OVERLAP) / m_gp.TILE_SIZE;
		tmp[1][2] = (y - FixedValues.OVERLAP + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		// bas droite
		tmp[0][3] = (x - FixedValues.OVERLAP + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		tmp[1][3] = (y - FixedValues.OVERLAP + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		return tmp;
	}

	public boolean isCollision(int x, int y) {
		int[][] cord_tuil = getHitbox(x, y);
		for (int i = 0; i < FixedValues.box_length; i++) {
			int tileId = m_gp.getM_tileM().getM_mapTileNum()[cord_tuil[0][i]][cord_tuil[1][i]];
			if (m_gp.getM_tileM().getM_tile()[tileId].m_collision) {
				return true;
			}
		}
		return false;

	}

	boolean isCollisionWithEnt(Entity e) {
		return m_hitbox.intersects(e.getM_hitbox());
	}

	public int getM_x() {
		return m_x;
	}

	public void setM_x(int m_x) {
		this.m_x = m_x;
	}

	public int getM_y() {
		return m_y;
	}

	public void setM_y(int m_y) {
		this.m_y = m_y;
	}

	public int getM_speed() {
		return m_speed;
	}

	public void setM_speed(int m_speed) {
		this.m_speed = m_speed;
	}

	public GamePanel getM_gp() {
		return m_gp;
	}

	public void setM_gp(GamePanel m_gp) {
		this.m_gp = m_gp;
	}

	public BufferedImage getM_idleImage() {
		return m_idleImage;
	}

	public void setM_idleImage(BufferedImage m_idleImage) {
		this.m_idleImage = m_idleImage;
	}

	public Rectangle getM_hitbox() {
		return m_hitbox;
	}

	public void setM_hitbox(Rectangle m_hitbox) {
		this.m_hitbox = m_hitbox;
	}
}