package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import resources.ImagePath;

public class Heart extends Entity {
    
    private Player m_player;

    private static BufferedImage getImageHeart(int typeHeart) {
        BufferedImage heartImage;
        if(typeHeart == 0) {
            heartImage = ImagePath.getInstance().HEART_EMPTY;
        } else if (typeHeart == 1) {
            heartImage = ImagePath.getInstance().HEART_HALF;
        } else {
            heartImage = ImagePath.getInstance().HEART_FULL;
        }
        
        return heartImage;
    }
    
    public Heart(int a_x, int a_y, int typeHeart, GamePanel a_gp, Player a_player){        
        super(a_x, a_y, 0, getImageHeart(typeHeart), a_gp);
        m_player = a_player;
    }

    @Override
    public void update() {
        int health = m_player.getHealth();
        
        int fullheart = 0;
        boolean parite = false;
        if (health % 2 == 0) {
            fullheart = health / 2;
            parite = true;
        } else {
            fullheart = (health - 1) / 2;
            parite = false;
        }
        
        if(m_x < fullheart * m_gp.TILE_SIZE) {
            setM_idleImage(getImageHeart(2));
        } else if(m_x == fullheart * m_gp.TILE_SIZE && !parite) {
            setM_idleImage(getImageHeart(1));
        } else {
            setM_idleImage(getImageHeart(0));
        }
    }
}

