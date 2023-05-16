package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePath {
	private static ImagePath imgStore;

	private String wall = "/tile/BRICK.png";
	private String barrier = "";
	private String grass = "/tile/GRASS.png";
	private String butler = "";
	private String bat = "";
	private String player = "/Player/superhero.png";
	private String lava = "/tiles/LAVA.png";

	public BufferedImage WALL;
	public BufferedImage BARRIER;
	public BufferedImage PLAYER;

	private ImagePath() {
		try {
			WALL = ImageIO.read(getClass().getResource(wall));
			BARRIER= ImageIO.read(getClass().getResource(barrier));
			PLAYER=ImageIO.read(getClass().getResource(player));
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
