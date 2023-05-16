package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePath {
	private static ImagePath imgStore;

	public BufferedImage WALL;
	public BufferedImage GRASS;
	public BufferedImage PLAYER;
	//TODO
	public BufferedImage BAT;
	public BufferedImage BUTLER;
	public BufferedImage BARRIER;
	public BufferedImage KEY;


	private ImagePath() {
		try {
			WALL = ImageIO.read(getClass().getResource("/tiles/BRICK2.png"));
			GRASS = ImageIO.read(getClass().getResource("/tiles/GRASS.png"));
			PLAYER = ImageIO.read(getClass().getResource("/Player/superhero.png"));
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
