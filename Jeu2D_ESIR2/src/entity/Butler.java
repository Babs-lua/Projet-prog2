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
        super(10, 100, 4, ImagePath.getInstance().BUTLER,a_gp,5,2);
        this.m_health = 5;
        this.m_attack = 2;
    }

    /**
     * Mise à jour des données du joueur
     */
    public void update(Player p) {
        move();
    }
    
 

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}