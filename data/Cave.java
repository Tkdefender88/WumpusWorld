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
		//Set the wumpus
		placeWumpus();
		placeGold();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//Adding 50 to adjust for StdDraw drawing from the center of
				//the image.
				map[x][y] = new Room(x * TILE_SIZE + 50, y * TILE_SIZE + 50);
			}
		}
	}
	
	private void placeGold() {
		int xPos = randomX();
		int yPos = randomY();
		map[xPos][yPos] = new Room(xPos * TILE_SIZE + 50, yPos * TILE_SIZE + 50);

	}
	
	private void placeWumpus() {
		int xPos = randomX();
		int yPos = randomY();
		map[xPos][yPos] = new Room(xPos * TILE_SIZE + 50, yPos * TILE_SIZE + 50);
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