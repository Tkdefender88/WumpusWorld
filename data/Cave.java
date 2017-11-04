package data;

/**
 * 
 * @author Justin Bak + Marcus Frisbee
 * 
 *
 * 
 * Description:
 */

public class Cave {
	
	private static final int TILE_SIZE = 100;
	private int width, height;
	private static Room[][] map;
	
	public Cave(int width, int height) {
		this.width = width;
		this.height = height;
		map = new Room[width][height];
		buildCave();
	}
	
	public void draw() {
		for (Room[] r : map) {
			for (Room x : r) {
				x.draw();
			}
		}
	}
	
	private void buildCave() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//Adding 50 to adjust for StdDraw drawing from the center of
				//the image.
				map[x][y] = new Room(x * TILE_SIZE + 50, y * TILE_SIZE + 50);
				
				if((Math.random() * 100) <= 20 && (x != 0 || y != 0)) {
					map[x][y].setPit();
				}
			}
		}
		placeWumpus();
		placeGold();
		layerRooms();
	}
	
	private void layerRooms() {
		for (Room[] y : map) {
			for (Room x : y) {
				x.layer();
			}
		}
	}
	
	private void placeGold() {
		int xPos = randomX();
		int yPos = randomY();
		map[xPos][yPos].setGold();
	}
	
	private void placeWumpus() {
		int xPos = randomX();
		int yPos = randomY();
		map[xPos][yPos].setWumpus();
	}
	
	private int randomX() {
		return (int) (Math.random() * width);
	}
	
	private int randomY() {
		return (int) (Math.random() * height);
	}
	
	public static Room[][] getCave() {
		return map;
	}
}