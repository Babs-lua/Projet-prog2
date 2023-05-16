package main;

import java.util.ArrayList;

import javax.swing.JFrame;

import entity.Door;
import entity.Entity;
import resources.ImagePath;

/**
 * 
 * Classe principale du jeu
 *
 */
public class Main {

	public static void main(String[] args) {
		ImagePath.createSingleton();
		//Fenêtre de lancement du jeu
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("ESIR1 - Projet Prog");
		
		//Ajout du panel du jeu et démarrage du thread principal
		GamePanel gamePanel = new GamePanel();
		ArrayList<Entity> tmp = new ArrayList<>();
		tmp.add(new Door(400, 288, ImagePath.getInstance().MAINDOOR, gamePanel, new Room(gamePanel, "/maps/map.txt",tmp)));
		gamePanel.setM_listEntity(tmp);
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.startGameThread();	

	}

}
