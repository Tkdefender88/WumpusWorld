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
import javax.swing.JPanel;
import helpers.StdDraw;


public class WumpusWorld extends JPanel {
  public static final int TILE_SIZE = 100;
  public static int width;
  public static int height;

  Cave cave = new Cave(width / TILE_SIZE, height / TILE_SIZE, this);
  Player archer = new Player(0, 0, this);

  public static void main(String[] args) {
    width = Integer.parseInt(args[0]) * TILE_SIZE;
    height = Integer.parseInt(args[1]) * TILE_SIZE;
    WumpusWorld ww = new WumpusWorld();
    ww.init();
    ww.play();
  }

  // Sets up the window
  public void init() {
    cave.buildCave();

    setCanvasSize(width, height);
    setXscale(0, width);
    setYscale(0, height);
  }

  // Main game loop
  public void play() {
    while (!isGameOver()) {
      cave.draw();
      archer.update();
      StdDraw.show(100);
      clear();
      cave.layerRooms();
    }
    cave.drawAll();
    archer.update();
    StdDraw.show(100);
  }

  // Tests if the game is over
  public boolean isGameOver() {
    boolean gameOver = false;
    int x = archer.getXPos();
    int y = archer.getYPos();
    Room[][] map = cave.getCave();
    if (map[x][y].isWumpus() && !archer.isKonami()) {
      gameOver = true;
    }
    if (map[x][y].isPit() && !archer.isKonami()) {
      gameOver = true;
    }
    if (archer.hasGold()) {
      gameOver = true;
    }
    return gameOver;
  }
}
