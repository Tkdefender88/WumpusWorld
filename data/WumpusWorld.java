package data;

/**
 * @authors Justin Bak + Marcus Frisbee
 *
 *
 *
 */

import static helpers.StdDraw.setCanvasSize;
import static helpers.StdDraw.setXscale;
import static helpers.StdDraw.setYscale;

public class WumpusWorld {
	
	public static final int TILE_SIZE = 100;
	public static int width, height;
	WumpusWorld ww;
	static Cave cave;
	
	public static void main(String[] args) {
		width = Integer.parseInt(args[0]) * TILE_SIZE;
		height = Integer.parseInt(args[1]) * TILE_SIZE;
		
		cave = new Cave(width / TILE_SIZE, height / TILE_SIZE);
		setCanvasSize(width, height);
		setXscale(0, width);
		setYscale(0, height);
		
		cave.draw();
	}
	
	
	public static void init() {
		cave = new Cave(width / TILE_SIZE, height / TILE_SIZE);
		Player archer = new Player(0, 0);
	}
}
