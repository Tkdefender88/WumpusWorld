/**
 * @author: Justin Bak + Marcus Frisbee
 * 
 *          Description: Player class that handles player movement and shooting.
 */

package data;

import static helpers.StdDraw.isKeyPressed;
import static helpers.StdDraw.picture;
import static helpers.StdDraw.show;
import java.awt.event.KeyEvent;

public class Player {

  private static final int TILE_SIZE = WumpusWorld.TILE_SIZE;
  private String texture = "HeroTile.png";
  private Boolean hasArrow = true;
  private int x;
  private int y;
  private int xPos = x / TILE_SIZE;
  private int yPos = y / TILE_SIZE;


  public Player(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void update() {
    draw();
    input();
  }

  /**
   * Draws the player to the screen.
   */
  private void draw() {
    picture(xPos * TILE_SIZE + 50, yPos * TILE_SIZE + 50, texture);
  }

  /**
   * Takes input and moves the player.
   */
  private void input() {
    int delay = 150;
    if (isKeyPressed(KeyEvent.VK_W) && yPos < WumpusWorld.height / TILE_SIZE - 1) {
      yPos++;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_S) && yPos > 0) {
      yPos--;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_D) && xPos < WumpusWorld.width / TILE_SIZE - 1) {
      xPos++;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_A) && xPos > 0) {
      xPos--;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_J) && xPos > 0) {
      // Room.shootWumpus(x - 1, y);
      show(delay);
    }
    Room.visited(xPos, yPos);
    // TODO: handle shooting the arrow
  }
}
