package entity.pickableObjects;

import java.awt.image.BufferedImage;

import entity.Objet;
import entity.Player;
import main.GamePanel;


/**
 * 
 * @author basti
 * @brief Comportement d'un buff 
 */
public interface Buff {

	
	/**
	 * @param p Player qui va subir l'effet du buff
	 */
	public void effect(Player p);
}
