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
	private Boolean stinky = false;
	private Boolean breezy = false;
	private Boolean gold = false;
	private Boolean pit = false;
	private Boolean wumpus = false;

	public Room(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void layer() {
		Room[][] map = Cave.getCave();
		if(x != 0) {
			if(map[x - 1][y].isPit() ) {
				breezy = true;

			}
			if(map[x - 1][y].isWumpus()) {
				stinky = true;
			} 	 
		}
		if(x != map[0].length - 1) {
			if(map[x + 1][y].isPit()) {
				breezy = true;

			}
			if(map[x + 1][y].isWumpus()) {
				stinky = true;
			} 	 
		}
		if(y != 0) {
			if(map[x][y - 1].isPit()) {
				breezy = true;

			}
			if(map[y][x - 1].isWumpus()) {
				stinky = true;
			} 	 
		}
		if(y != map[0].length - 1) {
			if(map[x][y + 1].isPit()) {
				breezy = true;

			}
			if(map[x][y + 1].isWumpus()) {
				stinky = true;
			} 	 
		}
	}
}
}

/*
 * player
 * notvisited
 * gold
 * wumpus
 * stench
 * breeze
 * pit
 * visited
 */
public void draw() {
	picture(x, y, texture);
	if(isPit()) {
		picture(x, y, "PitTile.png");
	}
	System.out.println(isBreezy());
	if(isBreezy()) {
		picture(x, y, "BreezeTile.png");
	}
	if(isStench()) {
		picture(x, y, "StenchTile.png");
	}
	if(isGold()) {
		picture(x, y, "GoldTile.png");
	} 
	if(isWumpus()) {
		picture(x, y, "WumpusTile.png");
	}
}

public void setPit() {
	this.pit = true;
}
public void setGold() {
	this.gold = true;
}
public void setWumpus() {
	this.wumpus = true;
}

public boolean isPit() {
	return pit;
}
public boolean isGold() {
	return gold;
}
public boolean isWumpus() {
	return wumpus;
}
public boolean isStench() {
	return stinky;
}
public boolean isBreezy() {
	return breezy;
}
}
