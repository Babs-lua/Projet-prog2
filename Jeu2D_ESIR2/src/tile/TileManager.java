package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import main.GamePanel;
import resources.ImagePath;

/**
 * 
 * Gestionnaire des tiles du jeu
 *
 */
public class TileManager {
	GamePanel m_gp;			//panel du jeu principal
	Tile[] m_tile;			//tableau de toutes les tiles possibles dans le jeu
	int m_maxTiles = 30;	//nombre maximum de tiles chargeable dans le jeu
	int m_mapTileNum[][];	//r�partition des tiles dans la carte du jeu
	
	public int[][] getM_mapTileNum() {
		return m_mapTileNum;
	}
	
	public Tile[] getM_tile() {
		return m_tile;
	}

	

	/**
	 * Constructeur
	 * @param gp
	 */
	public TileManager(GamePanel gp) {
		this.m_gp =  gp;
		m_tile = new Tile[m_maxTiles];
		m_mapTileNum = new int[gp.MAX_SCREEN_COL][gp.MAX_SCREE_ROW];
		this.getTileImage();
		this.loadMap("/maps/mapGarden.txt");
	}
	
	/**
	 * Chargement de toutes les tuiles du jeu
	 */
	public void getTileImage() {
			m_tile[0] = new Tile();
			m_tile[0].m_image = ImagePath.getInstance().BLACK;
			m_tile[0].m_collision=true;
			
			
			m_tile[1] = new Tile();
			m_tile[1].m_image = ImagePath.getInstance().WALL;
			m_tile[1].m_collision=true;
			
			m_tile[2] = new Tile();
			m_tile[2].m_image = ImagePath.getInstance().WOODENFLOOR;

			m_tile[3] = new Tile();
			m_tile[3].m_image = ImagePath.getInstance().DOOR;
			m_tile[3].m_collision=true;
			
			m_tile[4] = new Tile();
			m_tile[4].m_image = ImagePath.getInstance().BARRIER;
			m_tile[4].m_collision=true;
			
			m_tile[5] = new Tile();
			m_tile[5].m_image = ImagePath.getInstance().GRASS;
			
			m_tile[6] = new Tile();
			m_tile[6].m_image = ImagePath.getInstance().LOG;
			m_tile[6].m_collision=true;
			
			m_tile[7] = new Tile();
			m_tile[7].m_image = ImagePath.getInstance().BACKWALLMAIN;
			m_tile[7].m_collision=true;
			
			m_tile[8] = new Tile();
			m_tile[8].m_image = ImagePath.getInstance().STAIRS;
			
			m_tile[9] = new Tile();
			m_tile[9].m_image = ImagePath.getInstance().CARPET;
			
			m_tile[10] = new Tile();
			m_tile[10].m_image = ImagePath.getInstance().WALLPAPER;
			m_tile[10].m_collision=true;
			
			m_tile[11] = new Tile();
			m_tile[11].m_image = ImagePath.getInstance().WALLPAPERROOM;
			m_tile[11].m_collision=true;
			
			m_tile[12] = new Tile();
			m_tile[12].m_image = ImagePath.getInstance().BED1;
			m_tile[12].m_collision=true;
			
			m_tile[13] = new Tile();
			m_tile[13].m_image = ImagePath.getInstance().BED2;
			m_tile[13].m_collision=true;
			
			m_tile[14] = new Tile();
			m_tile[14].m_image = ImagePath.getInstance().BED3;
			m_tile[14].m_collision=true;
			
			m_tile[15] = new Tile();
			m_tile[15].m_image = ImagePath.getInstance().BED4;
			m_tile[15].m_collision=true;
			
			m_tile[16] = new Tile();
			m_tile[16].m_image = ImagePath.getInstance().FLOWER1;
			
			m_tile[17] = new Tile();
			m_tile[17].m_image = ImagePath.getInstance().FLOWER2;
			
			m_tile[18] = new Tile();
			m_tile[18].m_image = ImagePath.getInstance().COOK1;
			m_tile[18].m_collision=true;
			
			m_tile[19] = new Tile();
			m_tile[19].m_image = ImagePath.getInstance().COOK2;
			m_tile[19].m_collision=true;
			
			m_tile[20] = new Tile();
			m_tile[20].m_image = ImagePath.getInstance().COOK3;
			m_tile[20].m_collision=true;
			
		
			
			m_tile[21] = new Tile();
			m_tile[21].m_image = ImagePath.getInstance().TILE;
		
	
	
	}
	
	/**
	 * Lecture du fichier txt contenant la map et chargement des tuiles correspondantes.
	 */
	public void loadMap(String filePath) {
		//charger le fichier txt de la map
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
			int col = 0;
			int row = 0;
			
			// Parcourir le fichier txt pour r�cup�rer les valeurs
			while (col < m_gp.MAX_SCREEN_COL && row < m_gp.MAX_SCREE_ROW) {
				String line = br.readLine();
				while (col < m_gp.MAX_SCREEN_COL) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					m_mapTileNum [col][row] = num;
					col++;
				}
				if (col == m_gp.MAX_SCREEN_COL) {
					col = 0;
					row ++;
				}
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Affichage de la carte avec les diff�rentes tuiles
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while (col < m_gp.MAX_SCREEN_COL && row < m_gp.MAX_SCREE_ROW) {
			int tileNum = m_mapTileNum[col][row];
			
			g2.drawImage(m_tile[tileNum].m_image, x, y, m_gp.TILE_SIZE, m_gp.TILE_SIZE, null);
			col ++;
			x += m_gp.TILE_SIZE;
			if (col == m_gp.MAX_SCREEN_COL) {
				col = 0;
				row ++;
				x = 0;
				y += m_gp.TILE_SIZE;
			}
		}
		
	}
}
