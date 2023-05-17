package entity.furniture;

import entity.Objet;
import main.GamePanel;
import resources.FixedValues;
import resources.ImagePath;

public class Fridge extends Objet {

    private int heal;
    private int compteur;

    public Fridge(int x, int y, GamePanel gp) {
        super(x, y, ImagePath.getInstance().COBWEB, gp);
        this.heal = 1;
        this.compteur = 2;

    }

    public void heal() {
        if (m_gp.getM_Player().getHealth() < FixedValues.MAXHEALTH && compteur != 0) {
            m_gp.getM_Player().setHealth(m_gp.getM_Player().getAttack() + heal);
            compteur--;
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

}