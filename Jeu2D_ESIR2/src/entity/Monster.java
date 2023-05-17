package entity;

import java.util.Random;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import entity.pickableObjects.Chest;
import entity.pickableObjects.Heart;
import entity.pickableObjects.Key;
import entity.weapon.Sword;
import main.GamePanel;

public abstract class Monster extends Entity {

	private List<Objet> inventaire;
	protected int life_point;
	protected int damages;
	protected int frequence;
	private int gameCycle;

	public Monster(int a_x, int a_y, int a_speed, BufferedImage a_idleImage, GamePanel a_gp, int life_point,
			int damages, int frequence) {
		super(a_x, a_y, a_speed, a_idleImage, a_gp);
        inventaire = generateRandomObjects(); // Appel à une méthode pour générer des objets aléatoires
		this.life_point = life_point;
		this.setDamages(damages);
		this.frequence = frequence;

	}
	
	 private List<Objet> generateRandomObjects() {
	        List<Objet> randomObjects = new ArrayList<>();

	        // Ajouter ici la logique pour générer des objets aléatoires dans randomObjects
	        // Vous pouvez utiliser une boucle ou une logique personnalisée en fonction de vos besoins

	        // Exemple : Générer 3 objets aléatoires à partir d'une liste prédéfinie
	        List<Objet> possibleObjects = new ArrayList<>();
	        possibleObjects.add(new Sword(m_x,m_y,m_gp));
	        possibleObjects.add(new Key(m_x,m_y,m_gp));
	        possibleObjects.add(new Heart(m_x,m_y,m_gp));

	        Random random = new Random();
	            int randomIndex = random.nextInt(possibleObjects.size());
	            randomObjects.add(possibleObjects.get(randomIndex));

	        return randomObjects;
	    }

	public abstract void move();

	public void dealDamage() {
		m_gp.getM_Player().setHealth(m_gp.getM_Player().getHealth() - damages);
	}

	public void dropObjet() {
		m_gp.getM_listEntity().addAll(inventaire);
		m_gp.getM_listEntity().remove(this);
		System.out.println(m_gp.getM_listEntity());
	}

	public void update() {
		move();
		if (life_point <= 0) {
			dropObjet();
		}
		else if (isCollisionWithEnt(m_gp.getM_Player())) {
			if (gameCycle % frequence == 0)
				dealDamage();
			gameCycle++;
		}
		else gameCycle=0;

	}

	public List<Objet> getObject() {
		return inventaire;
	}

	public void setObject(List<Objet> object) {
		this.inventaire = object;
	}

	public int getLife_point() {
		return life_point;
	}

	public void setLife_point(int life_point) {
		this.life_point = life_point;
	}

	public int getDamages() {
		return damages;
	}

	public void setDamages(int damages) {
		this.damages = damages;
	}

}