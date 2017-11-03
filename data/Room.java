package data;

import static helpers.StdDraw.*;

/**
 * 
 * @author Justin Bak + Marcus Frisbee
 *
 * 
 * Description:
 */

public class Room {
	
	private int x, y;
	private String texture = "VisitedMapTile.png";
	
	public Room(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void draw() {
		picture(x, y, texture);
		System.out.printf("X: %d Y: %d\n", x ,y);
	}
	
}
