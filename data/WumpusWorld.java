/**
 * @authors Justin Bak + Marcus Frisbee
 *
 *          Description: Wumpus world game class handles setting up the game and the main game loop.
 *          To play, give two arguments, the width and the height of the game board you wish to play
 *          on.
 */

package data;

import static helpers.StdDraw.clear;
import static helpers.StdDraw.setCanvasSize;
import static helpers.StdDraw.setXscale;
import static helpers.StdDraw.setYscale;
import static helpers.StdDraw.show;


public class WumpusWorld {
  public static final int TILE_SIZE = 100;
  public static int width;
  public static int height;
  static WumpusWorld ww;
  Player archer;
  static Cave cave;
  

  public static void main(String[] args) {
    width = Integer.parseInt(args[0]) * TILE_SIZE;
    height = Integer.parseInt(args[1]) * TILE_SIZE;
    ww = new WumpusWorld();
    ww.init();
    ww.play();
  }

  public void init() {
    cave = new Cave(width / TILE_SIZE, height / TILE_SIZE);
    cave.buildCave();
    archer = new Player(0, 0);
    setCanvasSize(width, height);
    setXscale(0, width);
    setYscale(0, height);
  }

  public void play() {
    while (!isGameOver()) {
      cave.draw();
      archer.update();
      show(100);
      clear();
    }
    cave.draw();
    archer.update();
    show(100);
    
  }

  public boolean isGameOver() {
    boolean gameOver = false;
    int x = archer.getXPos();
    int y = archer.getYPos();
    Room[][] map = Cave.getCave();
		if(map[x][y].isWumpus()) {
			gameOver = true;
		}
		if(map[x][y].isPit()) {
			gameOver = true;
		}
    return gameOver;
  }
}
