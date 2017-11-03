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
	private Room[][] map;
	
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
				map[x][y] = new Room(x * TILE_SIZE + 50, y * TILE_SIZE + 50,
						RoomType.VISITED);
			}
		}
	}
}