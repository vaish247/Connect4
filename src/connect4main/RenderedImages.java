package connect4main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author ajith
 *
 */
public class RenderedImages {
  /**
   * 
   */
  public static BufferedImage board;
  /**
   * 
   */
  public static BufferedImage redCircle;
  /**
   * 
   */
  public static BufferedImage blueCircle;
  /**
   * Static initializer for reading the image files.
   */
  static {
    try {
      board = ImageIO.read(RenderedImages.class.getResource("board.png"));
      redCircle = ImageIO.read(RenderedImages.class.getResource("redTile.png"));
      blueCircle = ImageIO.read(RenderedImages.class.getResource("blueTile.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  /**
   * Takes a BufferedImage and a image file name to scale to a given width and height. Uses the passed BufferedImage as a backup if it can't scale the image file.
   * 
   * @param originalBufImg Backup in case of failed scaling
   * @param imgName Name of image file to scale
   * @param width Width to scale the image to
   * @param height Height to scale the image to
   * @return Scaled BufferedImage
   */
  private static BufferedImage scaleImage(BufferedImage originalBufImg, String imgName, int width, int height) {
    //Create a new image with good size that contains or might contain arbitrary alpha values between and including 0.0 and 1.0.
    BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);

    //Create a device-independant object to draw the resized image
    Graphics2D g2 = resizedImg.createGraphics();

    //This could be changed, Cf. http://stackoverflow.com/documentation/java/5482/creating-images-programmatically/19498/specifying-image-rendering-quality
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    //Finally draw the source image in the Graphics2D with the desired size.
    g2.drawImage(originalBufImg, 0, 0, width, height, null);

    //Disposes of this graphics context and releases any system resources that it is using
    g2.dispose();

    //Return the image used to create the Graphics2D 
    return resizedImg;
  }
  
  /**
   * Reloads all the renderer images scaled for a given width and height.
   * @param width 
   * @param height 
   */
  public static void scale(int width, int height) {
    board = scaleImage(board, "board.png", width, height);
    redCircle = scaleImage(redCircle, "redTile.png", width, height);
    blueCircle = scaleImage(blueCircle, "blueTile.png", width, height);
  }
  
  
}
