package connect4main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author ajith
 *
 */
public class GUIExperiment extends JFrame implements ActionListener {

  JFrame f;
  private JPanel buttonPanel;
  private JPanel controlButton;

  GUIExperiment() {
    setTitle("Connect4-Experiment");
    final JTextField tf = new JTextField(); // text field
    buttonPanel = new JPanel();
    buttonPanel.setBounds(50,  200, 500, 500);
    buttonPanel.setLayout( new GridLayout(9,9) );
        
    JButton[] buttons = new JButton[81];
    for (int i=0; i<81; i++) {
            buttons[i] = new JButton();
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
            buttons[i].setBackground(Color.WHITE);
            RenderedImages.scale(55, 55);
            Image image = RenderedImages.blueCircle;
            ImageIcon icon = new ImageIcon(image);
            buttons[i].setIcon(icon);
            buttonPanel.add(buttons[i]);
            
    }
    
    controlButton = new JPanel();
    controlButton.setBounds(50, 725, 500, 50);
    controlButton.setLayout( new GridLayout(1,9) );
    JButton[] contbuttons = new JButton[9];
    for (int i=0; i<9; i++) {
      contbuttons[i] = new JButton();
      contbuttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
      contbuttons[i].setBackground(Color.WHITE);
      RenderedImages.scale(55, 55);
      Image image = RenderedImages.redCircle;
      ImageIcon icon = new ImageIcon(image);
      contbuttons[i].setIcon(icon);
      controlButton.add(contbuttons[i]);     
      }
    add(controlButton);
    add(buttonPanel);

    tf.setBounds(50, 50, 150, 20);
    RenderedImages.scale(100, 40);
    Image image = RenderedImages.blueCircle;
    JButton b = new JButton(new ImageIcon(RenderedImages.blueCircle));// create button
    b.setBounds(130, 100, 100, 40); // x axis, y axis, width, height
    b.addActionListener(this);
//    b.setOpaque(false);
//    b.setContentAreaFilled(false);
//    b.setBorderPainted(false);  makes it transparent

    add(tf);
    add(b);// adding button on frame
    setSize(1000,1000);
    setLayout(null);
    setVisible(true);

  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    new GUIExperiment();

  }

  public void actionPerformed(ActionEvent e) {
    //tf.addActionListener(this);

    addMouseListener(new MouseListener() {
      
      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getX() + " " + e.getY());
        System.out.println(e.getComponent());

        
      }
      
      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }
      
      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }
      
      @Override
      public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
      }
    });
  }
}
