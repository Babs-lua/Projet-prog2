package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import main.GamePanel;

public abstract class Monster extends Entity {

    List<Objet> object;

    public Monster(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp) {
        super(a_x, a_y, a_speed, a_idleImage,a_gp);
        object = new ArrayList<Objet>();
    }

    public abstract void move(Player p);

    public abstract void update(Player p);

    public List<Objet> getObject() {
        return object;
    }

    public void setObject(List<Objet> object) {
        this.object = object;
    }
    public void draw(Graphics2D a_g2) {
		// récupère l'image du joueur
		BufferedImage l_image = m_idleImage;
		// affiche le personnage avec l'image "image", avec les coordonnées x et y, et
		// de taille tileSize (16x16) sans échelle, et 48x48 avec échelle)
		a_g2.drawImage(l_image, m_x, m_y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
	}

}