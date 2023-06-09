package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import entity.Heart;
import resources.FixedValues;
import resources.ImagePath;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import entity.Player.Status;
import tile.TileManager;

/**
 * Panel principal du jeu contenant la map principale
 *
 */
public class GamePanel extends JPanel implements Runnable {

	// Param�tres de l'�cran
	final int ORIGINAL_TILE_SIZE = 16; // une tuile de taille 16x16
	final int SCALE = 3; // �chelle utilis�e pour agrandir l'affichage
	public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48
	public final int MAX_SCREEN_COL = 16;
	public final int MAX_SCREE_ROW = 12; // ces valeurs donnent une r�solution 4:3
	public final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL; // 768 pixels
	public final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREE_ROW; // 576 pixels

	// FPS : taux de rafraichissement
	int m_FPS;

	// Cr�ation des diff�rentes instances (Player, KeyHandler, TileManager,
	// GameThread ...)
	KeyHandler m_keyH;
	Thread m_gameThread;
	Player m_player;
	TileManager m_tileM;
	LinkedList<Entity> m_listEntity;
	LinkedList<Heart> m_listHearts;

	/**
	 * Constructeur
	 */
	public GamePanel() {
		m_FPS = 60;
		m_keyH = new KeyHandler();
		m_player = new Player(this, m_keyH);
		m_tileM = new TileManager(this);

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(m_keyH);
		this.setFocusable(true);

		m_listHearts = new LinkedList<>();

		for (int i = 0; i < (FixedValues.MAXHEALTH / 2); i++) {
			m_listHearts.add(new Heart(TILE_SIZE * i, 0, 2, this, m_player));
		}
	}

	public LinkedList<Entity> getM_listEntity() {
		return m_listEntity;
	}

	public void setM_listEntity(LinkedList<Entity> m_listEntity) {
		this.m_listEntity = m_listEntity;
	}

	/**
	 * Lancement du thread principal
	 */
	public void startGameThread() {
		m_gameThread = new Thread(this);
		m_gameThread.start();
	}

	public void run() {

		double drawInterval = 1000000000 / m_FPS; // rafraichissement chaque 0.0166666 secondes
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (m_gameThread != null) { // Tant que le thread du jeu est actif

			if (m_player.getM_Status() == Status.alive) {
				// Permet de mettre � jour les diff�rentes variables du jeu
				this.update();

				// Dessine sur l'�cran le personnage et la map avec les nouvelles informations.
				// la m�thode "paintComponent" doit obligatoirement �tre appel�e avec
				// "repaint()"
				this.repaint();
			}

			// Calcule le temps de pause du thread
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Mise � jour des donn�es des entit�s
	 */
	public void update() {

		m_player.update();

		if (!m_listHearts.isEmpty()) {
			for (Heart h : m_listHearts) {
				h.update();
			}
		}

		if (!m_listEntity.isEmpty()) {
			for (Entity e : m_listEntity) {
				e.update();
			}
		}

	}

	public TileManager getM_tileM() {
		return m_tileM;
	}

	public Player getM_Player() {
		return m_player;
	}

	/**
	 * Affichage des �l�ments
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (m_player.getM_Status() == Status.alive) {
			m_tileM.draw(g2);
			m_player.draw(g2);

			if (!m_listHearts.isEmpty()) {
				for (Heart h : m_listHearts) {
					h.draw(g2);
				}
			}
			if (!m_listEntity.isEmpty()) {
				for (Entity e : m_listEntity) {
					e.draw(g2);
				}
			}
		} else {
			g2.drawImage(ImagePath.getInstance().GAME_OVER, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
		}

		g2.dispose();
	}

	@Override
	public String toString() {
		String s = "";
		for (Entity e : m_listEntity)
			s += e.toString() + " | ";
		return s;
	}

}
