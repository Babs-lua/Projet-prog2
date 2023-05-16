package main;

import java.util.ArrayList;
import java.util.List;

import entity.Entity;

public class Room {

	GamePanel m_gp;
	String m_map;
	ArrayList<Entity> m_listEntity;
	
	public Room(GamePanel gp, String map, List<Entity> listEntity) {
		m_gp = gp;
		m_map = map;
		m_listEntity = (ArrayList<Entity>) listEntity;
	}
	
	public void updateGamePanel() {
		m_gp.m_tileM.loadMap(m_map);
		m_gp.setM_listEntity(m_listEntity);
	}

}
