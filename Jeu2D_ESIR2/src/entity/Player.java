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

/**
 * D�fintition du comportement d'un joueur
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
		this.m_gp = a_gp;
		this.m_keyH = a_keyH;
		this.setDefaultValues();
		this.getPlayerImage();
	}

	/**
	 * Initialisation des donn�es membres avec des valeurs par d�faut
	 */
	protected void setDefaultValues() {
		m_x = 0;
		m_y = 0;
		m_speed = 4;
	}

	/**
	 * R�cup�ration de l'image du personnage
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
	 * Mise � jour des donn�es du joueur
	 */
	public void update() {

		move();

	}

	/**
	 * Affichage du l'image du joueur dans la fen�tre du jeu
	 * 
	 * @param a_g2 Graphics2D
	 */
	public void draw(Graphics2D a_g2) {
		// r�cup�re l'image du joueur
		BufferedImage l_image = m_idleImage;
		// affiche le personnage avec l'image "image", avec les coordonn�es x et y, et
		// de taille tileSize (16x16) sans �chelle, et 48x48 avec �chelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}

	public void move() {
        HashSet<Integer> tabKey = (HashSet<Integer>) m_keyH.getKey();
        if (tabKey.size() > 0) {
            for(Integer i : tabKey) {
                int keyCode = (int)i;
                int new_x = m_x ;
                int new_y = m_y ; 
                if (keyCode == Controls.goRight) {
                    new_x = Math.min(new_x + m_speed, m_gp.SCREEN_WIDTH - m_gp.TILE_SIZE);
                } 
                if (keyCode == Controls.goLeft) {

                    new_x = Math.max(new_x - m_speed, 0);

                }
                if (keyCode == Controls.goUp) {

                    new_y = Math.max(new_y - m_speed, 0);

                } 
                if (keyCode == Controls.goDown) {
                    new_y = Math.min(new_y + m_speed,  m_gp.SCREEN_HEIGHT - m_gp.TILE_SIZE);
                }
                m_x = new_x;
                m_y = new_y;
            }
        }
    }

}
