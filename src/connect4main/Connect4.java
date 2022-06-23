package connect4main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import connect4main.Tiles.State;

/**
 * @author ajith
 *
 */
public class Connect4 {

  private Board game;

  /**
   * @param number
   * @param game
   * @return board
   * @throws IOException
   * 
   */
  public Board run(int number, Board game) {
    // Reading data using readLine
    int i = 0;
    game.placeTile(number);
    if (game.checkWinner(game.latestTile(), 1, "None")) { //$NON-NLS-1$
      System.out.println("WOOOHOO"); //$NON-NLS-1$
    }
    System.out.println(game);
    return game;

  }
}
