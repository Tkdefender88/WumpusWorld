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
import java.awt.event.KeyListener;

public class Player implements KeyListener {

  private static final int TILE_SIZE = WumpusWorld.TILE_SIZE;
  private String texture = "HeroTile.png";
  private Boolean hasArrow = true;
  private int x;
  private int y;
  private int xPos = x / TILE_SIZE;
  private int yPos = y / TILE_SIZE;
  private boolean konami = false;
  private int konamiCount = 0;
  private boolean gold = false;


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
  private void input(KeyEvent e) {
    int delay = 100;
    int keyCode = e.getKeyCode();

    boolean konami = checkKonami(keyCode);

    switch (keyCode) {
      case KeyEvent.VK_W:
        if (yPos < WumpusWorld.height / TILE_SIZE - 1) {
          yPos++;
          show(delay);
        }
        break;
      case KeyEvent.VK_S:
        if (yPos > 0) {
          yPos--;
          show(delay);
        }
        break;
      case KeyEvent.VK_D:
        if (xPos < WumpusWorld.width / TILE_SIZE - 1) {
          xPos++;
          show(delay);
        }
        break;
      case KeyEvent.VK_A:
        if (xPos > 0) {
          xPos--;
          show(delay);
        }
        break;
      case KeyEvent.VK_J:
        if (xPos > 0 && hasArrow) {
          Room.killWumpus(xPos, yPos, "-x");
          show(delay);
        }
        break;
      case KeyEvent.VK_L:
        if (xPos < WumpusWorld.width / TILE_SIZE - 1 && hasArrow) {
          Room.killWumpus(xPos, yPos, "+x");
          show(delay);
        }
        break;
      case KeyEvent.VK_I:
        if (yPos < WumpusWorld.height / TILE_SIZE - 1 && hasArrow) {
          Room.killWumpus(xPos, yPos, "+y");
          show(delay);
        }
        break;
      case KeyEvent.VK_K:
        if (yPos > 0 && hasArrow) {
          Room.killWumpus(xPos, yPos, "-y");
          show(delay);
        }
        break;
      case KeyEvent.VK_G:
        Room map[][] = Cave.getCave();
        gold = map[xPos][yPos].isGold();
        show(delay);
        break;
    }
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
    } else if (isKeyPressed(KeyEvent.VK_J) && xPos > 0 && hasArrow) {
      Room.killWumpus(xPos - 1, yPos);
      // StdAudio.play("arrow2.wav");
      hasArrow = false;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_L) && xPos < WumpusWorld.width / TILE_SIZE - 1
        && hasArrow) {
      Room.killWumpus(xPos + 1, yPos);
      // StdAudio.play("arrow2.wav");
      hasArrow = false;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_I) && yPos < WumpusWorld.height / TILE_SIZE - 1
        && hasArrow) {
      Room.killWumpus(xPos, yPos + 1);
      // StdAudio.play("arrow2.wav");
      hasArrow = false;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_K) && yPos > 0 && hasArrow) {
      Room.killWumpus(xPos, yPos - 1);
      // StdAudio.play("arrow2.wav");
      hasArrow = false;
      show(delay);
    } else if (isKeyPressed(KeyEvent.VK_G)) {
      Room map[][] = Cave.getCave();
      gold = map[xPos][yPos].isGold();
      show(delay);
    }
    /*
     * else if (isKeyPressed(KeyEvent.VK_UP)) { // System.out.println("UP"); if (konamiCount == 0 ||
     * konamiCount == 1) { konamiCount++; } else { konamiCount = 0; } show(delay); } else if
     * (isKeyPressed(KeyEvent.VK_DOWN)) { // System.out.println("DOWN"); if (konamiCount == 2 ||
     * konamiCount == 3) { konamiCount++; } else { konamiCount = 0; } show(delay); } else if
     * (isKeyPressed(KeyEvent.VK_LEFT)) { // System.out.println("LEFT"); if (konamiCount == 4 ||
     * konamiCount == 6) { konamiCount++; } else { konamiCount = 0; } show(delay); } else if
     * (isKeyPressed(KeyEvent.VK_RIGHT)) { // System.out.println("RIGHT"); if (konamiCount == 5 ||
     * konamiCount == 7) { konamiCount++; } else { konamiCount = 0; } show(delay); } else if
     * (isKeyPressed(KeyEvent.VK_B)) { // System.out.println("B"); if (konamiCount == 8) {
     * konamiCount++; } else { konamiCount = 0; } show(delay); } else if
     * (isKeyPressed(KeyEvent.VK_A)) { // System.out.println("A"); if (konamiCount == 9) {
     * konamiCount++; } else { konamiCount = 0; } show(delay); } else if
     * (isKeyPressed(KeyEvent.VK_ENTER)) { // System.out.println("START"); if (konamiCount == 10) {
     * konami = true; System.out.println("Cheat code active."); } else { konamiCount = 0; }
     */
    // show(delay);
    // }
    Room.visited(xPos, yPos);
  }

  private int counter = 0;

  private boolean checkKonami(int keyCode) {
    // Key code int values for Up up down down left right left right b a enters
    int[] sequence = {86, 86, 40, 40, 37, 39, 37, 39, 66, 65, 61};
    if (sequence[counter] == keyCode) {
      counter += 1;
      if (counter == sequence.length) {
        counter = 0;
        return true;
      }
    } else {
      counter = 0;
    }
    return false;
  }


  /***************************************************************************
   * Getters and Setters
   ***************************************************************************/

  public int getXPos() {
    return xPos;
  }

  public int getYPos() {
    return yPos;
  }

  public boolean hasGold() {
    return gold;
  }

  public boolean isKonami() {
    return konami;
  }

  @Override
  public void keyPressed(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyReleased(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub

  }
}
