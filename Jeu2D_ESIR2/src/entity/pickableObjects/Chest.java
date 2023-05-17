package entity.pickableObjects;

import entity.Objet;
import main.GamePanel;
import resources.ImagePath;

public class Chest extends Objet {

	public enum chestStatus {
		open, closed
	}

	private chestStatus m_status;

	public Chest(int x, int y, GamePanel gp) {
		super(x, y, ImagePath.getInstance().CLOSECHEST, gp);
	}

	@Override
	public void update() {
		if (m_status == chestStatus.open)
			setM_idleImage(ImagePath.getInstance().OPENCHEST);
	}

	public chestStatus getM_status() {
		return m_status;
	}

	public void setM_status(chestStatus m_status) {
		this.m_status = m_status;
	}
}
