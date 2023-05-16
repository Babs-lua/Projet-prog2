package entity;

import java.awt.image.BufferedImage;

/**
 * Entité de base du jeu
 *
 */
public abstract class Entity {
    public int m_x, m_y;                //position sur la map
    public int m_speed;                    //Déplacement de l'entité
    public BufferedImage m_idleImage;    //Une image de l'entité
    
    Entity(int a_x, int a_y, int a_speed, BufferedImage a_idleImage){
        this.m_x = a_x;
        this.m_y = a_y;
        this.m_speed = a_speed;
        this.m_idleImage = a_idleImage;
    }
}