package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

/**
 * Entité de base du jeu
 *
 */
public abstract class Entity {
    public int m_x, m_y;                //position sur la map
    public int m_speed;                    //Déplacement de l'entité
    public GamePanel m_gp;
    public BufferedImage m_idleImage;    //Une image de l'entité
    
    Entity(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp){
        this.m_x = a_x;
        this.m_y = a_y;
        this.m_speed = a_speed;
        this.m_idleImage = a_idleImage;
        this.m_gp=a_gp;
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
    
}