package resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImagePath {
	private static ImagePath imgStore;

	public BufferedImage BACKWALLMAIN;
	public BufferedImage BARRIER;
	public BufferedImage BAT;
	public BufferedImage BATH;
	public BufferedImage BED1;
	public BufferedImage BED2;
	public BufferedImage BED3;
	public BufferedImage BED4;
	public BufferedImage BLACK;
	public BufferedImage BUTLER;
	public BufferedImage CARPET;
	public BufferedImage COBWEB;
	public BufferedImage CLOSECHEST;
	public BufferedImage FLOWER1;
	public BufferedImage FLOWER2;
	public BufferedImage DOOR;
	public BufferedImage GRASS;
	public BufferedImage KEY;
	public BufferedImage LOG;
	public BufferedImage MAINDOOR;
	public BufferedImage OPENCHEST;
	public BufferedImage PLAYER;
	public BufferedImage STAIRS;
	public BufferedImage SWORD;
	public BufferedImage TRANSPARENT;
	public BufferedImage WALL;
	public BufferedImage WALLPAPER;
	public BufferedImage WALLPAPERROOM;
	public BufferedImage WOODENFLOOR;
	
	


	private ImagePath() {
		try {
			BACKWALLMAIN = ImageIO.read(getClass().getResource("/tiles/BACKWALLMAIN.jpg"));
			BARRIER = ImageIO.read(getClass().getResource("/tiles/BARRIER.png"));
			BAT = ImageIO.read(getClass().getResource("/tiles/BAT.png"));
			BATH = ImageIO.read(getClass().getResource("/tiles/BATH.png"));
			BED1 = ImageIO.read(getClass().getResource("/tiles/BED1.png"));
			BED2 = ImageIO.read(getClass().getResource("/tiles/BED2.png"));
			BED3 = ImageIO.read(getClass().getResource("/tiles/BED3.png"));
			BED4 = ImageIO.read(getClass().getResource("/tiles/BED4.png"));
			BLACK = ImageIO.read(getClass().getResource("/tiles/BLACK.jpg"));
			BUTLER = ImageIO.read(getClass().getResource("/tiles/SKELETON.png"));
			CARPET = ImageIO.read(getClass().getResource("/tiles/CARPET.png"));
			CLOSECHEST = ImageIO.read(getClass().getResource("/tiles/CLOSECHEST.png"));
			FLOWER1 = ImageIO.read(getClass().getResource("/tiles/FLOWER1.png"));
			FLOWER2 = ImageIO.read(getClass().getResource("/tiles/FLOWER2.png"));
			COBWEB = ImageIO.read(getClass().getResource("/tiles/COBWEB.png"));
			DOOR = ImageIO.read(getClass().getResource("/tiles/DOOR.png"));
			GRASS = ImageIO.read(getClass().getResource("/tiles/GRASS.png"));
			KEY = ImageIO.read(getClass().getResource("/tiles/KEY.png"));
			LOG = ImageIO.read(getClass().getResource("/tiles/LOG.jpg"));
			MAINDOOR = ImageIO.read(getClass().getResource("/tiles/castledoors.png"));
			OPENCHEST = ImageIO.read(getClass().getResource("/tiles/OPENCHEST.png"));
			PLAYER = ImageIO.read(getClass().getResource("/Player/superhero.png"));
			STAIRS = ImageIO.read(getClass().getResource("/tiles/STAIRS.png"));
			SWORD = ImageIO.read(getClass().getResource("/tiles/SWORD.png"));
			TRANSPARENT = ImageIO.read(getClass().getResource("/tiles/TRANSPARENT.png"));
			WOODENFLOOR = ImageIO.read(getClass().getResource("/tiles/woodenfloor.png"));
			WALL = ImageIO.read(getClass().getResource("/tiles/STONEWALL.png"));
			WALLPAPER = ImageIO.read(getClass().getResource("/tiles/WALLPAPER.png"));
			WALLPAPERROOM = ImageIO.read(getClass().getResource("/tiles/WALLPAPERROOM.png"));
			
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
