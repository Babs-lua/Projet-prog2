package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

/**
 * Entit� de base du jeu
 *
 */
public abstract class Entity {
    public int m_x, m_y;                //position sur la map
    public int m_speed;                    //D�placement de l'entit�
    public GamePanel m_gp;
    public BufferedImage m_idleImage;    //Une image de l'entit�
    
    Entity(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp){
        this.m_x = a_x;
        this.m_y = a_y;
        this.m_speed = a_speed;
        this.m_idleImage = a_idleImage;
        this.m_gp=a_gp;
    }
    
    public abstract void update();
    
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
    
}