package entity;

import java.awt.image.BufferedImage;
import entity.Monster;
import entity.Player;
import main.GamePanel;
import resources.ImagePath;

public class Butler extends Monster{
    
    int m_health;
    int m_attack;
    GamePanel m_gp;
    
    public Butler(){
        super(10, 100, 4, ImagePath.getInstance().BUTLER);
        this.m_health = 5;
        this.m_attack = 2;
    }

    /**
     * Mise à jour des données du joueur
     */
    public void update(Player p) {
        move(p);
    }
    
    public void move(Player p) {
        
    }

}