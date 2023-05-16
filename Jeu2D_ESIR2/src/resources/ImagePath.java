package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePath {
	private static ImagePath imgStore;

	public BufferedImage BARRIER;
	public BufferedImage BAT;
	public BufferedImage BATH;
	public BufferedImage BED;
	public BufferedImage BUTLER;
	public BufferedImage COBWEB;
	public BufferedImage CLOSECHEST;
	public BufferedImage GRASS;
	public BufferedImage KEY;
	public BufferedImage MAINDOOR;
	public BufferedImage OPENCHEST;
	public BufferedImage PLAYER;
	public BufferedImage SWORD;
	public BufferedImage WALL;
	public BufferedImage WOODENFLOOR;
	
	


	private ImagePath() {
		try {
			BARRIER = ImageIO.read(getClass().getResource("/tiles/BARRIER.png"));
			BAT = ImageIO.read(getClass().getResource("/tiles/TheBat.png"));
			BATH = ImageIO.read(getClass().getResource("/tiles/BATH.png"));
			BED = ImageIO.read(getClass().getResource("/tiles/BED.png"));
			BUTLER = ImageIO.read(getClass().getResource("/tiles/SKELETON.png"));
			CLOSECHEST = ImageIO.read(getClass().getResource("/tiles/CLOSECHEST.png"));
			COBWEB = ImageIO.read(getClass().getResource("/tiles/COBWEB.png"));
			GRASS = ImageIO.read(getClass().getResource("/tiles/GRASS.png"));
			KEY = ImageIO.read(getClass().getResource("/tiles/KEY.png"));
			MAINDOOR = ImageIO.read(getClass().getResource("/tiles/castledoors.png"));
			OPENCHEST = ImageIO.read(getClass().getResource("/tiles/OPENCHEST.png"));
			PLAYER = ImageIO.read(getClass().getResource("/Player/superhero.png"));
			SWORD = ImageIO.read(getClass().getResource("/tiles/SWORD.png"));
			WOODENFLOOR = ImageIO.read(getClass().getResource("/tiles/woodenfloor.png"));
			WALL = ImageIO.read(getClass().getResource("/tiles/BRICK2.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createSingleton() {
		if (imgStore == null)
			imgStore = new ImagePath();
	}

	public static ImagePath getInstance() {
		return imgStore;
	}

}
