package connect4main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

/**
 * @author ajith
 *
 */
public class MouseListenerExample2 extends JFrame implements MouseListener, MouseMotionListener {
  boolean dragging = false;

  MouseListenerExample2() {
    addMouseListener(this);
    addMouseMotionListener(this);
    setSize(300, 300);
    setLayout(null);
    setVisible(true);

  }

  public void mouseClicked(MouseEvent e) {
    Graphics g = getGraphics();
    System.out.println(e.getX()+" "+e.getY());
    g.setColor(Color.BLUE);
    g.fillOval(e.getX() - 15, e.getY() - 15, 30, 30);
  }

  public void mouseEntered(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(Color.BLACK);
    g.fillOval(e.getX() - 15, e.getY() - 15, 30, 30);
  }

  public void mouseDragged(MouseEvent e) {
      System.out.println("DRAG");
      System.out.println(e.getX()+" "+e.getY());
      Graphics g = getGraphics();
      g.setColor(Color.PINK);
      g.fillOval(e.getX() - 15, e.getY() - 15, 30, 30);
    
  }


  public void mouseExited(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(Color.RED);
    g.fillOval(e.getX() - 15, e.getY() - 15, 30, 30);
  }


  public void mousePressed(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(Color.GREEN);
    g.fillOval(e.getX() - 15, e.getY() - 15, 30, 30);
    this.dragging = true;

  }

  public void mouseReleased(MouseEvent e) {
    Graphics g = getGraphics();
    g.setColor(Color.YELLOW);
    g.fillOval(e.getX() - 15, e.getY() - 15, 30, 30);
    this.dragging = false;
    ;

  }
  
  public void mouseMoved(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    new MouseListenerExample2();
  }



}