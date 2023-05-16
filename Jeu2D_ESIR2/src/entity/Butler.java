package entity;

import java.awt.image.BufferedImage;
import entity.Monster;
import entity.Player;
import main.GamePanel;
import resources.ImagePath;

public class Butler extends Monster{
    
    int m_health;
    int m_attack;
    
    
    public Butler(GamePanel a_gp){
        super(10, 100, 4, ImagePath.getInstance().BUTLER,a_gp);
        this.m_health = 5;
        this.m_attack = 2;
    }

    /**
     * Mise � jour des donn�es du joueur
     */
    public void update(Player p) {
        move(p);
    }
    
    public void move(Player p) {
        
    }

}