package data;

/**
 * Authors: Justin Bak + Marcus Frisbee
 * 
 * Description: Player class that handles player movement and shooting.
 */

import static helpers.StdDraw.*;

public class Player {
	
	private static final int TILE_SIZE = WumpusWorld.TILE_SIZE;
	private String texture = "HeroTile.png";
	private int x, y;
	private Boolean hasArrow = true;
	
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		draw();
		//input();
		//move();
	}
	
	public void draw() {
		picture(x, y, texture);
	}
	
}
