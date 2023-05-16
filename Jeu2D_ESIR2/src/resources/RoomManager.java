package resources;

import java.util.ArrayList;

import entity.Door;
import entity.Entity;
import main.GamePanel;
import main.Room;

public class RoomManager {
	
	private static RoomManager rm;
	public GamePanel m_gp;
	
	public Room RoomGarden;
	public Room RoomEntryMansion;
	public Room Roomtest;
	

	private RoomManager(GamePanel a_gp) {
			
		RoomGarden = new Room(a_gp, "/maps/mapGarden.txt", new ArrayList<>());
		
		RoomEntryMansion = new Room(a_gp, "/maps/mapEntreeMansion.txt", new ArrayList<>());
		
		Roomtest = new Room(a_gp, "/maps/map.txt", new ArrayList<>());
		
		RoomGarden.push_entity(new Door(336, 0, ImagePath.getInstance().MAINDOOR, a_gp, RoomEntryMansion));
		
		RoomEntryMansion.push_entity(new Door(336, 528, ImagePath.getInstance().MAINDOOR, a_gp, RoomGarden));
		
		RoomEntryMansion.push_entity(new Door(336, 0, ImagePath.getInstance().MAINDOOR, a_gp, Roomtest));
		
	}
	
	
	private static RoomManager createSingleton(GamePanel a_gp) {
		
		 return new RoomManager(a_gp);
	}

	public static RoomManager getInstance(GamePanel a_gp) {
		if(rm == null) {
			rm = createSingleton(a_gp);
		}
		return rm;
	}

	
}
