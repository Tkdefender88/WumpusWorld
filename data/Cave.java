/**
 * 
 * @author Justin Bak + Marcus Frisbee
 * 
 *         Description: Builds and stores the array of room objects, determines if a room has a
 *         wumpus, gold, or pit in it.
 */

package data;

public class Cave {

  public static final int TILE_SIZE = 100;
  private int width;
  private int height;
  private static Room[][] map;
  static Cave cave;

  // Constructor for the cave.
  public Cave(int width, int height) {
    this.width = width;
    this.height = height;
    map = new Room[width][height];
  }

  // Temporary main method added for Part 1, will not be used in later parts.
  /*
   * public static void main(String[] args) { int width = Integer.parseInt(args[0]) * TILE_SIZE; int
   * height = Integer.parseInt(args[1]) * TILE_SIZE;
   * 
   * cave = new Cave(width / TILE_SIZE, height / TILE_SIZE); setCanvasSize(width, height);
   * setXscale(0, width); setYscale(0, height);
   * 
   * cave.draw(); }
   */

  /**
   * Draw method calls all the rooms to draw themselves to the screen.
   */
  public void draw() {
    for (Room[] r : map) {
      for (Room x : r) {
        x.draw();
      }
    }
  }

  /**
   * Draw method calls all the rooms to draw themselves to the screen.
   */
  public void drawAll() {
    for (Room[] r : map) {
      for (Room x : r) {
        x.drawAll();
      }
    }
  }
  /**
   * Builds the array of rooms that represent the cave Determines which rooms will be pits and then
   * sets the wumpus and the gold. Also tells the rooms to layer so that they can find if they are
   * smelly or breezy.
   */
  public void buildCave() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // Adding 50 to adjust for StdDraw drawing from the center of
        // the image.
        map[x][y] = new Room(x * TILE_SIZE + 50, y * TILE_SIZE + 50);

        if ((Math.random() * 100) <= 20 && (x != 0 || y != 0)) {
          map[x][y].setPit();
        }
      }
    }
    placeWumpus();
    placeGold();
    layerRooms();
  }

  /**
   * Tells each room to layer on wether it is stinky or breezy.
   */
  public void layerRooms() {
    for (Room[] y : map) {
      for (Room x : y) {
        x.layer();
      }
    }
  }

  /**
   * places the gold at a random x and y location on the map.
   */
  private void placeGold() {
    int[] coords = randomTile();
    int xPos = coords[0];
    int yPos = coords[1];
    map[xPos][yPos].setGold();
  }

  /**
   * Places the wumpus at a random x and y location on the map.
   */
  private void placeWumpus() {
    int[] coords = randomNon00Tile();
    int xPos = coords[0];
    int yPos = coords[1];
    map[xPos][yPos].setWumpus();
  }

  /**
   * Provides a random X value for placing gold and wumpuses. Does not exceed the width of the map.
   * 
   * @return an integer for the x coordinate of the wumpus or gold.
   */
  private int[] randomNon00Tile() {
    int x = 0;
    int y = 0;
    int[] coords = new int[2];
    while (x == 0 && y == 0) {
      x = (int) (Math.random() * width - 1);
      y = (int) (Math.random() * height - 1);
    }
    coords[0] = x;
    coords[1] = y;
    return coords;
  }

  private int[] randomTile() {
    int x = (int) (Math.random() * width - 1);
    int y = (int) (Math.random() * height - 1);
    int[] coords = new int[2];
    coords[0] = x;
    coords[1] = y;
    return coords;
  }

  /**
   * Provides a random Y value for placing gold and the wumpus. Does not exceed the height of the
   * map.
   * 
   * @return an integer for the Y coordinate for the wumpus or gold.
   */
  private int randomY() {
    return (int) (Math.random() * height - 1) + 1;
  }

  /**
   * A getter for the array of rooms that is the map
   * 
   * @return a 2D array of room objects representing the cave map.
   */
  public static Room[][] getCave() {
    return map;
  }
}
