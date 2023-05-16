package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import resources.FixedValues;

/**
 * Entité de base du jeu
 *
 */
public abstract class Entity {
	public int m_x, m_y; // position sur la map
	public int m_speed; // Déplacement de l'entité
	public GamePanel m_gp;
	public BufferedImage m_idleImage; // Une image de l'entité

	Entity(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp) {
		this.m_x = a_x;
		this.m_y = a_y;
		this.m_speed = a_speed;
		this.m_idleImage = a_idleImage;
		this.m_gp = a_gp;
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

	public boolean isCollisonWithEnt(Entity e) {
		int[][] entiteBox = getHitbox(e.m_x, e.m_y);
		int[][] m_htibox = getHitbox(m_x, m_y);
		for (int i = 0; i < FixedValues.box_length; i++) {
			if (insideTheBox(m_htibox, entiteBox[0][i], entiteBox[1][i])) {
				System.out.println("touchepull");
				return true;
			}
		}
		return false;

	}

	private boolean insideTheBox(int[][] box, int x, int y) {
		return x > box[0][0] && x < box[0][1] && y > box[1][0] && y < box[1][1];
	}

}