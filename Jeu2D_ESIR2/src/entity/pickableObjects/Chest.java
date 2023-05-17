package entity.pickableObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Objet;
import entity.weapon.Sword;
import main.GamePanel;
import resources.ImagePath;

public class Chest extends Objet {

	private Objet inventaire;

	public enum chestStatus {
		open, closed
	}

	private chestStatus m_status;

	public Chest(int x, int y, GamePanel gp) {
		super(x, y, ImagePath.getInstance().CLOSECHEST, gp);
		inventaire = new Heart(m_x, m_y, m_gp);
	}

	@Override
	public void update() {
		if (m_status == chestStatus.open) {
			setM_idleImage(ImagePath.getInstance().OPENCHEST);
			m_gp.getM_listEntity().add(inventaire);
		}
	}

	public chestStatus getM_status() {
		return m_status;
	}

	public void setM_status(chestStatus m_status) {
		this.m_status = m_status;
	}
}