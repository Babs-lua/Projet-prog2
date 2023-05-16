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
	int m_maxTiles = 20;	//nombre maximum de tiles chargeable dans le jeu
	int m_mapTileNum[][];	//répartition des tiles dans la carte du jeu
	
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
			m_tile[0].m_image = ImagePath.getInstance().GRASS;
			
			m_tile[1] = new Tile();
			m_tile[1].m_image = ImagePath.getInstance().WALL;
			m_tile[1].m_collision=true;
			
			m_tile[2] = new Tile();
			m_tile[2].m_image = ImagePath.getInstance().WOODENFLOOR;

			m_tile[3] = new Tile();
			m_tile[3].m_image = ImagePath.getInstance().MAINDOOR;
			m_tile[3].m_collision=true;
			
			m_tile[4] = new Tile();
			m_tile[4].m_image = ImagePath.getInstance().BARRIER;
			m_tile[4].m_collision=true;
			
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
			
			// Parcourir le fichier txt pour récupérer les valeurs
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
	 * Affichage de la carte avec les différentes tuiles
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
