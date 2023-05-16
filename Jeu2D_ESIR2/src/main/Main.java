package main;

import java.util.ArrayList;

import javax.swing.JFrame;

import entity.Door;
import entity.Entity;
import resources.ImagePath;
import resources.RoomManager;

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
		RoomManager room_manager = RoomManager.getInstance(gamePanel);
		room_manager.RoomGarden.updateGamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.startGameThread();	

	}

}
