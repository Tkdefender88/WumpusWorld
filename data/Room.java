/**
 * @author Justin Bak + Marcus Frisbee
 *
 * 
 *         Description: Draws the room and stores whether the room is breezy, stinky has gold, has a
 *         pit or has a wumpus.
 */

package data;

import static helpers.StdDraw.picture;

public class Room {

  private static final int TILE_SIZE = Cave.TILE_SIZE;
  private int x, y;
  private int xPos;
  private int yPos;

  private String texture = "VisitedMapTile.png";

  private Boolean stinky = false;
  private Boolean breezy = false;
  private Boolean gold = false;
  private Boolean pit = false;
  private Boolean wumpus = false;
  private Boolean isVisited = false;

  private Cave cave;

  // Room constructor.
  public Room(int x, int y, Cave cave) {
    this.x = x;
    this.y = y;
    this.cave = cave;
    xPos = (x - 50) / TILE_SIZE;
    yPos = (y - 50) / TILE_SIZE;
  }

  /**
   * Looks up to the map of the cave and determines if the tiles next to it are pits or the wumpus.
   * If there is a pit or wumpus next to it then the tile becomes breezy or stinky respectively.
   */
  public void layer() {
    Room[][] map = cave.getCave();
    boolean wumpus = false;
    // Subtracting 50 to compensate for stdDraw drawing from center.

    if (xPos != 0) {
      if (map[xPos - 1][yPos].isPit()) {
        breezy = true;

      }
      if (map[xPos - 1][yPos].isWumpus()) {
        wumpus = true;
      }
    }
    if (xPos != map.length - 1) {
      if (map[xPos + 1][yPos].isPit()) {
        breezy = true;

      }
      if (map[xPos + 1][yPos].isWumpus()) {
        wumpus = true;
      }
    }
    if (yPos != 0) {
      if (map[xPos][yPos - 1].isPit()) {
        breezy = true;

      }
      if (map[xPos][yPos - 1].isWumpus()) {
        wumpus = true;
      }
    }
    if (yPos != map[0].length - 1) {
      if (map[xPos][yPos + 1].isPit()) {
        breezy = true;

      }
      if (map[xPos][yPos + 1].isWumpus()) {
        wumpus = true;
      }
    }
    if (wumpus) {
      stinky = true;
    } else {
      stinky = false;
    }
  }


  /**
   * Draw method for the room. Has if statements to determine which textrures to draw over the tile
   * depending on if it is breezy, stinky, has the wumpus or the gold or is a pit.
   */
  public void draw() {
    picture(x, y, texture);
    if (isPit()) {
      picture(x, y, "PitTile.png");
    }
    if (isBreezy()) {
      picture(x, y, "BreezeTile.png");
    }
    if (isStench()) {
      picture(x, y, "StenchTile.png");
    }
    if (isGold()) {
      picture(x, y, "GoldTile.png");
    }
    if (isWumpus()) {
      picture(x, y, "WumpusTile.png");
    }
    if (!isVisited()) {
      picture(x, y, "NotVisitedMapTile.png");
    }
  }

  public void drawAll() {
    picture(x, y, texture);
    if (isPit()) {
      picture(x, y, "PitTile.png");
    }
    if (isBreezy()) {
      picture(x, y, "BreezeTile.png");
    }
    if (isStench()) {
      picture(x, y, "StenchTile.png");
    }
    if (isGold()) {
      picture(x, y, "GoldTile.png");
    }
    if (isWumpus()) {
      picture(x, y, "WumpusTile.png");
    }
  }

  /*
   **************************************************************************
   * GETTERS AND SETTERS
   ************************************************************************** 
   */
  public void setPit() {
    this.pit = true;
  }

  public void setGold() {
    this.gold = true;
  }

  public void setWumpus() {
    this.wumpus = true;
  }

  public void setVisited(boolean visited) {
    this.isVisited = visited;
  }

  public void killWumpus(int x, int y, String direction) {
    if (direction == "+y") {
      for (int i = y; i < cave.getCave()[0].length; i++) {
        cave.getCave()[xPos][i].wumpus = false;
      }
    } else if (direction == "-y") {
      for (int i = y; i > 0; i--) {
        cave.getCave()[xPos][i].wumpus = false;
      }
    } else if (direction == "+x") {
      for (int i = x; i < cave.getCave().length; i++) {
        cave.getCave()[i][yPos].wumpus = false;
      }
    } else if (direction == "-x") {
      for (int i = x; i > 0; i--) {
        cave.getCave()[i][yPos].wumpus = false;
      }
    }
  }

  public void isSafe(int x, int y) {
    if (cave.getCave()[x][y].isWumpus()) {

    }
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

  public boolean isVisited() {
    return isVisited;
  }
}
