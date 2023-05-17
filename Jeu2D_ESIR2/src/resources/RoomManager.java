package resources;

import java.util.ArrayList;
import java.util.LinkedList;

import entity.Bat;
import entity.Butler;
import entity.Door;
import entity.Entity;
import main.GamePanel;
import main.Room;

public class RoomManager {
	
	private static RoomManager rm;
	public GamePanel m_gp;
	
	public Room RoomGarden;
	public Room RoomEntryMansion;
	public Room RoomMain;
	public Room RoomCouloir;
	public Room Room_1;
	public Room Room_2;
	public Room Room_3;
	
	

	private RoomManager(GamePanel a_gp) {
			
		RoomGarden = new Room(a_gp, "/maps/mapGarden.txt", new LinkedList<>());
		
		RoomEntryMansion = new Room(a_gp, "/maps/mapEntreeMansion.txt", new LinkedList<>());
		
		RoomMain = new Room(a_gp, "/maps/mapMain.txt", new LinkedList<>());
		
		RoomCouloir = new Room(a_gp, "/maps/Corridor.txt", new LinkedList<>());
		
		Room_1 = new Room(a_gp, "/maps/R1.txt", new LinkedList<>());
		Room_2 = new Room(a_gp, "/maps/R2.txt", new LinkedList<>());
		Room_3 = new Room(a_gp, "/maps/R3.txt", new LinkedList<>());
		
		RoomGarden.push_entity(new Door(336, 0, a_gp, RoomEntryMansion, 336, 470));
		
		RoomGarden.push_entity(new Door(384, 0, a_gp, RoomEntryMansion, 336, 470));
		
		// Couloir
		
		RoomEntryMansion.push_entity(new Door(336, 528, a_gp, RoomGarden, 336, 48));
		
		RoomEntryMansion.push_entity(new Door(384, 528, a_gp, RoomGarden, 336, 48));
		
		RoomEntryMansion.push_entity(new Door(336, 0, a_gp, RoomMain, 336, 470));
		
		RoomEntryMansion.push_entity(new Door(384, 0, a_gp, RoomMain, 336, 470));
		
		RoomEntryMansion.push_entity(new Butler(364, 255, a_gp));
		
		
		
		//Haul
		
		RoomMain.push_entity(new Door(336, 528, a_gp, RoomEntryMansion, 336, 48));
		
		RoomMain.push_entity(new Door(384, 528, a_gp, RoomEntryMansion, 336, 48));
		
		Door tmp = new Door(624, 48, a_gp, RoomCouloir, 336, 470);
		
		RoomMain.push_entity(tmp);
		
		//couloir 
		RoomCouloir.push_entity(new Door(336, 528, a_gp, RoomMain, 624, 100));
		RoomCouloir.push_entity(new Door(384, 528, a_gp, RoomMain, 624, 100));
		
		//couloir room 1 
		
		RoomCouloir.push_entity(new Door(144, 336, a_gp, Room_1, 228, 470));
		RoomCouloir.push_entity(new Door(336, 336, a_gp, Room_2, 336, 470));
		RoomCouloir.push_entity(new Door(528, 336, a_gp, Room_3, 480, 470));
		
		//Room1
		Room_1.push_entity(new Door(192, 528, a_gp, RoomCouloir, 144, 384));
		Room_1.push_entity(new Butler(250,250,a_gp));
		
		Room_2.push_entity(new Door(336, 528, a_gp, RoomCouloir, 336, 384));
		Room_2.push_entity(new Bat(264, 255,a_gp));
		
		Room_3.push_entity(new Door(480, 528, a_gp, RoomCouloir, 528, 384));
		
		
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
