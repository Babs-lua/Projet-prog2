package entity;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import controls.Controls;
import main.GamePanel;
import main.KeyHandler;
import resources.ImagePath;

/**
 * Défintition du comportement d'un joueur
 *
 */
public class Player extends Entity {

	GamePanel m_gp;
	KeyHandler m_keyH;

	/**
	 * Constructeur de Player
	 * 
	 * @param a_gp   GamePanel, pannel principal du jeu
	 * @param a_keyH KeyHandler, gestionnaire des touches
	 */
	public Player(GamePanel a_gp, KeyHandler a_keyH) {
		super(500,350,4,ImagePath.getInstance().PLAYER);
		this.m_gp = a_gp;
		this.m_keyH = a_keyH;
		this.getPlayerImage();
	}

	

	/**
	 * Récupération de l'image du personnage
	 */
	public void getPlayerImage() {
		// gestion des expections
		try {
			m_idleImage = ImageIO.read(getClass().getResource("/Player/superhero.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mise à jour des données du joueur
	 */
	public void update() {
		
		move();

	}

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

	public void move() {
		HashSet<Integer> tabKey = (HashSet<Integer>) m_keyH.getKey();
		if (tabKey.size() > 0) {
			for (Integer i : tabKey) {
				int keyCode = (int) i;
				int new_x = m_x;
				int new_y = m_y;
				if (keyCode == Controls.goRight) {
					new_x = Math.min(new_x + m_speed, m_gp.SCREEN_WIDTH - m_gp.TILE_SIZE)-1;
				}
				if (keyCode == Controls.goLeft) {

					new_x = Math.max(new_x - m_speed, 0)+1;

				}
				if (keyCode == Controls.goUp) {

					new_y = Math.max(new_y - m_speed, 0)+1;

				}
				if (keyCode == Controls.goDown) {
					new_y = Math.min(new_y + m_speed, m_gp.SCREEN_HEIGHT - m_gp.TILE_SIZE) -1;
				}
				if (!isCollision(new_x, new_y)) {
					m_x = new_x;
					m_y = new_y;
				}

			}
		}
	}

	public int[][] getTileCoord(int x, int y) {
		int[][] tmp = new int[2][4];
		// haut gauche
		tmp[0][0] = (x) / m_gp.TILE_SIZE;
		tmp[1][0] = (y) / m_gp.TILE_SIZE;
		// haut droite
		tmp[0][1] = (x + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		tmp[1][1] = (y) / m_gp.TILE_SIZE;
		// bas gauche
		tmp[0][2] = (x) / m_gp.TILE_SIZE;
		tmp[1][2] = (y + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		// bas droite
		tmp[0][3] = (x + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		tmp[1][3] = (y + m_gp.TILE_SIZE) / m_gp.TILE_SIZE;
		return tmp;
	}

	public boolean isCollision(int x, int y) {
		int[][] cord_tuil = getTileCoord(x, y);
		for(int i=0;i<4;i++) {
			int tileId = m_gp.getM_tileM().getM_mapTileNum()[cord_tuil[0][i]][cord_tuil[1][i]];
			if(m_gp.getM_tileM().getM_tile()[tileId].m_collision) {
				return true;
			}
		}
		return false;
		
		
	}

}
