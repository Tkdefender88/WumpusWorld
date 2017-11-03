package data;

import static helpers.StdDraw.*;
/**
 * @authors Justin Bak + Marcus Frisbee
 *
 *
 *
 */
public class WumpusWorld {
	
	public static final int TILE_SIZE = 100;
	
	WumpusWorld ww;
	static Cave cave;
	
	public static void main(String[] args) {
		int width, height;
		width = Integer.parseInt(args[0]) * TILE_SIZE;
		height = Integer.parseInt(args[1]) * TILE_SIZE;
		
		cave = new Cave(width / TILE_SIZE, height / TILE_SIZE);
		setCanvasSize(width, height);
		setXscale(0, width);
		setYscale(0, height);
	
		
		cave.draw();
	}
}
