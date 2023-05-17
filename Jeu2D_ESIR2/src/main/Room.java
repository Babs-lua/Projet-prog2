package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.Entity;

public class Room {

	private GamePanel m_gp;
	private String m_map;
	LinkedList<Entity> m_listEntity;

	public Room(GamePanel gp, String map, LinkedList<Entity> listEntity) {
		m_gp = gp;
		m_map = map;
		m_listEntity = listEntity;
	}

	public void updateGamePanel() {
		m_gp.m_tileM.loadMap(m_map);
		m_gp.setM_listEntity(m_listEntity);
	}

	public void push_entity(Entity e) {
		m_listEntity.add(e);
	}

}
