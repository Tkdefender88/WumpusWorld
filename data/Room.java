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
	private Boolean stinky, breezy;
	private Boolean gold = false;
	private Boolean pit = false;
	private Boolean wumpus = false;
	

	public Room(int x, int y){
		this.x = x;
		this.y = y;
	}

	public layer() {
		room[][] map = getCave();
		for (Room[] r : map) {
			for (Room x : r) {
				if(r != 0) {
					if(cave[r - 1][x].isPit ) {
						breezy = true;

					}
					if(cave[r - 1][x].isWumpus) {
						stinky = true;
					} 	 
				}
				if(r != map.length - 1) {
					if(cave[r + 1][x].isPit) {
						breezy = true;

					}
					if(cave[r + 1][x].isWumpus) {
						stinky = true;
					} 	 
				}
				if(x != 0) {
					if(cave[r][x - 1].isPit) {
						breezy = true;

					}
					if(cave[r][x - 1].isWumpus) {
						stinky = true;
					} 	 
				}
				if(x != r.length() - 1) {
					if(cave[r][x + 1].isPit) {
						breezy = true;

					}
					if(cave[r][x + 1].isWumpus) {
						stinky = true;
					} 	 
				}


			}
		}
	}
	
	public setPit() {
		this.pit = true;
	}
	public setGold() {
		this.gold = true;
	}
	public setWumpus() {
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
		if(isPit) {
			picture(x, y, "PitTile.png");
		}
		if(isBreeze) {
			picture(x, y, "BreezeTile.png");
		}
		if(isStench) {
			picture(x, y, "StenchTile.png");
		}
		
		System.out.printf("X: %d Y: %d\n", x ,y);
	}

}
